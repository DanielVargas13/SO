package lavanderia;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Lavanderia {
	public static List<Processo> listaProcessos = new ArrayList<Processo>();
    
	public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Arquivo arq = new Arquivo();
        String lixo;
        int op = 0;
        int dop = 0;
        
        do{
            System.out.println("");
            System.out.println("*-- SELECIONE UMA OPÇÃO --*");
            System.out.println("[1] - Exibir arquivo");
            System.out.println("[2] - Simulação.");
            System.out.println("[0] - Sair.");
            System.out.print("-> ");   
            try{
                op = teclado.nextInt();
                System.out.println("");
            }catch(InputMismatchException e){
                lixo = teclado.nextLine();
                System.out.println("--------------------------------------------");
                System.out.println("**Valor inválido!");
                System.out.println("--------------------------------------------");
            }
            
            switch(op){
                case 1:
                    arq.ler();
                    break;
                    
                case 2:
                	double duracao=0;
            		for (int i=0;i<arq.lerTotal();i++) {
            			String dados[] = arq.lerLinha().split(";");
            			duracao= Double.parseDouble(dados[1])/35;
            			String valor = dados[2].replaceAll(",", ".");
            			listaProcessos.add(new Processo(duracao,dados[0],Double.parseDouble(valor)));
            		}
                	do {
                	lixo = teclado.nextLine();
            		System.out.println("");
                    System.out.println("*-- QUAL A SIMULAÇÃO DESEJADA? --*");
                    System.out.println("[1] - FCFS");
                    System.out.println("[2] - SJF");
                    System.out.println("[3] - Round-Robin");
                    System.out.println("[4] - Filas de Prioridade");
                    System.out.print("-> ");
                    dop = teclado.nextInt();
            		switch(dop) {
            		case 1:
            			FCFS fcfs = new FCFS(listaProcessos);
            			break;
            		case 2:
            			SJF sjf = new SJF(listaProcessos);
            			break;
            		case 3:
            			RR rr = new RR(listaProcessos);
            			break;
            		case 4:
            			FP fp = new FP(listaProcessos);
            			break;
            		case 0:
                        break;
                    default:
                        System.out.println("--------------------------------------------");
                        System.out.println("**Opção Inválida!");
                        System.out.println("--------------------------------------------");
                        break;
            		}
                    System.out.println("\nDeseja realizar mais alguma simulação? (Sim-1/Não-0)");
					dop = teclado.nextInt();
				}while(dop!=0);
                   break;
                   
                case 0:
                    break;
                default:
                    System.out.println("--------------------------------------------");
                    System.out.println("**Opção Inválida!");
                    System.out.println("--------------------------------------------");
                    break;
                
            }
        }while(op != 0);
    }
    
}
