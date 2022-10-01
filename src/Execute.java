import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;


public class Execute {

	public static void main(String[] args) {
		ProcessTxtFile processaArquivoTxt = new ProcessTxtFile();
		List<Integer> lista = new ArrayList<Integer>();
		Random random = new Random();
		
		Map<Integer, Integer> numeroRepeticoes = processaArquivoTxt.processaArquivo();
		
		for (Entry<Integer, Integer> numeroRepeticao : numeroRepeticoes.entrySet()) {
			System.out.println("O numero " + numeroRepeticao.getKey() + 
					" é repetido " + numeroRepeticao.getValue() + " vezes.");
			if(numeroRepeticao.getValue() >= 6) {
				lista.add(numeroRepeticao.getKey());
			}
		}
		
		System.out.println("\n\n");
		System.out.println("***********************************************************");
		System.out.println("");
		System.out.println("Números processados: "+lista.size());
		System.out.println("Critério: Números com mais de 3 repetições");
		System.out.println("Sugestões.: "+lista);
		System.out.println("");
		System.out.println("***********************************************************");
		
		
		int rand;
		int numeroSorteado;
		for (int i=0; i < lista.size(); i++) {
			System.out.println("\n");
			System.out.println("Sugestão "+(i+1)+":\n");
            for (int j = 1; j <= 6; j++) {      
            	rand = random.nextInt(lista.size());
    			numeroSorteado = lista.get(rand);
    			lista.remove(rand);
    			System.out.println("Dezena.: "+numeroSorteado);
			}
		}

	}

}
