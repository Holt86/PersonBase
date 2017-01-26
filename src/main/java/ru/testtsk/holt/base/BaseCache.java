package ru.testtsk.holt.base;

import ru.testtsk.holt.model.User;

import java.util.ArrayList;
import java.util.Collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 20.01.2017.
 */
public class BaseCache implements BaseInterface {
    private static BaseCache ourInstance = new BaseCache();
    private static final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<Integer, User>();
    private static final AtomicInteger ID = new AtomicInteger(1);

    public static BaseCache getInstance() {
        return ourInstance;
    }

    private BaseCache() {
    }

    public Collection<User> values(){
        return users.values();
    }

    public Collection<User> findUser(final String name) {
        Collection<User> findUser = new ArrayList<User>();
        for (Map.Entry<Integer, User> pair : users.entrySet()) {
            if (pair.getValue().getName().equals(name))
                findUser.add(pair.getValue());
        }
        return findUser;
    }

    public void add(final User user) {
        user.setId(ID.getAndIncrement());
        users.put(user.getId(), user);
    }

    public void edit(final User user) {
        users.replace(user.getId(), user);
    }

    public void delete(final int id) {
        users.remove(id);
    }

    public User getUser(final int id) {
        return users.get(id);
    }

    public void close() {
       /* NOP*/
    }


}
