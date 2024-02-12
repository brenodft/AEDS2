import java.util.*;
public class ex2{
// se a letra for maiuscula retorna 1+ prox letra
//Funçao que checa caracter por caracter verificando se ele é maiusculo, retorna o numero de maiusculos
    public static int upper(String arg1, int tam, int pos){
        if (pos < arg1.length()){
            if (arg1.charAt(pos) >= 'A' && arg1.charAt(pos) <= 'Z' ){
                return 1 + upper(arg1,tam, ++pos);
            }else{
                return upper(arg1,tam,++pos);
            }
        } else{
            return 0;
        }

    }
//Funçao para checar a string digitada, se houver a palavra FIM, retornará "false" quebrando o laço de repetiçao
    public static boolean endLine (String arg1){
        if (arg1.equals("FIM")){
        return false;
        }else{
        return true;
        }
    }
    public static void main(String [] args){
// Inicializando Scanner
        Scanner sc = new Scanner(System.in);
// Criando variavel de vetor de Strings
        String[] inputString = new String[500];
// Inicializando contador
        int count = 0;
        do{
            //Atribuir uma string para a posição count
            inputString[count] = sc.nextLine();
        }while(endLine(inputString[count++]));
//Desconsiderando o FIM
        count --;
//Declarando vetor de numeros inteiros
        int[] vetInt = new int[count];
//Atribuindo o inteiro correspondente ao numero de maiusculas na string para cada posiçao do vetor de inteiros
        for(int i = 0; i< count; i++){
            vetInt[i] = upper(inputString[i], count, 0);
        }

//Saida
        for(int i = 0; i<count; i++){
            System.out.println(vetInt[i]);
        }
    }
}
