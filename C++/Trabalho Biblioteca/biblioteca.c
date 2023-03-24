#include<stdio.h>
#include<stdlib.h>
#include<locale.h>
#include<string.h>
#include<time.h>

#define stop fflush(stdin);getchar();
#define clear system("cls");

struct livro{
	char* nome;
	char* autor;
	int categoria;
	/*
		1 - acadêmico
		2 - romance
		3 - infantil
		4 - biografia
		5 - outros
	*/
	char* editora;
	int codigo;
	struct livro* prox;
};

//Funções primarias para funcionamento da Lista dos livros |1|

livro* inicializa();
livro* insere(livro*, char*, char*, int, char*
);
void imprime(livro*);
livro* retira(livro*);

//===========================  |1|

//função para funcionamento geral do programa |2|

void menu();
void escolhas();
livro* cadastrando(livro*);
void MostraCategoria(livro*);
void imprimeC(livro*, int);
// ============================== |2|

int main(){
	setlocale(LC_ALL, "Portuguese");
	
	srand(time(NULL));
	escolhas();
	
	/*
	livro*L = inicializa();
	L = insere(L,"Os 3 porquinhos","Maria",3,"Ferroiz",0043);
	L = insere(L,"Eu sou o numero 4","marta",5,"Peixotada",0044);
	imprime(L);
	*/
	
	return 0;
}

void menu(){
	
	printf("\t================================\n");
	printf("\t   Biblioteca Do Trio Monstro   \n");
	printf("\t================================\n");
	printf("\t     1 - Cadastrar livros       \n");
	printf("\t  2 - Mostrar todos os livros   \n");
	printf("\t3 - Mostrar livros por categoria\n");
	printf("\t      4 - Remover livro         \n");
	printf("\t           5 - Sair             \n");
	printf("\t================================\n");
}

void escolhas(){
	int x = 0 , escolha;
	livro*L = inicializa();
	
	
	
	
	do{
		clear;
		menu();
		
		printf("\nEscolha uma opção: ");
		scanf("%d",&escolha);
		
		switch(escolha){
			
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
				
				
				printf("\nDigite a cetegoria do livro de acordo com a tebela apresentada abaixo:\n");
				printf("\n  1 - acadêmico\n");
				printf("\n  2 - romance\n");
				printf("\n  3 - infantil\n");
				printf("\n  4 - biografia\n");
				printf("\n  5 - outros\n\n");
				printf("Escolha: ");
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
				x = 1;
				printf("\n\nObrigado pela Visita :)\n volte sempre. Bye!");
			break;
			
			
			default:
				printf("\n\n\n\n\nEscolha Invalida, tente novamente...");
				
		}
		
		stop;
	}while(x == 0);
}

livro* inicializa(){
	return NULL;
}
livro* insere(livro* l, char* nome, char* autor, int categoria, char* editora){
	livro* novo = (livro*)malloc(sizeof(livro));
	
	novo->nome = nome;
	novo->autor = autor;
	novo->categoria = categoria;
	novo->editora = editora;
	novo->codigo = rand() % 10000;
	novo->prox = NULL;
	
	livro* p = l;
	
	if(p == NULL){
		return novo;
	}
		
	
	while(p->prox != NULL){
		p = p->prox;
	}	
	
	p->prox = novo;
	
	return l;

}

void imprime(livro* l){
	livro* p = l;
	
	if(p == NULL){
		printf("NULL");
	}
	
	
	for(p=l; p != NULL; p=p->prox){
		
		printf("\n================================\n");
		printf("Nome do Livro: %s\n",p->nome);
		printf("Nome do(a) Autor(a): %s\n",p->autor);
		printf("Categoria do Livro: %d\n",p->categoria);
		printf("Editora: %s\n",p->editora);
		printf("Codigo: %d\n",p->codigo);
		printf("================================\n");
	}
	
}
void imprimeC(livro* l, int e){
	livro* p = l;
	int cont = 0;

	for(p=l; p != NULL; p=p->prox){
		if(p->categoria == e){
			printf("\n================================\n");
			printf("Nome do Livro: %s\n",p->nome);
			printf("Nome do(a) Autor(a): %s\n",p->autor);
			printf("Categoria do Livro: %d\n",p->categoria);
			printf("Editora: %s\n",p->editora);
			printf("Codigo: %d\n",p->codigo);
			printf("================================\n");
			
			cont++;
		}
	}
	
	if(cont == 0){
		printf("NULL");
	}
	
	
}

void MostraCategoria(livro* l){
	int escolha;
	clear;
	
	printf("Escolha Qual Categoria Você gostaria de Ver\n");
	printf("\n  1 - acadêmico\n");
	printf("\n  2 - romance\n");
	printf("\n  3 - infantil\n");
	printf("\n  4 - biografia\n");
	printf("\n  5 - outros\n\n");
	printf("Escolha: ");
	scanf("%d",&escolha);
	
	imprimeC(l, escolha);
}

livro* retira(livro* l){
    livro* ant = NULL;
    livro* p = l;
    int codigo;
	
	if(l == NULL){
		printf("\n\n\nNão há livros Cadastrados!");
	}else{
		clear;
		printf("Digite o Codigo do Livro que você gostaria de Retirar: ");
		scanf("%d",&codigo);
		
		while(p != NULL && p->codigo != codigo){
        ant = p;
        p = p->prox;
	    }
	
	    if(p == NULL){
	        printf("\nLivro não encontrado!n");
	        return l;
	    }
	
	    if(ant == NULL){
	        printf("\nLivro removido do início!\n\n");
	        l = p->prox;
	    }
	
	    else{
	        printf("\nLivro removido!\n\n");
	        ant->prox = p->prox;
	    }
	    free(p);
	    return l;
	}
	
}
