class Contato{
    String nome,telefone,email;
    int cpf;
    Contato(){
        nome = "template";
        telefone= "a";
        email = "a";
        cpf = 0;
    }
    Contato(String nomedig){
        nome = nomedig;
        telefone= "a";
        email = "a";
        cpf = 0;
    }
    Contato(Contato contato){
        nome = contato.nome;
        telefone = contato.telefone;
        email = contato.email;
        cpf = contato.cpf;
    }
}
class Celula{
    Contato contato;
    Celula prox;
    Celula(){
        this.contato = new Contato();
        this.prox = null;
    }
    Celula(Contato contato){
        this.contato = contato;
        this.prox = null;
    }
}
class No{
    char letra;
    No esq,dir;
    Celula primeiro,ultimo;
    No(char x){
        this.letra = x;
        this.esq = null;
        this.dir = null;
        this.primeiro = new Celula();
        this.ultimo = this.primeiro;
    }
    void mostrar(){
        for(Celula i = primeiro.prox;i != null;i = i.prox){
            System.out.print(i.contato.nome+ " ");
        }
    }
}

class Agenda{
    No raiz;

    int compararCaractere(char x1, char x2){
        if((int)x1 > (int)x2){
            return 1;
        } else if((int)x1<(int)x2){
            return -1;
        }else{
            return 0;
        }
    }
    void inserirNo(char x) throws Exception{
        raiz = inserirNo(x,raiz);
    }
    No inserirNo(char x, No i) throws Exception{
        if(i == null){
            i = new No(x);
        } else if(compararCaractere(x,i.letra) < 0){
            i.esq = inserirNo(x,i.esq);
        } else if(compararCaractere(x,i.letra) > 0){
            i.dir = inserirNo(x,i.dir);
        } else{
            throw new Exception("Erro!");
        }
        return i;
    }

    void construirArvore(char inicio, char fim) throws Exception{
        if (inicio>fim){
            return;
        }
        char meio = (char)((inicio+fim)/2);
        inserirNo(meio);
        construirArvore(inicio, (char)(meio-1));
        construirArvore((char)(meio+1),fim);
    }

    Agenda() throws Exception{
        construirArvore('A','Z');
    }
    void caminharCentral(No i){
        if(i != null){
            caminharCentral(i.esq);
            System.out.print(i.letra+ " ");
            i.mostrar();
            System.out.println();
            caminharCentral(i.dir);
        }
    }
    void inserir(Contato contato){
      raiz = inserir(contato,raiz);  
    }
    No inserir(Contato contato,No i){
        if(contato.nome.charAt(0) ==i.letra){
            if(i.primeiro == null){
                i.primeiro.prox = new Celula(contato);
                i.ultimo = i.primeiro.prox;
            }else{
                Celula tmp = i.primeiro.prox;
                i.primeiro.prox = new Celula(contato);
                i.primeiro.prox.prox = tmp;
            }
        } else if(compararCaractere(contato.nome.charAt(0),i.letra)>0){
            inserir(contato, i.dir);
        }else {
            inserir(contato, i.esq);
        }
        return i;
    }

    void pesquisar(String nome){
        System.out.println(pesquisar(raiz,nome));
    }
    boolean pesquisar(No i, String nome){
        boolean resp = false;
        if(i.letra == nome.charAt(0)){
            Celula p = i.primeiro;
            for(;p!= null; p = p.prox){
                if(p.contato.nome.compareTo(nome) == 0){
                    resp = true;
                }
            }
        } else if(compararCaractere(nome.charAt(0), i.letra) > 0){
            resp = pesquisar(i.dir, nome);
        }else{
            resp = pesquisar(i.esq, nome);
        }
        return resp;
    }

}

