import java.util.Scanner;

public class Q06{
//Função que verifica se a entrada é composta apenas por vogais
	public static boolean vogal(String entrada){
//Variável de checagem
		boolean check = false;
//Contador auxiliar
		int count = 0;
//Array com todas as vogais
		char[] vogais = {'A','E','I','O','U','a','e','i','o','u'};
		for(int i = 0; i< entrada.length();i++){
//Checa se a entraada é composta apenas por letras, se não for, o laço de repetição é quebrado
			if(!Character.isLetter(entrada.charAt(i))){
				break;
			}
//Checando se o caracter é uma vogal
			for(int j = 0; j< vogais.length;j++){
				if(entrada.charAt(i) == vogais[j]){
					count++;
				}
			}
		}
//A cada count = 1 caracter vogal, ou seja, se count for igual ao tamanho da entrada, a entrada é composta apenas por vogais
		if(count == entrada.length()){
			check = true;
		}
		return check;	
	}

//Função que verifica se a entrada é composta apenas por consoantes ( a lógica é a mesma da função vogal)
	public static boolean consoante(String entrada){
		boolean check = false;
		int count = 0;
		char[] vogais = {'A','E','I','O','U','a','e','i','o','u'};
		for (int i = 0; i<entrada.length();i++){
			boolean vogal = false;
			if(!Character.isLetter(entrada.charAt(i))){
				break;
			}
			for(int j = 0; j<vogais.length; j++){
				if(entrada.charAt(i) == vogais[j]){
					vogal = true;
					break;
				} 
			}
			if(!vogal && Character.isLetter(entrada.charAt(i))){
				count++;
			}
		}
		if(count == entrada.length()){
			check = true;
		}
		return check;
	}
//Função que verifica se a entrada é um número inteiro
	public static boolean checkinteiro(String entrada){
		boolean check = false;
/*É realizada uma tentativa de conversão visando os numeros inteiros, caso dê certo, 
a entrada é um número inteiro e check receberã o valor true*/
		try{
			int test = Integer.parseInt(entrada);
			check = true;
		} catch(NumberFormatException e){

		}
		return check;
	} 
	public static boolean checkreal(String entrada){
		boolean check = false;
//Mudar a virgula para ponto para se adaptar ao parseDouble
		entrada = entrada.replaceAll(",",".");
//Tentativa de conversão para double, caso dê certo, a entrada é um número real e check recebe o valor true
		try{
			double test = Double.parseDouble(entrada);
			check = true;
		} catch(NumberFormatException e){

		}
		return check;
	}
	public static boolean endLine(String entrada){
		boolean check = true;
		if(entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M'){
			check = false;
		}
		return check;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String entrada;
		entrada = sc.nextLine();
		while(endLine(entrada)){
// Sobre esse "?": Caso a função retorne true, imprime "SIM", caso retorne false, imprime "NAO
		System.out.print(vogal(entrada) ? "SIM " : "NAO ");
		System.out.print(consoante(entrada) ? "SIM " : "NAO ");
		System.out.print(checkinteiro(entrada) ? "SIM " : "NAO ");
		System.out.println(checkreal(entrada) ? "SIM " : "NAO ");
		entrada = sc.nextLine();
		}
	sc.close();
	}
	
	
}
