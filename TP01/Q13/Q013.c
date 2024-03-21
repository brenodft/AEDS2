#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <ctype.h>

// Função que gera um caractere aleatório entre 'a' e 'z'
char gerador() {
    return (char)('a' + (rand() % 26));
}

// Função que verifica se a entrada é "FIM"
int endLine(const char entrada[]) {
    return (entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M' && entrada[3] == '\0');
}

// Função recursiva que substitui todas as ocorrências de sorted1 por sorted2
void sort(char entrada[], char sorted1, char sorted2, int index) {
    if (entrada[index] == '\0') {
        return; // Retorna se atingir o final da string
    }
    if (isalpha(entrada[index])) { // Ignora caracteres especiais
        if (entrada[index] == sorted1) {
            entrada[index] = sorted2; // Substitui o caractere se for igual a sorted1
        }
    }
    // Chama recursivamente a função para o próximo caractere na entrada
    sort(entrada, sorted1, sorted2, index + 1);
}

int main() {
    //colocar seed como 4
    srand(4);
    char entrada[1000];
    while (1) {

        fgets(entrada, 1000, stdin); // Lê a entrada
        entrada[strcspn(entrada, "\n")] = '\0'; // Remove o caractere de nova linha
        char sorted1 = gerador();
        char sorted2 = gerador();
        if (endLine(entrada)) {
            break;
        }

        sort(entrada, sorted1, sorted2, 0); // Chama a função para substituir caracteres
        printf("%s\n", entrada);
    }

    return 0;
}
