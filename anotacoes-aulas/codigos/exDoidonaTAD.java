/**
 * Celula (pilha, lista e fila dinamica)
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Celula {
	public int elemento; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.


	/**
	 * Construtor da classe.
	 */
	public Celula() {
		this(0);
	}

	/**
	 * Construtor da classe.
	 * @param elemento int inserido na celula.
	 */
	public Celula(int elemento) {
      this.elemento = elemento;
      this.prox = null;
	}
}

/**
 * Lista dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class Lista {
	private Celula primeiro;
	private Celula ultimo;


	/**
	 * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
	 */
	public Lista() {
		primeiro = new Celula();
		ultimo = primeiro;
	}


	/**
	 * Insere um elemento na primeira posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void inserirInicio(int x) {
		Celula tmp = new Celula(x);
      tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {                 
			ultimo = tmp;
		}
      tmp = null;
	}


	/**
	 * Insere um elemento na ultima posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void inserirFim(int x) {
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
	}


	/**
	 * Remove um elemento da primeira posicao da lista.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public int removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

      Celula tmp = primeiro;
		primeiro = primeiro.prox;
		int resp = primeiro.elemento;
      tmp.prox = null;
      tmp = null;
		return resp;
	}


	/**
	 * Remove um elemento da ultima posicao da lista.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public int removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 

		// Caminhar ate a penultima celula:
      Celula i;
      for(i = primeiro; i.prox != ultimo; i = i.prox);

      int resp = ultimo.elemento; 
      ultimo = i; 
      i = ultimo.prox = null;
      
		return resp;
	}


	/**
    * Insere um elemento em uma posicao especifica considerando que o 
    * primeiro elemento valido esta na posicao 0.
    * @param x int elemento a ser inserido.
	 * @param pos int posicao da insercao.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
   public void inserir(int x, int pos) throws Exception {

      int tamanho = tamanho();

      if(pos < 0 || pos > tamanho){
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
      } else if (pos == 0){
         inserirInicio(x);
      } else if (pos == tamanho){
         inserirFim(x);
      } else {
		   // Caminhar ate a posicao anterior a insercao
         Celula i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         Celula tmp = new Celula(x);
         tmp.prox = i.prox;
         i.prox = tmp;
         tmp = i = null;
      }
   }


	/**
    * Remove um elemento de uma posicao especifica da lista
    * considerando que o primeiro elemento valido esta na posicao 0.
	 * @param posicao Meio da remocao.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
	public int remover(int pos) throws Exception {
      int resp;
      int tamanho = tamanho();

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");

      } else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
      } else if (pos == 0){
         resp = removerInicio();
      } else if (pos == tamanho - 1){
         resp = removerFim();
      } else {
		   // Caminhar ate a posicao anterior a insercao
         Celula i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         Celula tmp = i.prox;
         resp = tmp.elemento;
         i.prox = tmp.prox;
         tmp.prox = null;
         i = tmp = null;
      }

		return resp;
	}

	/**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar() {
		System.out.print("[ ");
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] ");
	}

	/**
	 * Procura um elemento e retorna se ele existe.
	 * @param x Elemento a pesquisar.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(int x) {
		boolean resp = false;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento == x){
            resp = true;
            i = ultimo;
         }
		}
		return resp;
	}

	/**
	 * Calcula e retorna o tamanho, em numero de elementos, da lista.
	 * @return resp int tamanho
	 */
   public int tamanho() {
      int tamanho = 0; 
      for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
      return tamanho;
   }
}

class No {
	public int elemento; // Conteudo do no.
	public No esq, dir; // Filhos da esq e dir.
	public int nivel; // Numero de niveis abaixo do no

	/**
	 * Construtor da classe
	 * @param elemento Conteudo do no.
	 */
	public No(int elemento) {
		this(elemento, null, null, 1);
	}

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq      No da esquerda.
	 * @param dir      No da direita.
	 */
	public No(int elemento, No esq, No dir, int nivel) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
		this.nivel = nivel;
	}

	/**
	 * Cálculo do número de níveis a partir de um vértice
	 */
	public void setNivel() {
		this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
	}

	/**
	 * Retorna o número de níveis a partir de um vértice
	 * @param no nó que se deseja o nível.
	 */
	public static int getNivel(No no) {
		return (no == null) ? 0 : no.nivel;
	}
}

