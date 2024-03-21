import java.util.Scanner;
public class resumo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int escolha;
        do{
            int[] array = new int[]{9,8,7,6,5,4,3,2,1};
            for(int p = 0; p<array.length; p++){
                System.out.print(array[p]+ " ");
            }
            System.out.println(" ");
            System.out.println("Escolha um metodo de ordenacao: \n1 - Selecao\n2 - Insercao\n3 - Bolha\n0 - Sair");
            escolha = sc.nextInt();
            switch(escolha){
                case 1: selecao(array); break;
                case 2: insercao(array); break;
                case 3: bubble(array); break;
                case 0: break;
            }
        } while(escolha != 0);
        sc.close();
    }

    public static void selecao(int[] array){
        int n = array.length;
        int count = 0;
        for(int i = 0; i<n-1; i++){
            int menor = i; // SELECIONA o indice i e SUPOE que ele é o menor
            for(int j = i+1; j<n; j++){
                if(array[menor] > array[j]){ //ele COMPARA o elemento do indice i com os demais elementos e ve se tem alguem menor q ele
                    menor = j; // no caso de ter, a variavel menor é o indice desse elemento
                    count++;
                }
            }
            int tmp = array[menor]; // Entao trocamos o indice i pelo menor elemento
            array[menor] = array[i];
            array[i] = tmp;
        }
        for(int p = 0; p < n; p++){
            System.out.print(array[p] + " ");
        }
        System.out.println(count);
        System.out.println(" ");
    }

    public static void insercao(int[] array){
        int n = array.length;
        for(int i = 1; i<n; i++){
            int tmp = array[i]; // Criamos uma variavel temporaria com o valor apontado pelo indice i
            int j = i-1; // Declaramos o j como um indice antes do i
            while(j>= 0 && array[j] > tmp){ // Se o elemento apontado por j for maior que a variavel temporaria
                array[j+1] = array[j]; // O indice situado na variavel temporaria recebe o valor do elemento apontado por j
                j--; // E j decrementa 1
            }
            array[j+1] = tmp; // O elemento j+1 recebe o valor de tmp
        }
        for(int p = 0; p<n; p++){
            System.out.print(array[p] + " ");
        }
        System.out.println(" ");
    }

    public static void bubble(int[] array){
        int n = array.length;
        for(int i = 0; i<n-1; i++){ // Apenas para repetir n-1 vezes
            for(int b=0; b< n- (i+1); b++){ 
                if(array[b] > array[b+1]){ // a bolha sempre vai pegar o maior e jogar ele pra ultima posicao do laço
                    int temp = array[b];
                    array[b] = array[b+1];
                    array[b+1] = temp;
                }
            }
        }
        for(int p = 0; p<n;p++){
            System.out.print(array[p] + " ");
        }
        System.out.println(" ");
    }
    

}