/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import GUI.jatek;
import java.awt.GridLayout;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cellár László
 */
@XmlRootElement
public class palyaFelepitese {

    //palyaFelepitese palyaFelepitese;
    @XmlElement
    int[][] palya;
    @XmlElement
    int PalyaMerete;
    @XmlElement
    int SzamokMeddig;

    int[] korkorosSzamok;

    public palyaFelepitese(int PalyaMerete, int SzamokMeddig) {
        this.SzamokMeddig = SzamokMeddig;
        this.PalyaMerete = PalyaMerete;
        palya = new int[PalyaMerete][PalyaMerete];
        korkorosSzamok = new int[PalyaMerete * PalyaMerete];

    }

    public palyaFelepitese() {

    }

    public String XMLmentes() {
        StringWriter sw = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(this.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            jaxbMarshaller.marshal(this, sw);
        } catch (JAXBException jaxbex) {
            jaxbex.printStackTrace();
        }

        String xml = sw.toString();
        if (xml == null) {
            xml = "";
        }

        return xml;
    }

    public void XMLbetoltes(String XMLpalya) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(palyaFelepitese.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

             palyaFelepitese pf = (palyaFelepitese) jaxbUnmarshaller.unmarshal(new StringReader(XMLpalya));

            System.out.println(pf.toString());
            System.out.println("" + PalyaMerete + " " + SzamokMeddig);
            jatek j = new jatek(pf.PalyaMerete, pf.PalyaMerete, pf);
                j.setVisible(true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
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

        if (sor == false) {
            return false;
        }

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

        if (sor == true) {
            return true;
        } else {
            return false;
        }

    }

    public void palyaKorkoros(int PalyaMerete, int kor, int korkorosSzamokValtozo) {
        int legkisebb = PalyaMerete - PalyaMerete;
        int legnagyobb = PalyaMerete - 1;

        for (int j = legkisebb; j <= legnagyobb; j++) {

            korkorosSzamok[korkorosSzamokValtozo] = palya[legkisebb + kor][j + kor];
            //System.out.println("Palya: " + palya[legkisebb+kor][j+kor] + "korkoros: " +korkorosSzamok[korkorosSzamokValtozo] +" Index: " +korkorosSzamokValtozo);
            korkorosSzamokValtozo++;
        }

        for (int i = legkisebb + 1; i <= legnagyobb; i++) {

            korkorosSzamok[korkorosSzamokValtozo] = palya[i + kor][legnagyobb + kor];
            //System.out.println("Palya:  " + palya[i+kor][legnagyobb+kor] + "korkoros: " +korkorosSzamok[korkorosSzamokValtozo] +" Index:  " +korkorosSzamokValtozo);
            korkorosSzamokValtozo++;
        }

        for (int j = legnagyobb - 1; j >= legkisebb; j--) {

            korkorosSzamok[korkorosSzamokValtozo] = palya[legnagyobb + kor][j + kor];
            //System.out.println("Palya:  " + palya[legnagyobb+kor][j+kor] + "korkoros: " +korkorosSzamok[korkorosSzamokValtozo] +" Index: " +korkorosSzamokValtozo);
            korkorosSzamokValtozo++;
        }

        for (int i = legnagyobb - 1; i >= legkisebb + 1; i--) {

            korkorosSzamok[korkorosSzamokValtozo] = palya[i + kor][legkisebb + kor];
            //System.out.println("Palya:  " + palya[i+kor][legkisebb+kor] + "korkoros: " +korkorosSzamok[korkorosSzamokValtozo] +" Index:  " +korkorosSzamokValtozo);
            korkorosSzamokValtozo++;
        }

        if (PalyaMerete - 2 > 0) {
            palyaKorkoros(PalyaMerete - 2, kor + 1, korkorosSzamokValtozo);
        }

    }

    public boolean folytonosE() {
        int j = 0;
        boolean folytonos = false;

        for (int i = 0; i < korkorosSzamok.length; i++) {
            if (korkorosSzamok[i] != 0) {
                j = i;
                break;
            }
        }

        int legutolso = korkorosSzamok[j];

        for (int i = j + 1; i < korkorosSzamok.length; i++) {
            System.out.println(korkorosSzamok[i]);
            if (korkorosSzamok[i] != 0) {
                if (legutolso < SzamokMeddig) {
                    if (legutolso < korkorosSzamok[i]) {
                        folytonos = true;
                        //System.out.println(folytonos + "1. legutolso: " +legutolso + " Körkörös: " +korkorosSzamok[i]);
                        legutolso = korkorosSzamok[i];
                    } else {
                        folytonos = false;
                        //System.out.println(folytonos + "2. legutolso: " +legutolso + " Körkörös: " +korkorosSzamok[i]);
                        break;
                    }
                    if (folytonos == false) {
                        break;
                    }
                } else if (legutolso == SzamokMeddig) {
                    if (korkorosSzamok[i] == 1) {
                        folytonos = true;
                        //System.out.println(folytonos + "3. legutolso: " +legutolso + " Körkörös: " +korkorosSzamok[i]);
                        legutolso = korkorosSzamok[i];
                    }
                } else {
                    folytonos = false;
                    //System.out.println(folytonos + "4. legutolso: " +legutolso + " Körkörös: " +korkorosSzamok[i]);
                    break;
                }
                if (folytonos == false) {
                    break;
                }

                if (folytonos == false) {
                    break;
                }
            }

        }

        System.out.println(folytonos);
        if (folytonos == false) {
            return false;
        } else {
            return true;
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
