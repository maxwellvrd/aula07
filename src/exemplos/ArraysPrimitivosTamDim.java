package exemplos;

public class ArraysPrimitivosTamDim {

	static int TAM = 9;
	static String[] nomes = new String[11];
	static int cont = 0;

	public static void main(String[] args) {

		add("Roberto");
		add("Anisio Cuba Libre");
		add("Gabriela Mudinha");
		add("Maxwell Gambiarra");
		add("Pedro way");
		add("Gabriel");
		add("Joaquim");
		add("Thais");
		add("Karla");
		add("Josi");
		add("Welligton");

		imprimir();
	}

	private static void add(String nome) {

		verifica();
		nomes[cont] = nome;
		cont++;
	}

	

	private static void imprimir() {
		for (String nome : nomes) {
			
			if(nome == null)
				break;
			
			System.out.println(nome);
			
		}
	}

	private static void verifica() {
		if ((cont+1) >= (TAM * 0.75)) {
			TAM += (TAM * 0.50);
			criaVetor(TAM);

		}

	}
	public static void criaVetor(int TAM) {
		// vetor temporario
		String[] temp = new String[TAM];
		// carrega o vetor temp
		
		for(int i = 0; i < nomes.length; i++){
			temp[i] = nomes[i];
		}
		// exclui o vetor nomes
		
		nomes = null;
		//recria o vetor nomes com o novo tamanho
		nomes = new String[TAM];
		// atribui os dados ao vetor nomes
		nomes = temp;
		//exclui o vetor temp
		temp = null;
	}
}
