import java.util.ArrayList;

public class Pedido {

    private int codigoPedido;
    private ArrayList<Produto> listaProdutos = new ArrayList<>();
    private Entrega tipoEntrega;

    public Pedido() {
    }

    public Pedido(int codigoPedido, Entrega tipoEntrega) {
        this.codigoPedido = codigoPedido;
        this.tipoEntrega = tipoEntrega;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Entrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(Entrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    
    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public double calcularPeso() {
        
        double pesoTotal = 0.0;

        for (Produto p : listaProdutos) {
            pesoTotal += p.getPeso();
        }

        return pesoTotal;
    }
    
    public double calcularValorEntrega() {

        double pesoEntrega = calcularPeso();

        return tipoEntrega.calcularEntrega(pesoEntrega);
    }
}