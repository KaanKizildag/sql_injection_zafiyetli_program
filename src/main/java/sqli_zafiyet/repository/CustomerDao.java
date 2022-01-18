/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqli_zafiyet.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import sqli_zafiyet.entity.Customer;

/**
 *
 * @author kaan
 */
public class CustomerDao {

    private DatabaseConnection dbConnection;

    public CustomerDao() {
        dbConnection = DatabaseConnection.getInstance();
    }

    public Customer getByCustomerName(String customerName) {

        Customer customer = new Customer();

        String sql = String.format(
                "select * from customers where customer_name = '%s'",
                customerName);
        System.out.println("Sorgu:\n" + sql);
        try {
            Statement stat = dbConnection.getConnection().createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                customer.setCustomerName(rs.getString("customer_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhoneNumber(rs.getString("phone_number"));
                customer.setId(rs.getInt("id"));
            } else {
                System.out.println("Kullanıcı bulunamadı");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(customer);
        return customer;
    }

    public void insertUser(Customer customer) {
        try {
            /// işte zafiyet burada
            String sql = String.format(
                    "insert into customers ("
                    + "customer_name, "
                    + "email,"
                    + "phone_number)"
                    + "values ('%s', '%s', '%s')",
                    customer.getCustomerName(),
                    customer.getEmail(),
                    customer.getPhoneNumber()
            );
            System.out.println("Sorgu:\n" + sql);
            PreparedStatement stat = dbConnection.getConnection().prepareStatement(
                    sql);
            stat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
