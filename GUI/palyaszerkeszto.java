/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business_Logic.palyaFelepitese;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 *
 * Eltárolja globálisan a pálya méretét, hogy meddig mennek a számok, a gombok
 * felépítését, illetve a pálya szerkezetét.
 *
 */
public class palyaszerkeszto extends javax.swing.JFrame implements ActionListener {

    int PalyaMerete, SzamokMeddig;
    JButton[][] mezo;
    palyaFelepitese pf;

    /**
     *
     *
     * A konstruktor paramétereiül kapott értékeket eltárolja a globális
     * változókba, illetve létrehozza a gombokat, plusz a pályát.
     *
     */
    public palyaszerkeszto(int inputPalyaMerete, int inputSzamokMeddig) {

        initComponents();
        PalyaMerete = inputPalyaMerete;
        SzamokMeddig = inputSzamokMeddig;
        mezo = new JButton[PalyaMerete][PalyaMerete];
        palya_letrehozas(PalyaMerete, SzamokMeddig, inputPalyaMerete);

    }

    /**
     *
     *
     * Létrehozza a gombokat, illetve lekérdezi a hozzáillő szöveget.
     *
     */
    private void palya_letrehozas(int PalyaMerete, int SzamokMeddig, int inputPalyaMerete) {

        palya.setLayout(new GridLayout(inputPalyaMerete, inputPalyaMerete, 5, 5));
        palya.setVisible(true);
        gombok.setLayout(new GridLayout(1, 2));
        gombok.setVisible(true);
        int valtozo = 0;

        pf = new palyaFelepitese(PalyaMerete, SzamokMeddig);
        pf.palyaKorkoros(PalyaMerete, 0, 0);

        for (int n = 0; n < PalyaMerete; n++) {
            for (int n2 = 0; n2 < PalyaMerete; n2++) {

                mezo[n][n2] = new JButton();

                mezo[n][n2].setText(pf.nyil(n, n2));
                mezo[n][n2].setFont(new Font("Arial Black", Font.PLAIN, 22));
                mezo[n][n2].setFocusable(false);
                mezo[n][n2].addActionListener(this);

                mezo[n][n2].setPreferredSize(new Dimension(40, 40));
                palya.add(mezo[n][n2]);
                valtozo++;
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        palya = new javax.swing.JPanel();
        gombok = new javax.swing.JPanel();
        jatek_inditasa = new javax.swing.JButton();
        palya_mentese = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pályaszerkesztő");

        palya.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout palyaLayout = new javax.swing.GroupLayout(palya);
        palya.setLayout(palyaLayout);
        palyaLayout.setHorizontalGroup(
            palyaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        palyaLayout.setVerticalGroup(
            palyaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jatek_inditasa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jatek_inditasa.setText("Játék indítása");
        jatek_inditasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jatek_inditasaActionPerformed(evt);
            }
        });

        palya_mentese.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        palya_mentese.setText("Pálya mentése");
        palya_mentese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palya_menteseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gombokLayout = new javax.swing.GroupLayout(gombok);
        gombok.setLayout(gombokLayout);
        gombokLayout.setHorizontalGroup(
            gombokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gombokLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(palya_mentese)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jatek_inditasa)
                .addGap(23, 23, 23))
        );
        gombokLayout.setVerticalGroup(
            gombokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gombokLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(gombokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jatek_inditasa)
                    .addComponent(palya_mentese))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pályaszerkesztő");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gombok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(palya, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(palya, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gombok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     *
     * Felépíti a pályát körkörösen, majd megvizsgálja, hogy a pálya eleget
     * tesz-e a feltételeknek, ha igen, akkor átugrik a mentésre. Ha nem, akkor
     * hibát ír ki.
     *
     */
    private void palya_menteseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palya_menteseActionPerformed

        try {

            pf.palyaKorkoros(PalyaMerete, 0, 0);

            if ((pf.palyaJo() == true) && (pf.vaneHely() == true)) {
                mentes m = new mentes(pf);
                m.setVisible(true);
            } else {
                showMessageDialog(null, "Egy sorban és oszlopban csak egyszer szerepeljen egy szám. Továbbá a számok növekvő sorrendben kövessék egymást.", "Hiba", ERROR_MESSAGE);
            }

        } catch (NumberFormatException nfe) {
            showMessageDialog(null, "Hibába ütköztem.", "Hiba", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_palya_menteseActionPerformed

    /**
     *
     *
     * Felépíti a pályát körkörösen, majd megvizsgálja, hogy a pálya eleget
     * tesz-e a feltételeknek. Ha nem, akkor hibát ír ki.
     *
     */
    private void jatek_inditasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jatek_inditasaActionPerformed

        try {

            pf.palyaKorkoros(PalyaMerete, 0, 0);
            if ((pf.palyaJo() == true) && (pf.vaneHely() == true)) {

                dispose();
                jatek j = new jatek(PalyaMerete, SzamokMeddig, pf);
                j.setVisible(true);
            } else {
                showMessageDialog(null, "Egy sorban és oszlopban csak egyszer szerepeljen egy szám. Továbbá a számok növekvő sorrendben kövessék egymást.", "Hiba", ERROR_MESSAGE);
            }

        } catch (NumberFormatException nfe) {
            showMessageDialog(null, "Hibába ütköztem.", "Hiba", ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jatek_inditasaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gombok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jatek_inditasa;
    private javax.swing.JPanel palya;
    private javax.swing.JButton palya_mentese;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * Vizsgálja a gombokon történő aktivitást és aszerint állít be nekik
     * értéket.
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < PalyaMerete; i++) {
            for (int j = 0; j < PalyaMerete; j++) {
                if (e.getSource() == mezo[i][j]) {
                    if (mezo[i][j].getText() == "↑" || mezo[i][j].getText() == "↓" || mezo[i][j].getText() == "→" || mezo[i][j].getText() == "←" || mezo[i][j].getText() == "") {
                        mezo[i][j].setText("1");
                        pf.ertekHozzaadas(i, j, Integer.parseInt(mezo[i][j].getText()));

                    } else if (Integer.parseInt(mezo[i][j].getText()) < SzamokMeddig) {
                        mezo[i][j].setText(String.valueOf(Integer.parseInt(mezo[i][j].getText()) + 1));
                        pf.ertekHozzaadas(i, j, Integer.parseInt(mezo[i][j].getText()));

                    } else {
                        mezo[i][j].setText(pf.nyil(i, j));
                        pf.ertekHozzaadas(i, j, 0);

                    }

                }

            }
        }

    }
}
