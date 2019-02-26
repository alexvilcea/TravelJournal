package com.example.alex.traveljournal.mytrips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.alex.traveljournal.R;

import java.util.ArrayList;

public class MyTripsActivity extends AppCompatActivity {
    private static final String TAG = "MyTripsActivity";

    //vars
    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImageDescriptions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_trips);


        Log.d(TAG, "onCreate: started");
        initImageBitmaps();

    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        mImageUrls.add(getString(R.string.imageUrl1));
        mTitles.add("Holiday 2017");
        mImageDescriptions.add("Islands");

        mImageUrls.add(getString(R.string.imageUrl2));
        mTitles.add("Fall 2017");
        mImageDescriptions.add("Rome");

        mImageUrls.add(getString(R.string.imageUrl3));
        mTitles.add("Summer 2017");
        mImageDescriptions.add("London");

        mImageUrls.add(getString(R.string.imageUrl4));
        mTitles.add("Winter 2017");
        mImageDescriptions.add("Paris");

        mImageUrls.add(getString(R.string.imageUrl5));
        mTitles.add("Spring 2018");
        mImageDescriptions.add("San Francisco");

        mImageUrls.add(getString(R.string.imageUrl6));
        mTitles.add("Summer 2018");
        mImageDescriptions.add("Amsterdam");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.my_trips);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mTitles,mImageDescriptions,mImageUrls,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
