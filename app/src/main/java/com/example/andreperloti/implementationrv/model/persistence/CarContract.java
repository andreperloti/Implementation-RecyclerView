package com.example.andreperloti.implementationrv.model.persistence;


import android.content.ContentValues;
import android.database.Cursor;

import com.example.andreperloti.implementationrv.model.entities.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre.perloti on 19/02/2016.
 */
public class CarContract {

    public static final String TABLE = "car";
    public static final String IDCAR = "idcar";
    public static final String NAME = "name";

    public static final String[] COLUMNS = {IDCAR, NAME};

    public CarContract() {
    }

    public static String getCreateTableScript(){

        final StringBuilder create = new StringBuilder();

        create.append(" CREATE TABLE " + TABLE);
        create.append(" ( ");
        create.append(IDCAR + " INTEGER PRIMARY KEY, ");
        create.append(NAME + " TEXT NOT NULL, ");
        create.append(" ); ");

        return create.toString();
    }

    public static ContentValues getContentValues(Car gategoria){
        ContentValues values = new ContentValues();
        values.put(CarContract.IDCAR, gategoria.getIdCar());
        values.put(CarContract.NAME, gategoria.getName());

        return values;
    }

    public static Car getCar(Cursor cursor){
        if (!cursor.isBeforeFirst() || cursor.moveToNext()) {
            Car gategoria = new Car();
            gategoria.setIdCar(cursor.getLong(cursor.getColumnIndex(CarContract.IDCAR)));
            gategoria.setName(cursor.getString(cursor.getColumnIndex(CarContract.NAME)));
            return gategoria;
        }else{
            return null;
        }
    }

    public static List<Car> getListCars(Cursor cursor){
        ArrayList<Car> gategorias = new ArrayList<>();
        while (cursor.moveToNext()){
            gategorias.add(getCar(cursor));
        }
        return gategorias;
    }

}
