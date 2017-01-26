package ru.testtsk.holt.service;

import ru.testtsk.holt.base.BaseCache;
import ru.testtsk.holt.base.BaseInterface;
import ru.testtsk.holt.base.JDBCBase;

/**
 * Created by user on 25.01.2017.
 */
public class BaseFactory {

    public static BaseInterface getBase(){
        return JDBCBase.getInstance();
    }
}
