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
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import search.State;

/**
 *
 *
 * Létrehozzuk a mezőként szolgáló gombokat és betöltjük a létrehozott pályát.
 *
 */
public class jatek extends javax.swing.JFrame implements ActionListener {

    JButton[][] mezo;
    //int[][] mezoTomb;
    int PalyaMerete, SzamokMeddig;
    palyaFelepitese pf;
    String[][] eredeti;
    
    //LinkedList<palyaFelepitese> megoldas = new LinkedList<>();
    //Iterator<palyaFelepitese> iterator = null;
    
    int lepes=0;
    List<State> solution = null;

    /**
     *
     *
     * A konstruktoron keresztül kapott értékekből meghatározzuk és létrehozzuk
     * a pálya méretét, elmentjük, hogy meddig lehet menni a számokkal, illetve
     * betöltjük a pályát, amelyet már létrehoztunk.
     * @param inputPalyaMerete A pálya méretét jelzi.
     * @param inputSzamokMeddig Azt mutatja, hogy meddig használhatunk fel
     * számokat a játék során.
     * @param palyafelepitese A létrehozott pályát tárolja.
     *
     */
    public jatek(int inputPalyaMerete, int inputSzamokMeddig, palyaFelepitese palyafelepitese) {
        initComponents();
        PalyaMerete = inputPalyaMerete;
        SzamokMeddig = inputSzamokMeddig;
        mezo = new JButton[PalyaMerete + 1][PalyaMerete + 1];
        eredeti = new String[PalyaMerete + 1][PalyaMerete + 1];
        pf = palyafelepitese;
        palyabetoltese();
        
       
        
    }

    /**
     *
     *
     * Itt töljük be a pályát, amelyet már létrehozunk. Megalkotjuk a mezőként
     * funkcionáló gombokat, valamint betöltjük rájuk a megfelelő tartalmakat. A
     * pályaszerkesztő során létrehozott gombok használhatóságát letiltjuk.
     *
     */
    public void palyabetoltese() {
        palya.setLayout(new GridLayout(PalyaMerete, PalyaMerete, 5, 5));
        palya.setVisible(true);
        gombok.setLayout(new GridLayout(1, 2));
        gombok.setVisible(true);
        gombok2.setLayout(new GridLayout(1, 2));
        vegso.setVisible(false); 
        kovetkezo.setVisible(false);
        elozo.setVisible(false); 

        for (int n = 0; n < PalyaMerete; n++) {
            for (int n2 = 0; n2 < PalyaMerete; n2++) {

                mezo[n][n2] = new JButton();

                mezo[n][n2].setText(pf.ertekLekerdezes(n, n2));
                mezo[n][n2].setFocusable(false);
                mezo[n][n2].setFont(new Font("Arial Black", Font.PLAIN, 22));
                mezo[n][n2].addActionListener(this);
                mezo[n][n2].setPreferredSize(new Dimension(40, 40));
                palya.add(mezo[n][n2]);

                if ((!(mezo[n][n2].getText().equalsIgnoreCase("↑"))) && (!(mezo[n][n2].getText().equalsIgnoreCase("↓"))) && (!(mezo[n][n2].getText().equalsIgnoreCase("→"))) && (!(mezo[n][n2].getText().equalsIgnoreCase("←"))) && (!(mezo[n][n2].getText().equalsIgnoreCase("")))) {
                    mezo[n][n2].setEnabled(false);
                }

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

        palya = new javax.swing.JPanel();
        gombok2 = new javax.swing.JPanel();
        kovetkezo = new javax.swing.JButton();
        elozo = new javax.swing.JButton();
        vegso = new javax.swing.JButton();
        gombok = new javax.swing.JPanel();
        kilepes = new javax.swing.JButton();
        ellenorzes = new javax.swing.JButton();
        megoldo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bűvös csiga játék");

        palya.setMinimumSize(new java.awt.Dimension(300, 300));
        palya.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout palyaLayout = new javax.swing.GroupLayout(palya);
        palya.setLayout(palyaLayout);
        palyaLayout.setHorizontalGroup(
            palyaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 714, Short.MAX_VALUE)
        );
        palyaLayout.setVerticalGroup(
            palyaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        kovetkezo.setText("Következő lépés");
        kovetkezo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kovetkezoActionPerformed(evt);
            }
        });

