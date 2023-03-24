/*-------------------------------------------------------

Trabalho de pilha - Professor Robson LTPI

Caio César
João Peixoto
Thayllon Ryan

Alunos de Informatica 2 - 1 Modulo

Uma loja de manutenção de computadores.

-------------------------------------------------------*/

/*Importando bibliotecas*/
#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

/*Define*/
#define limpar system("cls");
#define max 10

/*Declarando funções importantes e criando fila*/
typedef struct pilha Pilha;

struct pilha
{
    int topo;
    int v[max];
};

/*Função menu, do qual vai orientar o usuário*/
void menu();

/*Funcao responsável por criar as pilhas*/
Pilha* criar();

/*Function responsável por empilhar*/
void push(Pilha* , int);

/*Função responsável por desempilhar*/
int pop(Pilha*);

/*Funçõo responsável por inverter as pilha*/
Pilha* inverte_pilha_element(Pilha*);

/*Função responsável por imprimir as peças por peças a ser montada*/
void exibe_montar(Pilha*);

/*Função responsável para sair do programa*/
void sair();

/*Função responsável pela desmontagem de peças do computador*/
void desmontar();


int main()
{
    setlocale(LC_ALL, "Portuguese");

    menu();

    return 0;
}

void menu()
{   
    int opcMenu;

    do{
        limpar;

        printf(" ---------------------------------------------------- \n");
        printf("|                                                    |\n");
        printf("|    El Mantenimiento de las Computadoras Peitoxo    |\n");
        printf("|                                                    |\n");
        printf("|                                                    |\n");
        printf("| 1 - Desmontar o computador                         |\n");
        printf("|                                                    |\n");
        printf("| 2 - Sair                                           |\n");
        printf("|                                                    |\n");
        printf(" ---------------------------------------------------- \n");
        printf("\n\n  Sua escolha: ");
        scanf("%d", &opcMenu);

        switch(opcMenu)
        {
            case 1:
                desmontar();
                    break;
            case 2:
                sair();
                    break;
            default:
                printf("\n\nOPÇÃO INVÁLIDA!\n");
                printf("\n\nPressione ENTER para continuar...");
                fflush(stdin);
                getchar();
                    break;
        }
    }while(opcMenu != 2);
}

void desmontar()
{
    
    Pilha *p = criar();
    int valor;

    limpar;
    printf(" ----------------------------------- \n");
    printf("|                                   |\n");
    printf("|          TABELA DE PEÇAS          |\n");
    printf("|                                   |\n");
    printf("|                                   |\n");
    printf("| 1 - Placa Mâe                     |\n");
    printf("| 2 - Processador                   |\n");
    printf("| 3 - Memória RAM                   |\n");
    printf("| 4 - Placa de Vídeo                |\n");
    printf("| 5 - Teclado                       |\n");
    printf("| 6 - Bateria                       |\n");
    printf("| 7 - Tela                          |\n");
    printf("| 8 - Carcaça                       |\n");
    printf("| 9 - Trackpad                      |\n");
    printf("| 10 - Placa Wi-fi                  |\n");
    printf("|                                   |\n");
    printf(" ----------------------------------- \n");
	printf("\n");
    printf("\nDigite qual será a ordem da desmontagem do Computador:\n");
    for(int i = 0; i < max; i++){
        scanf("%d",&valor);
        push(p, valor);
    }
    
    limpar;
    exibe_montar(p);
}

Pilha* criar(){
    Pilha *p = (Pilha*) malloc(sizeof(Pilha));
    p->topo = 0;
    return p;
}

void push(Pilha*p, int valor){
    
    if(p->topo == max){
        printf("Você ja retirou todas as peças");
    }else{
        p->v[p->topo] = valor;
        p->topo++;
    }    
}

int pop(Pilha *p)
{
    if(p->topo == 0){
		printf("Pilha está vazia!");
	}else{
		int aux;
		p->topo--;
		aux = p -> v[p->topo];
		return aux;	
	}
}

Pilha* inverte_pilha_element(Pilha *p)
{
	int i, j;
	Pilha *p2 = criar();
	int aux = 0, aux2 = max;
	p2 -> topo = p->topo;
	do{
		p2->v[aux] = p -> v[aux2-1];
		aux++;
		aux2--;
	}while(aux2 > 0);
	
	return p2;
}

