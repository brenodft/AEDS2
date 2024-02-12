#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int* upper(char **str, int total){
    int *vet = (int*)malloc(total * sizeof(int));

    for(int i = 0; i < total; i++){
        int count = 0;
        for(int j = 0; j<20; j++){
            if(str[i][j] >= 'A' && str[i][j] <= 'Z'){
                count++;
            }
            vet[i] = count;

        }
    }
return vet;
}
int main(){
    char **strvet = (char**)malloc(5*sizeof(char*));

    int count = 0;
    do{
        strvet[count] = (char*)malloc(20*sizeof(char));
        scanf("%s", strvet[count]);
        count++;
    }while(count<5);
    int *mai = upper(strvet,5);

    mai = upper(strvet, count);
    for(int j = 0 ; j<count; j++){
        printf("%d ", mai[j]);
    }
    free(strvet);
    free(mai);
    return 0;
}
