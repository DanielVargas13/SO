package lavanderia;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class FCFS extends Escalonador {

	private static List<Processo> listaProntos;
	private static List<String> nomesProntos = new ArrayList<String>();
	private static List<String> nomesPassados = new ArrayList<String>();
	private static LinkedHashMap<String,Tempos> tempos = new LinkedHashMap<String,Tempos>();

	
	public FCFS(List<Processo> processos) {
		try {
			listaProntos = new ArrayList<Processo>(processos);
			double tempoRetorno = 0;
			int n = 0;
			int totalProcessos = processos.size();
			preencheNomes(totalProcessos);
			double retorno = 0;
			System.out.println("\n------------FCFS------------");
			// enquanto existir processos na fila de prontos
			while (!listaProntos.isEmpty()) {
				// obtem o primeiro processo da fila e remove
				Processo p = listaProntos.remove(0); 
				retorno += p.getDuracao();
				tempoRetorno += retorno;
				if(n<totalProcessos&&!nomesPassados.contains(p.getNome())) {
		            Tempos t = tempos.get(p.getNome());
		            t.setPrimeiroLote(retorno);
					tempos.replace(p.getNome(), t);
		            n++;
	            }
				nomesPassados.add(nomesProntos.remove(0));
				if (!nomesProntos.contains(p.getNome())) {
					Tempos t = tempos.get(p.getNome());
		            t.setTotal(retorno);
					tempos.replace(p.getNome(), t);
		        }
			}
			// seta os tempos médios
			super.setRetornoMedio(tempoRetorno/totalProcessos);
			printMetricas();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	//preeche o hash com os nomes
	private void preencheNomes(int total) {
		for (int i=0;i<total;i++) {
			nomesProntos.add(listaProntos.get(i).getNome());
			if(!tempos.containsKey(listaProntos.get(i).getNome())) {
				tempos.put(listaProntos.get(i).getNome(), new Tempos());
			}
		}
	}
	 //Imprime as métricas
	public void printMetricas() {
		System.out.println(tempos);
		super.printMetricas("Tempo de Médio");
	}
}