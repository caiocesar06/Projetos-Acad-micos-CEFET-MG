/*
 * Trabalho em grupo - Sistema de biblioteca com mecanismo de Login e gerenciador de contas
 * Membros:
 *	 	Artur Borges Corrêa
 *		Caio César Nascimento Silva
 *		João Victor dos Santos Peixoto
 * Data: 10/12/2021
 */

#include<stdio.h>
#include<stdlib.h>
#include<locale.h>
#include<string.h>
#include<time.h>

#define stop fflush(stdin);getchar();
#define clear system("cls");

struct livro {
	char* nome;
	char* autor;
	int categoria;
		/*----------------
		  Categorias:
			1 - acadêmico
			2 - romance
			3 - infantil
			4 - biografia
			5 - outros
		----------------*/
	char* editora;
	int codigo;
	struct livro* prox;
};

struct usuarios {
	char* USER;
	char* SEN;
	struct usuarios* prox;
};

// Funções primárias para funcionamento da Lista dos livros |1|
livro* inicializa();
livro* insere(livro*, char*, char*, int, char*);
void imprime(livro*);
livro* retira(livro*);
// ======================================================== |1|

// Funções para funcionamento geral do programa |2|
void menu();
void escolhas(usuarios*);
livro* cadastrando(livro*);
void MostraCategoria(livro*);
void imprimeC(livro*, int);
usuarios* iniciar(usuarios*);
usuarios* inserir(usuarios*,char*,char*);
void mostra(usuarios*);
void contatoInicial(usuarios*);
int verificacao(usuarios*,char*, char*);
void cadastroUsuarios(usuarios*);
void cadastrar(usuarios*);
usuarios* removerUse(usuarios*);
// ============================================ |2|

int main(){
	setlocale(LC_ALL, "Portuguese");
	
	srand(time(NULL));
	usuarios* user1 = iniciar(user1);
	contatoInicial(user1);

	
	return 0;
}


/*----------------------------------> Funções do arquivo biblioteca.cpp <-------------------------------------*/

void menu()
{	
	printf("\t================================\n");
	printf("\t   		                      \n");
	printf("\t   BIBLIOTECA DO TRIO MONSTRO   \n");
	printf("\t   		                      \n");
	printf("\t================================\n");
	printf("\t     1 - Cadastrar livros       \n");
	printf("\t   		                      \n");
	printf("\t  2 - Mostrar todos os livros   \n");
	printf("\t   		                      \n");
	printf("\t3 - Mostrar livros por categoria\n");
	printf("\t   		                      \n");
	printf("\t      4 - Remover livro         \n");
	printf("\t   		                      \n");
	printf("\t     5 - Gerenciar contas       \n");
	printf("\t   		                      \n");
	printf("\t           6 - Sair             \n");
	printf("\t================================\n");
}

void escolhas(usuarios* USU)
{
	int escolha;
	livro*L = inicializa();

	do {
		clear;
		menu();
		
		printf("\n Escolha uma opção: ");
		scanf("%d", &escolha);
		
		switch(escolha)
		{			
			case 1:
				int codigo, categoria;
				char *a, *n, *edi;
				
				n = (char*)malloc(sizeof(char));
				a = (char*)malloc(sizeof(char));
				edi = (char*)malloc(sizeof(char));
				
				clear;
				printf("Digite o nome do livro: ");
				setbuf(stdin,NULL);
				gets(n);

				printf("Digite o nome do(a) Autor(a): ");
				setbuf(stdin,NULL);
				gets(a);
				
				printf("Digite o nome da Editora: ");
				setbuf(stdin,NULL);
				gets(edi);
				
				clear;
				printf("\t================================\n");
				printf("\t  Digite a categoria do livro:  \n");
				printf("\t   		                      \n");
				printf("\t   1 - Acadêmico                \n");
				printf("\t   		                      \n");
				printf("\t   2 - Romance 				  \n");
				printf("\t   		                      \n");
				printf("\t   3 - Infantil                 \n");
				printf("\t   		                      \n");
				printf("\t   4 - Biografia                \n");
				printf("\t   		                      \n");
				printf("\t   5 - Outros                   \n");
				printf("\t================================\n");
				printf("\n  Escolha: ");
				setbuf(stdin,NULL);
				scanf("%d",&categoria);
				
				L = insere(L,n,a,categoria,edi);
			break;
			case 2:
				imprime(L);
			break;
			case 3:
				MostraCategoria(L);
			break;
			case 4:
                L = retira(L);
			break;
			case 5:
				cadastroUsuarios(USU);
			break;
			
			case 6:
				printf("\n\nObrigado pela Visita :)\n Volte sempre. Bye!");
			break;
			
			default:
				printf("\n\n\n\n\nEscolha inválida, tente novamente...");
					break;
		}
		stop;
	}while(escolha != 6);
}

