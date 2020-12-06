/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business_Logic.*;
import java.sql.*;

/**
 *
 * @author Cellár László
 * 
 * Adatbázis kapcsolat létrehozásához szükséges adatokat definiálunk.
 * 
 */
public class mentes extends javax.swing.JFrame {

    palyaFelepitese pf;
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/buvoscsiga";
    String USER = "root";
    String PASS = "";

    /**
     * @author Szőllősi Viktor
     * 
     * A konstruktorban kapott pályafelépítést tárolja el.
     *
     */
    
    public mentes(palyaFelepitese palyafelepitese) {
        initComponents();
        this.pf = palyafelepitese;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        palya_nev = new javax.swing.JTextField();
        mentes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Kérem nevezze el a pályát!");

        palya_nev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palya_nevActionPerformed(evt);
            }
        });

        mentes.setText("Mentés");
        mentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mentesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(palya_nev)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(mentes)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(palya_nev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(mentes))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void palya_nevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palya_nevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_palya_nevActionPerformed

    private void mentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mentesActionPerformed
       
        /**
         * 
         * @author Cellár László
         * 
         * Két különböző SQL utasítást definiáltunk, az egyik akkor hajtódik végre,
         * ha még nincs a megadott névvel pálya.
         * A másik, akkor ha már van olyan névvel pálya. Ebben az esetben felülírja
         * az előző pályát.
         * 
         */
        
        String nev = palya_nev.getText();
        Connection conn = null;
        Statement stmt = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");

            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = conn.createStatement();

            PreparedStatement st = conn.prepareStatement("SELECT nev FROM palyak WHERE nev=?");
            st.setString(1, nev);
            st.execute();
            if (st.getResultSet().next()) //VAN ILYEN 
            {
                PreparedStatement preparedStmt = conn.prepareStatement("UPDATE palyak set palya = ? WHERE nev = ?");
                preparedStmt.setString(1, pf.XMLmentes());
                preparedStmt.setString(2, nev);
                preparedStmt.executeUpdate();

            } else //nincs ilyen név
            {
                PreparedStatement preparedStmt = conn.prepareStatement("INSERT INTO palyak " + "VALUES (?,?)");
                preparedStmt.setString(1, nev);
                preparedStmt.setString(2, pf.XMLmentes());
                preparedStmt.executeUpdate();
            }

           

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

        dispose();

    }//GEN-LAST:event_mentesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mentes;
    private javax.swing.JTextField palya_nev;
    // End of variables declaration//GEN-END:variables
}
