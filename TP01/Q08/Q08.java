import java.util.Scanner;
import java.io.*;
import java.util.Locale;

public class Q08{

	public static void main(String[] args){	 
//Mudando a localidade para aceitar float com o separador . ao inves de ,
		Locale.setDefault(new Locale("en", "US"));//Inicializando scanner
		Scanner sc = new Scanner(System.in);
//Pedindo pro usuario informar o numero de elementos
		int inputsize = sc.nextInt();
		try{
//Acessando o arquivo em modo de ler e escrever
			RandomAccessFile arq = new RandomAccessFile("Q08.txt","rw");
//Preenchendo o arquivo
			for(int i = 0; i< inputsize; i++){
				double entrada = sc.nextDouble();
				arq.writeDouble(entrada);
			}
//Relizando a leitura do arquivo
			long seeklen = arq.length();
/*
 * Nessa variavel encontramos o valor em bytes dos elementos do arquivo, como é um double, cada caracter tem 8 bytes.
 * Ou seja, por exemplo, se temos 5 elementos, temos 40 bytes, então eu divido o filesize por 8 para ter o numero de elementos
 * para colocar no for
 */
			int filesize = (int)arq.length();
			int fileindex = filesize/8;
			for(int i = 0; i<fileindex;i++){
//Subtraio por 8 para ele ler de tras pra frente
			filesize = filesize - 8;
/*  O seek se orienta pelo numero de bytes ou seja, colocando o total -8 ele vai apontar pro ultimo elemento
 *  e assim por diante
*/	
			arq.seek(filesize);
			double number = arq.readDouble();
			if (number == (int)number){
				System.out.println((int)number);
			} else{
				System.out.println(number);
			}
			}
			//Fechando o arquivo
			arq.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		sc.close();
	}
}
