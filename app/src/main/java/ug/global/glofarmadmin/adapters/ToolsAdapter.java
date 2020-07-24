package ug.global.glofarmadmin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ug.global.glofarmadmin.R;
import ug.global.glofarmadmin.ToolsObjects;

public class ToolsAdapter extends RecyclerView.Adapter<ToolsAdapter.MyViewHolder> {
    private ArrayList<ToolsObjects> toolsObjectsArrayList;
    private LayoutInflater layoutInflater;

    public ToolsAdapter(ArrayList<ToolsObjects> toolsObjectsArrayList, Context context) {
        this.toolsObjectsArrayList = toolsObjectsArrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.tools_row_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(toolsObjectsArrayList.get(position).getName());
        holder.price.setText(toolsObjectsArrayList.get(position).getPrice());
        holder.availabletools.setText(toolsObjectsArrayList.get(position).getAvailable());

    }

    @Override
    public int getItemCount() {
        return toolsObjectsArrayList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, availabletools;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.toolname2);
            price = itemView.findViewById(R.id.toolprice2);
            availabletools = itemView.findViewById(R.id.toolsavailable2);
        }
    }
}
