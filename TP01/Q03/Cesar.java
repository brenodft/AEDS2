import java.util.Scanner;
public class Cesar{
//Realização do Ciframento de Cesar
	public static String cifCesar(String entrada){;
//String para receber cada caracter cifrado
		String cifrada = "";
		int ascii = 0;
		for(int i = 0; i< entrada.length(); i++){
//Tratamento para caracteres especiais
			if((int)entrada.charAt(i) != 65533){
				ascii = (int)entrada.charAt(i) + 3;
			}else{
//Caso o caracter seja especial, mantém o mesmo
				ascii = (int)entrada.charAt(i);
			}
//Fim do ciframento
			cifrada += (char)ascii;
		}
		return cifrada;
	}	
// Verifica se a entrada é a palavra FIM
	public static boolean endLine(String entrada){
		boolean check= true;
		if(entrada.charAt(0) == 'F' && entrada.charAt(1)== 'I' && entrada.charAt(2)== 'M'){
			check = false;
		}
		return check;
	}

	public static void main(String args[]){
			Scanner sc = new Scanner(System.in);
			String entrada = sc.nextLine();
			while(endLine(entrada)){
				System.out.println(cifCesar(entrada));
				entrada = sc.nextLine();
			}
			sc.close();
	}
}
