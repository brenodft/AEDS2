#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool palindromo(char entrada[], int esquerda, int direita){
	while(entrada[esquerda] == -61 || entrada[esquerda] == -17 || entrada[esquerda] == -65){
		esquerda++;
	}
	/*
	Explicando o bloco acima
	Ao debugar percebi que quando temos caracteres especiais sempre temos primeiro um -61 e um numero negativo,
	sendo assim pensei que o -61 é prefixo de todo caracter especial entao nao fazia sentido comparar ele
	entao coloquei que se o codigo for -61, desconsiderar e comparar o da frente que realmente é o que diferencia.
	*/
	if(esquerda >= direita){
		return true;
	}
	if(entrada[esquerda] != entrada[direita]){
		return false;
	}
	return palindromo(entrada, esquerda + 1, direita - 1);
}


int main() {
    while (true) {
        char entrada[1000];
        fgets(entrada, sizeof(entrada), stdin);
        // Remover quebra de linha, se presente
        entrada[strcspn(entrada, "\n")] = '\0';

        if (strcmp(entrada, "FIM") == 0) {
            return 0;
        }
        int tamanho = strlen(entrada);
        bool resultado = palindromo(entrada, 0, tamanho - 1);
        if (resultado) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }
    return 0;
}
