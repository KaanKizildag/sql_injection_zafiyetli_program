/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqli_zafiyet.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sqli_zafiyet.entity.User;

/**
 *
 * @author kaan
 */
public class UserDao {

    private final DatabaseConnection dbConnection;

    public UserDao() {
        dbConnection = DatabaseConnection.getInstance();
    }

    public void insertUser(User user) {
        try {
            /// işte zafiyet burada
            String sql = String.format(
                    "delete from fake where id = 1; zinsert into users ("
                    + "name, "
                    + "password)"
                    + "values ('%s', '%s')",
                    user.getName(),
                    user.getPassword()
            );
            System.out.println("Sorgu:\n" + sql);
            PreparedStatement stat = dbConnection.getConnection().prepareStatement(
                    sql);
            stat.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        try {
            PreparedStatement stat = dbConnection
                    .getConnection()
                    .prepareStatement(String.format(
                            "select * from users"));

            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    public List<User> getAllByName(String name) {

        
        List<User> users = new ArrayList<>();

        try {
            // zafiyet
            PreparedStatement stat = dbConnection
                    .getConnection()
                    .prepareStatement(String.format(
                            "select * from users where name = '%s'", name));

            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    public boolean getByNameAndPassword(String name, String password) {

        try {
            String sql = String.format(
                    "select * from users where"
                    + " name = '%s' and password = '%s'",
                    name,
                    password);
            System.out.println("Sorgu: \n" + sql);
            PreparedStatement stat = dbConnection
                    .getConnection()
                    .prepareStatement(sql);

            ResultSet rs = stat.executeQuery();
            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
