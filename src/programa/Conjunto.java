package programa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Conjunto {
	private List<String> numeros = new ArrayList<String>();
	private List<String> numerosUniao = new ArrayList<String>();
	private List<String> numerosIntersecao = new ArrayList<String>();
	private List<String> numerosComplemento = new ArrayList<String>();

	// OK
	public Conjunto(String[] conjunto) {// CONSTRUTOR
		for (int i = 0;i<conjunto.length;i++) {
			numeros.add(conjunto[i]);
			numerosUniao.add(conjunto[i]);
		}
	}

	// OK
	public void unionOfSets(Conjunto b) {
		List<String> conj2 = b.getNumeros();
		//REALIZA A UNIÃO
		Iterator<String> it = conj2.iterator();
		while(it.hasNext()) {
			String a = it.next();
			if(!numeros.contains(a)) {
				numerosUniao.add(a);
			}
		}	
	}

	// OK
	public void intersectionOfSets(Conjunto b) {
		List<String> conj2 = b.getNumeros();
		//REALIZA A INTERSEÇÃO
		Iterator<String> it = conj2.iterator();
		while(it.hasNext()) {
			String a = it.next();
			if(numeros.contains(a)) {
				numerosIntersecao.add(a);
			}
		}
	}
	// OK
	public void complementOfSets(Conjunto b) {
		List<String> conj2 = b.getNumeros();
		//REALIZA O COMPLEMENTO
		Iterator<String> it = conj2.iterator();
		while(it.hasNext()) {
			String a = it.next();
			if(!numeros.contains(a)) {
				numerosComplemento.add(a);
			}
		}
	}
	public boolean isEqualTo(Conjunto b) {
		
		return true;
	}

	public List<String> getNumeros() {
		return numeros;
	}

	public List<String> getNumerosUniao() {
		return numerosUniao;
	}

	public List<String> getNumerosIntersecao() {
		return numerosIntersecao;
	}

	public List<String> getNumerosComplemento() {
		return numerosComplemento;
	}


}
