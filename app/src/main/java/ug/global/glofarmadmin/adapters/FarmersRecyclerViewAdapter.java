package ug.global.glofarmadmin.adapters;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ug.global.glofarmadmin.FarmerObjects;
import ug.global.glofarmadmin.R;

public class FarmersRecyclerViewAdapter extends RecyclerView.Adapter<FarmersRecyclerViewAdapter.MyViewHolder> {
    public Context context;
    private ArrayList<FarmerObjects> farmerObjectsArrayList;
    private LayoutInflater layoutInflater;

    public FarmersRecyclerViewAdapter(ArrayList<FarmerObjects> farmerObjectsArrayList, Context context) {
        this.farmerObjectsArrayList = farmerObjectsArrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.famers_row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(farmerObjectsArrayList.get(position).getName());
        holder.location.setText(farmerObjectsArrayList.get(position).getLocation());
        holder.contact.setText(farmerObjectsArrayList.get(position).getContact());
    }

    @Override
    public int getItemCount() {
        return farmerObjectsArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, location, contact, verified;
        ImageView call;
        CardView farmcard;

        MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.farmername);
            contact = itemView.findViewById(R.id.farmercontact);
            location = itemView.findViewById(R.id.location);
            verified = itemView.findViewById(R.id.verified);

            farmcard = itemView.findViewById(R.id.farmerscard);
            verified.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:0377778888"));

                    if (ActivityCompat.checkSelfPermission(verified.getContext(),
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    context.startActivity(callIntent);

                }
            });
            farmcard.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    PopupMenu popupMenu = new PopupMenu(farmcard.getContext(), itemView);
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.verify:
                                    Toast.makeText(farmcard.getContext(), "Account Verified", Toast.LENGTH_SHORT).show();
                                    verified.setText(R.string.verified);
                                    verified.setTextColor(ContextCompat.getColor(farmcard.getContext(), R.color.green));
                                    return true;
                                case R.id.suspend:
                                    Toast.makeText(farmcard.getContext(), "Account Suspended", Toast.LENGTH_SHORT).show();
                                    verified.setText(R.string.suspended);
                                    verified.setTextColor(ContextCompat.getColor(farmcard.getContext(), R.color.red));
                                    return true;
                            }
                            return false;
                        }
                    });
                    popupMenu.inflate(R.menu.contextmenu);
                    popupMenu.setGravity(Gravity.START);
                    popupMenu.show();
                    return true;
                }
            });
        }


    }
}
