class Celula{
    int elemento;
    Celula primeiro,prox;

    Celula(){
        elemento = 0;
        primeiro = new Celula();
        prox = null;
    }
    Celula(int x){
        elemento = x;
        primeiro = new Celula();
        prox = null;
    }
}

class CelulaMat{
    public Celula elemento;
    public CelulaMat dir;
    public CelulaMat esq;
    public CelulaMat sup;
    public CelulaMat inf;

    
    public CelulaMat(){
        this.elemento = new Celula();
        this.dir = null;
        this.esq = null;
        this.sup = null;
        this.inf = null;
    }
    public CelulaMat(int x){
        this.elemento = new Celula(x);
        this.dir = null;
        this.esq = null;
        this.sup = null;
        this.inf = null;
    }
}

class MatrizFlexivel{
    private CelulaMat inicio;
    Celula lista;
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
        resp = pesquisar(inicio,elemento);;
    }
    boolean pesquisar(Celulamat celmat, int elemento){
        while(celmat != null){
            celmat.lista.p
        }
    }
}
