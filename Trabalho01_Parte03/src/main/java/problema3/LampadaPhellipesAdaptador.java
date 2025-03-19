package problema3;

import br.furb.analise.algoritmos.LampadaPhellipes;

public class LampadaPhellipesAdaptador implements Lampada{

	 private LampadaPhellipes lampada;

	    public LampadaPhellipesAdaptador() {
	        this.lampada = new LampadaPhellipes();
	    }

	    @Override
	    public void ligar() {
	        lampada.setIntensidade(100);
	    }

	    @Override
	    public void desligar() {
	        lampada.setIntensidade(0);
	    }
}
