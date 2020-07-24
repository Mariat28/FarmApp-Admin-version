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
import ug.global.glofarmadmin.SupplyObjects;

public class SupplyAdapter extends RecyclerView.Adapter<SupplyAdapter.MyViewHolder> {
    private ArrayList<SupplyObjects> supplyObjectsArrayList;
    private LayoutInflater layoutInflater;

    public SupplyAdapter(ArrayList<SupplyObjects> supplyObjectsArrayList, Context context) {
        this.supplyObjectsArrayList = supplyObjectsArrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.supplies_row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(supplyObjectsArrayList.get(position).getSupplyname());
        holder.brand.setText(supplyObjectsArrayList.get(position).getBrand());
        holder.supplytype.setText(supplyObjectsArrayList.get(position).getSupplytype());
        holder.availabilty.setText(supplyObjectsArrayList.get(position).getAvailablesupply());
        holder.supplyprice.setText(supplyObjectsArrayList.get(position).getSupplyprice());


    }

    @Override
    public int getItemCount() {
        return supplyObjectsArrayList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, brand, availabilty, supplytype, supplyprice;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.supplynamemain);
            brand = itemView.findViewById(R.id.supplybrandmain);
            supplytype = itemView.findViewById(R.id.supplytype);
            availabilty = itemView.findViewById(R.id.supplyavailable);
            supplyprice = itemView.findViewById(R.id.suppplyprice);
        }
    }
}
