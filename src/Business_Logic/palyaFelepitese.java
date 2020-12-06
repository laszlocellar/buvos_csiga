/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import GUI.jatek;
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
 * 
 * Itt tároljuk el a palya nevű kétdimenziós tömbben a pálya "vizuális" felépítését, a pálya méretét,
 * hogy meddig lehet számot megadni, a pálya körkörös felépítését a csiga spirál kialakításához,
 * illetve a korkorosIranyok mutatják, hogy merre kanyarodik a csigavonal.
 * Az @XmlElement annotációt kapó részeket konvertáljuk át XML-be a mentés során,
 * illetve ebbe olvassuk vissza a pályát beolvasás során.
 * 
 */
@XmlRootElement
public class palyaFelepitese {

    
    @XmlElement
    int[][] palya;
    @XmlElement
    int PalyaMerete;
    @XmlElement
    int SzamokMeddig;
    @XmlElement
    int[] korkorosSzamok;
    @XmlElement
    String[][] korkorosIranyok;
    
    
/**
 *
 * @author Cellár László
 * 
 * A konstruktorban kapott értékeket tároljuk el helyi változókba, illetve ezekből számolunk ki olyan dolgokat,
 * mint például a kétdimenziós tömb mérete, vagy pedig a körkörös pályához tartozó tömb mérete.
 * 
 */
    
    public palyaFelepitese(int PalyaMerete, int SzamokMeddig) {
        this.SzamokMeddig = SzamokMeddig;
        this.PalyaMerete = PalyaMerete;
        palya = new int[PalyaMerete][PalyaMerete];
        korkorosSzamok = new int[PalyaMerete * PalyaMerete];
        korkorosIranyok = new String[PalyaMerete][PalyaMerete];
    }
    
    
    /**
     * 
     * Üres konstruktor az XML számára.
     * 
     */

    public palyaFelepitese() {

    }
    
    /**
     * 
     * @author Szőllősi Viktor
     * JAXB segítségével készítünk XML-t.
     * A @return a pálya felépítését adja vissza XML-ként.
     */

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

     /**
     * 
     * @author Szőllősi Viktor
     * JAXB segítségével töltjük be az XML-t.
     * 
     */
    
