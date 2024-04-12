#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <wchar.h>   
#include <locale.h>  

typedef struct s_Personagem
{
char*   id              ; 
char*   name            ; 
char*   alternateNames  ;
char*   house           ; 
char*   ancestry        ; 
char*   species         ; 
char*   patronus        ; 
bool    hogwartsStaff   ;  
bool    hogwartsStudent ;  
char*   actorName       ; 
bool    alive           ;
char*   alternateActors ; 
char*    dateOfBirth    ; 
int     yearOfBirth     ; 
char*   eyeColour       ; 
char*   gender          ; 
char*   hairColour      ; 
bool    wizard          ; 
} Personagem;

// construtor
void newPersonagem ( Personagem* personagem, char* id , char*  name, char* alternateNames, char* house,char* ancestry, char*  species, char* patronus,bool  hogwartsStaff,bool  hogwartsStudent, char* actorName, bool alive, char* alternateActors, char*  dateOfBirth, int yearOfBirth, char*eyeColour, char* gender , char* hairColour, bool wizard ){
    if(personagem != NULL){
    personagem->id = id;                             
    personagem->name = name;                         
    personagem->alternateNames = alternateNames;                 
    personagem->house = house;                           
    personagem->ancestry = ancestry;                     
    personagem->species = species;      
    if(strcmp(patronus,"null") == 0){
        personagem -> patronus = "";
    }else{
        personagem->patronus= patronus;     
    }                           
    personagem->hogwartsStaff= hogwartsStaff;                   
    personagem->hogwartsStudent= hogwartsStudent ;     
    if(strcmp(actorName,"null") == 0){ 
        personagem -> actorName = "";
    }else{
        personagem->actorName= actorName;  
    }                         
    personagem->alive= alive  ;                           
    personagem->alternateActors= alternateActors;               
    personagem->dateOfBirth  = dateOfBirth  ;                   
    personagem->yearOfBirth = yearOfBirth ;                   
    personagem->eyeColour = eyeColour;                       
    personagem->gender = gender ;                         
    personagem->hairColour  = hairColour ;                     
    personagem->wizard  = wizard ;                         
    }
}

//setters

void setPersonagemId(Personagem *p, const char *id) {
    if (p->id != NULL) free(p->id);
    p->id = strdup(id);
}

void setPersonagemName(Personagem *p, const char *name) {
    if (p->name != NULL) free(p->name);
    p->name = strdup(name);
}

void setPersonagemAlternateNames(Personagem *p, const char *alternateNames) {
    if (p->alternateNames != NULL) free(p->alternateNames);
    p->alternateNames = strdup(alternateNames);
}

void setPersonagemHouse(Personagem *p, const char *house) {
    if (p->house != NULL) free(p->house);
    p->house = strdup(house);
}

void setPersonagemAncestry(Personagem *p, const char *ancestry) {
    if (p->ancestry != NULL) free(p->ancestry);
    p->ancestry = strdup(ancestry);
}

void setPersonagemSpecies(Personagem *p, const char *species) {
    if (p->species != NULL) free(p->species);
    p->species = strdup(species);
}

void setPersonagemPatronus(Personagem *p, const char *patronus) {
    if (p->patronus != NULL) free(p->patronus);
    p->patronus = strdup(patronus);
}

void setPersonagemHogwartsStaff(Personagem *p, bool hogwartsStaff) {
    p->hogwartsStaff = hogwartsStaff;
}

void setPersonagemHogwartsStudent(Personagem *p, bool hogwartsStudent) {
    p->hogwartsStudent = hogwartsStudent;
}

void setPersonagemActorName(Personagem *p, const char *actorName) {
    if (p->actorName != NULL) free(p->actorName);
    p->actorName = strdup(actorName);
}

void setPersonagemAlive(Personagem *p, bool alive) {
    p->alive = alive;
}

void setPersonagemAlternateActors(Personagem *p, const char *alternateActors) {
    if (p->alternateActors != NULL) free(p->alternateActors);
    p->alternateActors = strdup(alternateActors);
}

void setPersonagemDateOfBirth(Personagem *p, const char *dateOfBirth) {
    if (p->dateOfBirth != NULL) free(p->dateOfBirth);
    p->dateOfBirth = strdup(dateOfBirth);
}

void setPersonagemYearOfBirth(Personagem *p, int yearOfBirth) {
    p->yearOfBirth = yearOfBirth;
}

