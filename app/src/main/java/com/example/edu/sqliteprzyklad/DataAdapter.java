package com.example.edu.sqliteprzyklad;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class DataAdapter extends
        RecyclerView.Adapter<DataAdapter.ViewHolder> {

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View dataView = inflater.inflate(R.layout.item_data, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(dataView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        // Get the data model based on position
        COVIDData data = covidDataList.get(position);

        // Set item views based on your views and data model
        viewHolder.TextView1.setText("Country: "+data.getCountry());
        viewHolder.TextView23.setText(" Cases/Active: "+data.getCases()+"/"+data.getActive());
        viewHolder.TextView4.setText(" cPerOneM: "+data.getCasesPerOneMillion());
        viewHolder.TextView5.setText(" tPerOneM: "+data.getTestsPerOneMillion());
    }

    @Override
    public int getItemCount() {
        return covidDataList.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView TextView1;
        public TextView TextView23;
        public TextView TextView4;
        public TextView TextView5;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            TextView1 = (TextView) itemView.findViewById(R.id.country);
            TextView23 = (TextView) itemView.findViewById(R.id.cases);
            TextView4 = (TextView) itemView.findViewById(R.id.casesPerOneMillion);
            TextView5 = (TextView) itemView.findViewById(R.id.testsPerOneMillion);
        }
    }

    // Store a member variable for the contacts
    private List<COVIDData> covidDataList;

    // Pass in the contact array into the constructor
    public DataAdapter(List<COVIDData> data) {
        covidDataList = data;
    }





}
