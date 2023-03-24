#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <locale.h>
#include "samuka.h"

#define limpar system("clear||cls")

// Corpo da função

// criar = create
void Create(stack *s){
	s->top = NULL;
}

// bota == put
void Put(char *code, stack *s) {	
	limpar;
    bs *ptr = (bs *) malloc(sizeof(bs)); //Aloca dinamicamente um novo nó
    if(ptr == NULL){
    	printf("Ah Shit. Here we go again");
        return;
    }else{
        ptr->idBook = code;
        ptr->next = s->top;
        s->top = ptr;
        printf("Livro Empilhado com sucesso!!!");	

  }// tirar  = pull
}
int Pull(stack *s) {
	bs* ptr = s->top;
	int data;
	if(!(Verify(s))) {
		s->top = ptr->next;
		ptr->next = NULL;
		data = ptr->idBook;
		free(ptr);
		return data;
	} else {
		printf("A pilha já está vazia!\n\n");
	}
}


bool Verify(stack *s) {
	if (s->top == NULL)
    {
        return true;
    }
    else
    {
        return false;
    }
}

// exibir = show
void Show(stack *s) {
    bs *ptr = s->top;
    printf("----Samukinha's Book Shelf----\n");
    while(ptr != NULL){
        printf("\t%s\n", ptr->idBook);
        ptr = ptr->next;
    }
    printf ("\n");
}

void Menu(stack *s)
{
    int aux, id, code, choice;
	do{
		limpar;
		printf("====================================================\n");
		printf("\tWellcome to Samukinha's Library!!!\n");
		printf("====================================================\n\n");
		printf("(1)Add a new book\n");
		printf("(2)Withdraw a book\n");
		printf("(3)Show the bookcase\n");
		printf("(4)Leave\n");
		printf("\nYour choice: ");
		scanf("%d", &aux);
		switch(aux) {
			case 1:
				do{
					limpar;
					printf("Digite o ID do livro: ");
					scanf("%s", &id);
					Put(id, s);
					printf("\n\nVocê quer empilhar outro livro?\n\n");
					printf("1 - Sim\n2 - Não");
					printf("\nDigite a opção desejada: ");
					scanf("%d", &choice);
					if(choice == 2)
						return;
					if(choice != 1){
						printf("\nBURRO! >:(\n\n");
						fflush(stdin);
						getchar();
						getchar();
					}
				}while(choice == 1);		
					break;
			case 2:
            	limpar;
          		Pull(s);
                printf("Book successfully removed from the top!");	//nao sei ingles 😭
                printf("\n\nPress ENTER to continue...");
				fflush(stdin);
				getchar();
				getchar();
					break;

			case 3:
				limpar;
            	Show(s);
				printf("\n\nPress ENTER to continue...");
				fflush(stdin);
				getchar();
				getchar();
					break;

			case 4:
				return;
					break; 
			default: 
            	limpar;
				printf("Please enter a valid value");
					break;
		}
	}while(aux != 4);
}