package problema3;

import br.furb.analise.algoritmos.PersianaNatLight;

public class PersianaNatLightAdaptador implements Persiana {
	
	  private PersianaNatLight persiana;
	    private boolean estaAberta;
	    private boolean palhetasAbertas;

	    public PersianaNatLightAdaptador() {
	        this.persiana = new PersianaNatLight();
	        this.estaAberta = false; 
	        this.palhetasAbertas = false;
	    }

	    @Override
	    public void abrir() throws Exception {
	        
	        if (!palhetasAbertas) {
	            persiana.abrirPalheta();
	            palhetasAbertas = true;
	        }

	        
	        if (palhetasAbertas) {
	            persiana.subirPalheta();
	            estaAberta = true;
	        }
	    }

	    @Override
	    public void fechar() throws Exception {
	        
	        if (estaAberta) {
	            System.out.println("Não é possível fechar palhetas com a persiana levantada.");
	            return;
	        }

	        
	        if (palhetasAbertas) {
	            persiana.fecharPalheta();
	            palhetasAbertas = false;
	        }

	        
	        persiana.descerPalheta();
	        estaAberta = false;
	    }

	    @Override
	    public boolean estaAberta() {
	        return estaAberta;
	    }

	    @Override
	    public boolean estaPalhetasAbertas() {
	        return palhetasAbertas;
	    }
    
    

}
