/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import GUI.jatek;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import search.AbstractState;
import search.State;


/**
 *
 *
 * Itt tároljuk el a palya nevű kétdimenziós tömbben a pálya "vizuális"
 * felépítését, a pálya méretét, hogy meddig lehet számot megadni, a pálya
 * körkörös felépítését a csiga spirál kialakításához, illetve a korkorosIranyok
 * mutatják, hogy merre kanyarodik a csigavonal. Az @XmlElement annotációt kapó
 * részeket konvertáljuk át XML-be a mentés során, illetve ebbe olvassuk vissza
 * a pályát beolvasás során.
 *
 */



@XmlRootElement
public class palyaFelepitese extends AbstractState {

    @XmlElement
    public int[][] palya;
    @XmlElement
    int PalyaMerete;
    @XmlElement
    int SzamokMeddig;
    @XmlElement
    int[] korkorosSzamok;
    @XmlElement
    String[][] korkorosIranyok;

    public palyaFelepitese() {super();}
    //public palyaFelepitese(palyaFelepitese pf) {super(pf);}
    public palyaFelepitese(int[][] palya) {this.palya=palya;}
    public palyaFelepitese(palyaFelepitese pf, int[][] palya, int PalyaMerete, int SzamokMeddig, int[] korkorosSzamok, String[][] korkorosIranyok) {
        super(pf);
        this.palya=palya;
        this.PalyaMerete=PalyaMerete;
        this.SzamokMeddig=SzamokMeddig;
        this.korkorosSzamok=korkorosSzamok;
        this.korkorosIranyok=korkorosIranyok;
        
        
                
    }
    
    public palyaFelepitese(palyaFelepitese pf) {
                super(pf);

                //System.out.println("Új " + pf.toString());
        
    }
        public palyaFelepitese(palyaFelepitese pf, int[][] palya) {
        super(pf);
        

        
        this.palya=palya;
                        //System.out.println("Új " + pf.toString());

    }
    
    
        public palyaFelepitese(palyaFelepitese pf, int i, int j, int szam) {
        super(pf);
        this.palya[i][j]=szam;
    }
    
    
    
    /**
     *
     *
     * A konstruktorban kapott értékeket tároljuk el helyi változókba, illetve
     * ezekből számolunk ki olyan dolgokat, mint például a kétdimenziós tömb
     * mérete, vagy pedig a körkörös pályához tartozó tömb mérete.
     * @param PalyaMerete A pálya méretét jelzi.
     * @param SzamokMeddig Azt mutatja meg, hogy meddig használhatunk fel
     * számokat a játék során.
     *
     */
    public palyaFelepitese(int PalyaMerete, int SzamokMeddig) {
        super();
        this.SzamokMeddig = SzamokMeddig;
        this.PalyaMerete = PalyaMerete;
        palya = new int[PalyaMerete][PalyaMerete];
        korkorosSzamok = new int[PalyaMerete * PalyaMerete];
        korkorosIranyok = new String[PalyaMerete][PalyaMerete];
        palyaKorkoros(PalyaMerete,0,0);
        
    }


