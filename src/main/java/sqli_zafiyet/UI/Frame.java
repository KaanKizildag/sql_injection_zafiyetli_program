/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqli_zafiyet.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author kaan
 */
public class Frame extends JFrame {

    public static boolean isLogged = false;

    public Frame() {
        super();
        setLayout(new GridLayout(1, 1));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(true);
        setTitle("zafiyet içeren program");
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        //new Thread(() -> {
            tabbedPane.add(new Panel(), "zafiyet1");
        //}).start();

        new Thread(() -> {
            tabbedPane.add(new BilgiPaneli(), "zafiyet2");
        }).start();
        new Thread(() -> {
            tabbedPane.add(new MusteriEklemePaneli(), "zafiyet3");
        }).start();
         new Thread(() -> {
            tabbedPane.add(new MusteriSayfasi(), "zafiyet4");
        }).start();

        add(tabbedPane);

    }
}
