import java.util.Scanner;
public class desafio1{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] lista = new int[6];
        for(int i = 0; i <lista.length; i++){
            lista[i] = sc.nextInt();
        }
        // Ordenação por seleção
        for(int i = 0; i < lista.length - 1; i++){
            int menor = i;
            for(int j = i+1; j<lista.length; j++){
                if(lista[menor] > lista[j]){
                    menor = j;
                }
            }
            int aux = lista[i];
            lista[i] = lista[menor];
            lista[menor] = aux;
        }
        System.out.println("\n");
        for(int i = 0; i<lista.length; i++){
            System.out.println(lista[i]+ " ");
        }
        sc.close();
    }
}