livro* inicializa()
{
	return NULL;
}

livro* insere(livro* l, char* nome, char* autor, int categoria, char* editora)
{
	livro* novo = (livro*)malloc(sizeof(livro));
	
	novo->nome = nome;
	novo->autor = autor;
	novo->categoria = categoria;
	novo->editora = editora;
	novo->codigo = rand() % 10000;	// Gera o código randomicamente
	novo->prox = NULL;
	
	livro* p = l;
	
	if(p == NULL)
		return novo;
	while(p->prox != NULL)
		p = p->prox;
	p->prox = novo;
	
	return l;
}

void imprime(livro* l)
{
	livro* p = l;

	clear;
	if(p == NULL)
		printf("NÃO HÁ LIVROS NESSA BIBLIOTECA!");	
	
	for(p=l; p != NULL; p=p->prox)
	{
		printf("\n");
		printf("======================================\n");
		printf("  Nome do Livro: %s             	  \n",p->nome);
		printf("  Nome do(a) Autor(a): %s       	  \n",p->autor);
		printf("  Categoria do Livro: %d        	  \n",p->categoria);
		printf("  Editora: %s                   	  \n",p->editora);
		printf("  Código: %d                    	  \n",p->codigo);
		printf("======================================\n");
	}
}

void imprimeC(livro* l, int e)
{
	livro* p = l;
	int cont = 0;

	clear;
	for(p=l; p != NULL; p=p->prox)
	{
		if(p->categoria == e)
		{
			printf("\n");
			printf("======================================\n");
			printf("  Nome do Livro: %s             	  \n",p->nome);
			printf("  Nome do(a) Autor(a): %s       	  \n",p->autor);
			printf("  Categoria do Livro: %d        	  \n",p->categoria);
			printf("  Editora: %s                   	  \n",p->editora);
			printf("  Código: %d                    	  \n",p->codigo);
			printf("======================================\n");
			
			cont++;
		}
	}
	
	if(cont == 0)
		printf("\tNÃO HÁ NENHUM LIVRO DESSA CATEGORIA!\nAdicione mais livros dessa categoria...");
}

void MostraCategoria(livro* l)
{
	int escolha;

	clear;
	printf("\t==========================\n");
	printf("\t  Escolha qual categoria  \n");
	printf("\t  você gostaria de ver:   \n");
	printf("\t   		                \n");
	printf("\t   1 - Acadêmico          \n");
	printf("\t   		                \n");
	printf("\t   2 - Romance            \n");
	printf("\t   		                \n");
	printf("\t   3 - Infantil           \n");
	printf("\t   		                \n");
	printf("\t   4 - Biografia          \n");
	printf("\t   		                \n");
	printf("\t   5 - Outros             \n");
	printf("\t==========================\n");
	printf("\n Escolha: ");
	scanf("%d",&escolha);
	
	imprimeC(l, escolha);
}

livro* retira(livro* l)
{
    livro* ant = NULL;
    livro* p = l;
    int codigo;
	
	if(l == NULL)
		printf("\n\n\nNão há livros Cadastrados!");
	else {
		clear;
		printf("Digite o código do livro a ser retirado: ");
		scanf("%d",&codigo);
		
		while(p != NULL && p->codigo != codigo)
		{
			ant = p;
			p = p->prox;
	    }
	
	    if(p == NULL)
		{
	        printf("\nLivro não encontrado!\n\n");
	        return l;
	    }
	
	    if(ant == NULL)
		{
	        printf("\nLivro removido do início!\n\n");
	        l = p->prox;
	    } 
		
		else {
	        printf("\nLivro removido!\n\n");
	        ant->prox = p->prox;
	    }
	    free(p);
	    return l;
	}
}

/*--------------------------------------------------> FIM <---------------------------------------------------*/



/*----------------------------------> Funções para o mecanismo de Login <-------------------------------------*/

usuarios* iniciar(usuarios* U)
{
	usuarios* novo = (usuarios*)malloc(sizeof(usuarios));

	novo->USER = "admin";
	novo->SEN = "admin";
	novo->prox = NULL;
	
	return novo;
}

