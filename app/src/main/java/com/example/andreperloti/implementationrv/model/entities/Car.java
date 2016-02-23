package com.example.andreperloti.implementationrv.model.entities;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by andre.perloti on 19/02/2016.
 */
public class Car implements Parcelable {
    private Long idCar;
    private String name;

    public Car(Long idCar, String name) {
        this.idCar = idCar;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!idCar.equals(car.idCar)) return false;
        return name.equals(car.name);

    }

    @Override
    public int hashCode() {
        int result = idCar.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.idCar);
        dest.writeString(this.name);
    }

    public Car() {
    }

    protected Car(Parcel in) {
        this.idCar = (Long) in.readValue(Long.class.getClassLoader());
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Car> CREATOR = new Parcelable.Creator<Car>() {
        public Car createFromParcel(Parcel source) {
            return new Car(source);
        }

        public Car[] newArray(int size) {
            return new Car[size];
        }
    };
}