    public void XMLbetoltes(String XMLpalya) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(palyaFelepitese.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            palyaFelepitese pf = (palyaFelepitese) jaxbUnmarshaller.unmarshal(new StringReader(XMLpalya));

            jatek j = new jatek(pf.PalyaMerete, pf.PalyaMerete, pf);
            j.setVisible(true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 
     * @author Cellár László
     * 
     * A @return igaz vagy hamis értéket ad vissza, attól függően, hogy van az adott számot elhelyezhetjük-e
     * a pályán vagy sem. Azt határozza meg, hogy két lerakott szám között marad-e még elég hely, hogy a számok
     * folytonosságát ne szakítsuk meg.
     * 
     */

    public boolean vaneHely() {

        int j = 0;
        boolean igaz = true;

        for (int i = 0; i < korkorosSzamok.length; i++) {
            if (korkorosSzamok[i] != 0) {
                j = i;
                break;
            }
        }

        int legutolso = korkorosSzamok[j];

        int nullak = 0;
        for (int i = j+1; i < PalyaMerete * PalyaMerete; i++) {

            if (korkorosSzamok[i] != 0) {

                if (korkorosSzamok[i] - legutolso - 1 <= nullak) {
                    return true;
                } else {
                    return false;
                }

            } else {
                nullak++;
            }

        }
        if (igaz == false) {

            return false;
        } else {
            return true;
        }
    }

    
    /**
     * 
     * @author Cellár László
     * 
     * A @return igaz vagy hamis értéket ad vissza, attól függően, hogy a pálya felépítése megfelelő-e.
     * Ellenőrzi, hogy egy sorban és oszlopban nincsenek-e ismétlődő számok.
     * 
     */
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
        if (sor == true /*&& vaneHely() == true*/) {
            return true;
        } else {

            return false;
        }

    }
    
     /**
     * 
     * @author Cellár László
     * 
     * Elkészíti a pálya körkörös felépítését, amely azért fontos, mert a számokat körkörösen
     * kell vizsgálnunk. Ez a körkörösség a csigavonal miatt szükséges.
     * 
     */

    public void palyaKorkoros(int PalyaMerete, int kor, int korkorosSzamokValtozo) {
        int legkisebb = PalyaMerete - PalyaMerete;
        int legnagyobb = PalyaMerete - 1;

        for (int j = legkisebb; j <=  legnagyobb; j++) {

            korkorosSzamok[korkorosSzamokValtozo] = palya[legkisebb + kor][j + kor];

            korkorosIranyok[legkisebb + kor][j + kor] = "→";

            korkorosSzamokValtozo++;
        }

        for (int i = legkisebb+1; i <=  legnagyobb; i++) {

            korkorosSzamok[korkorosSzamokValtozo] = palya[i + kor][legnagyobb + kor];
            korkorosIranyok[i + kor][legnagyobb + kor] = "↓";
            korkorosSzamokValtozo++;
        }

        for (int j = legnagyobb-1; j >=  legkisebb; j--) {
            korkorosIranyok[legnagyobb + kor][j + kor] = "←";
            korkorosSzamok[korkorosSzamokValtozo] = palya[legnagyobb + kor][j + kor];
            korkorosSzamokValtozo++;
        }

        for (int i = legnagyobb-1; i >= legkisebb + 1; i--) {
            korkorosIranyok[i + kor][legkisebb + kor] = "↑";
            korkorosSzamok[korkorosSzamokValtozo] = palya[i + kor][legkisebb + kor];
            korkorosSzamokValtozo++;
        }
        
        korkorosIranyok[legkisebb+kor][legnagyobb+kor]="↓";
        korkorosIranyok[legnagyobb+kor][legnagyobb+kor]="←";
        korkorosIranyok[legnagyobb+kor][legkisebb+kor]="↑";
        
        if (PalyaMerete - 2 > 0) {
            korkorosIranyok[legkisebb + kor + 1][legkisebb + kor] = "→";
            palyaKorkoros(PalyaMerete - 2, kor + 1, korkorosSzamokValtozo);
        } else {
            korkorosIranyok[legnagyobb + kor][legkisebb + kor] = "";
        }

    }
    
    
     /**
     * 
     * @author Cellár László
     * 
     * 
     * A @return igaz vagy hamis értéket ad vissza, attól függően, hogy a pálya folytonos-e,
     * azaz a számok folytonosan jönnek-e. (1 után 2, 2 után 3, illetve n után újból 1.)
     * 
     */

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
                    if (legutolso + 1 == korkorosSzamok[i]) {
                        folytonos = true;
                        legutolso = korkorosSzamok[i];
                    } else {
                        folytonos= false;
                        break;
                    }
                    if (folytonos == false) {
                        break;
                    }
                } else if (legutolso == SzamokMeddig) {
                    if (korkorosSzamok[i] == 1) {
                        folytonos = true;
                        legutolso = korkorosSzamok[i];
                    }
                } else {
                    folytonos = false;
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

        if (folytonos == false) {
            return false;
        } else {
            return true;
        }
    }
    
    
     /**
     * 
     * @author Szőllősi Viktor
     * 
     * A pálya egy adott mezőjén egy adott érték elhelyezésést teszi lehetővé.
     * 
     */

    public void ertekHozzaadas(int sor, int oszlop, int szam) {
        palya[sor][oszlop] = szam;

    }

   /**
     * 
     * @author Szőllősi Viktor
     * 
     * Visszaadja a pálya egy adott mezőjének értékét.
     * Ha nincs még értéke (nem helyeztünk el rajta számot), akkor az irányt adja vissza.
     * 
     */
    
    public String ertekLekerdezes(int sor, int oszlop) {
        if (palya[sor][oszlop] != 0) {
            return String.valueOf(palya[sor][oszlop]);
        } else {
            return nyil(sor, oszlop);
        }
    }

/**
     * 
     * @author Szőllősi Viktor
     * 
     * A bejövő paraméterei alapján visszaadja a megfelelő irányt.
     * 
     */
    
    public String nyil(int n, int n2) {

        return korkorosIranyok[n][n2];

    }
}
