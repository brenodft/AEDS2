boolean pesquisar(String nome){
    return pesquisar(raiz,nome);
}
boolean pesquisar(No i, String nome){
    boolean resp = false;
    if(i != null){
        if(nome.charAt(0) == i.letra){
            resp = true;
            pesquisaInterna(i.raizSec, nome);
        } else if(nome.charAt(0) > i.letra){
            resp = pesquisar(i.dir,nome);
        } else{
            resp = pesquisar(i.esq,nome);
        }
    }
    return resp;
}

boolean pesquisaInterna(No i, String nome){
    boolean resp = false;
    if(i != null){
        if(nome.compareTo(i.nome) == 0){
            resp = true;
        } else if(nome.compareTo(i.nome)>0){
            resp = pesquisaInterna(i.dir, nome);
        }else{
            resp = pesquisaInterna(i.esq, nome);
        }
    }
    return resp;
}

void inserir(String nome){
    inserir(raiz,nome);
}

void inserir(No i, String nome){
    if(nome.charAt(0) == i.letra){
        inserirArvoreInterna(i, nome);
    } else if(nome.compareTo(i.letra) > 0){
        inserir(i.dir, nome);
    } else{
        inserir(i.esq,nome);
    }
}

No inserirArvoreInterna(No i, String nome){
    if(i == null){
        inserirNo(nome);
    }else if(nome.compareTo(i.nome) > 0){
        inserirArvoreInterna(i.dir, nome);
    }else{
        inserirArvoreInterna(i.esq, nome);
    }
    return i;
}

void mostrar(){
    caminhar(raiz);
}

void caminhar(No i){
    if(i != null){
        caminhar(i.esq);
        System.out.println("LETRA: "+i.letra);
        caminharInterna(i.raizSec);
        caminhar(i.dir);
    }
}

void caminharInterna(No i){
    if(i != null){
        caminharInterna(i.esq);
        System.out.print(i.nome + " ");
        caminharInterna(i.dir);
    }
}

boolean hasStringTam10(){
    boolean resp = hasStringTam10(raiz);
}

boolean hasStringTam10(No i){
    boolean resp = false;
    if(i!= null){
        hasStringTam10(i.esq);
        if(acessoInterno(i.raiz)){
            resp = true;
        }
        hasStringTam10(i.dir);
    }
    return resp;
}

boolean hasStringTam10(char c){
    boolean resp = hasStringTam10(c);
}

boolean hasStringTam10(No i, char c){
    boolean resp = false;
    if(i!= null){
        hasStringTam10(i.esq);
        if(i.nome.charAt(0) == c){
            if(acessoInterno(i.raiz)){
                resp = true;
            }
        }
        hasStringTam10(i.dir);
    }
    return resp;
}

boolean acessoInterno(No i){
    boolean resp = false;
    if(i != null){
        resp = (i.nome.length == 10) ? true:false || acessoInterno(i.esq) || acessoInterno(i.dir);
    }
    return resp; 
}