package lavanderia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Arquivo {
	private static int cont = 0;
	private static int contl = 0;
	/*public void gravar(Cliente cliente) {

		try {
			File arquivo = new File("arquivo.txt");
			FileWriter fileWriter = new FileWriter(arquivo, true);
			BufferedWriter escrever = new BufferedWriter(fileWriter);
			cont=lerTotal();
			if(cont==0) {
				escrever.write(String.valueOf(cont));
				escrever.newLine();
			}
			escrever.write(cliente.getNome()+"; ");
			escrever.write(String.valueOf(cliente.getPeso())+"; ");
			escrever.write(String.valueOf(cliente.getPreco()));
			escrever.newLine();
			escrever.close();
			fileWriter.close();
			cont++;
			regravar();
			System.out.println("Registro gravado com sucesso");
		}catch(NullPointerException ex){
			System.out.println("Não foi possível gravar o registro");
		}catch (IOException ex) {
			System.out.println("Arquivo não existe");
		} 
	}
	private void regravar() {
		try {
			File arquivo = new File("arquivo.txt");
			File temp = new File("temp.txt");
			FileReader ler = new FileReader(arquivo);
			BufferedReader lerb = new BufferedReader(ler);
			FileWriter fileWriter = new FileWriter(temp, true);
			BufferedWriter escrever = new BufferedWriter(fileWriter);
			lerb.readLine();
			String linha = lerb.readLine();
			escrever.write(String.valueOf(cont));
			escrever.newLine();

			while (linha != null) {
				escrever.write(linha);
				escrever.newLine();
				linha = lerb.readLine();
			}
			lerb.close();
			ler.close();
			escrever.close();
			fileWriter.close();
			arquivo.delete();
			transferir();
		} catch (IOException e) {
			System.out.println("Arquivo não existe");
		}
	}
	private void transferir() {
		try {
			File arquivo = new File("arquivo.txt");
			File temp = new File("temp.txt");
			FileReader ler = new FileReader(temp);
			BufferedReader lerb = new BufferedReader(ler);
			FileWriter fileWriter = new FileWriter(arquivo, true);
			BufferedWriter escrever = new BufferedWriter(fileWriter);
			String linha = lerb.readLine();

			while (linha != null) {
				escrever.write(linha);
				escrever.newLine();
				linha = lerb.readLine();
			}
			lerb.close();
			ler.close();
			escrever.close();
			fileWriter.close();
			temp.delete();
		} catch (IOException e) {
			System.out.println("Arquivo não existe");
		}
	}*/
	public void ler() {
		try {
			File arquivo = new File("arquivo.txt");
			FileReader ler = new FileReader(arquivo);
			BufferedReader lerb = new BufferedReader(ler);
			String linha = lerb.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = lerb.readLine();
			}
			lerb.close();
			ler.close();
		} catch (IOException e) {
			System.out.println("Arquivo não existe");
		}
	}
	public int lerTotal() {
		String linha;
		int total=0;
		try {
			File arquivo = new File("arquivo.txt");
			FileReader ler = new FileReader(arquivo);
			BufferedReader lerb = new BufferedReader(ler);
			linha=lerb.readLine();
			if(linha==null) {
				total=0;
			}else {
				total=Integer.parseInt(linha);
			}
			lerb.close();
			ler.close();
		} catch (IOException e) {
			System.out.println("Arquivo não existe");
		}
		return total;
	}
	public String lerLinha() {
		String linha=null;
		try {
			File arquivo = new File("arquivo.txt");
			FileReader ler = new FileReader(arquivo);
			BufferedReader lerb = new BufferedReader(ler);
			lerb.readLine();
			for(int i=0;i<contl;i++) {
				lerb.readLine();
			}
			linha = lerb.readLine();
			lerb.close();
			ler.close();
			contl++;
		} catch (IOException e) {
			System.out.println("Arquivo não existe");
		}
		return linha;
	}
	public void apagar() {
		try {
			File arquivo = new File("arquivo.txt");
			FileWriter fileWriter = new FileWriter(arquivo, false);
			fileWriter.write("");
			fileWriter.close();
			cont=0;
		} catch (IOException e) {
			System.out.println("Não foi possivel apagar os registros");
		}
		System.out.println("Registros apagados com sucesso");
	}
}
