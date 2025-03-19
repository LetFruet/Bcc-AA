package problema3;

import br.furb.analise.algoritmos.ArCondicionadoGellaKaza;

public class ArCondicionadoGellaKazaAdaptador implements ArCondicionado{
	
	private ArCondicionadoGellaKaza arCondicionado;

    public ArCondicionadoGellaKazaAdaptador() {
        this.arCondicionado = new ArCondicionadoGellaKaza();
    }

    @Override
    public void ligar() {
        arCondicionado.ativar();
    }

    @Override
    public void desligar() {
        arCondicionado.desativar();
    }

    @Override
    public void aumentarTemperatura() {
        arCondicionado.aumentarTemperatura();
    }

    @Override
    public void diminuirTemperatura() {
        arCondicionado.diminuirTemperatura();
    }

    @Override
    public void definirTemperatura(int temperatura) {
        int tempAtual = 28;
        while (tempAtual < temperatura) {
            arCondicionado.aumentarTemperatura();
            tempAtual++;
        }
        while (tempAtual > temperatura) {
            arCondicionado.diminuirTemperatura();
            tempAtual--;
        }
    }

}
