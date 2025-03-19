package problema3;

import br.furb.analise.algoritmos.LampadaShoyuMi;

public class LampadaShoyouMiAdaptador implements Lampada {
	
    private LampadaShoyuMi lampada;

    public LampadaShoyouMiAdaptador() {
        this.lampada = new LampadaShoyuMi();
    }

    @Override
    public void ligar() {
        lampada.ligar();
    }

    @Override
    public void desligar() {
        lampada.desligar();
    }

	
}
