package problema3;

import br.furb.analise.algoritmos.PersianaSolarius;

public class PersianaSolariusAdaptador implements Persiana {

	 private PersianaSolarius persiana;
	 private boolean estaAberta;

	    public PersianaSolariusAdaptador() {
	    	this.estaAberta = false;
	        this.persiana = new PersianaSolarius();
	    }

	    @Override
	    public void abrir() {
	        persiana.subirPersiana();
	        estaAberta = true;
	    }

	    @Override
	    public void fechar() {
	        persiana.descerPersiana();
	        estaAberta = false;
	    }
	    
	    public boolean estaAberto() {
	    	return estaAberta;
	    }

		@Override
		public boolean estaAberta() {
			
			return false;
		}

		@Override
		public boolean estaPalhetasAbertas() {
			
			return false;
		}
}
