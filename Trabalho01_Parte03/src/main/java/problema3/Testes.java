package problema3;

import br.furb.analise.algoritmos.LampadaPhellipes;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TesteTest {

    @Test
    public void testPersianaSolariusAdapter() throws Exception {
        Persiana persiana = new PersianaSolariusAdaptador();


        persiana.abrir();
        assertTrue(persiana instanceof Persiana);


        persiana.fechar();
        assertTrue(persiana instanceof Persiana);
    }

    @Test
    public void testPersianaNatLightAdapter() throws Exception {
        Persiana persiana = new PersianaNatLightAdaptador();


        persiana.abrir();
        assertTrue(persiana.estaPalhetasAbertas());


        persiana.fechar();
        assertTrue(persiana.estaAberta());
    }

    @Test
    public void testArVentoBaumnAdapter() {
        ArCondicionado ar = new ArCondicionadoVentoBaumnAdaptador();

        ar.ligar();
        assertTrue(ar instanceof ArCondicionado);

        ar.definirTemperatura(20);
        ar.desligar();
        assertTrue(ar instanceof ArCondicionado);
    }

    @Test
    public void testArGellaKazaAdapter() {
        ArCondicionado ar = new ArCondicionadoGellaKazaAdaptador();

        ar.ligar();
        assertTrue(ar instanceof ArCondicionado);

        ar.aumentarTemperatura();
        ar.diminuirTemperatura();

        ar.desligar();
        assertTrue(ar instanceof ArCondicionado);
    }

    @Test
    public void testLampadaShoyouMiAdapter() {
        Lampada lampada = new LampadaShoyouMiAdaptador();

        lampada.ligar();
        assertTrue(lampada instanceof Lampada);

        lampada.desligar();
        assertTrue(lampada instanceof Lampada);
    }

    @Test
    public void testLampadaPhelippesAdapter() {
        Lampada lampada = new LampadaPhellipesAdaptador();

        lampada.ligar();
        assertTrue(lampada instanceof Lampada);

        lampada.desligar();
        assertTrue(lampada instanceof Lampada);
    }

}