/**
 * Arvore binaria de pesquisa
 * 
 * @author Max do Val Machado
 */
 class ArvoreBinaria {
	protected No raiz; // Raiz da arvore.

	/**
	 * Construtor da classe.
	 */
	public ArvoreBinaria() {
		raiz = null;
	}

	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * 
	 * @param x Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 *         <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(int x) {
		return pesquisar(x, raiz);
	}

	/**
	 * Metodo privado recursivo para pesquisar elemento.
	 * 
	 * @param x Elemento que sera procurado.
	 * @param i No em analise.
	 * @return <code>true</code> se o elemento existir,
	 *         <code>false</code> em caso contrario.
	 */
	private boolean pesquisar(int x, No i) {
		boolean resp;
		if (i == null) {
			resp = false;

		} else if (x == i.elemento) {
			resp = true;

		} else if (x < i.elemento) {
			resp = pesquisar(x, i.esq);

		} else {
			resp = pesquisar(x, i.dir);
		}
		return resp;
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharCentral() {
		System.out.print("[ ");
		caminharCentral(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * 
	 * @param i No em analise.
	 */
	private void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esq); // Elementos da esquerda.
			System.out.print(i.elemento + " "); // Conteudo do no.
			caminharCentral(i.dir); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharPre() {
		System.out.print("[ ");
		caminharPre(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * 
	 * @param i No em analise.
	 */
	private void caminharPre(No i) {
		if (i != null) {
			System.out.print(i.elemento + " "); // Conteudo do no.
			caminharPre(i.esq); // Elementos da esquerda.
			caminharPre(i.dir); // Elementos da direita.
		}
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void caminharPos() {
		System.out.print("[ ");
		caminharPos(raiz);
		System.out.println("]");
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * 
	 * @param i No em analise.
	 */
	private void caminharPos(No i) {
		if (i != null) {
			caminharPos(i.esq); // Elementos da esquerda.
			caminharPos(i.dir); // Elementos da direita.
			System.out.print(i.elemento + " "); // Conteudo do no.
		}
	}

	/**
	 * Metodo publico iterativo para inserir elemento.
	 * 
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserir(int x) throws Exception {
		raiz = inserir(x, raiz);
	}

	/**
	 * Metodo privado recursivo para inserir elemento.
	 * 
	 * @param x Elemento a ser inserido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se o elemento existir.
	 */
	protected No inserir(int x, No i) throws Exception {
		if (i == null) {
			i = new No(x);
		} else if (x < i.elemento) {
			i.esq = inserir(x, i.esq);
		} else if (x > i.elemento) {
			i.dir = inserir(x, i.dir);
		} else {
			throw new Exception("Erro ao inserir!");
		}
		return i;
	}

	/**
	 * Metodo publico para inserir elemento.
	 * 
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
	public void inserirPai(int x) throws Exception {
		if (raiz == null) {
			raiz = new No(x);
		} else if (x < raiz.elemento) {
			inserirPai(x, raiz.esq, raiz);
		} else if (x > raiz.elemento) {
			inserirPai(x, raiz.dir, raiz);
		} else {
			throw new Exception("Erro ao inserirPai!");
		}
	}

	/**
	 * Metodo privado recursivo para inserirPai elemento.
	 * 
	 * @param x   Elemento a ser inserido.
	 * @param i   No em analise.
	 * @param pai No superior ao em analise.
	 * @throws Exception Se o elemento existir.
	 */
	private void inserirPai(int x, No i, No pai) throws Exception {
		if (i == null) {
			if (x < pai.elemento) {
				pai.esq = new No(x);
			} else {
				pai.dir = new No(x);
			}
		} else if (x < i.elemento) {
			inserirPai(x, i.esq, i);
		} else if (x > i.elemento) {
			inserirPai(x, i.dir, i);
		} else {
			throw new Exception("Erro ao inserirPai!");
		}
	}

	/**
	 * Metodo publico iterativo para remover elemento.
	 * 
	 * @param x Elemento a ser removido.
	 * @throws Exception Se nao encontrar elemento.
	 */
	public void remover(int x) throws Exception {
		raiz = remover(x, raiz);
	}

	/**
	 * Metodo privado recursivo para remover elemento.
	 * 
	 * @param x Elemento a ser removido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se nao encontrar elemento.
	 */
	protected No remover(int x, No i) throws Exception {
		if (i == null) {
			throw new Exception("Erro ao remover!");
		} else if (x < i.elemento) {
			i.esq = remover(x, i.esq);
		} else if (x > i.elemento) {
			i.dir = remover(x, i.dir);
			// Sem no a direita.
		} else if (i.dir == null) {
			i = i.esq;
			// Sem no a esquerda.
		} else if (i.esq == null) {
			i = i.dir;
			// No a esquerda e no a direita.
		} else {
			i.esq = maiorEsq(i, i.esq);
		}
		return i;
	}

	/**
	 * Metodo para trocar o elemento "removido" pelo maior da esquerda.
	 * 
	 * @param i No que teve o elemento removido.
	 * @param j No da subarvore esquerda.
	 * @return No em analise, alterado ou nao.
	 */
	protected No maiorEsq(No i, No j) {
		// Encontrou o maximo da subarvore esquerda.
		if (j.dir == null) {
			i.elemento = j.elemento; // Substitui i por j.
			j = j.esq; // Substitui j por j.ESQ.

			// Existe no a direita.
		} else {
			// Caminha para direita.
			j.dir = maiorEsq(i, j.dir);
		}
		return j;
	}

	/**
	 * Metodo que retorna o maior elemento da árvore
	 * 
	 * @return int maior elemento da árvore
	 */
	public int getMaior() {
		int resp = -1;

		if (raiz != null) {
			No i;
			for (i = raiz; i.dir != null; i = i.dir)
				;
			resp = i.elemento;
		}

		return resp;
	}

	/**
	 * Metodo que retorna o menor elemento da árvore
	 * 
	 * @return int menor elemento da árvore
	 */
	public int getMenor() {
		int resp = -1;

		if (raiz != null) {
			No i;
			for (i = raiz; i.esq != null; i = i.esq)
				;
			resp = i.elemento;
		}

		return resp;
	}

	/**
	 * Metodo que retorna a altura da árvore
	 * @return int altura da árvore
	 */
	public int getAltura() {
		return getAltura(raiz, 0);
	}

	/**
	 * Metodo que retorna a altura da árvore
	 * @return int altura da árvore
	 */
	public int getAltura(No i, int altura) {
		if (i == null) {
			altura--;
		} else {
			int alturaEsq = getAltura(i.esq, altura + 1);
			int alturaDir = getAltura(i.dir, altura + 1);
			altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
		}
		return altura;
	}

	/**
	 * Metodo publico iterativo para remover elemento.
	 * 
	 * @param x Elemento a ser removido.
	 * @throws Exception Se nao encontrar elemento.
	 */
	public void remover2(int x) throws Exception {
		if (raiz == null) {
			throw new Exception("Erro ao remover2!");
		} else if (x < raiz.elemento) {
			remover2(x, raiz.esq, raiz);
		} else if (x > raiz.elemento) {
			remover2(x, raiz.dir, raiz);
		} else if (raiz.dir == null) {
			raiz = raiz.esq;
		} else if (raiz.esq == null) {
			raiz = raiz.dir;
		} else {
			raiz.esq = maiorEsq(raiz, raiz.esq);
		}
	}

	/**
	 * Metodo privado recursivo para remover elemento.
	 * 
	 * @param x   Elemento a ser removido.
	 * @param i   No em analise.
	 * @param pai do No em analise.
	 * @throws Exception Se nao encontrar elemento.
	 */
	private void remover2(int x, No i, No pai) throws Exception {
		if (i == null) {
			throw new Exception("Erro ao remover2!");
		} else if (x < i.elemento) {
			remover2(x, i.esq, i);
		} else if (x > i.elemento) {
			remover2(x, i.dir, i);
		} else if (i.dir == null) {
			pai = i.esq;
		} else if (i.esq == null) {
			pai = i.dir;
		} else {
			i.esq = maiorEsq(i, i.esq);
		}
	}

	public int getRaiz() throws Exception {
		return raiz.elemento;
	}

	public static boolean igual(ArvoreBinaria a1, ArvoreBinaria a2) {
		return igual(a1.raiz, a2.raiz);
	}

	private static boolean igual(No i1, No i2) {
		boolean resp;
		if (i1 != null && i2 != null) {
			resp = (i1.elemento == i2.elemento) && igual(i1.esq, i2.esq) && igual(i1.dir, i2.dir);
		} else if (i1 == null && i2 == null) {
			resp = true;
		} else {
			resp = false;
		}
		return resp;
	}

	public int soma() {
		return soma(raiz);
	}

	public int soma(No i) {
		int resp = 0;
		if (i != null) {
			resp = i.elemento + soma(i.esq) + soma(i.dir);
		}
		return resp;
	}

	public int quantidadePares() {
		return quantidadePares(raiz);
	}

	public int quantidadePares(No i) {
		int resp = 0;
		if (i != null) {
			resp = ((i.elemento % 2 == 0) ? 1 : 0) + quantidadePares(i.esq) + quantidadePares(i.dir);
		}
		return resp;
	}

	public boolean hasDiv11() {
		return hasDiv11(raiz);
	}

	public boolean hasDiv11(No i) {
		boolean resp = false;
		if (i != null) {
			resp = (i.elemento % 11 == 0) || hasDiv11(i.esq) || hasDiv11(i.dir);
		}
		return resp;
	}
}
class Doidona{
    int t1[];
    int t3[];

    ArvoreBinaria arvore1;
    ArvoreBinaria arvore2;

    Lista lista;
    public Doidona(){
        t1 = new int[100];
        t3 = new int[100];
        for(int i = 0; i<100; i++){
            t1[i] = -1;
            t3[i]= -1;
        }
        arvore1 = new ArvoreBinaria();
        arvore2 = new ArvoreBinaria();
        lista = new Lista();
    }
    int hashT1(int elemento){
        return elemento%100;
    }
    int hashT3(int elemento){
        return elemento%100;
    }
    int hashT2(int elemento){
        return elemento%3;
    }
	public int reh(int elemento) {
		return ++elemento % 100;
	 }
  
    void inserir(int elemento) throws Exception{
        if(t1[hashT1(elemento)] == -1){
            System.out.println("Sem conflito na T1!");
            t1[hashT1(elemento)] = elemento;
        } else if(hashT2(elemento) == 0){
            System.out.println("Conflito na T1!");
            if(t3[hashT3(elemento)] == -1){
                System.out.println("Sem conflito na T3!");
                t3[hashT3(elemento)] = elemento;
            } else{
				System.out.println("Rehash!");
				if(t3[reh(elemento)] == -1){
					t3[reh(elemento)]=elemento;
				}else{
					System.out.println("Falha no rehash, partindo para a arvore!");
					arvore1.inserir(elemento);
				}

            }
        } else if(hashT2(elemento) == 1){
            System.out.println("Conflito na T1! Partindo para a Lista");
            lista.inserirFim(elemento);
        } else if(hashT2(elemento) == 2){
            System.out.println("Conflito na T1! Partindo para a Arvore2");
            arvore2.inserir(elemento);
        } else{
            System.out.println("ERRO!!!!");
        }
    }
    boolean pesquisar(int elemento){
        boolean resp = false;
        if(t1[hashT1(elemento)] == elemento){
            resp = true;
        } else if(hashT2(elemento) == 0){
            if(t3[hashT3(elemento)] == elemento){
                resp = true;
            } else{
                resp = arvore1.pesquisar(elemento);
            }
        } else if(hashT2(elemento) == 1){
            resp = lista.pesquisar(elemento);
        } else if(hashT2(elemento) == 2){
            resp = arvore2.pesquisar(elemento);
        } else{
            System.out.println("Não encontrado!");
        }
        return resp;
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
        arvore1.caminharCentral();
        System.out.println("Lista: ");
        lista.mostrar();
        System.out.println("\n\nUltima arvore: ");
        arvore2.caminharCentral();
    }
}

public class exDoidonaTAD {
    public static void main(String[] args) throws Exception{
        Doidona tabela = new Doidona();
        int[] numeros = {105, 205, 305, 110, 210, 310, 115, 215, 315, 120};
        for(int i:numeros){
            System.out.println("\n\nInserindo: "+i);
            tabela.inserir(i);
            System.out.println("\n\nEstrutura da doidona: ");
            tabela.mostrar();
            System.out.println("\n");
        }
    }
}
