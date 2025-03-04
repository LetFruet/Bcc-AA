public class Sedex implements Entrega {
    
    @Override
    public double calcularEntrega(double peso) {
        if (peso <= 500) return 12.5;
        else if (peso <= 750) return 20;
        else if (peso <= 1200) return 30;
        else if (peso <= 2000)  return 45;
        return 46.5 + (((peso - 2) * 10) * 1.5);
    }
}