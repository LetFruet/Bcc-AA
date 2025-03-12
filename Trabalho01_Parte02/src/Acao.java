import java.util.ArrayList;
import java.util.List;

public class Acao implements Subject {

	private String nomeAcao;
	private Double valorAcao;
	private List<Observer> observadores = new ArrayList<>();
	private String mensagemValor;

	public Acao(String nomeAcao, Double valorAcao) {
	this.nomeAcao = nomeAcao;
	this.valorAcao = valorAcao;
	}

	public void AtualizarValor(double novoValor) {
	  this.valorAcao = novoValor;
	  notifyObserver("O valor da ação " + nomeAcao + " foi atualizado para R$" + valorAcao);
	  mensagemValor = "O valor da ação " + nomeAcao + " foi atualizado para R$" + valorAcao;
    }

    @Override
    public void registerObserver(Observer observer) {
        observadores.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observadores.remove(observer);
    }

    @Override
    public void notifyObserver(String mensagem) {
        for (Observer observer : observadores) {
            observer.update(mensagem);
       }
    }

	public String getNomeAcao() {
		return nomeAcao;
	}

	public void setNomeAcao(String nomeAcao) {
		this.nomeAcao = nomeAcao;
	}

	public Double getValorAcao() {
		return valorAcao;
	}

	public void setValorAcao(Double valorAcao) {
		this.valorAcao = valorAcao;
	}

	public List<Observer> getObservadores() {
		return observadores;
	}

	public void setObservadores(List<Observer> observadores) {
		this.observadores = observadores;
	}

	public String getMensagemValor() {
		return mensagemValor;
	}

	public void setMensagemValor(String mensagemValor) {
		this.mensagemValor = mensagemValor;
	}
	
	
    
    
}

