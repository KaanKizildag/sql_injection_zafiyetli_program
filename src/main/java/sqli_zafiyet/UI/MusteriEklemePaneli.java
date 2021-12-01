/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqli_zafiyet.UI;

import java.awt.Color;
import sqli_zafiyet.entity.Customer;
import sqli_zafiyet.repository.CustomerDao;

/**
 *
 * @author kaan
 */
public class MusteriEklemePaneli extends javax.swing.JPanel {

    /**
     * Creates new form GirisPaneli
     */
    public MusteriEklemePaneli() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = UI_CONSTS.createJLabel();
        tbxName = UI_CONSTS.createTextField("");
        jLabel2 = UI_CONSTS.createJLabel();
        tbxEmail = UI_CONSTS.createTextField("");
        jLabel3 = UI_CONSTS.createJLabel();
        tbxPhoneNumber = UI_CONSTS.createTextField("");
        jButton1 = UI_CONSTS.createButton((ae) -> {
            insertCustomer();
        }, Color.GREEN);

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new java.awt.GridLayout(5, 2));

        jLabel1.setText("Müsteri adı");
        add(jLabel1);

        tbxName.setText("Müşteri adı");
        add(tbxName);

        jLabel2.setText("Email");
        add(jLabel2);

        tbxEmail.setText("Email");
        add(tbxEmail);

        jLabel3.setText("Telefon");
        add(jLabel3);

        tbxPhoneNumber.setText("Telefon numarası");
        add(tbxPhoneNumber);

        jButton1.setText("Müşteriyi Kaydet");
        add(jButton1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tbxEmail;
    private javax.swing.JTextField tbxName;
    private javax.swing.JTextField tbxPhoneNumber;
    // End of variables declaration//GEN-END:variables

    private void insertCustomer() {
        CustomerDao customerDao = new CustomerDao();
        Customer user = new Customer();
        user.setCustomerName(tbxName.getText());
        user.setPhoneNumber(tbxPhoneNumber.getText());
        user.setEmail(tbxEmail.getText());
        customerDao.insertUser(user);
    }
}