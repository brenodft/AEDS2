#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int endLine(char* ponteiro){
        if(ponteiro[0] == 'F'&& ponteiro[1] == 'I' && ponteiro[2] == 'M') {
        return 0;
       	}
	return 1;
}

void palindromo(char *ponteiro){ 
	if(ponteiro[0] == 'F'&& ponteiro[1] == 'I' && ponteiro[2] == 'M') {
	return;
	}
	ponteiro[strcspn(ponteiro, "\r\n")] = '\0';
	int dif = 0;
	int tam = strlen(ponteiro) -1;
	int in = 0;
	do{
	if(ponteiro[in]>0){
        	if (ponteiro[in] != ponteiro[tam]){
            	dif++;
		}
	}else{
		int specialen;
		if(ponteiro[in] == -61){
			specialen = 1;
		}else{
			specialen = 2;
		};
		if(ponteiro[in+specialen] != ponteiro[tam]){
			dif++;
		}
		in += specialen;
		tam -= specialen;
	}		

	in++;
	tam--;
	}while(in<tam);
	if(dif == 0){
		printf("SIM\n");
	}else{
		printf("NAO\n");
	}
	//printf("%s\n",ponteiro);
	

}

int main(){
char** entrada = NULL;
int lin = 0;
int col = 0;
int numstring = 0;
do{
entrada = (char**)realloc(entrada, (300* (numstring+1)) * sizeof(char*));
entrada[numstring] = (char*)malloc(500);
fgets(entrada[numstring], 500, stdin);
palindromo(entrada[numstring]);
numstring++;
}while(endLine(entrada[numstring-1]) != 0 );
free(entrada);
return 0;

}
