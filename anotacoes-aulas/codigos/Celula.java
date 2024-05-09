public class Celula{
    public int elemento;
    public Celula dir;
    public Celula esq;
    public Celula sup;
    public Celula inf;

    
    public Celula(){
        this.elemento = 0;
        this.dir = null;
        this.esq = null;
        this.sup = null;
        this.inf = null;
    }
    public Celula(int x){
        this.elemento = x;
        this.dir = null;
        this.esq = null;
        this.sup = null;
        this.inf = null;
    }
}