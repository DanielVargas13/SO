package lavanderia;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class RR extends Escalonador {

    private static final double QUANTUM = 1;
    private static List<Processo> listaProntos = new ArrayList<Processo>();
    private static List<String> nomesProntos = new ArrayList<String>();
    private static List<String> nomesPassados = new ArrayList<String>();
    private static LinkedHashMap<String,Tempos> tempos = new LinkedHashMap<String,Tempos>();

    public RR(List<Processo> processos) {
        double tempoRetorno = 0;
        int totalProcessos = processos.size();
        double retorno = 0;
        int n = 0;
        preparaListaProntos(processos, retorno);
        System.out.println("\n------------Round-Robin------------");
        // enquanto houver processos na lista de prontos
        while (!listaProntos.isEmpty()) {
	            Processo p = listaProntos.remove(0);
	            //Verifica se o processo da vez possui tempo restante maior que o QUANTUM
	    		//Caso contrário o resto do tempo é pego e o processo finalizado
	            if (p.getDuracaoRestante() > QUANTUM) {
	                p.setDuracaoRestante(p.getDuracaoRestante() - QUANTUM);
	                retorno += QUANTUM;
	                // adiciona o processo no final da lista, pois não foi finalizado
	                listaProntos.add(p);
	                nomesProntos.add(p.getNome());
	            } else {
	                retorno += p.getDuracaoRestante();
	            }
	            if(n<totalProcessos&&!nomesPassados.contains(p.getNome())) {
		            Tempos t = tempos.get(p.getNome());
		            t.setPrimeiroLote(retorno);
					tempos.replace(p.getNome(), t);
		            n++;
	            }
				nomesPassados.add(nomesProntos.remove(0));
		        //Verifica se o processo foi finalizado. 
		         //Se finalizado, são calculadas as métricas deste processo
		        if (!listaProntos.contains(p)) {
		            tempoRetorno += retorno;
		        }
		        if (!nomesProntos.contains(p.getNome())) {
					Tempos t = tempos.get(p.getNome());
		            t.setTotal(retorno);
					tempos.replace(p.getNome(), t);
		        }
        }

        //Depois que todos os processos foram executados a média das métricas é calculada
        super.setRetornoMedio(tempoRetorno/totalProcessos);
        printMetricas();
    }
    
    //Prepara a lista de prontos de acordo com o tempo de chegada e preeche o hash com os nomes
    private void preparaListaProntos(List<Processo> processos, double retorno) {
    	for (Processo p : processos) {
				if(!listaProntos.contains(p)) {
					for (Processo processo : processos) {
							listaProntos.add(processo);
							nomesProntos.add(processo.getNome());
							if(!tempos.containsKey(processo.getNome())) {
								tempos.put(processo.getNome(), new Tempos());
							}
					}
				}
			}
    }
    
    //Imprime as métricas
    public void printMetricas() {
    	System.out.println(tempos);
    	super.printMetricas("Tempo de Médio");
    }
}
