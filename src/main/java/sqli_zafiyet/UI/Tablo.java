/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqli_zafiyet.UI;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kaan
 */
public class Tablo extends JTable {

    private static Tablo tablo;

    public static Tablo getTablo() {
        if (tablo == null) {
            tablo = new Tablo();
        }
        return tablo;
    }

    private Tablo() {

        setFont(new java.awt.Font("Dialog", 0, 18));
        setBackground(Color.darkGray);
        setForeground(Color.white);
        setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "id", "isim", "parola"
                }
        ) {
            Class[] types = new Class[]{
                Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });

        setRowHeight(32);
        JScrollPane JScrollPane1 = new JScrollPane();
        JScrollPane1.setViewportView(this);

    }

    public void insertUser(int id, String name, String password) {
        DefaultTableModel model = (DefaultTableModel) tablo.getModel();
        int rowCount = model.getRowCount();
        model.addRow(new Object[]{id, name, password});
    }

    public static void removeAllRows() {
        DefaultTableModel model = (DefaultTableModel) tablo.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

}
