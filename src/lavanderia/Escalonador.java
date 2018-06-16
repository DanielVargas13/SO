package lavanderia;

import static java.lang.String.format;

import java.util.List;


public class Escalonador {

    private double retornoMedio;

    public double getRetornoMedio() {
        return retornoMedio;
    }

    public void setRetornoMedio(double retornoMedio) {
        this.retornoMedio = retornoMedio;
    }


    //Imprime as métricas do escalonador: 
    //Tempo de retono médio - Tempo de resposta médio - Tempo de espera médio
    public void printMetricas(String siglaEscalonador) {
        System.out.println(format("\n%s - %.1f horas", siglaEscalonador, getRetornoMedio()));
    }
}