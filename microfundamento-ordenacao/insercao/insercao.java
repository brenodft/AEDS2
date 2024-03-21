public class insercao{
    public static void main(String[] args){
        int[] lista = {2,3,6,1};
        for (int i : lista) {
            System.out.print(i +" ");
        }
        System.out.println("\n");
        for(int i = 1; i<lista.length; i++){
            int tmp = lista[i];
            int j = i-1;
            while((j>=0) && (lista[j] > tmp)){
                lista[j+1] = lista[j];
                j--;
            }
            lista[j+1] = tmp;
        }
        for(int i : lista){
            System.out.print(i+ " ");
        }
    }
}