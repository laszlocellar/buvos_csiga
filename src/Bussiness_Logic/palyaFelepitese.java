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
    
   public palyaFelepitese(int PalyaMerete)
   {
     palya= new int[PalyaMerete][PalyaMerete];
   

   }
   
   
   public palyaFelepitese getPalya() {
        return palyaFelepitese;
    }
   



   
   public void ertekHozzaadas(int sor, int oszlop, int szam)
   {
       palya[sor][oszlop]=szam;
   }
   
   public String ertekLekerdezes(int sor, int oszlop)
   {
       if (palya[sor][oszlop]!=0) return String.valueOf(palya[sor][oszlop]);
       else return "";
   }
   


}
