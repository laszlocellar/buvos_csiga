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
    int[] korkorosSzamok;
    int korkorosSzamokValtozo=0;

    public palyaFelepitese(int PalyaMerete, int SzamokMeddig) {
        this.SzamokMeddig = SzamokMeddig;
        this.PalyaMerete = PalyaMerete;
        palya = new int[PalyaMerete][PalyaMerete];
        korkorosSzamok = new int[PalyaMerete*PalyaMerete];

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

       
        if (sor == true && folytonosE()==true) {
            return true;
        } else {
            return false;
        }
        
    }
    
    public void palyaKorkoros(int PalyaMerete, int kor)
    {
        int legkisebb=PalyaMerete-PalyaMerete;
        int legnagyobb=PalyaMerete-1;
        
        for(int j=legkisebb;j<=legnagyobb;j++)
        {
            //System.out.print(" " + palya[legkisebb+kor][j+kor] + "");
            korkorosSzamok[korkorosSzamokValtozo]=palya[legkisebb+kor][j+kor];
            korkorosSzamokValtozo++;
        }
        
        for(int i=legkisebb+1;i<=legnagyobb;i++)
        {
            //System.out.print(" " + palya[i+kor][legnagyobb+kor] + "");
            korkorosSzamok[korkorosSzamokValtozo]=palya[i+kor][legnagyobb+kor];
            korkorosSzamokValtozo++;
        }

                
           for(int j=legnagyobb-1;j>=legkisebb;j--)
        {
            //System.out.print(" " + palya[legnagyobb+kor][j+kor] + "");
            korkorosSzamok[korkorosSzamokValtozo]=palya[legnagyobb+kor][j+kor];
            korkorosSzamokValtozo++;
        }
           
                   for(int i=legnagyobb-1;i>=legkisebb+1;i--)
        {
            //System.out.print(" " + palya[i+kor][legkisebb+kor] + "");
            korkorosSzamok[korkorosSzamokValtozo]=palya[i+kor][legkisebb+kor];
            korkorosSzamokValtozo++;
        }
                   
                   if (PalyaMerete-2>=0) palyaKorkoros(PalyaMerete-2,kor+1);     
                   
                   
                
 }
    
    public boolean folytonosE()
    {
                          
                   
                   
                   int j=0;
                   boolean folytonos=false;
                   
                           
                   while (j<korkorosSzamok.length && korkorosSzamok[j]==0 )
                   {
                       j++;
                   }
                   
                   
                   
                   
                   int legutolso=korkorosSzamok[j];
 
                   
                   
                  
                   for (int i=j+1; i<korkorosSzamok.length;i++)
                   {
                       if (korkorosSzamok[i]!=0)
                       {
                           if (legutolso<SzamokMeddig){
                                if(legutolso<korkorosSzamok[i]) {
                                    folytonos=true;
                                    legutolso=korkorosSzamok[i];
                                }
                                else {
                                    folytonos=false;
                                    break;
                                }
                                if (folytonos==false) break;
                           }
                           
                           else if (legutolso==SzamokMeddig)
                           {
                               if (korkorosSzamok[i]==1)
                               {
                                   folytonos=true;
                                   legutolso=korkorosSzamok[i];
                               }
                               
                               else
                               {
                                   folytonos=false;
                                   break;
                               }
                               if (folytonos==false) break;
                           }
                           if (folytonos==false) break;
                       }
                       if (folytonos==false) break;
                   }
                         
                   
                   if (folytonos==false) return false;
                   else return true;
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
