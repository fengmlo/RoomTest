package me.fengmlo.roomtest.database.entity;

import android.arch.persistence.room.ColumnInfo;

public class Address {

    public String street;
    public String state;
    public String city;

    @ColumnInfo(name = "post_code")
    public int postCode;
}
