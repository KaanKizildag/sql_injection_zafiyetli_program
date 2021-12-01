/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqli_zafiyet.UI;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import sqli_zafiyet.entity.User;
import sqli_zafiyet.repository.UserDao;

/**
 *
 * @author kaan
 */
public class BilgiPaneli extends JPanel {

    public BilgiPaneli() {
        super();

        setLayout(new GridLayout());

        UserDao userDao = new UserDao();
        JScrollPane JScrollPane1 = new JScrollPane();
        JScrollPane1.setViewportView(Tablo.getTablo());
        add(JScrollPane1);
        JLabel label = new JLabel();
        JPanel insertForm = new JPanel();
        insertForm.setLayout(new GridLayout(4, 1));
        JTextField tbxName = UI_CONSTS.createTextField("yeni İsim");
        JTextField tbxPassword = UI_CONSTS.createTextField("parola");

        insertForm.add(tbxName);
        insertForm.add(tbxPassword);
        insertForm.add(label);
        
        JButton insertButton = new JButton("Kullanıcı ekle");
        insertButton.setBackground(Color.green);
        insertButton.addActionListener((e) -> {
            if (Frame.isLogged) {
                User user = new User();
                user.setName(tbxName.getText());
                user.setPassword(tbxPassword.getText());
                userDao.insertUser(user);

            } else {
                label.setText("Önce giriş yapın");
                label.setForeground(Color.red);

            }

        });

        JButton getAllButton = UI_CONSTS.createButton((e) -> {
            if (Frame.isLogged) {
                Tablo.removeAllRows();
                List<User> users = userDao.getAll();
                users.forEach(user -> {
                    Tablo.getTablo().insertUser(
                            user.getId(),
                            user.getName(),
                            user.getPassword());
                });
                label.setText("Listelendi");
                label.setForeground(Color.green);
            } else {
                label.setText("önce giriş yapın");
                label.setForeground(Color.red);
            }

        }, Color.orange);

        getAllButton.setText("müşterileri listele");
        
        JButton logOutButton = UI_CONSTS.createButton((e) -> {
            Frame.isLogged = false;
        }, Color.red);

        logOutButton.setText("Çıkış yap");
        
        insertForm.add(insertButton);
        insertForm.add(getAllButton);
        insertForm.add(logOutButton);

        add(insertForm);
    }
}
