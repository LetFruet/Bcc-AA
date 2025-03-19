package problema3;

import java.beans.Encoder;
import java.beans.Expression;
import java.beans.PersistenceDelegate;
import java.util.ArrayList;
import java.util.List;

import br.furb.analise.algoritmos.LampadaPhellipes;

public class ControleUniversal {
	
	
	private List<Lampada> lampadas;
    private List<Persiana> persianas;
    private List<ArCondicionado> arCondicionados;

    public ControleUniversal() {
        this.lampadas = new ArrayList<>();
        this.persianas = new ArrayList<>();
        this.arCondicionados = new ArrayList<>();
    }

    public void adicionarLampada(Lampada lampada) {
        lampadas.add(lampada);
    }

    public void adicionarPersiana(Persiana persiana) {
        persianas.add(persiana);
    }

    public void adicionarArCondicionado(ArCondicionado ar) {
        arCondicionados.add(ar);
    }

    public void modoSono() {
        lampadas.forEach(Lampada::desligar);
        persianas.forEach(t -> {
			try {
				t.fechar();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        arCondicionados.forEach(ArCondicionado::desligar);
    }

    public void modoTrabalho() {
        lampadas.forEach(Lampada::ligar);
        persianas.forEach(t -> {
			try {
				t.abrir();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        arCondicionados.forEach(ar -> ar.definirTemperatura(25));
        arCondicionados.forEach(ArCondicionado::ligar);
    }

}
