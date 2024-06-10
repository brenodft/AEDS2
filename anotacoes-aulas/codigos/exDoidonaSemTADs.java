class Celula{
    int elemento;
    Celula prox;
    public Celula(){
        this(0);
    }
    public Celula(int x){
        this.elemento = x;
        this.prox = null;
    }
    void inserir(Celula i, int x){
        Celula aux = i;
        if(i.elemento == 0){
            i.elemento = x;
        } else{
            while(aux.prox != null){
                aux = aux.prox;
            }
            Celula inserir = new Celula(x);
            aux.prox = inserir;
        }

    }
    void mostrar(Celula i){
        Celula aux = i;
        while(aux != null){
            System.out.print(aux.elemento+" ");
            aux = aux.prox;
        }
    }
}

class No{
    No esq;
    No dir;
    int elemento;
    public No(){
        this(0);
    }
    public No(int x){
        this.elemento = x;
        this.esq = null;
        this.dir = null;
    }

    No inserir(No i,int x){
        if(i == null){
            System.out.println("VALOR DE X: "+x);
            i = new No(x);
        }else if(i.elemento == 0){
            i.elemento = x;
        }
        else if(x > i.elemento){
            System.out.println("IDIR: "+x);
            i.dir=inserir(i.dir,x);
        } else if(x<i.elemento){
            System.out.println("IDIR: "+x);
            i.esq=inserir(i.esq,x);
        }else{
            System.out.println("Esse elemento já foi adicionado!");
        }
        return i;
    }

    void mostrar(No i){
        if(i != null){
            mostrar(i.esq);
            if(i.elemento != 0){
                System.out.print(i.elemento+" ");
            }
            mostrar(i.dir);
        }
        System.out.println();
    }
}

class Doidona{
    int [] t1;
    int [] t3;
    No no1;
    Celula cel;
    No no2;
    public Doidona(){
        t1 = new int[100];
        t3 = new int[100];
        for(int i = 0; i<100; i++){
            t1[i] = -1;
            t3[i] = -1;
        }
        no1 = new No();
        no2 = new No();
        cel = new Celula();
    }
    int hashT1(int elemento){
        return elemento%100;
    }
    int hashT2(int elemento){
        return elemento%3;
    }
    int hashT3(int elemento){
        return elemento%100;
    }

    void inserir(int x){
        if(t1[hashT1(x)] == -1){
            t1[hashT1(x)] = x;
        } else if(hashT2(x) == 0){
            if(t3[hashT3(x)] == -1){
                t3[hashT3(x)] = x;
            } else{
                no1.inserir(no1,x);
            }
        } else if(hashT2(x) == 1){
            cel.inserir(cel, x);
        } else if(hashT2(x) == 2){
            no2= no2.inserir(no2,x);
        } else{
            System.out.println("Erro!");
        }
    }

    void mostrar(){
        System.out.println("\n\nT1");
        for(int i = 0;i<100; i++){
            if(t1[i] != -1){
                System.out.println(i+" - "+t1[i]);
            }
        }
        System.out.println("\n\nT3");
        for(int j = 0; j<100; j++){
            if(t3[j] != -1){
                System.out.println(j+" - "+t3[j]);
            }
        }
        System.out.println("Arvore do T3: ");
        no1.mostrar(no1);;
        System.out.println("Lista: ");
        cel.mostrar(cel);;
        System.out.println("\n\nUltima arvore: ");
        no2.mostrar(no2);;
    }
}

public class exDoidonaSemTADs {
    public static void main(String[] args) {
        Doidona tabela = new Doidona();
        int[] numeros = {105, 205, 305, 110, 210, 310, 115, 215, 315, 120};
        for(int i: numeros){
            tabela.inserir(i);
        }
        tabela.mostrar();
    }
}
