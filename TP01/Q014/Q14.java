import java.util.Scanner;
public class Q14{
    public static String fix(String entrada){
        String aux = "";
        for(int i = 0; i<entrada.length(); i++){
            if(entrada.charAt(i) != ' '){
                aux += entrada.charAt(i); // criando uma copia da string original sem espaçamento
            }
        }
        int n = Character.getNumericValue(entrada.charAt(0)); // pega a primeira caracter como inteiro (ela indica o numero de elementos)
        char[] bits = new char[n]; //Array com o tamanho do numero de elementos pra abrigá-los

        for(int i = 1; i<=n; i++){
            bits[i-1] = aux.charAt(i); // alocando os elementos para o array
        }

        String logic = aux.substring(n+1, aux.length()); // substring para a logica booleana
        char[] logicArray = new char[logic.length()];//array de caracteres para a logica booleana
        for(int i = 0; i<logic.length();i++){
            logicArray[i] = logic.charAt(i);
        }
        
        for(int i = 0; i<n; i++){
            char c = (char) ('A' + i);
            for(int j = n+1; j< logicArray.length; j++){
                    if(logicArray[j] == c){
                        logicArray[j] = bits[i];
                    } //substituindo as letras por seus devidos numeros
            }
        }

        String fixedExpression = "";
        for (int i = 0; i<logicArray.length; i++){
            fixedExpression += logicArray[i];
        }
        fixedExpression = fixedExpression.replace("and","a").replace("or","o").replace("not","n"); // resumindo as operações para facilitar no if

        return fixedExpression;
        
    }

	public static String algebra(String entrada){
		char calc = entrada.charAt(0); // pegando o primeiro caracter da substring e fazendo a algebra booleana
		switch(calc){
			case 'a':														
				for(int i = 2; i < entrada.length(); i++){
					if(entrada.charAt(i) == '0'){					
						return "0";
					}
				}
				return "1";												
		
			case 'o':														
                for(int i = 2; i < entrada.length(); i++){
                    if(entrada.charAt(i) == '1'){
                         return "1";
                     }
                 }
				return "0";
		
			case 'n':														
				return entrada.charAt(2) == '0' ? "1" : "0";
			default:								         			
												       	 				  								
				return "";
		}
	}




	public static boolean check(String entrada){
		if(entrada.contains("(")){
			int indiceFechamento = entrada.indexOf(')');
			int indiceAbertura = entrada.lastIndexOf('(',indiceFechamento);	
			String subExpr = entrada.substring(indiceAbertura - 1, indiceFechamento + 1);		

			String resul = algebra(subExpr);
			entrada = entrada.substring(0,indiceAbertura-1) + resul + entrada.substring(indiceFechamento+1,entrada.length());		
            //eliminando parentereses para calculo de algebra
			return check(entrada); // chamada recursiva que ocorre enquanto os parenteses nao forem eliminados
		}
		else{
			return entrada.equals("1");
		}
		
	}


    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while(true){
        String entrada = sc.nextLine();
        if (entrada.equals("0")){
            break;
        }
        if(check(fix(entrada))){ //Se a expressão booleana for true imprime 1, caso contrario imprime 0
            System.out.println(1);
        } else{
            System.out.println(0 );
        }
        }
        sc.close();
    }
}