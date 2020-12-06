/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class palyaFelepiteseTest {

    public palyaFelepiteseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * @author Szőllősi Viktor
     *
     * AZ XML mentés helyes működését teszteljük, előre betápláltuk a megfelelő
     * XML kódot, melyet összehasonlítunk a program által generáltal. Ha
     * egyezik, akkor a teszt sikeres.
     */
    @Test
    public void testXMLmentesJo() {
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        pf.ertekHozzaadas(0, 0, 1);
        pf.ertekHozzaadas(0, 2, 3);
        pf.ertekHozzaadas(2, 2, 3);
        String expResult = "<palyaFelepitese><palya><item>1</item><item>0</item><item>3</item></palya><palya><item>0</item><item>0</item><item>0</item></palya><palya><item>0</item><item>0</item><item>3</item></palya><PalyaMerete>3</PalyaMerete><SzamokMeddig>3</SzamokMeddig><korkorosSzamok>0</korkorosSzamok><korkorosSzamok>0</korkorosSzamok><korkorosSzamok>0</korkorosSzamok><korkorosSzamok>0</korkorosSzamok><korkorosSzamok>0</korkorosSzamok><korkorosSzamok>0</korkorosSzamok><korkorosSzamok>0</korkorosSzamok><korkorosSzamok>0</korkorosSzamok><korkorosSzamok>0</korkorosSzamok><korkorosIranyok><item xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/><item xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/><item xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/></korkorosIranyok><korkorosIranyok><item xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/><item xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/><item xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/></korkorosIranyok><korkorosIranyok><item xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/><item xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/><item xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/></korkorosIranyok></palyaFelepitese>";
        String result = pf.XMLmentes();
        assertEquals(expResult, result);
    }

    /**
     * @author Szőllősi Viktor
     *
     * AZ XML mentés rossz működését teszteljük, előre betápláltunk egy rossz
     * XML kódot, melyet összehasonlítunk a program által generáltal. Ha
     * különbözik, akkor a teszt sikeres.
     */
    @Test
    public void testXMLmentesRossz() {
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        pf.ertekHozzaadas(0, 0, 1);
        pf.ertekHozzaadas(0, 2, 3);
        pf.ertekHozzaadas(2, 2, 3);
        String expResult = "";
        String result = pf.XMLmentes();
        assertNotEquals(expResult, result);
    }

    /**
     * @author Szőllősi Viktor
     *
     * AZ XML betöltés rossz működését teszteljük, előre betápláltuk egy nem
     * megfelelő XML kódot, amelyet a program nem tud beolvasni. Így a tesztelés
     * helyes működéséhez az kell, hogy a két érték ne legyen egyező.
     */
    @Test
    public void testXMLbetoltesRossz() {
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        String XMLpalya = "ROSSZ";
        pf.XMLbetoltes(XMLpalya);
        assertNotSame(pf.ertekLekerdezes(0, 0), "1");
    }

    /**
     * @author Cellár László
     *
     * Felveszünk két egymás melletti helyre két megfelelő értéket. Előre
     * megadjuk, hogy a VaneHely metódusnak igaz viszatérési értéket várunk.
     * Majd összehasonlítjuk a várt értéket a metódus értékével, ha egyezik a
     * két érték, akkor a metódus jól működik.
     *
     */
    @Test
    public void testVaneHelyJo() {
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        pf.ertekHozzaadas(0, 0, 1);
        pf.ertekHozzaadas(0, 1, 2);
        boolean expResult = true;
        boolean result = pf.vaneHely();
        assertEquals(expResult, result);

    }

    /**
     * @author Cellár László Felveszünk két egymás melletti helyre két nem
     * megfelelő értéket. Előre megadjuk, hogy a VaneHely metódusnak hamis
     * viszatérési értéket várunk. Majd összehasonlítjuk a várt értéket a
     * metódus értékével, ha nem egyezik a két érték, akkor a metódus jól
     * működik.
     */
    @Test
    public void testVaneHelyRossz() {
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        pf.ertekHozzaadas(0, 0, 1);
        pf.ertekHozzaadas(0, 1, 3);
        pf.palyaKorkoros(3, 0, 0);
        boolean expResult = false;
        boolean result = pf.vaneHely();
        assertEquals(expResult, result);

    }

    /**
     * @author Cellár László
     *
     * A két felvett értékkel azt vizsgáljuk, hogy a pályá soraiban, illetve
     * oszlopaiban vannak-e ismétlődő értékek. Direkt úgy vettük fel, hogy
     * legyenek. Mivel vannak ismétlődő értékek, így a metódusnak hamis
     * visszatérési értéket kell visszaadni. Ha hamisat ad vissza, akkor a
     * tesztelés igaz értéket.
     */
    @Test
    public void testPalyaJoRossz() {
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        pf.ertekHozzaadas(0, 0, 2);
        pf.ertekHozzaadas(0, 1, 2);
        boolean expResult = false;
        boolean result = pf.palyaJo();
        assertEquals(expResult, result);
    }

    /**
     * @author Cellár László
     *
     * A két felvett értékkel azt vizsgáljuk, hogy a pályá soraiban, illetve
     * oszlopaiban vannak-e ismétlődő értékek. Direkt úgy vettük fel, hogy ne
     * legyenek. Mivel nincsenek ismétlődő értékek, így a metódusnak igaz
     * értéket kell visszaadni. Ha igazat ad vissza, akkor a tesztelés is.
     */
    @Test
    public void testPalyaJoJo() {
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        pf.ertekHozzaadas(0, 0, 2);
        pf.ertekHozzaadas(0, 1, 3);
        boolean expResult = true;
        boolean result = pf.palyaJo();
        assertEquals(expResult, result);
    }

    /**
     * @author Szőllősi Viktor
     *
     * Sor, oszlop és szám alapján hozzáadunk a mátrixhoz egy értéket, melyből
     * leképzünk egy körkörös felépítést. Ha a tesztelés igazat ad vissza, akkor
     * a metódus jól működik.
     */
    @Test
    public void testPalyaKorkorosJo() {
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        pf.ertekHozzaadas(0, 0, 3);
        pf.palyaKorkoros(3, 0, 0);
        assertEquals(pf.korkorosSzamok[0], 3);
    }

    /**
     * @author Szőllősi Viktor
     *
     * Sor, oszlop és szám alapján hozzáadunk a mátrixhoz egy értéket, melyből
     * leképzünk egy körkörös felépítést. Ha a tesztelés hamis értéket ad
     * vissza, akkor a metódus jól működik.
     */
    @Test
    public void testPalyaKorkorosRossz() {
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        pf.ertekHozzaadas(0, 0, 3);
        pf.palyaKorkoros(3, 0, 0);
        assertNotSame(pf.korkorosSzamok[0], 2);
    }

    /**
     * @author Cellár László
     *
     * Felveszünk három egymás után következő értéket, melyek növekvő sorrendben
     * követik egymást. Majd megvizsgáljuk, hogy folytonosak-e (azaz növekvő
     * sorrendben követik egymást 1-től n-ig) Ha folytonosak, akkor igaz értéket
     * ad vissza.
     *
     */
    @Test
    public void testFolytonosEJo() {
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        boolean expResult = true;
        pf.ertekHozzaadas(0, 0, 1);
        pf.ertekHozzaadas(0, 1, 2);
        pf.ertekHozzaadas(0, 2, 3);
        pf.palyaKorkoros(3, 0, 0);
        boolean result = pf.folytonosE();
        assertEquals(expResult, result);
    }

    /**
     * @author Cellár László
     *
     * Felveszünk három egymás után következő értéket, melyek nem növekvő
     * sorrendben követik egymást. Majd megvizsgáljuk, hogy folytonosak-e (azaz
     * növekvő sorrendben követik egymást 1-től n-ig) Ha nem folytonosak, akkor
     * a metódus hamis értéket ad vissza. Mi is hamis értéket várunk. Ha a
     * visszaadott érték és a várt érték egyezik, akkor a tesztelés jól működik.
     *
     */
    @Test
    public void testFolytonosERossz() {
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        boolean expResult = false;
        pf.ertekHozzaadas(0, 0, 1);
        pf.ertekHozzaadas(0, 1, 3);
        pf.ertekHozzaadas(0, 2, 2);
        boolean result = pf.folytonosE();
        assertEquals(expResult, result);
    }

    /**
     * @author Szőllősi Viktor
     *
     * A tábla egy adott pontjához hozzáadunk egy adott értéket. Majd
     * megvizsgáljuk, hogy a hozzáadott érték megegyezik-e a várttal.
     *
     */
    @Test
    public void testErtekHozzaadasJo() {
        int sor = 0;
        int oszlop = 0;
        int szam = 0;
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        pf.ertekHozzaadas(0, 0, 5);
        assertEquals(pf.ertekLekerdezes(0, 0), String.valueOf("5"));

    }

    /**
     * @author Szőllősi Viktor
     *
     * A tábla egy adott pontjához hozzáadunk egy adott értéket. Majd
     * megvizsgáljuk, hogy a hozzáadott érték megegyezik-e egy teljesen másik
     * értékkel. Ha nem egyezik meg, akkor a metódus jól működik.
     */
    @Test
    public void testErtekHozzaadasRossz() {
        int sor = 0;
        int oszlop = 0;
        int szam = 0;
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        pf.ertekHozzaadas(0, 0, 5);
        assertNotSame(pf.ertekLekerdezes(0, 0), String.valueOf("3"));

    }

    /**
     * @author Szőllősi Viktor
     *
     * Hozzáadunk egy értéket, majd lekérdezzük, ha a kettő egyezik, akkor a
     * metódus jól működik.
     *
     */
    @Test
    public void testErtekLekerdezesJo() {
        int sor = 0;
        int oszlop = 0;
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        pf.ertekHozzaadas(0, 0, 3);
        String expResult = "3";
        String result = pf.ertekLekerdezes(sor, oszlop);
        assertEquals(expResult, result);

    }

    /**
     * @author Szőllősi Viktor
     *
     * Hozzáadunk egy értéket, majd lekérdezzük, ha a kettő nem egyezik, akkor a
     * metódus jól működik.
     *
     */
    @Test
    public void testErtekLekerdezesRossz() {
        int sor = 0;
        int oszlop = 0;
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        pf.ertekHozzaadas(0, 0, 5);
        String expResult = "3";
        String result = pf.ertekLekerdezes(sor, oszlop);
        assertNotSame(expResult, result);

    }

    /**
     * @author Cellár László
     *
     * Hozzáadunk egy értéket a pályához, majd lekérjük a hozzátartozó irányt.
     * Ha a lekért irány megegyezik az általunk várt iránnyal, akkor a metódus
     * jól működik.
     *
     */
    @Test
    public void testNyilJo() {
        int n = 0;
        int n2 = 0;
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        pf.palyaKorkoros(3, 0, 0);
        String expResult = "→";
        String result = pf.nyil(n, n2);
        assertEquals(expResult, result);

    }

    /**
     * @author Cellár László
     *
     * Hozzáadunk egy értéket a pályához, majd lekérjük a hozzátartozó irányt.
     * Ha a lekért irány nem egyezik meg az általunk várt iránnyal, akkor a
     * metódus jól működik.
     *
     */
    @Test
    public void testNyilRossz() {
        int n = 0;
        int n2 = 0;
        palyaFelepitese pf = new palyaFelepitese(3, 3);
        pf.palyaKorkoros(3, 0, 0);
        String expResult = "←";
        String result = pf.nyil(n, n2);
        assertNotSame(expResult, result);

    }

}
