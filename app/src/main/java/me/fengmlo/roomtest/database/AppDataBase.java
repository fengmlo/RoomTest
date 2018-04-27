package me.fengmlo.roomtest.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import me.fengmlo.roomtest.database.dao.UserDao;
import me.fengmlo.roomtest.database.entity.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
