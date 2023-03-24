#include<stdio.h>
#include<stdlib.h>
#include<locale.h>
#include<string.h>
#include<time.h>
#include "biblioteca.c"

#define stop fflush(stdin);getchar();
#define clear system("cls");

// STRUCTS |1|

typedef struct Usuarios{
	char* USER;
	char* SEN;
	struct usuarios* prox;
}usuarios;
// STRUCTS |1|

// Funções |2|

usuarios* iniciar(usuarios*);
usuarios* inserir(usuarios*,char*,char*);
void mostra(usuarios*);
void contatoInicial(usuarios*);
int verificacao(usuarios*,char*, char*);
void cadastroUsuarios(usuarios*);
void cadastrar(usuarios*);
usuarios* removerUse(usuarios*);

//Funções |2|
/*------------------- MENU ----------------
int main(){
	
	usuarios* user1 = iniciar(user1);
	printf("\n\nUsuario: %s\n",user1->USER);
	printf("Senha: %s",user1->SEN);
	stop;
	
	contatoInicial(user1);
	
	return 0;
}
----------------------------------------*/
usuarios* iniciar(usuarios* U){
	
	usuarios* novo = (usuarios*)malloc(sizeof(usuarios));

	novo->USER = "admin";
	novo->SEN = "admin";
	novo->prox = NULL;
	
	return novo;

}

usuarios* inserir(usuarios* u,char* usua,char* senha){
	
	usuarios* novo = (usuarios*)malloc(sizeof(usuarios));
	
	novo->USER = usua;
	novo->SEN = senha;
	novo->prox = NULL;
	
	usuarios* p = u;
	
	while(p->prox != NULL){
		p = p->prox;
	}
	
	p->prox = novo;
	
	return u;
	
}
void mostra(usuarios* US){
	usuarios* p;
	
	if(US == NULL){
		printf("NULL");
		
	}else{
		for(p = US; p != NULL; p = p->prox){
			printf("\n\nUsuario: %s\n",p->USER);
			printf("Senha: %s",p->SEN);
			printf("\n=================");
		}
		
	}
	
}

void contatoInicial(usuarios* us){
	char* NomeUser = (char*)malloc(sizeof(char));
	char* SenUser = (char*)malloc(sizeof(char));

	int x = 0;
	int teste;
	
	do{
		clear;
		printf("=========================\n");
		printf("DIGITE ABAIXO O SEU LOGIN\n");
		printf("=========================\n");
		printf("Usuario: ");
		setbuf(stdin,NULL);
		gets(NomeUser);
		printf("\nSenha: ");
		gets(SenUser);
		
		teste = verificacao(us,NomeUser,SenUser);
		
		printf("\n%d",teste);
		stop;
		
		if(teste == 1){
			printf("\n\n\nLogin Efetuado com sucesso, parabens e Bem Vindo a nossa biblioteca!! :)");
			stop;
			//cadastroUsuarios(us);
            escolhas();
			x = 1;
		}else{
			printf("\n\n\n");
			printf("Senha ou Usuario INCORRETO!!!");
			stop;
		}
	
	}while(x == 0);

	
}

int verificacao(usuarios* USUARIO, char* u, char* s){
	usuarios* p = USUARIO;
	
	while(p != NULL){
		if(strcmp(p->USER,u) == 0){
			if(strcmp(p->SEN,s) == 0){
				return 1;
			}
		}
		p = p->prox;
	}
	
	return 0;	
}
void cadastroUsuarios(usuarios* USUARIO1){
	
	int x = 0, escolha;
	
	
	do{
		clear;
		printf("==============================\n");
		printf("Escolha entre as opções abaixo\n");
		printf("1 - Cadastrar novo Usua.\n");
		printf("2 - Trocar de Usuario\n");
		printf("3 - Remover Usuario\n");
		printf("4 - Voltar para Biblioteca \n");
		printf("==============================\n");
		
		printf("Sua escolha: ");
		scanf("%d",&escolha);
		
		switch(escolha){
			case 1:
				cadastrar(USUARIO1);
			break;	
			
			case 2:
				contatoInicial(USUARIO1);
				x = 1;
			break;
				
			case 3:
				removerUse(USUARIO1);
			break;
			
			case 4:
				x = 1;
			break;
			
			case 5:
				mostra(USUARIO1);
				stop;
			break;
			
			default:
				printf("Escolha Invalida, tente novamente");
				stop;	
		}
		
	}while(x == 0);
	
}
void cadastrar(usuarios* UsuariO){
	
	char* NomeUser = (char*)malloc(sizeof(char));
	char* SenUser = (char*)malloc(sizeof(char));
	
	clear;
	printf("Digite o nome do novo Usuario: ");
	setbuf(stdin,NULL);
	gets(NomeUser);
	
	printf("Digite a senha: ");
	setbuf(stdin,NULL);
	gets(SenUser);
	
	UsuariO = inserir(UsuariO,NomeUser,SenUser);
	
	printf("\nUsuario Inserido Com Sucesso!");
	stop;
	
}
usuarios* removerUse(usuarios* Us){
	
	usuarios* ant = NULL;
	usuarios* p = Us;
	char* senha = (char*)malloc(sizeof(char));

	
	
	if(p == NULL){
		printf("Não a usuarios Cadastrados");
		return Us;
	}
	
	clear;
	printf("Digite a senha do Usuario que deseja remover: ");
	setbuf(stdin,NULL);
	gets(senha);
	
	if(strcmp(senha,"admin") == 0){
		printf("Voce nao pode remover o usuario admin");
		stop;
		return Us;
	}
	
	while(p != NULL && strcmp(p->SEN,senha) != 0){
		ant = p;
		p = p->prox;
	}
	if(p == NULL){
		printf("\n\nSenha nao encontrada!");
		stop;
		return Us;
	}
	ant->prox = p->prox;
	free(p);
	
	printf("\n\nUsuario removido com sucesso!!");
	stop

	return Us;
}
