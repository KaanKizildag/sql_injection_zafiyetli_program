/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqli_zafiyet.UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author kaan
 */
public class UI_CONSTS {

    public static Font FONT = new Font(Font.MONOSPACED, Font.PLAIN, 18);
    public static Color BACKGROUND_COLOR = Color.darkGray;
    public static Color FOREGROUND_COLOR = Color.white;

    public static JTextField createTextField(String text) {
        JTextField textField = new JTextField();
        textField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                //textField.setText("");
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
        textField.setCaretColor(Color.white);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setText(text);
        textField.setFont(new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 18));
        textField.setBackground(BACKGROUND_COLOR);
        textField.setForeground(FOREGROUND_COLOR);

        textField.setSize(150, 60);
        return textField;

    }

    public static JButton createButton(ActionListener e) {
        JButton button = new JButton();
        button.setBackground(Color.white);
        button.addActionListener(e);
        return button;
    }

    public static JButton createButton(ActionListener e, Color c) {
        JButton button = createButton(e);
        button.setBackground(c);
        return button;
    }

    public static JLabel createJLabel() {
        JLabel label = new JLabel();
        label.setFont(FONT);
        label.setForeground(FOREGROUND_COLOR);
        return label;
    }
}
