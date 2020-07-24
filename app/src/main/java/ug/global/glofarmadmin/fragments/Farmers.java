package ug.global.glofarmadmin.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ug.global.glofarmadmin.FarmerObjects;
import ug.global.glofarmadmin.R;
import ug.global.glofarmadmin.adapters.FarmersRecyclerViewAdapter;

public class Farmers extends Fragment {
    private ArrayList<FarmerObjects> farmerObjectsArrayList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_farmers, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.farmerrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        FarmersRecyclerViewAdapter farmersRecyclerViewAdapter = new FarmersRecyclerViewAdapter(farmerObjectsArrayList, getActivity());
        for (int i = 0; i < 10; i++) {
            FarmerObjects farmerObjects = new FarmerObjects("Nahabwe Farm", "0707878698", "Kanungu");
            farmerObjectsArrayList.add(farmerObjects);
            farmersRecyclerViewAdapter.notifyDataSetChanged();
        }
        recyclerView.setAdapter(farmersRecyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }


}
