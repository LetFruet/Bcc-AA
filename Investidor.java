import java.util.ArrayList;

public class Investidor {

    private String nomeInvestidor;
    private ArrayList<Ordem> ordens = new ArrayList<Ordem>();
    private ArrayList<Acao> acoesInteresse = new ArrayList<Acao>();

    public Investidor(String nomeInvestidor) {
        this.nomeInvestidor = nomeInvestidor;
        this.ordens = ordens;
        this.acoesInteresse = acoesInteresse;
    }

    public void registraOrdem(Ordem ordem, Acao acao) {
        ordens.add(ordem);
        acao.RegistrarOrdem(ordem);
    }

    public void registraAcao(Acao acao) {
        acoesInteresse.add(acao);
        acao.AdicionarInvestidor(this);
    }

    public void programarOrdem(Double valor, String tipo, Acao acao) {
        acao.AdicionarOrdemProgramada(valor, tipo, this);
    }

    public String getNomeInvestidor() {
        return nomeInvestidor;
    }
}
