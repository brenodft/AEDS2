import java.util.Scanner;
import java.io.*;

class main {

	public static boolean palindromo(String text){
		int countnormal = 0;
		int palin = 0;
		String text2 = "";
		char chr;
		if (text.charAt(0) == 'F' && text.charAt(1) == 'I' && text.charAt(2) == 'M') {
			return false;
		}
		for(int i = 0; i< text.length(); i++){
			chr = text.charAt(i);
			text2 = chr+text2;
		}
		if(text.equals(text2)){
			System.out.println("SIM");
			return true;
		}else{
			System.out.println("NAO");
			return false;
		}
	} 
	public static boolean endrep(String frase) {
		if(frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M'){
			return false;
		} else{
			return true;
		}
	}

	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		String textinput;
		do{ 
			textinput = sc.nextLine();
			palindromo(textinput);
		}while (endrep(textinput)); 
	}
}
