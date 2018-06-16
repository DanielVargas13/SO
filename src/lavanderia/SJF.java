package lavanderia;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;


public class SJF extends Escalonador {

    private static List<Processo> listaProntos = new ArrayList<Processo>();
    private static List<String> nomesProntos = new ArrayList<String>();
    private static List<String> nomesPassados = new ArrayList<String>();
    private static LinkedHashMap<String,Tempos> tempos = new LinkedHashMap<String,Tempos>();

    public SJF(List<Processo> processos) {
        try {
            double tempoRetorno = 0;
            int n = 0;
            int totalProcessos = processos.size();
            double retorno = 0;
            preparaListaProntos(processos);
            preencheNomes(totalProcessos);
            System.out.println("\n------------SJF------------");
            // enquanto houver processos
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
    
     //Ordena a lista de acordo com a duração dos processos
	private void preparaListaProntos(List<Processo> processos) {
		List<Processo> p = new ArrayList<Processo>(processos);
		int menor = 0;
		int pivo = 0;
		Collections.sort(p);
		listaProntos.add(p.remove(0));

		while(p.size() > 1) {
			pivo = 0;
			for(int i = 1; i < p.size(); i++) {
				if(p.get(pivo).getDuracao() <= p.get(i).getDuracao()) {
					menor = pivo;
				}
				else {
					pivo = i;
					menor = i;
				}
			}
			listaProntos.add(p.remove(menor));
		}
		// add o ultimo processo a lista, na ultima posicao
		if(p.size() == 1)
			listaProntos.add(p.remove(0));
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