void setPersonagemEyeColour(Personagem *p, const char *eyeColour) {
    if (p->eyeColour != NULL) free(p->eyeColour);
    p->eyeColour = strdup(eyeColour);
}

void setPersonagemGender(Personagem *p, const char *gender) {
    if (p->gender != NULL) free(p->gender);
    p->gender = strdup(gender);
}

void setPersonagemHairColour(Personagem *p, const char *hairColour) {
    if (p->hairColour != NULL) free(p->hairColour);
    p->hairColour = strdup(hairColour);
}

void setPersonagemWizard(Personagem *p, bool wizard) {
    p->wizard = wizard;
}

// getters
const char* getPersonagemId(const Personagem *p) {
    return p->id;
}

const char* getPersonagemName(const Personagem *p) {
    return p->name;
}

const char* getPersonagemAlternateNames(const Personagem *p) {
    return p->alternateNames;
}

const char* getPersonagemHouse(const Personagem *p) {
    return p->house;
}

const char* getPersonagemAncestry(const Personagem *p) {
    return p->ancestry;
}

const char* getPersonagemSpecies(const Personagem *p) {
    return p->species;
}

const char* getPersonagemPatronus(const Personagem *p) {
    return p->patronus;
}

bool getPersonagemHogwartsStaff(const Personagem *p) {
    return p->hogwartsStaff;
}

bool getPersonagemHogwartsStudent(const Personagem *p) {
    return p->hogwartsStudent;
}

const char* getPersonagemActorName(const Personagem *p) {
    return p->actorName;
}

bool getPersonagemAlive(const Personagem *p) {
    return p->alive;
}

const char* getPersonagemAlternateActors(const Personagem *p) {
    return p->alternateActors;
}

const char* getPersonagemDateOfBirth(const Personagem *p) {
    return p->dateOfBirth;
}

int getPersonagemYearOfBirth(const Personagem *p) {
    return p->yearOfBirth;
}

const char* getPersonagemEyeColour(const Personagem *p) {
    return p->eyeColour;
}

const char* getPersonagemGender(const Personagem *p) {
    return p->gender;
}

const char* getPersonagemHairColour(const Personagem *p) {
    return p->hairColour;
}

bool getPersonagemWizard(const Personagem *p) {
    return p->wizard;
}

//imprimir personagem

void imprimir ( Personagem* personagem ){
    //adequando ao layout do canvas
    //printf("ESTUDANTE: %s\n",personagem->hogwartsStudent);
    if (personagem->dateOfBirth && strlen(personagem->dateOfBirth) < 10) {
        char *aux = calloc(11, sizeof(char));  // espaço para "dd-mm-yyyy\0"
        int dia, mes, ano;
        
        // parse da data presumindo formatos "d-m-yyyy" ou "dd-m-yyyy" etc.
        if (sscanf(personagem->dateOfBirth, "%d-%d-%d", &dia, &mes, &ano) == 3) {
            sprintf(aux, "%02d-%02d-%d", dia, mes, ano);  // formata com zeros à esquerda para dia e mês
            free(personagem->dateOfBirth);  // libera a memória antiga
            personagem->dateOfBirth = aux;  // atribui a nova string formatada
        } else {
            free(aux);  // libera aux se não for usada
        }
    }
    printf( "[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n",personagem->id,personagem->name,personagem->alternateNames,personagem->house,personagem->ancestry,personagem->species,personagem->patronus,personagem->hogwartsStaff ? "true" : "false",personagem->hogwartsStudent ? "true" : "false",personagem->actorName,personagem->alive ? "true" : "false",personagem->dateOfBirth,personagem->yearOfBirth,personagem->eyeColour,personagem->gender,personagem->hairColour,personagem->wizard ? "true" : "false" ); 
}
bool checardata(char data[]){
    bool edata = "false";
    char molde[] = {"00-0-0000"};
    int count = 0;
    for(int i = 0; i<strlen(molde);i++){
        if(data[i] == molde[i]){
            count++;
        }
    }
    if(count == 2){
        edata = "true";
    }
    return edata;
}

void padronizarData(char data[]) {
    int dia, mes, ano;
    for(int i = 0; i<strlen(data); i++){
        printf("%c", data[i]);
    }
    printf("\n");
}

