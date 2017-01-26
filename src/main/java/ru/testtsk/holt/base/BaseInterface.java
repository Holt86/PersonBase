package ru.testtsk.holt.base;

import ru.testtsk.holt.model.User;


import java.util.Collection;


/**
 * Created by user on 25.01.2017.
 */
public interface BaseInterface {

    Collection<User> values();

    Collection<User> findUser(final String name);

    void add(final User user);

    void edit(final User user);

    void delete(final int id);

    User getUser(final int id);

    void close();

}
