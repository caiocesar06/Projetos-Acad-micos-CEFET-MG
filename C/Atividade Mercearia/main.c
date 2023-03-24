#include <stdio.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <stdlib.h>

#define RED   "\x1B[31m"
#define GRN   "\x1B[32m"
#define YEL   "\x1B[33m"
#define BLU   "\x1B[34m"
#define MAG   "\x1B[35m"
#define CYN   "\x1B[36m"
#define WHT   "\x1B[37m"
#define RESET "\x1B[0m"
#define limpar system("clear || cls");

void menu();
void sair();
void voltarMenu();
void mostrarEstoque();
void estoqueCrescente(int *estoque, char **nomes);
void estoqueDecrescente(int *estoque, char **nomes);
int cadastrarFlores(int *estoque);

int main(void) {

  char nomes[5][20] = {"Rosa","Margarida","Cravo","Girassol","Hort�ncia"};
  int estoque[5] = {0, 0, 0, 0, 0}, escolha;

  setlocale(LC_ALL, "Portuguese");
  menu();

  scanf("%d", &escolha);

  switch(escolha)
	{
		case 1:
			limpar;
      cadastrarFlores(estoque);
			break;
		case 2:
			limpar;
      mostrarEstoque(estoque);
			break;
		case 3:
			limpar;
      estoqueCrescente(estoque,nomes);
      break;
		case 4:
      limpar;
      estoqueDecrescente(estoque,nomes);
	    break;
		case 5:
			limpar;
			sair();
				break;
		
		default:
			limpar;
			printf("VOC� DIGITOU UM VALOR INV�LIDO!\n\n");
      voltarMenu();
				break;
	}

  return 0;
}

void menu()
{

	printf("-------------------------------------------------\n");
	printf("|                                               |\n");
  printf("|                                               |\n");
	printf("|       LA FLORICULTURA DEL FELIP�O             |\n");
	printf("|                                               |\n");
	printf("|                                               |\n");
	printf("|   1) Cadastrar flores                         |\n");
	printf("|   2) Mostrar estoque                          |\n");
	printf("|   3) Mostrar estoque (menos para mais)        |\n");
	printf("|   4) Mostrar estoque (mais para menos)        |\n");
	printf("|   5) Sair                                     |\n");
  printf("|                                               |\n"); 
	printf("|                                               |\n"); 
	printf("-------------------------------------------------");

	printf("\n\n Escolha uma op��o: ");
}

void sair()
{
  int i;
	printf("\n\nMuito obrigado por acessar o sistema da nossa Floricultura!\n\nVolte sempre que quiser ;)\n\n\nAperte ENTER para sair...");
	fflush(stdin);
  printf("O sistema ser� finalizado em:\n\n");
  for(i=5; i>0; i--){
    printf("  %d\n", i);
    sleep(1);
  }
	exit(0);
}

void voltarMenu()
{
  char escolhaCHAR;
  
	fflush(stdin);
	printf("\n\n\t\t\tAperte ESC para voltar ao Menu...\n\n");
	escolhaCHAR = getch();
	if(escolhaCHAR == 27)
	{
		limpar;
		
		menu();
	}
}

void mostrarEstoque(int *estoque)
{
  limpar;
  printf("Rosa (R): %d\n\n", estoque[0]);
  printf("Manteiga (M): %d\n\n", estoque[1]);
  printf("Cravo (C): %d\n\n", estoque[2]);
  printf("Girassol (G): %d\n\n", estoque[3]);
  printf("Hort�ncia (H): %d\n\n", estoque[4]);
  voltarMenu();
}
void estoqueCrescente(int *estoque, char **nomes){

    int i, j, swap;
    char swap_names[15];
     
     for(i=0; i<5; i++){
        for(j=i; j<5; j++){
           if(estoque[i]>estoque[j]){
              swap = estoque[i]; strcpy(swap_names,nomes[i]);
              estoque[j] = estoque[i]; strcpy(nomes[j],nomes[i]);
              estoque[j] = swap; strcpy(nomes[j],swap_names);
           }
        }
     }

  printf("\nEstoque Crescente:\n\n");

  for(i=0; i<5; i++){
    printf("Item: %s\nEstoque:%d\n\n", nomes[i], estoque[i]);
  }
  voltarMenu();
}
void estoqueDecrescente(int *estoque, char **nomes)
{

  int i, j, swap;
    char swap_names[15];
     
     for(i=0; i<5; i++){
        for(j=i; j<5; j++){
           if(estoque[i]>estoque[j]){
              swap = estoque[i]; strcpy(swap_names,nomes[i]);
              estoque[j] = estoque[i]; strcpy(nomes[j],nomes[i]);
              estoque[j] = swap; strcpy(nomes[j],swap_names);
           }
        }
     }

  printf("\nEstoque Decrescente:\n\n");

  for(i=4; i>=0; i--){
    printf("Item: %s\nEstoque:%d\n\n", nomes[i], estoque[i]);
  }
  voltarMenu();

}


int cadastrarFlores(int *estoque)
{
  int x, y;
  
  for(x = 0; x < 5; x++)
  {
    if(x == 0)
    {
      printf("Digite a quantidade de Rosas no estoque: ");
      scanf("%d", &y);
      if(y < 0){
        printf("Infelizmente n�o � possivel colocar esta quantidade no estoque.\n");
        
        printf("Digite um novo valor: ");
        scanf("%d", &y);
      }
      estoque[x] = y;
    }
    else if(x == 1)
    {
      printf("Digite a quantidade de Margaridas no estoque: ");
      scanf("%d", &y);
      if(y < 0){
        printf("Infelizmente n�o � possivel colocar esta quantidade no estoque.\n");
        
        printf("Digite um novo valor: ");
        scanf("%d", &y);
      }
      estoque[x] = y;
    }
    else if(x == 2)
    {
      printf("Digite a quantidade de Cravos no estoque: ");
      scanf("%d", &y);
      if(y < 0){
        printf("Infelizmente n�o � possivel colocar esta quantidade no estoque.\n");
        
        printf("Digite um novo valor: ");
        scanf("%d", &y);
      }
      estoque[x] = y;
    }
    else if(x == 3)
    {
      printf("Digite a quantidade de Girassois no estoque: ");
      scanf("%d", &y);
      if(y < 0){
        printf("Infelizmente n�o � possivel colocar esta quantidade no estoque.\n");
        
        printf("Digite um novo valor: ");
        scanf("%d", &y);
      }
      estoque[x] = y;
    }
    else if(x == 4)
    {
      printf("Digite a quantidade de Hort�ncia no estoque: ");
      scanf("%d", &y);
      if(y < 0){
        printf("Infelizmente n�o � possivel colocar esta quantidade no estoque.\n");
        
        printf("Digite um novo valor: ");
        scanf("%d", &y);
      }
      estoque[x] = y;
    }
  }
  limpar;
  voltarMenu();
}