    /**
     * JAXB segítségével készítünk XML-t.
     * @return Az XML fájlt adja vissza.
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
     * JAXB segítségével töltjük be az XML-t.
     * @param XMLpalya A pályát leíró XML kódot tartalmazza.
     *
     */
    public void XMLbetoltes(String XMLpalya) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(palyaFelepitese.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            palyaFelepitese pf = (palyaFelepitese) jaxbUnmarshaller.unmarshal(new StringReader(XMLpalya));

            jatek j = new jatek(pf.PalyaMerete, pf.SzamokMeddig, pf);
            j.setVisible(true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     *
     * @return Igaz vagy hamis értéket ad vissza, attól függően, hogy van az
     * adott számot elhelyezhetjük-e a pályán vagy sem. Azt határozza meg, hogy
     * két lerakott szám között marad-e még elég hely, hogy a számok
     * folytonosságát ne szakítsuk meg.
     *
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
        for (int i = j + 1; i < PalyaMerete * PalyaMerete; i++) {

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
     *
     * @return Igaz vagy hamis értéket ad vissza, attól függően, hogy a pálya
     * felépítése megfelelő-e. Ellenőrzi, hogy egy sorban és oszlopban
     * nincsenek-e ismétlődő számok.
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

            //elmentem, hogy melyik számból hányat találok
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
     *
     * Elkészíti a pálya körkörös felépítését, amely azért fontos, mert a
     * számokat körkörösen kell vizsgálnunk. Ez a körkörösség a csigavonal miatt
     * szükséges.
     * @param PalyaMerete A pálya méretét adja meg.
     * @param kor A rekurzívitáshoz szükséges változó, ami azt jelöli, hogy
     * hanyadjára fut le a metódus rekurzívan.
     * @param korkorosSzamokValtozo A pálya körkörös feltérképezése során
     * használt változó.
     *
     */
    public void palyaKorkoros(int PalyaMerete, int kor, int korkorosSzamokValtozo) {
        int legkisebb = PalyaMerete - PalyaMerete;
        int legnagyobb = PalyaMerete - 1;

        for (int j = legkisebb; j <= legnagyobb; j++) {
            korkorosSzamok[korkorosSzamokValtozo] = palya[legkisebb + kor][j + kor];
            korkorosIranyok[legkisebb + kor][j + kor] = "→";
            korkorosSzamokValtozo++;
        }

        for (int i = legkisebb + 1; i <= legnagyobb; i++) {
            korkorosSzamok[korkorosSzamokValtozo] = palya[i + kor][legnagyobb + kor];
            korkorosIranyok[i + kor][legnagyobb + kor] = "↓";
            korkorosSzamokValtozo++;
        }

        for (int j = legnagyobb - 1; j >= legkisebb; j--) {
            korkorosIranyok[legnagyobb + kor][j + kor] = "←";
            korkorosSzamok[korkorosSzamokValtozo] = palya[legnagyobb + kor][j + kor];
            korkorosSzamokValtozo++;
        }

        for (int i = legnagyobb - 1; i >= legkisebb + 1; i--) {
            korkorosIranyok[i + kor][legkisebb + kor] = "↑";
            korkorosSzamok[korkorosSzamokValtozo] = palya[i + kor][legkisebb + kor];
            korkorosSzamokValtozo++;
        }

        korkorosIranyok[legkisebb + kor][legnagyobb + kor] = "↓";
        korkorosIranyok[legnagyobb + kor][legnagyobb + kor] = "←";
        korkorosIranyok[legnagyobb + kor][legkisebb + kor] = "↑";

        if (PalyaMerete - 2 > 0) {
            korkorosIranyok[legkisebb + kor + 1][legkisebb + kor] = "→";
            palyaKorkoros(PalyaMerete - 2, kor + 1, korkorosSzamokValtozo);
        } else {
            korkorosIranyok[legnagyobb + kor][legkisebb + kor] = "";
        }

    }


    /**
     *
     *
     *
     * @return Igaz vagy hamis értéket ad vissza, attól függően, hogy a pálya
     * folytonos-e, azaz a számok folytonosan jönnek-e. (1 után 2, 2 után 3,
     * illetve n után újból 1.)
     *
     *
     */
    public boolean folytonosE() {
        LinkedList<Integer> szamokNullaNelkul = new LinkedList<>();
        boolean folytonos=true;
        for (int i=0; i<=korkorosSzamok.length-1; i++) {
            if (korkorosSzamok[i]!=0) {
                szamokNullaNelkul.add(korkorosSzamok[i]);
            }
        }
        
        for (int i=1; i<=szamokNullaNelkul.size()-1; i++) {
            if (szamokNullaNelkul.get(i)!=1) { // ha nem egyenlő maximummal
            if (szamokNullaNelkul.get(i)-1 == szamokNullaNelkul.get(i-1)) folytonos = true;
            else return false;
            }
            else {
            if (szamokNullaNelkul.get(i) == 1 && szamokNullaNelkul.get(i-1)==SzamokMeddig) folytonos = true;
            else return false;
            
            }
        }
        return folytonos;
    }
        
        
        
        

    /**
     *
     *
     * A pálya egy adott mezőjén egy adott érték elhelyezésést teszi lehetővé.
     * @param sor Megadjuk, hogy melyik sorhoz szeretnénk hozzáadni az értéket.
     * @param oszlop Megadjuk, hogy melyik oszlophoz szeretnénk hozzáadni az
     * értéket.
     * @param szam Megadjuk, hogy melyik értéket szeretnénk hozzáadni.
     *
     */
    public void ertekHozzaadas(int sor, int oszlop, int szam) {
        palya[sor][oszlop] = szam;

    }

    /**
     *
     *
     * @param sor A pálya egy sorát adja meg.
     * @param oszlop A pálya egy oszlopát adja meg.
     * @return Visszaadja a pálya egy adott mezőjének értékét. Ha nincs még
     * értéke (nem helyeztünk el rajta számot), akkor az irányt adja vissza.
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
     *
     * @param n A pálya egy sorát adja meg.
     * @param n2 A pálya egy oszlopát adja meg.
     * @return A bejövő paraméterei alapján visszaadja a megfelelő irányt.
     *
     */
    public String nyil(int n, int n2) {

        return korkorosIranyok[n][n2];

    }

    @Override
    public Iterable<State> getPossibleMoves() {
        Set<State> moves = new HashSet<State>();
        
        for (int i=0; i<PalyaMerete; i++)
        {
           for (int j=0; j<PalyaMerete; j++)
        {
                for (int y=1; y<=SzamokMeddig; y++) {
                if (palya[i][j]==0) {
                    
                //System.out.println("Régi "+this.toString());
                
                            int[][] ujPalya = new int[PalyaMerete][PalyaMerete];

                        
                        
                        for (int c=0; c<PalyaMerete; c++) {
                    for (int d=0; d<PalyaMerete; d++) {
                        ujPalya[c][d]=this.palya[c][d];
                    }
                }
                        ujPalya[i][j]=y;
                        
                        if (helyesLepes(ujPalya,i,j)){
                            palyaFelepitese ujAllapot =  new palyaFelepitese(this, ujPalya, PalyaMerete,  SzamokMeddig, korkorosSzamok, korkorosIranyok);
                            moves.add(ujAllapot);
                        }
     

                }
            }
        } 
        }
        return moves;
    }
    
    public boolean helyesLepes(int[][] ujPalya, int i, int j) {
        int[] fuggoleges = new int[SzamokMeddig+1];
        int[] vizszintes = new int[SzamokMeddig+1];
        
        for (int d=0;d<SzamokMeddig+1;d++) {
            fuggoleges[d]=0;
            vizszintes[d]=0;
            
        }
        
        for (int d=0;d<PalyaMerete;d++) {
            fuggoleges[ujPalya[i][d]]++;
            vizszintes[ujPalya[d][j]]++;
        }
        
        for (int d=1;d<SzamokMeddig+1;d++) {
        if (fuggoleges[d]>1 || vizszintes[d]>1) return false;
            
        } 
        return true;
    }

    @Override
    public boolean isSolution() {
        palyaKorkoros(PalyaMerete,0,0);
        if (palyaJo() == true && folytonosE() == true) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 
     * minél több a nulla, annál kevesebb lépésből sikerült megoldani a feladatot 
     *
     */
    @Override
    public double getHeuristic() {
        double elemek=0;
        for (int i=0; i<korkorosSzamok.length; i++) {
            if (korkorosSzamok[i]!=0) {
                elemek++;
            }       
        }
        return elemek;
    }
    
    @Override
    public String toString() {
          StringBuilder palyaKorKiir = new StringBuilder("");
          StringBuilder palyaKiir = new StringBuilder("");
          
        for (int i=0;i<PalyaMerete*PalyaMerete; i++) palyaKorKiir.append(korkorosSzamok[i] + " ");
        
        for (int i=0;i<PalyaMerete; i++) {
            palyaKiir.append("\n");
            for (int j=0; j<PalyaMerete; j++)
        palyaKiir.append(palya[i][j] + " ");
        }
        return "Pálya: " + palyaKiir + " Pálya mérete: " + PalyaMerete + " SzámokMeddig: " + SzamokMeddig + " körkörösSzámok: " + palyaKorKiir + " körkörösIrányok: " + korkorosIranyok;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89* hash + Arrays.deepHashCode(this.palya);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final palyaFelepitese other = (palyaFelepitese) obj;
        
        if (!Arrays.deepEquals(this.palya, other.palya)) {
            return false;
        }
        return true;
    }
}
