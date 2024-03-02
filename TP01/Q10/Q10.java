import java.util.Scanner;
//Importando para a entrada de arquivos

public class Q10{
	public static void main(String[] args){
		//Abrindo entrada
		Scanner sc = new Scanner(System.in);
		//Definição de um array para varias strings
		String[] frase= new String[800];
		//Declaração do índice
		int i = 0;
		//Primeira entrada
		frase[i] = sc.nextLine();
		//Condição: Enquanto a palavra digitada NÃO FOR "FIM", permita a digitação
		while(!(endInput(frase[i]))){
		//Acionando função que verifica se aquela palavra é um palíndromo 
			if(ispalindrom(frase[i])){
				System.out.println("SIM");
			}else{
				System.out.println("NAO");
			}
		//Pulando uma linha do array de Strings
			i++;
		//Chamando mais uma entrada
			frase[i] = sc.nextLine();
		}
		//Fechando entrada
		sc.close();
	}

//Função para verificar se a palavra é um palindromo
	public static boolean ispalindrom(String entrada){
		//Condicao de parada
		if(entrada.length() <= 1){
			return true;
		}
		//Se o primeiro caracter for igual o ultimo, retorna uma funcao com uma substring da qual
		//O primeiro caracter é o segundo da string inicial e o ultimo é o penultimo da string inicial
		if(entrada.charAt(0) == entrada.charAt(entrada.length()-1)){
			return ispalindrom(entrada.substring(1,entrada.length()-1));
		}else{
			return false;
		}
	}

//Função para checar se a palavra escrita foi "FIM"
	public static boolean endInput(String entrada){
	//Declarando variavel de checagem
		boolean check = false;
	//Por ser uma palavra pequena, é válido realizar a comparação caracter por caracter para não ter problemas
		if(entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M'){
		//Muudança da variavel de checagem
			check = true;
		}
	//Retorno de valor booleano
		return check;
	}
}

