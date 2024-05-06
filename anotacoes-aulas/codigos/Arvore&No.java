class No{
    int elemento;
    No esq;
    No dir;
    No(int x){
        this.elemento = x;
        this.esq = null;
        this.dir = null;
    }
    No(int x, No esq, No dir){
        this.elemento = x;
        this.esq = esq;
        this.dir = dir;
    }

}


class Arvore{
    No raiz;
    Arvore() {raiz = null;}
    void inserir(int x) throws Exception{
        raiz = inserir(x,raiz);
    }
    No inserir(int x, No i) throws Exception{
        if(i == null){
            i = new No(x);
        } else if(x < i.elemento){
            i.esq = inserir(x,i.esq);
        } else if(x > i.elemento){
            i.dir = inserir(x,i.dir);
        } else{
            throw new Exception("Erro!");
        }
        return i;
    }
    boolean pesquisa(int x, No i){
        boolean resp = false;
        if(i == null){
            resp = false;;
        } else if(x > i.elemento){
            resp = pesquisa(x, i.dir);
        } else{
            resp = pesquisa(x, i.esq);
        }
        return resp;
    }
    void caminharCentral(No i){
        if(i != null){
            caminharCentral(i.esq);
            System.out.println(i.elemento + " ");
            caminharCentral(i.dir);
        }
    }
    void caminharPos(No i){
        if(i!= null){
            caminharPos(i.esq);
            caminharPos(i.dir);
            System.out.println(i.elemento + " ");
        }
    }
    void caminharPre(No i){
        if(i!= null){
            System.out.println(i.elemento + " ");
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }
    int getAltura(No i, int altura){
        if(i == null){
            altura--;
        }else{
            int alturaEsq = getAltura(i.esq, altura+1);
            int alturaDir = getAltura(i.dir, altura+1);
            altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
        }
        return altura;
    }
    int soma(No i, int soma){
        
        if(i!= null){
            soma = i.elemento + soma(i.esq, 0) + soma(i.dir,0);
        }
        return soma;
    }
    int numPares(No i){
        int qtd = 0;
        if (i!= null){
            int c = (i.elemento%2 ==0)? 1 : 0;
            qtd += c + numPares(i.esq) + numPares(i.dir);
        }
        return qtd;
    }
    boolean igual(Arvore a1, Arvore a2){
        return igual(a1.raiz, a2.raiz);
    }
    boolean igual(No i1, No i2){
        boolean resp;
        if(i1 != null && i2 != null){
            resp = (i1.elemento == i2.elemento) && igual(i1.esq , i2.esq) && igual(i1.dir , i2.dir);
        } else if(i1 == null && i2 == null){
            resp = true;
        } else{
            resp = false;
        }
        return resp;
    }
    boolean div11(No i){
        boolean resp = false;
        if(i != null){
            resp = ((i.elemento % 11==0) ? true:false) || div11(i.esq) || div11(i.dir) ;
        }
        return resp;
    }
    
}