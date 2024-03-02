import java.util.Scanner;
import java.util.Random;

public class Randomchar{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		while(endLine(entrada)){
			System.out.println(sort(entrada));
			entrada = sc.nextLine();
		}
		sc.close();		
	}
//Inicializa a variavel global gerador com seed 4
	static Random gerador = new Random(4);
//Gera um char aleatorio entre 'a' e 'z'
	static char gerador(){
		return (char)('a'+(Math.abs(gerador.nextInt())%26));
	}
//Checa se a entrada é FIM
	public static boolean endLine(String entrada){
		boolean checked = true;
		//Checa letra por letra se a entrada é FIM
		if(entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M'){
			checked = false;
		}
		return checked;
	}
//Substitui todas as ocorrencias de sorted1 por sorted2
	public static String sort(String entrada){
		//Gera dois chars aleatorios
		char sorted1 = gerador();
		char sorted2 = gerador();
		String sortedstring = new String();
		for(int i = 0; i<entrada.length(); i++){
			if(entrada.charAt(i) == sorted1){
				sortedstring +=  sorted2;
			}else{										
				sortedstring += entrada.charAt(i);
			}
		}
		//Retorna a string com as substituições
		return sortedstring;

	}
}




