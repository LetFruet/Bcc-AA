import java.util.ArrayList;
import java.util.List;


public class Acao {

    private String nomeAcao;
    private Double valorAcao;
    private ArrayList<Ordem> ordens = new ArrayList<Ordem>();
    private ArrayList<Investidor> investidors = new ArrayList<Investidor>();
    private ArrayList<Ordem> ordensProgramadas = new ArrayList<Ordem>();
    private List<String> notificacoes = new ArrayList<>(); // Lista para armazenar notificações

    public Acao(String nomeAcao, Double valorAcao) {
        this.nomeAcao = nomeAcao;
        this.valorAcao = valorAcao;
        this.ordens = new ArrayList<>();
        this.investidors = new ArrayList<>();
        this.ordensProgramadas = new ArrayList<>();
    }

    public void RegistrarOrdem(Ordem ordem) {
        ordens.add(ordem);
        VerificarOrdem(ordem);
    }

    public void VerificarOrdem(Ordem novaOrdem) {
        for(Ordem ordem : new ArrayList<Ordem>(ordens)){
            if(ordem.getTipoOrdem().equals("Compra") && novaOrdem.getTipoOrdem().equals("Venda") && ordem.getValorAcao() >= novaOrdem.getValorAcao()){
                ordens.remove(ordem);
                ordens.remove(novaOrdem);
                AtualizarValor(novaOrdem.getValorAcao());
                break;
            } else if(ordem.getTipoOrdem().equals("Venda") && novaOrdem.getTipoOrdem().equals("Compra") && ordem.getValorAcao() >= novaOrdem.getValorAcao()){
                ordens.remove(ordem);
                ordens.remove(novaOrdem);
                AtualizarValor(novaOrdem.getValorAcao());
                break;
            }
        }
    }

    public void AtualizarValor(double novoValor){
        this.valorAcao = novoValor;
        NotificarInvestidor();
        processarOrdemProgramada();
    }

    public void NotificarInvestidor() {
        for (Investidor investidor : investidors) {
            String mensagem = "Notificação: " + investidor.getNomeInvestidor() +
                    " O valor da ação " + nomeAcao + " foi atualizado para R$" + valorAcao;
            notificacoes.add(mensagem);
        }
    }

    public List<String> getNotificacoes() {
        return notificacoes;
    }
    public void AdicionarInvestidor(Investidor investidor){
        investidors.add(investidor);
    }

    public void AdicionarOrdemProgramada(double valor, String tipo, Investidor investidor){
        Ordem ordemProgramada = new Ordem(investidor.getNomeInvestidor(), tipo, valor);
        ordensProgramadas.add(ordemProgramada);
    }

    public void processarOrdemProgramada(){
        List<Ordem> ordensRemover = new ArrayList<>();
        for(Ordem ordem : ordensProgramadas){
            if((ordem.getTipoOrdem().equals("Venda") && valorAcao <= ordem.getValorAcao()) || (ordem.getTipoOrdem().equals("Compra") && valorAcao >= ordem.getValorAcao())){
                RegistrarOrdem(ordem);
                ordensRemover.add(ordem);
            }
        }
        ordensRemover.removeAll(ordensRemover);
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public Double getValorAcao() {
        return valorAcao;
    }
}
