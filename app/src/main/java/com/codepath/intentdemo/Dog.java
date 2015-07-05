package com.codepath.intentdemo;

import android.os.Parcel;
import android.os.Parcelable;

public class Dog implements Parcelable{
    String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    protected Dog(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<Dog> CREATOR = new Creator<Dog>() {
        public Dog createFromParcel(Parcel source) {
            return new Dog(source);
        }

        public Dog[] newArray(int size) {
            return new Dog[size];
        }
    };
}
