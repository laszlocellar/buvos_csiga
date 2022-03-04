/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class menu extends javax.swing.JFrame {

    public menu() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        palya_merete = new javax.swing.JTextField();
        szamok_meddig = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        palya_szerkesztese = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        palya_betoltes = new javax.swing.JLabel();
        betoltes_palya = new javax.swing.JButton();
        kilepes = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        szabalyok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bűvös csiga");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bűvös csiga");

        jLabel2.setText("Mekkora legyen a pálya mérete? (n*n méretű):");

        palya_merete.setToolTipText("");
        palya_merete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palya_mereteActionPerformed(evt);
            }
        });

        szamok_meddig.setToolTipText("");
        szamok_meddig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                szamok_meddigActionPerformed(evt);
            }
        });

        jLabel3.setText("Meddig menjenk a számok?");

        palya_szerkesztese.setText("Pálya szerkesztése");
        palya_szerkesztese.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                palya_szerkeszteseMouseClicked(evt);
            }
        });
        palya_szerkesztese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palya_szerkeszteseActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Pályaszerkesztő");

        palya_betoltes.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        palya_betoltes.setText("Pálya betöltés");

        betoltes_palya.setText("Pálya kiválasztása");
        betoltes_palya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betoltes_palyaActionPerformed(evt);
            }
        });

        kilepes.setText("Kilépés");
        kilepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kilepesActionPerformed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 178));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

        szabalyok.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        szabalyok.setText("Játékszabályok");
        szabalyok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                szabalyokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(palya_merete, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(szabalyok, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(palya_szerkesztese))
                                    .addComponent(palya_betoltes)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(kilepes, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(betoltes_palya))))
                                .addGap(159, 159, 159))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(szamok_meddig, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(127, 127, 127))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(szabalyok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(palya_merete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(szamok_meddig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(palya_szerkesztese, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(palya_betoltes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(betoltes_palya, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kilepes, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void palya_szerkeszteseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palya_szerkeszteseActionPerformed

        /**
         *
         *
         * Eltárolja a szövegmezőkből kiolvasott értékeket, majd egy vizsgálat
         * utána eldönti, hogy a pálya létrehozható-e vagy sem.
         */
        try {
            int PalyaMerete = Integer.parseInt(palya_merete.getText().trim());
            int SzamokMeddig = Integer.parseInt(szamok_meddig.getText().trim());
            if (PalyaMerete > 0 && SzamokMeddig <= PalyaMerete * PalyaMerete) {

                dispose();
                palyaszerkeszto psz = new palyaszerkeszto(PalyaMerete, SzamokMeddig);
                this.setVisible(false);
                psz.setVisible(true);
            } else {
                showMessageDialog(null, "A megadott adatok nem megfelelőek. Kérem a pálya mérete legyen nagyobb 0-nál!", "Hiba", ERROR_MESSAGE);
            }

        } catch (NumberFormatException nfe) {
            showMessageDialog(null, "Kérem adjon meg értékeket.", "Hiba", ERROR_MESSAGE);
        }

    }//GEN-LAST:event_palya_szerkeszteseActionPerformed

    private void palya_szerkeszteseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_palya_szerkeszteseMouseClicked

    }//GEN-LAST:event_palya_szerkeszteseMouseClicked

    private void szamok_meddigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_szamok_meddigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_szamok_meddigActionPerformed

    private void palya_mereteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palya_mereteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_palya_mereteActionPerformed

    private void betoltes_palyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betoltes_palyaActionPerformed
        /**
         *
         * Betöltésre vonatkozó gomb esetén megnyitja a betoltes JFrame-et.
         *
         */

        betoltes b = new betoltes();
        b.setVisible(true);
        dispose();
    }//GEN-LAST:event_betoltes_palyaActionPerformed

    private void kilepesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kilepesActionPerformed
        this.dispose();

    }//GEN-LAST:event_kilepesActionPerformed

    private void szabalyokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_szabalyokActionPerformed

        /**
         *
         * Játékszabályzatra vonatkozó gomb megnyomása esetén megnyitja a
         * jatekszabalyzat JFrame-et.
         *
         */
        jatekszabalyzat jsz = new jatekszabalyzat();
        jsz.setVisible(true);
    }//GEN-LAST:event_szabalyokActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton betoltes_palya;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton kilepes;
    private javax.swing.JLabel palya_betoltes;
    private javax.swing.JTextField palya_merete;
    private javax.swing.JButton palya_szerkesztese;
    private javax.swing.JButton szabalyok;
    private javax.swing.JTextField szamok_meddig;
    // End of variables declaration//GEN-END:variables
}
