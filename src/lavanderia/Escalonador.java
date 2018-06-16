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


    //Imprime as m�tricas do escalonador: 
    //Tempo de retono m�dio - Tempo de resposta m�dio - Tempo de espera m�dio
    public void printMetricas(String siglaEscalonador) {
        System.out.println(format("\n%s - %.1f horas", siglaEscalonador, getRetornoMedio()));
    }
}