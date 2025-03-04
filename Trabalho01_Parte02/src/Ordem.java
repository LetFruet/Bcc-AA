public class Ordem {

    private String investidor;
    private String tipoOrdem;
    private Double valorAcao;

    public Ordem(String investidor, String tipoOrdem, Double valorAcao) {
        this.investidor = investidor;
        this.tipoOrdem = tipoOrdem;
        this.valorAcao = valorAcao;
    }

    public String getTipoOrdem() {
        return tipoOrdem;
    }

    public Double getValorAcao() {
        return valorAcao;
    }
}
