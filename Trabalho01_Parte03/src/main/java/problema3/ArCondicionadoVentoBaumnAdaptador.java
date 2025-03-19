package problema3;

import br.furb.analise.algoritmos.ArCondicionadoVentoBaumn;

public class ArCondicionadoVentoBaumnAdaptador implements ArCondicionado {
	
	 private ArCondicionadoVentoBaumn arCondicionado;

	    public ArCondicionadoVentoBaumnAdaptador() {
	        this.arCondicionado = new ArCondicionadoVentoBaumn();
	    }

	    @Override
	    public void ligar() {
	        arCondicionado.ligar();
	    }

	    @Override
	    public void desligar() {
	        arCondicionado.desligar();
	    }

	    @Override
	    public void aumentarTemperatura() {
	        arCondicionado.definirTemperatura(arCondicionado.getTemperatura() + 1);
	    }

	    @Override
	    public void diminuirTemperatura() {
	        arCondicionado.definirTemperatura(arCondicionado.getTemperatura() - 1);
	    }

	    @Override
	    public void definirTemperatura(int temperatura) {
	        arCondicionado.definirTemperatura(temperatura);
	    }

}
