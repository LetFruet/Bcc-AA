import java.util.ArrayList;

public class Investidor implements Observer {

    private String nomeInvestidor;
    private ArrayList<Ordem> ordens = new ArrayList<Ordem>();
    
    public String getNomeInvestidor() {
        return nomeInvestidor;
    }
    public Investidor(String nomeInvestidor) {
        this.nomeInvestidor = nomeInvestidor;
    }
    
    public void registrarOrdem(Ordem ordem, Acao acao) {
        ordens.add(ordem);
    }
    @Override
    public void update(String mensagem) {
        System.out.println("O investidor e " + nomeInvestidor + " Sua notificação: " + mensagem);
    }

}
