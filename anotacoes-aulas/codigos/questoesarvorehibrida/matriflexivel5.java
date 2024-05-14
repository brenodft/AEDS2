class Celula{
    int elemento;
    Celula primeiro,ultimo,prox;

    Celula(){
        elemento = 0;
        primeiro= ultimo = new Celula();
        prox = null;
    }
    Celula(int x){
        elemento = x;
        primeiro= ultimo = new Celula();
        prox = null;
    }
    void inserirFinal(int x){
        Celula i = primeiro;
        for(;i.prox != null; i = i.prox);
        Celula tmp = new Celula(x);
        i.prox = tmp;
        ultimo = tmp;
        tmp = null;
    }
}

class CelulaMat{
    public Celula lista;
    public CelulaMat dir;
    public CelulaMat esq;
    public CelulaMat sup;
    public CelulaMat inf;

    
    public CelulaMat(){
        this.lista = new Celula();
        this.dir = null;
        this.esq = null;
        this.sup = null;
        this.inf = null;
    }
    public CelulaMat(int x){
        this.lista = new Celula(x);
        this.dir = null;
        this.esq = null;
        this.sup = null;
        this.inf = null;
    }
}

class MatrizFlexivel{
    private CelulaMat inicio;
    private int linha,coluna;
    public MatrizFlexivel(){
        this(3,3);
    }
    public MatrizFlexivel(int linhas, int colunas){
       inicio = new CelulaMat(0);
       this.linha = linhas;
       this.coluna = colunas;
       CelulaMat i = inicio;
       for(int j = 1; j< this.coluna; j++){
        CelulaMat nova = new CelulaMat(0);
        i.dir = nova;
        nova.esq = i;
        i = nova;
       }

       CelulaMat linhaAnterior = inicio;
       for(int k = 1; k<this.linha; k++){
        CelulaMat novaLinha = new CelulaMat(0);
        linhaAnterior.inf = novaLinha;
        novaLinha.sup = linhaAnterior;

        CelulaMat celulaAtualLinha = novaLinha;
        CelulaMat celulaAcima = linhaAnterior;
        for(int j = 1; j<this.coluna; j++){
            CelulaMat novaCelula = new CelulaMat(0);
            celulaAtualLinha.dir = novaCelula;
            novaCelula.esq = celulaAtualLinha;

            celulaAcima = celulaAcima.dir;
            celulaAcima.inf = novaCelula;
            novaCelula.sup = celulaAcima;

            celulaAtualLinha=novaCelula;
        }
        linhaAnterior = novaLinha;
       }
        
    }
    boolean pesquisar(int elemento){
        return pesquisar(inicio,elemento);
    }
    boolean pesquisar(CelulaMat celmat, int elemento){
        boolean resp = false;
        CelulaMat in = celmat.inf;
        CelulaMat i = celmat;
        while(in != null){
            for(;i != null; i = i.dir){
                if(percorrerPesquisar(celmat.lista, elemento)){
                    resp = true;
                }
            }
            i = in;
            in = in.inf;
        }
        return resp;
    }
    boolean percorrerPesquisar(Celula i,int elemento){
        boolean resp = false;
        for(;i!= null; i=i.prox){
            if(i.elemento == elemento){
                resp = true;
            }
        }
        return resp;
    }
    void percorrerPrintar(Celula i){
        for(;i!= null; i=i.prox){
            System.out.print(i.elemento+ " ");
        }
    }
    boolean pesquisar(int i, int j, int elemento){
        return pesquisar(inicio,i,j,elemento);
    }
    boolean pesquisar(CelulaMat cel,int i, int j, int elemento){
        CelulaMat aux = cel;
        for(int a = 0; a<i; a++){
            aux = aux.dir;
        }
        for(int b = 0; b<j; b++){
            aux = aux.inf;
        }
        return percorrerPesquisar(aux.lista, elemento);
    }
    void inserir(int i, int j, int elemento){
        inserir(inicio,i,j,elemento);
    }
    void inserir(CelulaMat cel, int i, int j, int elemento){
        CelulaMat aux = cel;
        for(int a = 0; a<i; a++){
            aux = aux.dir;
        }
        for(int b = 0; b<j; b++){
            aux = aux.inf;
        }
        aux.lista.inserirFinal(elemento);
    }
    void mostrar(){
        CelulaMat aux = inicio;
        CelulaMat auxinf = aux.inf;
        while(aux != null){
            for(;aux != null; aux = aux.dir){
                percorrerPrintar(aux.lista);
            }
            aux = auxinf;
            auxinf = auxinf.inf;
        }
    }
}
