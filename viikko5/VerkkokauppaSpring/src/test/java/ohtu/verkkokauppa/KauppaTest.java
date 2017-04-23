/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author kaisa
 */
public class KauppaTest {

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        // luodaan ensin mock-oliot
        Pankki pankki = mock(Pankki.class);

        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        Varasto varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), anyInt());
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }

    //aloitetaan asiointi, koriin lisätään tuote, jota varastossa on ja suoritetaan ostos,
    //eli kutsutaan metodia kaupan tilimaksu(). 
    //varmistettava että kutsutaan pankin metodia tilisiirto oikealla asiakkaalla,
    //tilinumerolla ja summalla (verify:ssä on tarkastettava että parametreilla on oikeat arvot)
    @Test
    public void ostoksenPaatytyttyaTilisiirtoMetodiaKutsutaanOikeillaArvoilla() {
        // luodaan ensin mock-oliot
        Pankki pankki = mock(Pankki.class);

        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(45);

        Varasto varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto("pekka", 45, "12345", "33333-44455", 5);
    }

    //aloitetaan asiointi, koriin lisätään kaksi eri tuotetta, joita varastossa on 
    //ja suoritetaan ostos. varmistettava että kutsutaan pankin metodia tilisiirto oikealla
    //asiakkaalla, tilinumerolla ja summalla
    // luodaan ensin mock-oliot
    @Test
    public void tilisiirtoMetodiaKutsutaanOikeillaArvoillaKunUseitaOstoksia() {
        Pankki pankki = mock(Pankki.class);

        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 48
        when(viite.uusi()).thenReturn(48);

        Varasto varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(2)).thenReturn(20);
        when(varasto.saldo(30)).thenReturn(15);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "mehu", 4));
        when(varasto.haeTuote(30)).thenReturn(new Tuote(30, "karkki", 2));

        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(2);     // ostetaan mehu
        k.lisaaKoriin(30);
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu oikein
        verify(pankki).tilisiirto("pekka", 48, "12345", "33333-44455", 6);
    }

    //aloitetaan asiointi, koriin lisätään kaksi samaa tuotetta jota on varastossa 
    //tarpeeksi ja suoritetaan ostos. varmistettava että kutsutaan pankin metodia 
    //tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla
    @Test
    public void tilisiirtoMetodiaKutsutaanOikeillaArvoillaKunUseitaSamojaOstoksia() {
        Pankki pankki = mock(Pankki.class);

        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 48
        when(viite.uusi()).thenReturn(50);

        Varasto varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(2)).thenReturn(20).thenReturn(19);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "mehu", 4));

        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(2);     // ostetaan mehu
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu oikein
        verify(varasto, times(2)).haeTuote(2);
        verify(pankki, times(1)).tilisiirto("pekka", 50, "12345", "33333-44455", 8);
    }

    //aloitetaan asiointi, koriin lisätään tuote jota on varastossa tarpeeksi ja tuote
    //joka on loppu ja suoritetaan ostos. varmistettava että kutsutaan pankin metodia 
    //tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla
    @Test
    public void tilisiirtoMetodiaKutsutaanOikeillaArvoillaKunToinenTuoteLoppu() {
        Pankki pankki = mock(Pankki.class);

        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 52
        when(viite.uusi()).thenReturn(52);

        Varasto varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(2)).thenReturn(20);
        when(varasto.saldo(30)).thenReturn(0);  //karkit on loppu
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "mehu", 4));
        when(varasto.haeTuote(30)).thenReturn(new Tuote(30, "karkki", 2));

        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(2);     // ostetaan mehu
        k.lisaaKoriin(30);
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu oikein
        verify(varasto).otaVarastosta(varasto.haeTuote(2));
        verify(varasto, never()).otaVarastosta(varasto.haeTuote(30));
        verify(pankki, times(1)).tilisiirto("pekka", 52, "12345", "33333-44455", 4);

    }

    //varmistettava, että metodin aloitaAsiointi kutsuminen nollaa edellisen ostoksen 
    //tiedot (eli edellisen ostoksen hinta ei näy uuden ostoksen hinnassa), katso 
    //tarvittaessa apua projektin MockitoDemo testeistä!
    @Test
    public void aloitaAsiointiTyhjentaaOstoskorin() {
        Pankki pankki = mock(Pankki.class);

        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 50
        when(viite.uusi()).thenReturn(50);

        Varasto varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(2)).thenReturn(20).thenReturn(19).thenReturn(18);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "mehu", 4));

        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(2);     // ostetaan mehua
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");

        // tehdään toiset ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(2);     // ostetaan mehu
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu oikein;
//        verify(pankki,times(2)).tilisiirto("pekka", anyInt(), "12345", "33333-44455", anyInt());
        //...ja että jälkimmäisellä kutsulla saldo on nollaantunut
        verify(pankki).tilisiirto("pekka", 50, "12345", "33333-44455", 4);
    }

    //varmistettava, että kauppa pyytää uuden viitenumeron jokaiselle maksutapahtumalle,
    //katso tarvittaessa apua projektin MockitoDemo testeistä!
    @Test
    public void aloitaAsiointiHakeeUudenViitteen() {
        Pankki pankki = mock(Pankki.class);

        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 50
        when(viite.uusi()).thenReturn(55).thenReturn(56);

        Varasto varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(2)).thenReturn(20).thenReturn(19).thenReturn(18);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "mehu", 4));

        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(2);     // ostetaan mehua
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");

        // tehdään toiset ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(2);     // ostetaan mehu
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu oikein;
//        verify(pankki,times(2)).tilisiirto("pekka", anyInt(), "12345", "33333-44455", anyInt());
        //...ja että jälkimmäisellä kutsulla saldo on nollaantunut
        verify(pankki).tilisiirto("pekka", 55, "12345", "33333-44455", 8);
        verify(pankki).tilisiirto("pekka", 56, "12345", "33333-44455", 4);
    }
    
    //varmistettava, että kauppa pyytää uuden viitenumeron jokaiselle maksutapahtumalle,
    //katso tarvittaessa apua projektin MockitoDemo testeistä!
    @Test
    public void poistaKoristaPoistaaTuotteen() {
        Pankki pankki = mock(Pankki.class);

        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 50
        when(viite.uusi()).thenReturn(40);

        Varasto varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(2)).thenReturn(20);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "mehu", 4));
        when(varasto.saldo(30)).thenReturn(20);  //karkit on loppu
        when(varasto.haeTuote(30)).thenReturn(new Tuote(30, "karkki", 2));
        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(2);     // ostetaan mehua
        k.lisaaKoriin(30);
        k.poistaKorista(30);
        k.tilimaksu("pekka", "12345");


        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu oikein
        verify(pankki).tilisiirto("pekka", 40, "12345", "33333-44455", 4);
    }

}
