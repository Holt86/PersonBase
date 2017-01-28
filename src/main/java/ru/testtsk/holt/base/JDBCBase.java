package ru.testtsk.holt.base;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import ru.testtsk.holt.model.User;
import ru.testtsk.holt.service.SettingsJDBC;

import java.sql.*;
import java.util.*;

/**
 * Created by user on 26.01.2017.
 */
public class JDBCBase implements BaseInterface {
    private final Connection connection;
    private final static JDBCBase ourInstance = new JDBCBase();


    private JDBCBase() {
        SettingsJDBC settings = SettingsJDBC.getInstance();
        try{
            Class.forName(settings.value("jdbc.driver_class"));
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public static JDBCBase getInstance(){
        return ourInstance;
    }

    public Collection<User> values() {
        List<User> users = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet res = statement.executeQuery("SELECT * FROM test.user")) {
            while (res.next()) {
                int id = res.getInt(1);
                String name = res.getString(2);
                int age = res.getInt(3);
                boolean isAdmin = res.getBoolean(4);
                java.util.Date createDate = new java.util.Date(res.getTimestamp(5).getTime());
                users.add(new User(id, name, age, isAdmin, createDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    public Collection<User> findUser(String name) {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM test.user WHERE NAME =(?)")) {
            statement.setString(1, name);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                int id = res.getInt(1);
                int age = res.getInt(3);
                boolean isAdmin = res.getBoolean(4);
                java.util.Date createDate = new java.util.Date(res.getTimestamp(5).getTime());
                users.add(new User(id, name, age, isAdmin, createDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void add(User user) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT  INTO test.user(NAME, AGE, IS_ADMIN)  VALUES (?,?,?)")) {
            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setBoolean(3, user.getIsAdmin());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void edit(User user) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE test.user SET NAME=?, AGE=?, IS_ADMIN=? WHERE ID=?")) {
            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setBoolean(3, user.getIsAdmin());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM test.user WHERE ID=?")) {
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public User getUser(int id) {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM test.user WHERE ID=?")){
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            while (res.next()){
                String name = res.getString(2);
                int age = res.getInt(3);
                boolean isAdmin = res.getBoolean(4);
                java.util.Date createDate = new java.util.Date(res.getTimestamp(5).getTime());
                user = new User(id, name, age, isAdmin, createDate);}

        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
