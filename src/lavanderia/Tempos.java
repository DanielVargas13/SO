package lavanderia;

import static java.lang.String.format;

public class Tempos {
    private double primeiroLote;
    private double total;
    
    
    public Tempos(){
        setPrimeiroLote(0);
        setTotal(0);
    }   
    
    public Tempos(double primeiro, double total){
        setPrimeiroLote(primeiro);
        setTotal(total);
    }

	public double getPrimeiroLote() {
		return primeiroLote;
	}

	public void setPrimeiroLote(double primeiroLote) {
		this.primeiroLote = primeiroLote;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return format("Tempo até o primeiro lote: %.1f hrs, Tempo até o último lote: %.1f hrs\n",primeiroLote,total);
	}
    
     
}
