/*-------------------------------------------------------

Trabalho de fila - Professor Robson LLTPI

Caio César
João Peixoto
Thayllon Ryan

Alunos de Informatica 2 - 1 Modulo

Gerador de senha.

-------------------------------------------------------*/

//Importando bibliotecas
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

//Define
#define RED   "\x1B[31m"
#define GRN   "\x1B[32m"
#define YEL   "\x1B[33m"
#define BLU   "\x1B[34m"
#define CYN   "\x1B[36m"
#define RESET "\x1B[0m"

#define clear system("cls")
#define TAM 16

//Variáveis globais
int cont = 0;
int Senha_Comum = 0;
int Senha_Prio = 0;

//Criando a fila
typedef struct fila 
{
	int ini;
	int fim;
	int t[TAM];
}fila;

fila* cria();//Função responsável por alocar a fila dinâmicamente e zerar o inicio e o fim
int incrementa(int i);//Função responsável por incrementar
void insere(fila* f, int v);//Função responsável por inserir o valor na fila
int vazia(fila* f);//Função inteira responsável por retornar se a fila está ou não vazia
int retira(fila* f);//Função responsável por retornar o valor da fila
void libera(fila* f);//Função responsável por limpar a fila 
void menu();//Função responsável por mostrar o menu ao usuário
int gerar(int escolha);//Função responsável por gerar as senhas

int main(){

	setlocale(LC_ALL, "Portuguese");
	
	fila* comum = cria();
	fila* prioridade = cria();
	int escolha, x = 1, i = 0;;
	int escolhaF, controle1 = 0, controle = 0;
	
	do{
		
		menu();
		scanf("%d",&escolha);
		switch(escolha){
			case 1:
				clear;
				printf("Voce gostaria de gerar um senha "CYN"Comum(1)"RESET" ou "YEL"Prioritaria(2):"RESET"\n");
				scanf("%d",&escolhaF);
				if(escolhaF == 1){
					insere(comum, gerar(escolhaF));
					
					printf("\n\n\n\nPressione qualquer tecla para voltar ao menu...");
						
					
					fflush(stdin);
					getchar();
					
					controle1++;
				}else if(escolhaF == 2){
					insere(prioridade, gerar(escolhaF));
					
					printf("\n\n\n\nPressione qualquer tecla para voltar ao menu...");
					
					fflush(stdin);
					getchar();
					
					controle++;
				}else{
					printf("\n\n"RED"OPÇÂO INVALIDA"RESET);
					printf("\n\n\n\n\nPressione qualquer tecla para voltar ao menu principal...");
					fflush(stdin);
					getchar();
				}
				
				
			break;
			case 2:
				if(vazia(comum) == 1 && vazia(prioridade) == 1){
					printf(RED"TODAS AS SENHAS JA FOROM CHAMADAS OU AINDA NÃO EXISTEM SENHAS!\n"RESET);
					fflush(stdin);
					getchar();
				}	
				
				if(vazia(prioridade) == 0)
				{	
					if(vazia(comum) == 1)
					{
						
						printf("\n\nProxima Senha\nSenha %d da fila "RED"FILA PRIORITARIA\n"RESET, retira(prioridade));
                    	i = 0;
						fflush(stdin);
						getchar();
					}
					else if(i == 2)
                	{
					
                    	printf("\n\nProxima Senha\nSenha %d da fila "RED"FILA PRIORITARIA\n"RESET, retira(prioridade));
                    	i = 0;
						fflush(stdin);
						getchar();
						break;
                	}
				}
				if(vazia(comum) == 0){
					i++;
                    printf("\n\nProxima Senha\nSenha %d da fila "GRN"FILA COMUM\n"RESET, retira(comum));
					fflush(stdin);
					getchar();
				}
			break;
			
			case 3:
				x = 0;
			break;
			
			default:
				printf("\n"RED"ESCOLHA INVALIDA!"RESET"\ntente novamente.");
					fflush(stdin);
					getchar();
		}
		
	}while(x != 0);
	
	
	
	
	
	
	
	
	
	fflush(stdin);
	getchar();
	return 0;
	
}

void menu(){
	clear;
	printf("|----------------------------------------------------|\n");
	printf("|                                                    |\n");
	printf("|"GRN"GERADOR DE SENHAS"RESET"                                   |\n");
	printf("|                                                    |\n");
	printf("|                                                    |\n");
	printf("| 1 - Gerar senha                                    |\n");
	printf("|                                                    |\n");
	printf("| 2 - Proximo da fila                                |\n");
	printf("|                                                    |\n");
	printf("| 3 - sair                                           |\n");
	printf("|----------------------------------------------------|\n");
	printf("\n\nSua escolha: ");
	
}

int gerar(int escolha){
	
	
	int senha = 0;
	clear;
	printf(" ---------------------------------------------------- \n");
	printf("|                                                    |\n");
	printf("|"GRN"Bem Vindo ao Gerador de Senha"RESET"                       |\n");
	printf("|                                                    |\n");
	printf(" ---------------------------------------------------- \n");
	
	printf("\n"RED"SUA SENHA E: "RESET,senha);
	
	if(escolha == 1){
		senha = Senha_Comum;
		Senha_Comum++;
		return senha;
	}else{
		senha = Senha_Prio;
		Senha_Prio++;
		return senha;
	}
}

fila* cria(){
	fila* f = (fila*) malloc(sizeof(fila));
	f->ini = f->fim = 0;
	return f;
}

int incrementa(int i){
	
	
	if(i == TAM-1){
		return 0;
	}else{
		return i+1;
	}
		
}

void insere(fila* f, int v){
	
	if(incrementa(f->fim) == f->ini){
		printf("a fila esta cheia\n");
		cont = 1;
		return;	
	}
	
	f->t[f->fim] = v;
	f->fim = incrementa(f->fim);
	printf("%d\n",v);
	
}

int vazia(fila* f){
	return (f->fim == f->ini);
}

int retira (fila* f){
	int valor;
	
	if(vazia(f)){
		printf("a fila está vazia!\n");
		exit(1);
	}
	
	valor = f->t[f->ini];
	f->ini = incrementa(f->ini);
	return valor;
}

void libera(fila* f){
	free(f);
}