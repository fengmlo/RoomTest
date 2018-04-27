package me.fengmlo.roomtest;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import me.fengmlo.roomtest.database.AppDataBase;
import me.fengmlo.roomtest.database.dao.UserDao;
import me.fengmlo.roomtest.database.entity.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDataBase db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "room_db").build();
        final UserDao userDao = db.getUserDao();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4));

        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<User> users = new ArrayList<>(10);
                for (int i = 1; i <= 10; i++) {
                    User user = new User();
                    user.setName("Jim" + i);
                    user.setAge(i * 10);
                    user.setId(i);
                    users.add(user);
                }

                userDao.insertAll(users);

                for (int i = 1; i <= 10; i++) {
                    User userById = userDao.getUserById(i);
                    System.out.println("User: id=" + userById.getId() + " name=" + userById.getName() + " age=" + userById.getAge());
                }

            }
        });


    }
}
