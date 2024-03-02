#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string.h>

void formatdouble(double value) {
    char buffer[64]; // Buffer para a conversão de double para string
    sprintf(buffer, "%f", value); // Converte o double para string 
    
    // Remove os zeros à direita e o ponto decimal, se necessário
    char *dot = strchr(buffer, '.'); // Encontra o ponto decimal na string
    if (dot != NULL) { // Se encontrou o ponto decimal
        char *end = buffer + strlen(buffer) - 1; // Último caractere válido antes do terminador nulo
        while (end > dot && *end == '0') { // Remove zeros à direita
            *end = '\0';
            end--;
        }
        if (end == dot) { // Se só restou o ponto decimal, remove também
            *dot = '\0';
        }
    }
    
    printf("%s\n", buffer); // Imprime o número formatado
}

int main() {
    setlocale(LC_NUMERIC, "en_US.UTF-8");

    FILE* arq = fopen("Q08.txt", "w+b");
    if (arq == NULL) {
        printf("Não foi possível abrir o arquivo.\n");
        return 1;
    }

    int inputsize;
    scanf("%d", &inputsize);

    for (int i = 0; i < inputsize; i++) {
        double entrada;
        scanf("%lf", &entrada);
        fwrite(&entrada, sizeof(double), 1, arq);
    }

    fseek(arq, 0, SEEK_SET);

    fseek(arq, 0, SEEK_END);
    long filesize = ftell(arq);
    int fileindex = filesize / sizeof(double);

    for (int i = 0; i < fileindex; i++) {
        fseek(arq, -(i + 1) * sizeof(double), SEEK_END);
        double number;
        fread(&number, sizeof(double), 1, arq);
        formatdouble(number);
    }

    fclose(arq);

    return 0;
}