        elozo.setText("Előző lépés");
        elozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elozoActionPerformed(evt);
            }
        });

        vegso.setText("Végső megoldás");
        vegso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vegsoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gombok2Layout = new javax.swing.GroupLayout(gombok2);
        gombok2.setLayout(gombok2Layout);
        gombok2Layout.setHorizontalGroup(
            gombok2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gombok2Layout.createSequentialGroup()
                .addComponent(elozo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kovetkezo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vegso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gombok2Layout.setVerticalGroup(
            gombok2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gombok2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gombok2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kovetkezo)
                    .addComponent(elozo)
                    .addComponent(vegso)))
        );

        kilepes.setText("Kilépés");
        kilepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kilepesActionPerformed(evt);
            }
        });

        ellenorzes.setText("Ellenőrzés");
        ellenorzes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ellenorzesActionPerformed(evt);
            }
        });

        megoldo.setText("Megoldás");
        megoldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                megoldoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gombokLayout = new javax.swing.GroupLayout(gombok);
        gombok.setLayout(gombokLayout);
        gombokLayout.setHorizontalGroup(
            gombokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gombokLayout.createSequentialGroup()
                .addComponent(kilepes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ellenorzes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(megoldo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gombokLayout.setVerticalGroup(
            gombokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gombokLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(gombokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kilepes)
                    .addComponent(ellenorzes)
                    .addComponent(megoldo)))
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
                    .addComponent(palya, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addComponent(gombok2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gombok2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(palya, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gombok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ellenorzesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ellenorzesActionPerformed
        
        /**
         *
         * Megvizsgáljuk, hogy a pálya helyesen van-e kitöltve, ha igen, akkor
         * átugrunk az eredményt kijelző JFrame-re.
         *
         */
        try {

            pf.palyaKorkoros(PalyaMerete, 0, 0);
            if (pf.palyaJo() == true && pf.folytonosE() == true) {
                dispose();
                eredmeny e = new eredmeny();

                e.setVisible(true);

            } else {
                showMessageDialog(null, "Egy sorban és oszlopban csak egyszer szerepeljen egy szám. Továbbá a számok növekvő sorrendben kövessék egymást.", "Hiba", ERROR_MESSAGE);
            }

        } catch (NumberFormatException nfe) {
            showMessageDialog(null, "Hibába ütköztem.", "Hiba", ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ellenorzesActionPerformed

    private void kilepesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kilepesActionPerformed

        /**
         *
         * Lehetővé teszi a játékból való kilépést.
         *
         */
        this.dispose();

    }//GEN-LAST:event_kilepesActionPerformed

    private void megoldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_megoldoActionPerformed
        
        /* lemásolom a kezdőállapotokat, mert egy gombnyomás egyből a példányba ír */
         for (int i=0;i<PalyaMerete;i++) {
             for (int j=0; j<PalyaMerete; j++) {
                 eredeti[i][j]=pf.ertekLekerdezes(i, j);
             }
         }
        
        /* gombok láthatóságának kezelése */
        vegso.setVisible(true); 
        kovetkezo.setVisible(true);
        elozo.setVisible(true); 
        megoldo.setEnabled(false);

        /* keresőalgoritmus példányosítása */
        search.BestFirstSolver solver = new search.BestFirstSolver();

        /* megoldáskereső függvény meghívása */
        solution = solver.solve(pf);
                                     
		//System.out.println("  States visited: "+solver.getVisitedStateCount());
        
        
                /* ha nincs megoldás, akkor kiírom */
		if (solution == null) showMessageDialog(null, "Nincs megoldás.", "Hiba", ERROR_MESSAGE);

		
                    
    }//GEN-LAST:event_megoldoActionPerformed

    private void kovetkezoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kovetkezoActionPerformed

       /* ha a kért lépés kisebb, mint a megoldást tartalmazó lista mérete */
       if (lepes<solution.size()-1) {
           lepes++;
           
           /* a pályára felírom az értékeket */
             for (int i=0; i<PalyaMerete;i++) {
            for(int j=0; j<PalyaMerete; j++) {
                  if (((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="0" &&
                          ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="↓" &&
                          ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="" &&
                          ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="↑" &&
                          ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="→" &&
                          ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="←") {
                      pf.ertekHozzaadas(i, j, Integer.valueOf(((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)));
                      mezo[i][j].setText(String.valueOf(((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)));
                  }
                  else mezo[i][j].setText(String.valueOf(pf.ertekLekerdezes(i,j)));
              }
                       
		}
       } else showMessageDialog(null, "Nincs több lépés.", "Hiba", ERROR_MESSAGE);                   
    }//GEN-LAST:event_kovetkezoActionPerformed

    private void elozoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elozoActionPerformed

    /* ha van még lépés visszafele */
    if (lepes>=1) {
        lepes--;
        for (int i=0; i<PalyaMerete;i++) {
            for(int j=0; j<PalyaMerete; j++) {
                  if (((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="0" &&
                          ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="" 
                          /*((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="↓" &&
                          ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="↑" &&
                          ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="→" &&
                          ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="←"*/) {
                      
                        if (((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)=="↓" ||
                            ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)=="↑" ||
                            ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)=="→" ||
                            ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)=="←") pf.ertekHozzaadas(i, j, 0);
                        
                        
                      if (lepes==0) {
                          
                          if (eredeti[i][j]!="↓" && eredeti[i][j]!="↑" && eredeti[i][j]!="→" && eredeti[i][j]!="←") pf.ertekHozzaadas(i, j, Integer.valueOf(eredeti[i][j]));
                          else pf.ertekHozzaadas(i, j, 0);
                          mezo[i][j].setText(String.valueOf(eredeti[i][j]));
                      }
                      else mezo[i][j].setText(String.valueOf(((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)));
                  }
                  else mezo[i][j].setText(String.valueOf(pf.ertekLekerdezes(i,j)));
              }
                       
		}
    } else showMessageDialog(null, "Nincs több lépés.", "Hiba", ERROR_MESSAGE);    
    }//GEN-LAST:event_elozoActionPerformed

    /* a végső eredményt mutatja meg */
    private void vegsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vegsoActionPerformed
       lepes=solution.size()-1;
        for (int i=0; i<PalyaMerete;i++) {
            for(int j=0; j<PalyaMerete; j++) {
                  if (((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="0" &&
                          ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="↓" &&
                          ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="" &&
                          ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="↑" &&
                          ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="→" &&
                          ((palyaFelepitese)solution.get(lepes)).ertekLekerdezes(i,j)!="←") {
                      pf.ertekHozzaadas(i, j, Integer.valueOf(((palyaFelepitese)solution.get(solution.size()-1)).ertekLekerdezes(i,j)));
                      mezo[i][j].setText(String.valueOf(((palyaFelepitese)solution.get(solution.size()-1)).ertekLekerdezes(i,j)));
                  }
                  else mezo[i][j].setText(String.valueOf(pf.ertekLekerdezes(i,j)));
              }
                       
		}
    }//GEN-LAST:event_vegsoActionPerformed
    
    /**
     *
     *
     * Vizsgálja a kattintásokat és minden egyes mezőn történő változtatást
     * eltárol az adatszerkezetben, illetve frissíti a gombon megjelenő
     * szöveget.
     *
     */
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < PalyaMerete; i++) {
            for (int j = 0; j < PalyaMerete; j++) {
                if (e.getSource() == mezo[i][j]) {
                    if (mezo[i][j].getText().equalsIgnoreCase("↑") || mezo[i][j].getText().equalsIgnoreCase("↓") || mezo[i][j].getText().equalsIgnoreCase("→") || mezo[i][j].getText().equalsIgnoreCase("←") || mezo[i][j].getText().equalsIgnoreCase("")) {
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ellenorzes;
    private javax.swing.JButton elozo;
    private javax.swing.JPanel gombok;
    private javax.swing.JPanel gombok2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton kilepes;
    private javax.swing.JButton kovetkezo;
    private javax.swing.JButton megoldo;
    private javax.swing.JPanel palya;
    private javax.swing.JButton vegso;
    // End of variables declaration//GEN-END:variables
}