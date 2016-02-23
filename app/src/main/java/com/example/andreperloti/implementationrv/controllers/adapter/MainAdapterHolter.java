package com.example.andreperloti.implementationrv.controllers.adapter;


import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andreperloti.implementationrv.R;
import com.example.andreperloti.implementationrv.model.entities.Car;

import java.util.List;

/**
 * Created by andre.perloti on 19/02/2016.
 */
public class MainAdapterHolter extends RecyclerView.Adapter<MainAdapterHolter.ViewHolder> {


    private List<Car> cars;
    private Activity context;
    private Car car;

    public MainAdapterHolter(Activity context, List<Car> cars) {
        this.cars = cars;
        this.context = context;
    }

    @Override
    public MainAdapterHolter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_list_main, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        car = cars.get(position);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifyItemChanged(position);
            }
        });
        viewHolder.textViewCategoria.setText(car.getName());


    }

    public Car getItem(int position) {
        return cars.get(position);
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewCategoria;

        public ViewHolder(View view) {
            super(view);
            this.textViewCategoria = (TextView) view.findViewById(R.id.car);
        }

    }



}
