import java.util.Scanner;

class Celula{
    int entrada;
    int saida;
    Celula prox;

    public Celula(int entrada,int saida){
        this.entrada = entrada;
        this.saida = saida;
        this.prox = null;
    }
}

class Lista{
    Celula primeira;
    Celula ultima;

    public Lista(){
        this.primeira = new Celula(0, 0);
        this.ultima = this.primeira;
    }
    void add(int e1, int e2){
        if(this.primeira == null){
            this.primeira.prox = new Celula(e1,e2);
            this.ultima = this.primeira.prox;
        }else{
            Celula aux = this.primeira;
            for(;aux.prox!=null; aux = aux.prox){}
            aux.prox = new Celula(e1,e2);
            this.ultima = aux.prox;
        }
    }
    int remove(){
        Celula aux = this.primeira;
        for(;aux.prox!=this.ultima; aux = aux.prox){}
        int remove = aux.prox.entrada;
        aux.prox = null;
        return remove;
    }
    void mostrar(){
        Celula aux = this.primeira.prox;
        while(aux != null){
            System.out.println(aux.entrada +" "+aux.saida);
            aux = aux.prox;
        }
    }
    void check(){
        if(this.primeira.prox.saida < this.ultima.saida){
            System.out.println("Nao");
        }else{
            System.out.println("Sim");
        }
    }
}

public class q01{
    public static void main(String[] args) {
        int entrada; int saida; int i1; int i2;
        Scanner sc = new Scanner(System.in);
        do{
            Lista carros = new Lista();
            i1 = sc.nextInt();
            i2 = sc.nextInt();
            if(i1 == 0 && i2 == 0){
                break;
            }
            for(int i = 0; i<i1; i++){
                entrada = sc.nextInt();
                saida = sc.nextInt();
                carros.add(entrada, saida);
            }
            carros.check();
        } while(i1 != 0 && i2 != 0);
        sc.close();
    }
}