void exibe_montar(Pilha *p)
{
	int peca_atl;
	int i = max-1;
	char opc;
	int aux;

    if( p->topo == 0){
        printf("\n\nA pilha está vazia, nem uma peça desmontada!");
        printf("\nPressione ENTER para voltar ao menu...");
        fflush(stdin);
        getchar();
	    menu();
    }else{
	    do{
            limpar;
            printf(" ----------------------------------- \n");
            printf("|                                   |\n");
            printf("|          TABELA DE PEÇAS          |\n");
            printf("|                                   |\n");
            printf("|                                   |\n");
            printf("| 1 - Placa Mâe                     |\n");
            printf("| 2 - Processador                   |\n");
            printf("| 3 - Memória RAM                   |\n");
            printf("| 4 - Placa de Vídeo                |\n");
            printf("| 5 - Teclado                       |\n");
            printf("| 6 - Bateria                       |\n");
            printf("| 7 - Tela                          |\n");
            printf("| 8 - Carcaça                       |\n");
            printf("| 9 - Trackpad                      |\n");
            printf("| 10 - Placa Wi-fi                  |\n");
            printf("|                                   |\n");
            printf(" ----------------------------------- \n");
            printf("\n");
            printf("Montar a peça: ");
            scanf("%d", &peca_atl);
            printf("\n");
            
            
            if(peca_atl != p -> v[i]){
                
                    if(peca_atl == 1){
                        printf("\n");
                        printf("A peça Placa Mâe está na sequência incorreta ou não existe, deseja ver qual é a proxima? (s/n)");
                    }
                    else if(peca_atl == 2){
                        printf("\n");
                        printf("A peça Processador está na sequência incorreta ou não existe, deseja ver qual é a proxima? (s/n)");
                    }
                    else if(peca_atl == 3){
                        printf("\n");
                        printf("A peça Memória RAM está na sequência incorreta ou não existe, deseja ver qual é a proxima? (s/n)");
                    }
                    else if(peca_atl == 4){
                        printf("\n");
                        printf("A peça Placa de Vídeo está na sequência incorreta ou não existe, deseja ver qual é a proxima? (s/n)");
                    }
                    else if(peca_atl == 5){
                        printf("\n");
                        printf("A peça Teclado está na sequência incorreta ou não existe, deseja ver qual é a proxima? (s/n)");
                    }
                    else if(peca_atl == 6){
                        printf("\n");
                        printf("A peça Bateria está na sequência incorreta ou não existe, deseja ver qual é a proxima? (s/n)");
                    }
                    else if(peca_atl == 7){
                        printf("\n");
                        printf("A peça Tela está na sequência incorreta ou não existe, deseja ver qual é a proxima? (s/n)");
                    }
                    else if(peca_atl == 8){
                        printf("\n");
                        printf("A peça Carcaça está na sequência incorreta ou não existe, deseja ver qual é a proxima? (s/n)");
                    }
                    else if(peca_atl == 9){
                        printf("\n");
                        printf("A peça Trackpad está na sequência incorreta ou não existe, deseja ver qual é a proxima? (s/n)");
                    }
                    else if(peca_atl == 10){
                        printf("\n");
                        printf("A peça Placa Wi-fi está na sequência incorreta ou não existe, deseja ver qual é a proxima? (s/n)");
                    }
                    scanf(" %c", &opc);

                if(opc == 's'){
                    if(p->v[i] == 1){
                        printf("\nA próxima peça a ser montada é a peça: Placa Mâe ");
                        printf("\n");
                    }
                    else if(p->v[i] == 2){
                        printf("\nA próxima peça a ser montada é a peça: Processador");
                        printf("\n");
                    }
                    else if(p->v[i] == 3){
                        printf("\nA próxima peça a ser montada é a peça: Memória RAM");
                        printf("\n");
                    }
                    else if(p->v[i] == 4){
                        printf("\nA próxima peça a ser montada é a peça: Placa de Vídeo");
                        printf("\n");
                    }
                    else if(p->v[i] == 5){
                        printf("\nA próxima peça a ser montada é a peça: Teclado");
                        printf("\n");
                    }
                    else if(p->v[i] == 6){
                        printf("\nA próxima peça a ser montada é a peça: Bateria");
                        printf("\n");
                    }
                    else if(p->v[i] == 7){
                        printf("\nA próxima peça a ser montada é a peça: Tela");
                        printf("\n");
                        }
                        else if(p->v[i] == 8){
                            printf("\nA próxima peça a ser montada é a peça: Carcaça");
                            printf("\n");
                        }
                        else if(p->v[i] == 9){
                            printf("\nA próxima peça a ser montada é a peça: Trackpad");
                            printf("\n");
                        }
                        else if(p->v[i] == 10){
                            printf("\nA próxima peça a ser montada é a peça: Placa Wi-fi");
                            printf("\n");
                        }
                    }
		    }else{
			    aux = pop(p);
			    if(aux == 1){
				    printf("A peça Placa Mâe foi montado");
				    printf("\n");
			    }
			    else if(aux == 2){
				    printf("A peça Processador foi montado");
				    printf("\n");
			    }
			    else if(aux == 3){
				    printf("A peça Memória RAM foi montado");
				    printf("\n");
			    }
			    else if(aux == 4){
			    	printf("A peça Placa de Vídeo foi montado");
			    	printf("\n");
			    }
			    else if(aux == 5){
			    	printf("A peça Teclado foi montado");
			    	printf("\n");
			    }
			    else if(aux == 6){
			    	printf("A peça Bateria foi montado");
			    	printf("\n");
			    }
			    else if(aux == 7){
			    	printf("A peça Tela foi montado");
			    	printf("\n");
			    }
			    else if(aux == 8){
				    printf("A peça Carcaça foi montado");
				    printf("\n");
			    }
			    else if(aux == 9){
				    printf("A peça Trackpad foi montado");
				    printf("\n");
			    }
			    else if(aux == 10){
				    printf("A peça Placa Wi-fi foi montado");
				    printf("\n");
			    }
    
			    i--;
		    }
		
		    printf("\n\n\n\nPressione qualquer ENTER para seguir....");
		    fflush(stdin);
		    getchar();
		    limpar;
	    }while (i >= 0);
	    printf("\n");
	    printf("O computador já esta completamente montado, parabéns!\n\n");
	    printf("\n\nPressione qualquer ENTER para continuar....");
        fflush(stdin);
	    getchar();
    }
}

void sair()
{
    limpar;
    printf("\n\tPressione ENTER para sair...");
    fflush(stdin);
    getchar();
    limpar;
    exit(0);
}