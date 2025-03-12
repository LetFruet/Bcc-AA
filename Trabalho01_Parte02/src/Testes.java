import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class Testes {

    @Test //Criar Investidores e Retornar Seus Nomes ----------------- ok
    public void teste01() {

        Investidor investidor01 = new Investidor("Pedro Rafael");
        Investidor investidor02 = new Investidor("Leonardo Dal'Olmo");

        assertEquals("Pedro Rafael", investidor01.getNomeInvestidor());
        assertEquals("Leonardo Dal'Olmo", investidor02.getNomeInvestidor());
    }

    @Test //Criar A��es e Retornar Seus Nomes e Valores ----------------- ok
    public void teste02() {

        Acao acao01 = new Acao("Vale", 30.0);
        Acao acao02 = new Acao("Petrobras", 45.0);

        assertEquals("Vale", acao01.getNomeAcao());
        assertEquals("Petrobras", acao02.getNomeAcao());
    }

    @Test //Criar Ordens e Retornar Seus Tipos e Valores ----------------- ok
    public void teste03() {

        Ordem ordemCompra = new Ordem("Pedro Rafael", "Compra", 30.0);
        Ordem ordemVenda = new Ordem("Pedro Rafael", "Venda", 45.0);

        assertEquals("Compra", ordemCompra.getTipoOrdem());
        assertEquals("Venda", ordemVenda.getTipoOrdem());

        assertEquals(30.0, ordemCompra.getValorAcao(), 0);
        assertEquals(45.0, ordemVenda.getValorAcao(), 0);

    }

    @Test //Verificar o Valor da A��o Ap�s Sua Atualiza��o ----------------- ok
    public void teste04() {

        Acao acao01 = new Acao("Vale", 30.0);

        Investidor investidor01 = new Investidor("Pedro Rafael");
        Investidor investidor02 = new Investidor("Leonardo Dal'Olmo");

        assertEquals(30.0, acao01.getValorAcao(), 0);

        Ordem ordemCompraInvestidor01 = new Ordem("Pedro Rafael", "Compra", 25.0);
        investidor01.registrarOrdem(ordemCompraInvestidor01, acao01);
        
        acao01.AtualizarValor(25);

        Ordem ordemVendaInvestidor02 = new Ordem("Pedro Rafael", "Venda", 25.0);
        investidor02.registrarOrdem(ordemVendaInvestidor02, acao01);


        assertEquals(25.0, acao01.getValorAcao(), 0);

    }


    @Test //Teste da Notifica��o de Altera��o de Valor COM Interesse do Investidor ----------------- ok
    public void teste05() {

        Acao acao01 = new Acao("Vale", 30.0);

        Investidor investidor01 = new Investidor("Pedro Rafael");
   

        Investidor investidor02 = new Investidor("Leonardo Dal'Olmo");
   

        Ordem ordemCompraInvestidor01 = new Ordem("Pedro Rafael", "Compra", 25.0);
        investidor01.registrarOrdem(ordemCompraInvestidor01, acao01);
        

        Ordem ordemVendaInvestidor02 = new Ordem("Pedro Rafael", "Venda", 25.0);
        investidor02.registrarOrdem(ordemVendaInvestidor02, acao01);
        
        acao01.AtualizarValor(10);
        
        
        assertEquals("O valor da ação Vale foi atualizado para R$10.0", acao01.getMensagemValor());


 
    }

}