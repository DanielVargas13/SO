package lavanderia;


public class Processo implements Comparable<Processo> {
	
	private String nome;
	private double duracao;
	private double duracaoRestante;
	private double valorPago;

	public Processo(double duracao, String nome, double valor) {
		this.duracao = duracao;
		this.duracaoRestante = duracao;
		this.nome = nome;
		this.valorPago = valor;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public double getDuracaoRestante() {
		return duracaoRestante;
	}

	public void setDuracaoRestante(double duracaoRestante) {
		this.duracaoRestante = duracaoRestante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public int compareTo(Processo p) {
		if ( this.getDuracao() < p.getDuracao()) {
			return -1;
		} else if ( this.getDuracao() > p.getDuracao() ) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return getNome()+" - Peso:"+ getDuracao() + " Valor Pago:"+getValorPago();
	}

}
