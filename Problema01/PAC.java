public class PAC implements Entrega {

    @Override
    public double calcularEntrega(double peso) throws IllegalArgumentException {
        if (peso <= 1000) return 10;
        else if (peso <= 2000) return 15;
        else if (peso <= 3000) return 20;
        else if (peso <= 5000)  return 30;
        
        throw new IllegalArgumentException("Não aceita este tipo de entrega");
    }
}