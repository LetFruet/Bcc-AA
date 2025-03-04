import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

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

        assertEquals(30.0, ordemCompra.getValorAcao());
        assertEquals(45.0, ordemVenda.getValorAcao());

    }

    @Test //Verificar o Valor da A��o Ap�s Sua Atualiza��o ----------------- ok
    public void teste04() {

        Acao acao01 = new Acao("Vale", 30.0);

        Investidor investidor01 = new Investidor("Pedro Rafael");
        Investidor investidor02 = new Investidor("Leonardo Dal'Olmo");

        assertEquals(30.0, acao01.getValorAcao());

        Ordem ordemCompraInvestidor01 = new Ordem("Pedro Rafael", "Compra", 25.0);
        investidor01.registraOrdem(ordemCompraInvestidor01, acao01);

        Ordem ordemVendaInvestidor02 = new Ordem("Pedro Rafael", "Venda", 25.0);
        investidor02.registraOrdem(ordemVendaInvestidor02, acao01);

        acao01.VerificarOrdem(ordemVendaInvestidor02);

        assertEquals(25.0, acao01.getValorAcao());

    }

    @Test //Verificar Se N�o Ocorre Match Com Valor de Compra e Venda Diferente ----------------- ok
    public void teste05() {

        Acao acao01 = new Acao("Vale", 30.0);

        Investidor investidor01 = new Investidor("Pedro Rafael");
        Investidor investidor02 = new Investidor("Leonardo Dal'Olmo");

        assertEquals(30.0, acao01.getValorAcao());

        Ordem ordemCompraInvestidor01 = new Ordem("Pedro Rafael", "Compra", 25.0);
        investidor01.registraOrdem(ordemCompraInvestidor01, acao01);

        Ordem ordemVendaInvestidor02 = new Ordem("Pedro Rafael", "Venda", 70.0);
        investidor02.registraOrdem(ordemVendaInvestidor02, acao01);

        acao01.VerificarOrdem(ordemVendaInvestidor02);

        assertEquals(30.0, acao01.getValorAcao());

    }

    @Test //Verificar Se Ocorre Match Com Compra Menor Que o Valor de Venda ----------------- ok
    public void teste06() {

        Acao acao01 = new Acao("Vale", 30.0);

        Investidor investidor01 = new Investidor("Pedro Rafael");
        Investidor investidor02 = new Investidor("Leonardo Dal'Olmo");

        assertEquals(30.0, acao01.getValorAcao());

        Ordem ordemCompraInvestidor01 = new Ordem("Pedro Rafael", "Compra", 25.0);
        investidor01.registraOrdem(ordemCompraInvestidor01, acao01);

        Ordem ordemVendaInvestidor02 = new Ordem("Pedro Rafael", "Venda", 10.0);
        investidor02.registraOrdem(ordemVendaInvestidor02, acao01);

        acao01.VerificarOrdem(ordemVendaInvestidor02);

        assertEquals(10.0, acao01.getValorAcao());

    }

    @Test //Teste da Notifica��o de Altera��o de Valor COM Interesse do Investidor ----------------- ok
    public void teste07() {

        Acao acao01 = new Acao("Vale", 30.0);

        Investidor investidor01 = new Investidor("Pedro Rafael");
        investidor01.registraAcao(acao01);

        Investidor investidor02 = new Investidor("Leonardo Dal'Olmo");
        investidor02.registraAcao(acao01);

        Ordem ordemCompraInvestidor01 = new Ordem("Pedro Rafael", "Compra", 25.0);
        investidor01.registraOrdem(ordemCompraInvestidor01, acao01);

        Ordem ordemVendaInvestidor02 = new Ordem("Pedro Rafael", "Venda", 25.0);
        investidor02.registraOrdem(ordemVendaInvestidor02, acao01);

        List<String> notificacoes = acao01.getNotificacoes();

        assertTrue(notificacoes.contains("Notificação: Pedro Rafael O valor da ação Vale foi atualizado para R$25.0"));
        assertTrue(notificacoes.contains("Notificação: Leonardo Dal'Olmo O valor da ação Vale foi atualizado para R$25.0"));
    }

    @Test //Teste da Notifica��o de Altera��o de Valor SEM Interesse do Investidor ----------------- ok
    public void teste08() {

        Acao acao01 = new Acao("Vale", 30.0);

        Investidor investidor01 = new Investidor("Pedro Rafael");
        Investidor investidor02 = new Investidor("Leonardo Dal'Olmo");

        Ordem ordemCompraInvestidor01 = new Ordem("Pedro Rafael", "Compra", 25.0);
        investidor01.registraOrdem(ordemCompraInvestidor01, acao01);

        Ordem ordemVendaInvestidor02 = new Ordem("Pedro Rafael", "Venda", 25.0);
        investidor02.registraOrdem(ordemVendaInvestidor02, acao01);

        assertTrue(acao01.getNotificacoes().isEmpty(), "Nenhuma notificação deveria ser enviada.");
    }
}