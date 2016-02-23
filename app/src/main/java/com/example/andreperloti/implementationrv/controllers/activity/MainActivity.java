package com.example.andreperloti.implementationrv.controllers.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.andreperloti.implementationrv.R;
import com.example.andreperloti.implementationrv.controllers.adapter.MainAdapterHolter;
import com.example.andreperloti.implementationrv.controllers.adapter.RecyclerItemClickListener;
import com.example.andreperloti.implementationrv.model.entities.Car;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerViewCarros;
    private Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindToolbar();
        bindRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        onUpdate();
    }

    private void onUpdate() {
        ArrayList<Car> cars = new ArrayList<>();
        Car car1 = new Car(1L, "Gol");
        Car car2 = new Car(2L, "Golf");
        Car car3 = new Car(3L, "Vectra");
        Car car4 = new Car(4L, "Astra");
        Car car5 = new Car(4L, "Porsche");
        Car car6 = new Car(4L, "Cruze");
        Car car7 = new Car(4L, "HB20");

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);

        recyclerViewCarros.setAdapter(new MainAdapterHolter(this, cars));
    }

    public void bindToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Exemplo RecyclerView");
        setSupportActionBar(toolbar);
    }


    /**
     * Basta apenas implementar as funções de click aqui.
     */
    private void bindRecyclerView() {
        recyclerViewCarros = (RecyclerView) findViewById(R.id.listaA);
        recyclerViewCarros.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCarros.setItemAnimator(new DefaultItemAnimator());
        registerForContextMenu(recyclerViewCarros);
        recyclerViewCarros.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerViewCarros, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        MainAdapterHolter adapter = (MainAdapterHolter) recyclerViewCarros.getAdapter();
                        car = adapter.getItem(position);
                        Toast.makeText(MainActivity.this, "Click Normal, item: " + position + " " + car.getName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                        MainAdapterHolter adapter = (MainAdapterHolter) recyclerViewCarros.getAdapter();
                        car = adapter.getItem(position);
                        Toast.makeText(MainActivity.this, "Click LONGO, item: " + position + " " + car.getName(), Toast.LENGTH_SHORT).show();
                    }
                })
        );
    }

}
