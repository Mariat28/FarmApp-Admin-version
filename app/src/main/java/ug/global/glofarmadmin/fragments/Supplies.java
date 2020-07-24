package ug.global.glofarmadmin.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.HashMap;

import ug.global.glofarmadmin.NewSupplyActivity;
import ug.global.glofarmadmin.R;
import ug.global.glofarmadmin.SupplyObjects;
import ug.global.glofarmadmin.adapters.SupplyAdapter;

public class Supplies extends Fragment {
    private ArrayList<SupplyObjects> supplyarraylist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_supplies, container, false);

        final RecyclerView recyclerView = view.findViewById(R.id.supplierrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        final SupplyAdapter adapter = new SupplyAdapter(supplyarraylist, getActivity());
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("/supplies");
        Query query = reference.orderByChild("supplytype");
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                HashMap<String, String> hashMap = (HashMap<String, String>) dataSnapshot.getValue();
                Log.i("checking data", "Checking data" + hashMap.toString());
                String name = hashMap.get("supplyname");
                String brand = hashMap.get("supplydescription");
                String availablesupply = hashMap.get("availableamount");
                String supplytype = hashMap.get("supplytype");
                String supplyprice = hashMap.get("price");
                SupplyObjects supplyObjects = new SupplyObjects(name, brand, availablesupply, supplytype, supplyprice);
                supplyarraylist.add(supplyObjects);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        FloatingActionButton addsupplier = view.findViewById(R.id.addsupplierfab);
        addsupplier.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("InflateParams")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewSupplyActivity.class);
                startActivity(intent);

            }

        });


        return view;
    }

}
