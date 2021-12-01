/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqli_zafiyet.UI;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sqli_zafiyet.repository.UserDao;

/**
 *
 * @author kaan
 */
public class Panel extends JPanel {

    public Panel() {
        setBackground(Color.darkGray);
        JButton button = new JButton("Giriş yap");
        setSize(800, 600);
        setLayout(new GridLayout(2, 2));
        JTextField textField1 = UI_CONSTS.createTextField("parola");
        JTextField textField = UI_CONSTS.createTextField("isim");
        JPanel formArea = new JPanel();
        formArea.setLayout(new GridLayout());
        formArea.setBackground(Color.darkGray);
        formArea.add(textField);
        formArea.add(textField1);

        JLabel label = new JLabel("Giriş yapınız");
        label.setFont(UI_CONSTS.FONT);
        label.setForeground(Color.white);
        formArea.add(label);
        add(formArea);
        button.setBackground(Color.cyan);
        button.addActionListener((ae) -> {
            UserDao userDao = new UserDao();

            if (userDao.getByNameAndPassword(textField.getText(), textField1.getText())) {

                label.setText(String.format("Hoş geldiniz %s ", textField.getText()));
                label.setForeground(Color.green);
//               
                Frame.isLogged = true;
            } else {
                label.setText("Hatalı giriş");
                label.setForeground(Color.red);
            }

        });
        add(button);
//        
    }

}
