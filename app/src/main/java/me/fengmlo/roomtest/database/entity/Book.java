package me.fengmlo.roomtest.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "user_id"))
public class Book {

    @PrimaryKey(autoGenerate = true)
    public int bookId;

    public String title;

    @ColumnInfo(name = "user_id")
    public int userId;
}
