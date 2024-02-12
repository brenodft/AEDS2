#include <stdio.h>

char parimpar(int num){
        if (num %2 == 0){
                return 'P';
        }else{
                return 'I';
        }
}
int endrep(int num) {
        if (num == 0 ){
                return 0;
        } else{
                return 1;
        }
}

int main(){
	int num = 0;
	do{
		scanf("%d", &num);
		if ( num != 0) {
			printf("%c\n",parimpar(num));
		}
	}while(endrep(num) == 1);


}

