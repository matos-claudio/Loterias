import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessTxtFile {
	public Map<Integer, Integer> processaArquivo() {
		try {
			String nome = "src/numeros.txt";
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);
			List<Integer> numerosProcessados = new ArrayList<Integer>();
			
			while (lerArq.ready()) {
	            String texto = lerArq.readLine();
	            String textoSplit [] = texto.split(",");

	            for (int i = 0; i < textoSplit.length; i++) {
	            	//System.out.println(textoSplit[i]);
	            	numerosProcessados.add(Integer.parseInt(textoSplit[i]));
				}  
	        }
			arq.close();
			return retornaNumerosProcessados(numerosProcessados);			
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		return null;
	}
	
	private Map<Integer, Integer> retornaNumerosProcessados(List<Integer> numerosProcessados){
		int[] array = new int[numerosProcessados.size()];
		List<Integer> numerosJaContabilizados = new ArrayList<Integer>();
		Map<Integer, Integer> numeroRepeticoes = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < numerosProcessados.size(); i++) {
			array[i] = numerosProcessados.get(i);
		}
		
		
		System.out.println("Números processados: " + Arrays.toString(array));
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j] && i != j && !numerosJaContabilizados.contains(array[i])) {
					registrarNumeroRepeticao(array[i], numeroRepeticoes);
				}
			}
			numerosJaContabilizados.add(array[i]);
		}
		return numeroRepeticoes;
	}
	
	private static void registrarNumeroRepeticao(int numero, Map<Integer, Integer> numeroRepeticoes) {
		if (numeroRepeticoes.get(numero) != null)
			numeroRepeticoes.put(numero, numeroRepeticoes.get(numero) + 1);
		else
			numeroRepeticoes.put(numero, 2);
	}
}
