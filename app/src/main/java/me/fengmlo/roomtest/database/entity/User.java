package me.fengmlo.roomtest.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users", indices = {
        @Index("name"),
        @Index(value = {"name", "age"}, unique = true)})
public class User {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    private int age;

    @Embedded(prefix = "ad") // 当有多个相同的嵌套字段时，指定每个字段的前缀
    private Address address; // 会分解成Address中的字段

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