usuarios* inserir(usuarios* u,char* usua,char* senha)
{
	usuarios* novo = (usuarios*)malloc(sizeof(usuarios));
	
	novo->USER = usua;
	novo->SEN = senha;
	novo->prox = NULL;
	
	usuarios* p = u;
	
	while(p->prox != NULL)
		p = p->prox;
	p->prox = novo;
	
	return u;
}

void mostra(usuarios* US)
{
	usuarios* p;
	
	if(US == NULL)
		printf("NULL");
	else {
		for(p = US; p != NULL; p = p->prox)
		{
			printf("\n=========================");
			printf("\nUsuario: %s              ",p->USER);
			printf("\nSenha: %s                ",p->SEN);
			printf("\n=========================");
		}
	}
}

void contatoInicial(usuarios* us)
{
	char* NomeUser = (char*)malloc(sizeof(char));
	char* SenUser = (char*)malloc(sizeof(char));

	int x = 0;
	int teste;
	
	do {
		clear;
		printf("=========================\n");
		printf("          LOGIN          \n");
		printf("=========================\n");
		printf("\nUsuário: ");
		setbuf(stdin,NULL);
		gets(NomeUser);
		printf("\nSenha: ");
		gets(SenUser);
		
		teste = verificacao(us,NomeUser,SenUser);
		
		if(teste == 1)
		{
			printf("\n\n\nLogin efetuado com sucesso!");
			stop;
			printf("\n\nBem Vindo a nossa biblioteca!! :)");
			stop;
			escolhas(us);
			x = 1;
		} else {
			printf("\n\n\n");
			printf("Senha e/ou Usuário INCORRETOS!!!");
			stop;
		}
	}while(x == 0);
}

int verificacao(usuarios* USUARIO, char* u, char* s)
{
	usuarios* p = USUARIO;
	
	while(p != NULL)
	{
		if(strcmp(p->USER,u) == 0)
		{
			if(strcmp(p->SEN,s) == 0)
				return 1;
		}
		p = p->prox;
	}
	
	return 0;	
}

void cadastroUsuarios(usuarios* USUARIO1)
{
	int x = 0, escolha;
	
	do {
		clear;
		printf("\t================================\n");
		printf("\t   Escolha uma opção abaixo:    \n");
		printf("\t  		                      \n");
		printf("\t  1 - Cadastrar novo usuário    \n");
		printf("\t  		                      \n");
		printf("\t  2 - Trocar de usuário 		  \n");
		printf("\t  		                      \n");
		printf("\t  3 - Remover usuário           \n");
		printf("\t  		                      \n");
		printf("\t  4 - Voltar para a biblioteca  \n");
		printf("\t================================\n");

		printf("\n Sua escolha: ");
		scanf("%d",&escolha);
		
		switch(escolha)
		{
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
				printf("Escolha inválida! Tente novamente...");
				stop;	
		}
	}while(x == 0);
}

void cadastrar(usuarios* UsuariO)
{
	char* NomeUser = (char*)malloc(sizeof(char));
	char* SenUser = (char*)malloc(sizeof(char));
	
	clear;
	printf("Digite o nome do novo Usuario: ");
	setbuf(stdin,NULL);
	gets(NomeUser);
	
	printf("Digite a nova senha: ");
	setbuf(stdin,NULL);
	gets(SenUser);
	
	UsuariO = inserir(UsuariO,NomeUser,SenUser);
	
	printf("\nUsuário inserido com SUCESSO!");
	stop;
}

usuarios* removerUse(usuarios* Us)
{
	usuarios* ant = NULL;
	usuarios* p = Us;
	char* senha = (char*)malloc(sizeof(char));

	if(p == NULL){
		printf("N�o a usuarios Cadastrados");
		return Us;
	}
	
	clear;
	printf("Digite a senha do usuário que deseja remover: ");
	setbuf(stdin,NULL);
	gets(senha);
	
	if(strcmp(senha,"admin") == 0)
	{
		printf("\n\nVoce nao pode remover o usuário \"admin\"");
		stop;
		return Us;
	}
	
	while(p != NULL && strcmp(p->SEN,senha) != 0)
	{
		ant = p;
		p = p->prox;
	}
	if(p == NULL)
	{
		printf("\n\nSenha não encontrada!");
		stop;
		return Us;
	}
	ant->prox = p->prox;
	free(p);
	
	printf("\n\nUsuário removido com SUCESSO!!");
	stop

	return Us;
}

/*--------------------------------------------------> FIM <---------------------------------------------------*/