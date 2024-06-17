class doidona {
    void add(int x){
        if(t1[hashT1(x)].elemento == null){
            t1[hashT1(x)].elemento = x;
        }else if(t1[hashT1(x)].t2.tab[hashT2(x)].elemento == null){
            t1[hashT1(x)].t2.tab[hashT2(x)].elemento = x; 
        }else if(t1[hashT1(x)].t2.tab[rehashT2(x)].elemento == null){
            t1[hashT1(x)].t2.tab[rehashT2(x)].elemento = x;
        }else if(t1[hashT1(x)].t2.tab[hashT3(x)] == 0){
            if(t1[hashT1(x)].t2.primeiroT3 == t1[hashT1(x)].t2.ultimoT3){
                Celula aux = new Celula(x);
                t1[hashT1(x)].t2.ultimoT3 = aux;
                t1[hashT1(x)].t2.primeiroT3.prox = aux;
            } else{
                Celula aux = new Celula(x);
                t1[hashT1(x)].t2.ultimoT3.prox = aux;
                t1[hashT1(x)].t2.ultimoT3 = t1[hashT1(x)].t2.ultimoT3.prox;
            }
        } else{
            addArvore(t1[hashT1(x)].t2.ultimoT3 = t1[hashT1(x)].t2.raizT3,x);
        }
    }
    void addArvore(No i,int x){
        if(i == null){
            i = new No(x);
        }else{
            if(x < i.elemento){
                addArvore(i.esq,x);
            }else{
                addArvore(i.dir,x);
            }
        } 
    }
    boolean pesquisararvore(No i, int x){
        boolean resp = false;
        if(x<i.elemento){
            resp = pesquisararvore(i.esq, x);
        }else if(x > i.elemento){
            resp = pesquisararvore(i.dir, x);
        } else{
            resp = true;
        }
        return resp;
    }
    boolean pesquisar(int x){
        boolean resp = false;
        if(t1[hashT1(x)].elemento == x){
            resp = true;
        }else if(t1[hashT1(x)].t2.tab[hashT2(x)].elemento == x){
            resp = true;
        }else if(t1[hashT1(x)].t2.tab[rehashT2(x)].elemento == x){
            resp = true;
        }else if(t1[hashT1(x)].t2.tab[hashT3(x)] == 0){
            Celula aux = t1[hashT1(x)].t2.primeiroT3;
            while(aux != null){
                if(aux.elemento == x){
                    resp = true;
                }
                aux = aux.prox;
            }
        } else{
            resp = pesquisararvore(t1[hashT1(x)].t2.raizT3, x);

        }
        return resp;
    }
    
}
