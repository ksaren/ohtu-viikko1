package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto varasto2;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }
    
    @After
    public void tearDown() {
        varasto2 = null;
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoTyhjanVaraston2() {
        varasto2 = new Varasto(10,0);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriTayttaaVaraston() {
        varasto2 = new Varasto(10,3);
        assertEquals(3, varasto2.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriEiTaytaNegalla() {
        varasto2 = new Varasto(10,-3);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }
 
    
    @Test
    public void konstruktoriEiAlustaNegaa() {
        varasto = new Varasto(-5);
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriEiAlustaNegaa2() {
        varasto2 = new Varasto(-5,-5);
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void uudellaVarastollaLiikaaAlkusaldoa() {
        varasto2 = new Varasto(10,15);
        assertEquals(10, varasto2.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaysNegallaEiVaikuta() {
        double saldo = varasto.getSaldo();
        varasto.lisaaVarastoon(-8);

        // saldon pitäisi olla sama kun ennen lisaysta
        assertEquals(saldo, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaysYliRajanEiOnnistu() {
        varasto.lisaaVarastoon(varasto.paljonkoMahtuu()+5);

        // saldon pitäisi olla sama kun yläraja
        assertEquals(varasto.getTilavuus(), varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void ottaminenNegallaEiVaikuta() {
        double saldo = varasto.getSaldo();
        varasto.otaVarastosta(-8);

        // saldon pitäisi olla sama kun ennen lisaysta
        assertEquals(saldo, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void ottaminenPalauttaaOikeanMaaranKunSaldoEiRiita() {
        varasto.lisaaVarastoon(8);
        double saldo= varasto.getSaldo();
        double saatuMaara = varasto.otaVarastosta(saldo+10);

        assertEquals(saldo, saatuMaara, vertailuTarkkuus);
    }
    
    @Test 
    public void toStringPalauttaaMitaHalutaan() {
        String haluttu = "saldo = "+ varasto.getSaldo() + ", vielä tilaa " + varasto.paljonkoMahtuu();
        
        assertEquals(haluttu, varasto.toString());
    }

}