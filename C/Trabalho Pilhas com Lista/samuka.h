//sou gay.
//sou garoto de programa

#ifndef SAMUKA_H
#define SAMUKA_H
#define limpar system("clear||cls");

typedef struct BookShelf {
	char *idBook;
	struct bs *next;
}bs;

typedef struct Stack {
	bs *top;
}stack;

// Assinatura da função
void Create(stack *s);

void Put(char *code, stack *s);

int Pull(stack *s);

bool Verify(stack *s);

void Show(stack *s);

void Menu();

#endif