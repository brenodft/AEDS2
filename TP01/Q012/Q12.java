import java.util.*;
public class Q12{


    public static String cifCesar(String entrada, int pos){
        String aux = ""; // String auxiliar para receber os caracteres de entrada cifrados 
        if (pos<entrada.length()){
            if((int)entrada.charAt(pos) != 65533){ //Caso o caracter seja especial, manter
                aux+= (char)(entrada.charAt(pos) + 3)+cifCesar(entrada, ++pos);
            }else{
                aux+= (char)(entrada.charAt(pos))+cifCesar(entrada, ++pos);
            }
        }
        return aux; // Retorno da string auxiliar somada com os caracteres

    }

    public static boolean endLine(String entrada){
        if (entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M'){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        while(endLine(entrada)){
            System.out.println(cifCesar(entrada,0));
            entrada = sc.nextLine();
        }
        sc.close();
    }
}