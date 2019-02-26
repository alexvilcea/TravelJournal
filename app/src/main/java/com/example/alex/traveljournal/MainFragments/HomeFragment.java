package com.example.alex.traveljournal.MainFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alex.traveljournal.MainActivity;
import com.example.alex.traveljournal.R;
import com.example.alex.traveljournal.addtrip.AddTripActivity;
import com.example.alex.traveljournal.mytrips.MyTripsActivity;
import com.example.alex.traveljournal.mytrips.RecyclerViewAdapter;
import com.example.alex.traveljournal.tryRecycleView.Trip;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static android.support.constraint.Constraints.TAG;

public class HomeFragment extends Fragment{
    private FloatingActionButton floatingActionButton;
    private RecyclerView myrecyclerview;
    private com.example.alex.traveljournal.tryRecycleView.RecyclerViewAdapter recyclerViewAdapter;
    private List<Trip> lstTrip;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        createTripList();
        buildRecyclerView(view);

//        myrecyclerview = (RecyclerView) view.findViewById(R.id.home_recyclerview);
//        com.example.alex.traveljournal.tryRecycleView.RecyclerViewAdapter recyclerViewAdapter = new com.example.alex.traveljournal.tryRecycleView.RecyclerViewAdapter(getContext(),lstTrip);
//        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
//        myrecyclerview.setAdapter(recyclerViewAdapter);

        floatingActionButton =(FloatingActionButton) view.findViewById(R.id.add_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddActivity();
//                insertItem(lstTrip.size()-1);
            }
        });




        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstTrip = new ArrayList<>();
        initImageBitmaps();



    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");


        lstTrip.add(new Trip("Holiday 2017","Islands",getString(R.string.imageUrl1)));
        lstTrip.add(new Trip("Fall 2017","Rome",getString(R.string.imageUrl2)));
        lstTrip.add(new Trip("Summer 2017","London",getString(R.string.imageUrl3)));


    }

    public void openAddActivity(){
        Intent intent = new Intent(getContext(), AddTripActivity.class);
        startActivityForResult(intent,1);
    }

    public void insertItem(int position, String name, String description){
        lstTrip.add(new Trip(name,description,getString(R.string.imageUrl3)));
        recyclerViewAdapter.notifyItemInserted(position+1);

    }

    public void createTripList(){
        lstTrip = new ArrayList<>();
        initImageBitmaps();
    }
    public void buildRecyclerView(View view){
        myrecyclerview = (RecyclerView) view.findViewById(R.id.home_recyclerview);
        recyclerViewAdapter = new com.example.alex.traveljournal.tryRecycleView.RecyclerViewAdapter(getContext(),lstTrip);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1){
            if(resultCode == RESULT_OK){
                String[] result = data.getStringArrayExtra("result");
                insertItem(lstTrip.size()-1,result[0],result[1]);
            }

        }
    }
}
