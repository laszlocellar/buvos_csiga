/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import Business_Logic.*;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 *
 * Felvesszünk pár fontos adatot az adatbázis kapcsolat létrehozásához: driver,
 * adatbázis elérési útvonal, felhasználónév, jelszó.
 */
public class betoltes extends javax.swing.JFrame {

    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/buvoscsiga";
    String USER = "root";
    String PASS = "";

    /**
     *
     *
     * Itt történik a pálya betöltése. Egy SQL kóddal kilistázzuk az adatbázisba
     * elmentett pályákat.
     *
     *
     */
    public betoltes() {
        initComponents();
        DefaultTableModel model = new DefaultTableModel(new String[]{"Pálya készítője", "Pálya neve", "Pálya felépítése"}, 0);
        palyak_listazasa.setDefaultEditor(Object.class, null);

        Connection conn = null;
        Statement stmt = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql = "SELECT * FROM palyak";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String felhnev = rs.getString("felhnev");
                String nev = rs.getString("nev");
                String palya = rs.getString("palya");
                model.addRow(new Object[]{felhnev, nev, palya});
            }

            palyak_listazasa.setModel(model);

            TableColumnModel tcm = palyak_listazasa.getColumnModel();
            tcm.removeColumn(tcm.getColumn(2));

        } catch (SQLException se) {

            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        palyak_listazasa = new javax.swing.JTable();
        betoltes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pálya betöltése");

        palyak_listazasa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Pálya név"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(palyak_listazasa);

        betoltes.setText("Pálya betöltése");
        betoltes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betoltesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Pálya betöltése");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(betoltes)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(betoltes)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void betoltesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betoltesActionPerformed

        /**
         *
         *
         * Itt hívjuk meg az XMLbetoltes nevű metódust, amely betölti a
         * kiválasztott pályát.
         *
         */
        try {
            palyaFelepitese pf = new palyaFelepitese();

            pf.XMLbetoltes(palyak_listazasa.getModel().getValueAt(palyak_listazasa.getSelectedRow(), 1).toString());
            this.setVisible(false);
        } catch (Exception e) {
            showMessageDialog(null, "Kérem válasszon ki egy betöltendő pályát.", "Hiba", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_betoltesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton betoltes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable palyak_listazasa;
    // End of variables declaration//GEN-END:variables
}