//ler arquivo e colocar as caracteristicas daquele ID no personagem

Personagem* ler(Personagem* personagem, char* filename, char* id_procurado) {
    //leitura do arquivo
    FILE* file = fopen(filename, "r");
    if (file == NULL) {
        printf("\nERROR: File Not Found.\n");
    } else {
        char line[500];
        //variavel para controlar o while
        bool idFound = false;

        // pular cabeçalho
        fgets(line, sizeof(line), file);
        // ler o resto das linhas
        int na = 0;
        //a cada fgets é uma quebra de linha
        while (fgets(line, sizeof(line), file) != NULL && !idFound) {
            char *atributos[18];
            char auxline[500] = {0};
            int col = 0;
            int t = 0;
            int k = 0;
            int index = 0;
            //faz a mesma coisa que o split, armazena nessa variavel as palavras separadas com ;
            char *token = strtok(line, ";");
            int execvar = 0;
            na++;
            int debug= 0;
            while (token != NULL) {
                //nesse caso a lógica é que esse ponteiro de strings "token" vai ser repartido e seu valor vai para aquele indice em atributos
                debug++;
                execvar++;
                atributos[index++] = strdup(token);
                token = strtok(NULL, ";");
            }
        //variavel auxiliar para trocar o [] por {}
        char aux[500] = {0};
        int j = 0;
        for (int i = 0; i < strlen(atributos[2]); i++) {
            if (atributos[2][i] == '[') {
                aux[j] = '{';
            } else if (atributos[2][i] == ']') {
                aux[j] = '}';
            } else if (atributos[2][i] == '\'') {
                continue; 
            } else {
                aux[j] = atributos[2][i];
            }
            j++; 
        }
        aux[j] = '\0'; 

        free(atributos[2]); 
        atributos[2] = strdup(aux);
            //comparação entre a primeira coluna e o id colocado pelo usuario
            if (strcmp(atributos[0], id_procurado) == 0) {
                //atribuição dos valores das colunas para um personagem
                if(execvar < 18){
                    if(execvar>16){
                    newPersonagem(personagem,atributos[0], atributos[1], atributos[2], atributos[3],atributos[4], atributos[5], "null" ,strcmp(atributos[6], "true") == 0,strcmp(atributos[7], "true") == 0,atributos[8], strcmp(atributos[9], "true") == 0,atributos[10], atributos[11],atoi(atributos[12]), atributos[13], atributos[14],atributos[15], strcmp(atributos[16], "true") == 0);
                    } else{
                    newPersonagem(personagem,atributos[0], atributos[1], atributos[2], atributos[3],atributos[4], atributos[5], "null" ,strcmp(atributos[6], "true") == 0,strcmp(atributos[7], "true") == 0,"null", strcmp(atributos[8], "true") == 0,atributos[9], atributos[10],atoi(atributos[11]), atributos[12], atributos[13],atributos[14], strcmp(atributos[15], "true") == 0);
                    }
                }else{
                    newPersonagem(personagem,atributos[0], atributos[1], atributos[2], atributos[3],atributos[4], atributos[5], atributos[6],strcmp(atributos[7], "true") == 0,strcmp(atributos[8], "true") == 0,atributos[9], strcmp(atributos[10], "true") == 0,atributos[11], atributos[12],atoi(atributos[13]), atributos[14], atributos[15],atributos[16], strcmp(atributos[17], "true") == 0);
                }
                idFound = true;
                //retorna o personagem com essas caracteristicas
                return personagem;
            }

            // liberar memoria
            for (int x = 0; x < index; x++) {
                free(atributos[x]);
            }
        }
        //fechar arquivo
        fclose(file);
    }
}



int main(){
    setlocale(LC_CTYPE, "UTF-8"); 
    //alocando local de memoria para o personagem
    Personagem* personagem = (Personagem*) malloc ( 1 * sizeof(Personagem) );
    char* path = "/tmp/characters.csv"; 
    char id[81];
    //ler id novo
    scanf("%s",id ); 
    //limpar buffer
    getchar( );
    while( strcmp( id,"FIM" ) != 0 ){
        personagem = ler( personagem, path, id );
        imprimir( personagem );
        //ler id novo
        scanf( "%s", id ); 
        //limpar buffer
        getchar( );
    } 
    //liberar memoria alocada
    free( personagem );
    personagem = NULL;
    return 0;
}