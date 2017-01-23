package ru.testtsk.holt.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 20.01.2017.
 */
public class User {
    private int id;
    private String name;
    private int age;
    private boolean isAdmin;
    private Date createDate;

    public User(int id, String name, int age, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
        this.createDate = new Date();
    }

    public int getId() {
        return id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }


    public String getCreateDateString() {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return format.format(getCreateDate());
    }
}
