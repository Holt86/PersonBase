package ru.testtsk.holt.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by user on 26.01.2017.
 */
public class Settings {
    private static final Settings SETTINGS = new Settings();

    private final Properties properties = new Properties();

    public static Settings getInstance() {
        return SETTINGS;
    }

    private Settings() {
        try {
            properties.load(new FileInputStream(this.getClass().getClassLoader().getResource("jdbc.properties").getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key){
        return this.properties.getProperty(key);
    }
}
