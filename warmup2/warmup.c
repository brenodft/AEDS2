#include <stdio.h>
#include <stdlib.h>

typedef struct estudante{
    char nome[500];
    char direcao;
    int distancia;
}estudante;

estudante* sort(estudante* estudantes, int qtd){
    estudante* aux = estudantes;
    for(int i = 0;i<(qtd-1);i++){
        int menor = i;
        for(int j = (i+1); j< qtd; j++){
            if(aux[menor].distancia > aux[j].distancia || 
            (aux[menor].distancia == aux[j].distancia) && (aux[menor].direcao > aux[j].direcao)){
                menor = j;
            }
        }
        estudante aux2 = aux[i];
        aux[i] = aux[menor];
        aux[menor] = aux2;
    }
    return aux;
}

int main(){
    estudante e1;
    int qtd;
    scanf("%d",&qtd);
    estudante* estudantes= (estudante*)malloc(qtd*sizeof(estudante));
    for(int i = 0; i<qtd; i++){
        scanf("%s %c %d",&e1.nome,&e1.direcao,&e1.distancia);
        estudantes[i] = e1;
    }
    estudantes = sort(estudantes, qtd);
    for(int i = 0; i<qtd; i++){
        printf("%s \n",estudantes[i].nome);
    }
}