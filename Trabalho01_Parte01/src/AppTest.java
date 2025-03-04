import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {

    @Test
    public void testAdicionarProduto() {
        Pedido pedido = new Pedido();
        Produto livro = new Produto("Livro Java", 50.0, 700);

        pedido.adicionarProduto(livro);

        assertEquals(1, pedido.getListaProdutos().size()); // Verifica se o produto foi adicionado
    }

    @Test
    public void testCalcularPeso() {
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro 1", 30.0, 500));
        pedido.adicionarProduto(new Produto("Livro 2", 40.0, 800));

        assertEquals(1300, pedido.calcularPeso(), 0);
    }

    @Test
    public void testCalcularValorEntregaSedex() {
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro 1", 30.0, 1200));

        Entrega sedex = new Sedex();
        double valorFrete = sedex.calcularEntrega(pedido.calcularPeso());

        assertEquals(30.00, valorFrete, 0);
    }

    @Test
    public void testCalcularValorEntregaPresencial() {
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro 1", 30.0, 1200));

        Entrega RetiradaLocal = new RetiradaLocal();
        double valorFrete = RetiradaLocal.calcularEntrega(pedido.calcularPeso());

        assertEquals(0.0, valorFrete, 0);
    }

    @Test
    public void testCalcularValorEntregaPAC() {
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro 1", 30.0, 1200));

        Entrega PAC = new PAC();
        double valorFrete = PAC.calcularEntrega(pedido.calcularPeso());

        assertEquals(15.0, valorFrete, 0);
    }


    @Test (expected = IllegalArgumentException.class)
    public void testCalcularValorEntregaPACErro() {
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(new Produto("Livro 1", 30.0, 5001));

        Entrega PAC = new PAC();
        PAC.calcularEntrega(pedido.calcularPeso());
    }
}