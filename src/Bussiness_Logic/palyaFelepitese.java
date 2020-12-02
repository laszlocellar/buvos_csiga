/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness_Logic;

import GUI.palya_szerkeszto;
import javax.swing.JButton;

/**
 *
 * @author Cellár László
 */
public class palyaFelepitese {

    palyaFelepitese palyaFelepitese;
    int[][] palya;
    int PalyaMerete;
    int SzamokMeddig;

    public palyaFelepitese(int PalyaMerete, int SzamokMeddig) {
        this.SzamokMeddig = SzamokMeddig;
        this.PalyaMerete = PalyaMerete;
        palya = new int[PalyaMerete][PalyaMerete];

    }

    public palyaFelepitese getPalya() {
        return palyaFelepitese;
    }

    public boolean palyaJo() {
        boolean sor = false;
        int[] szamokTomb = new int[SzamokMeddig + 1];

        //Sorok ellenőrzése
        for (int i = 0; i < PalyaMerete; i++) {
            //Tömb nullázása 
            for (int x = 0; x < SzamokMeddig + 1; x++) {
                szamokTomb[x] = 0;
            }

            for (int j = 0; j < PalyaMerete; j++) {
                szamokTomb[palya[i][j]] = szamokTomb[palya[i][j]] + 1;

            }

            //Vizsgálat
            for (int y = 1; y < SzamokMeddig + 1; y++) {
                System.out.println("y: " + y + " " + szamokTomb[y]);
                if (szamokTomb[y] <= 1) {
                    sor = true;
                } else {
                    sor = false;
                    break;
                }
                if (sor == false) {
                    break;
                }
            }

            if (sor == false) {
                break;
            }
        }
        
        if (sor == false) return false;
        

        //Oszlopok ellenőrzése
        for (int j = 0; j < PalyaMerete; j++) {
            //Tömb nullázása 

            for (int x = 0; x < SzamokMeddig + 1; x++) {
                szamokTomb[x] = 0;
            }

            for (int i = 0; i < PalyaMerete; i++) {
                szamokTomb[palya[i][j]] = szamokTomb[palya[i][j]] + 1;
            }

            //Vizsgálat
            for (int y = 1; y < SzamokMeddig + 1; y++) {
                System.out.println("x: " + y + " " + szamokTomb[y]);
                if (szamokTomb[y] <= 1) {
                    sor = true;
                } else {
                    sor = false;
                    break;
                }
                if (sor == false) {
                    break;
                }
            }
            if (sor == false) {
                break;
            }
        }

        if (sor == true) {
            return true;
        } else {
            return false;
        }
    }

    public void ertekHozzaadas(int sor, int oszlop, int szam) {
        palya[sor][oszlop] = szam;
    }

    public String ertekLekerdezes(int sor, int oszlop) {
        if (palya[sor][oszlop] != 0) {
            return String.valueOf(palya[sor][oszlop]);
        } else {
            return "";
        }
    }

}
