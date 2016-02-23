package com.example.andreperloti.implementationrv.model.persistence;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.andreperloti.implementationrv.model.entities.Car;

import java.util.List;

/**
 * Created by andre.perloti on 19/02/2016.
 */
public class CarRepository {

    public static void saveUpdate(Car car) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues contentValues = CarContract.getContentValues(car);
        if (car.getIdCar() == null) {
            db.insert(CarContract.TABLE, null, contentValues);
        } else {
            String where = CarContract.IDCAR + " =? ";
            String[] parans = {car.getIdCar().toString()};
            db.update(CarContract.TABLE, contentValues, where, parans);
        }

        db.close();
        databaseHelper.close();
    }

    public static void save(Car car) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues contentValues = CarContract.getContentValues(car);
        db.insert(CarContract.TABLE, null, contentValues);

        db.close();
        databaseHelper.close();
    }


    public static void delete(Long id) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        String where = CarContract.IDCAR + " =? ";
        String[] params = {String.valueOf(id)};
        db.delete(CarContract.TABLE, where, params);

        db.close();
        databaseHelper.close();
    }


    public static Car getCarById(Long id) {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = CarContract.IDCAR + " = ? ";
        String[] params = {String.valueOf(id)};
        Cursor cursor = db.query(CarContract.TABLE, CarContract.COLUMNS, where, params, null, null, null);
        Car car = CarContract.getCar(cursor);

        db.close();
        databaseHelper.close();
        return car;
    }

    public static List<Car> getAll() {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        Cursor cursor = db.query(CarContract.TABLE, CarContract.COLUMNS, null, null, null, null, null);
        List<Car> values = CarContract.getListCars(cursor);

        db.close();
        databaseHelper.close();
        return values;
    }



}
