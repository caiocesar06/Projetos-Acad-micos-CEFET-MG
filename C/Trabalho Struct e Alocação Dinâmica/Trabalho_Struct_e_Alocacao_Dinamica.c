/*-------------------------------------------------------------------------------
            LABORATÓRIO DE LINGUAGEM E TÉCNICAS DE PROGRAMAÇÃO

Info-2

Membros do grupo:                       Objetivo:
    Artur Borges Corrêa                      Trabalho em grupo de até 3 pessoas.
    Caio César Nascimento Silva             Desenvolver um programa capaz de
    Felipe Augusto do Nascimento            auxiliar uma loja de manutenção de
                                            computadores, utilizando Struct e
                                            Alocação Dinâmica.
-------------------------------------------------------------------------------*/

//Incluir biblioteca
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>

//Facilita para limpar o terminal
#define limpar system("cls");

//Varável global que Conta quantas vezes o Código da OS foi registrado
int cc = 0;

//Definimos algumas variaveis em estrutura
typedef struct 
{
    int codigoOs; //Define o cód da OS
    int tiposServico[4]; //Cadastra a OS
    int dias; //Calcula quantos dias serão necessários
    float valorTotal; //Calcula o Valor total
    int statusOs; //Verifica se a OS já foi iniciada e etc
    int statusPag; //Verifica se o cliente pagou ou não o serviço
    char nomeCliente[64]; //Recolhe o nome do cliente
    //Outras variáveis que podem ser inseridas depois
}OrdemServico;

//Funções utilizadas
void menuPrincipal(OrdemServico *os); //Mostra o MENU principal
void registrarOs(OrdemServico *os); //Cadastra as OS
void vizualizarOS(OrdemServico *os); //Visualiza os dados das OS


//Utilizado para fazer o MALLOC para formatar a linguagem e para iniciar o MENU
int main()
{   
    int i, j;

    setlocale(LC_ALL, "pt-br||Portuguese");

    OrdemServico *os = (OrdemServico *)malloc(sizeof(OrdemServico));

    //Igualar todos os valores a 0
    for(i = 0; i <= cc; i ++)
    {   
        os[i].codigoOs = 0;
        for(j = 0; j < 4; j ++)
            os[i].tiposServico[j] = 0;
        os[i].dias = 0;
        os[i].valorTotal = 0.00;
        os[i].statusOs = 0;
        os[i].statusPag = 0;
        os[i].nomeCliente[64] = NULL;
    }

    menuPrincipal(os);

    return 0;
}

//Mostra o Menu e direciona o cliente
void menuPrincipal(OrdemServico *os)
{
    int escolhaMenu;

    fflush(stdin);
    limpar;
    do
    {
        printf("\n\n\t*********************************************************\n");
	    printf("\t*   Bem vindo a loja de computadores do seu João!       *\n");
	    printf("\t*                                                       *\n");
	    printf("\t*   Escolha dentre as opções abaixo:                    *\n");
	    printf("\t*   1 - Vizualizar as funcionalidades                   *\n");
	    printf("\t*   2 - Fornecer serviços                               *\n");
	    printf("\t*   3 - Sair                                            *\n");
        printf("\t*********************************************************\n");
        scanf("%d", &escolhaMenu);

        switch(escolhaMenu)
        {
        case 1:
            limpar;
            //Executar a função Vizualizar
            vizualizarOS(os);
                break;

        case 2:
            limpar;
            //Executar a função de registrar uma Ordem de Serviço
            registrarOs(os);
                break;

        case 3:
            limpar;
            //Caso o cliente escolha sair
            printf("Você escolheu sair!\n\nAté mais o/\n\n");
            exit(0);
                break;
        
        default: //Caso o cliente digite uma resposta inválida 
            printf("\n\nPor favor, digite uma opção válida!\n");
            printf("\nAperte ENTER para voltar ao menu...");
            fflush(stdin);
            getchar();
                break;
        }
    }while(escolhaMenu < 0 || escolhaMenu > 3);
}

//Menu de visualizações
void vizualizarOS(OrdemServico *os)
{
    //Variaveis de auxilio
    int i, x, codOs;
    char stServ[4][64], stOs[64], stPg[64];
    float totalPago;
    do //Para não sair do menu enquanto o cliente não solicitar
    {
        limpar;

        printf("\n\n                     Menu de visualizações:                     \n\n");
        printf("****************************************************************\n");
        printf("*      1 || Ordens de serviço                                  *\n");
        printf("*      2 || Ordens de serviço pagas                            *\n");
        printf("*      3 || Serviço que estão aguardando pagamento             *\n");
        printf("*      4 || Serviços que ainda não foram iniciados             *\n");
        printf("*      5 || Serviços em execução                               *\n");
        printf("*      6 || Serviços finalizados                               *\n");
        printf("*      7 || Serviços finalizados que ainda não foram pagos     *\n");
        printf("*      8 || Buscar uma Ordem de Serviço                        *\n");
        printf("*      9 || Valor total dos serviços pagos                     *\n");
        printf("*     10 || Valor total dos serviços pagos e não pagos         *\n");
        printf("*     11 || Sair do Sistema                                    *\n");
        printf("****************************************************************\n\n");
    
        printf("Selecione uma opção: ");
        scanf("%d", &x);

        //Defini as opções que o cliente pode pedir
        for(i = 0; i < 4; i ++)
        {
            if(os[cc - 1].tiposServico[0] == 1)
                strcpy(stServ[0], "Formatacao com backup");
            if(os[cc - 1].tiposServico[1] == 1)
                strcpy(stServ[1], "Formatacao sem backup");
            if(os[cc - 1].tiposServico[2] == 1)
                strcpy(stServ[2], "Troca de pecas");
            if(os[cc - 1].tiposServico[3] == 1)
                strcpy(stServ[3], "Limpeza e manutencao");
            else strcpy(stServ[i], " ");
        }

        //Define o Status da OS
        if(os[cc - 1].statusOs == 1)
            strcpy(stOs, "Nao iniciado");
        if(os[cc - 1].statusOs == 2)
            strcpy(stOs, "Servico em execucao");
        if(os[cc - 1].statusOs == 3)
            strcpy(stOs, "Servico finalizado");

        //Define o Status do pagamento da OS
        if(os[cc - 1].statusPag == 1)
            strcpy(stPg, "Aguardando pagamento");
        if(os[cc - 1].statusPag == 2)
            strcpy(stPg, "Servico pago");
        

        //Recolhe a escolha do cliente e o direciona
        switch(x)
        {
            case 1: //Mostra a OS completa
                limpar;
                printf("Código da %dª Ordem de Serviço: %d\n\n", cc, os[cc - 1].codigoOs);
                printf("Tipos de serviços: %s, %s, %s, %s\n\n", stServ[0], stServ[1], stServ[2], stServ[3]);//servicos
                printf("Dias necessários: %d\n\n", os[cc - 1].dias);
                printf("Valor total: R$%.2f\n\n", os[cc - 1].valorTotal);
                printf("Nome do cliente: %s\n\n", os[cc - 1].nomeCliente);
                printf("Status da ordem de serviço: %s\n\n", stOs);//status os
                printf("Status de pagamento: %s\n\n", stPg);//status pagamento
                fflush(stdin);
                getchar();
                    break;
            case 2: //Mostra todas as OS pagas
                for(i = 0; i <= cc; i ++)
                {
                    if(os[cc - 1].statusPag == 2)
                    {
                        limpar;
                        printf("Código da %dª Ordem de Serviço: %d\n\n", cc, os[cc - 1].codigoOs);
                        printf("Tipos de serviços: %s, %s, %s, %s\n\n", stServ[0], stServ[1], stServ[2], stServ[3]);//servicos
                        printf("Dias necessários: %d\n\n", os[cc - 1].dias);
                        printf("Valor total: R$%.2f\n\n", os[cc - 1].valorTotal);
                        printf("Nome do cliente: %s\n\n", os[cc - 1].nomeCliente);
                        printf("Status da ordem de serviço: %s\n\n", stOs);//status os
                        printf("Status de pagamento: %s\n\n", stPg);//status pagamento
                    }
                }
                fflush(stdin);
                getchar();
                    break;
            case 3: //Mostra todas as OS que ainda não foram pagas
                for(i = 0; i <= cc; i ++)
                {
                    if(os[cc - 1].statusPag == 1)
                    {
                        limpar;
                        printf("Código da %dª Ordem de Serviço: %d\n\n", cc, os[cc - 1].codigoOs);
                        printf("Tipos de serviços: %s, %s, %s, %s\n\n", stServ[0], stServ[1], stServ[2], stServ[3]);//servicos
                        printf("Dias necessários: %d\n\n", os[cc - 1].dias);
                        printf("Valor total: R$%.2f\n\n", os[cc - 1].valorTotal);
                        printf("Nome do cliente: %s\n\n", os[cc - 1].nomeCliente);
                        printf("Status da ordem de serviço: %s\n\n", stOs);//status os
                        printf("Status de pagamento: %s\n\n", stPg);//status pagamento
                    }
                }
                fflush(stdin);
                getchar();
                    break;
            case 4: //Mostra os serviços que ainda não foram iniciados
                for(i = 0; i <= cc; i ++)
                {
                    if(os[cc - 1].statusOs == 1)
                    {
                        limpar;
                        printf("Código da %dª Ordem de Serviço: %d\n\n", cc, os[cc - 1].codigoOs);
                        printf("Tipos de serviços: %s  %s  %s  %s\n\n", stServ[0], stServ[1], stServ[2], stServ[3]);//servicos
                        printf("Dias necessários: %d\n\n", os[cc - 1].dias);
                        printf("Valor total: R$%.2f\n\n", os[cc - 1].valorTotal);
                        printf("Nome do cliente: %s\n\n", os[cc - 1].nomeCliente);
                        printf("Status da ordem de serviço: %s\n\n", stOs);//status os
                        printf("Status de pagamento: %s\n\n", stPg);//status pagamento
                    }
                }
                fflush(stdin);
                getchar();
                    break;
            case 5: //Mostra os serviços em execução
                for(i = 0; i <= cc; i ++)
                {
                    if(os[cc - 1].statusOs == 2)
                    {
                        limpar;
                        printf("Código da %dª Ordem de Serviço: %d\n\n", cc, os[cc].codigoOs);
                        printf("Tipos de serviços: %s, %s, %s, %s\n\n", stServ[0], stServ[1], stServ[2], stServ[3]);//servicos
                        printf("Dias necessários: %d\n\n", os[cc - 1].dias);
                        printf("Valor total: R$%.2f\n\n", os[cc - 1].valorTotal);
                        printf("Nome do cliente: %s\n\n", os[cc - 1].nomeCliente);
                        printf("Status da ordem de serviço: %s\n\n", stOs);//status os
                        printf("Status de pagamento: %s\n\n", stPg);//status pagamento
                    }
                }
                fflush(stdin);
                getchar();
                    break;
            case 6: // Mostra os serviços finalizados
                for(i = 0; i <= cc; i ++)
                {
                    if(os[cc - 1].statusOs == 3)
                    {
                        limpar;
                        printf("Código da %dª Ordem de Serviço: %d\n\n", cc, os[cc - 1].codigoOs);
                        printf("Tipos de serviços: %s, %s, %s, %s\n\n", stServ[0], stServ[1], stServ[2], stServ[3]);//servicos
                        printf("Dias necessários: %d\n\n", os[cc - 1].dias);
                        printf("Valor total: R$%.2f\n\n", os[cc - 1].valorTotal);
                        printf("Nome do cliente: %s\n\n", os[cc - 1].nomeCliente);
                        printf("Status da ordem de serviço: %s\n\n", stOs);//status os
                        printf("Status de pagamento: %s\n\n", stPg);//status pagamento
                    }
                }
                fflush(stdin);
                getchar();
                    break;
            case 7: //Mostra os serviços finalizados mas que ainda não foram pagos
                for(i = 0; i <= cc; i ++)
                {
                    if(os[cc - 1].statusOs == 3)
                    {
                        limpar;
                        printf("Código da %dª Ordem de Serviço: %d\n\n", cc, os[cc - 1].codigoOs);
                        printf("Tipos de serviços: %s, %s, %s, %s\n\n", stServ[0], stServ[1], stServ[2], stServ[3]);//servicos
                        printf("Dias necessários: %d\n\n", os[cc - 1].dias);
                        printf("Valor total: R$%.2f\n\n", os[cc - 1].valorTotal);
                        printf("Nome do cliente: %s\n\n", os[cc - 1].nomeCliente);
                        printf("Status da ordem de serviço: %s\n\n", stOs);//status os
                        printf("Status de pagamento: %s\n\n", stPg);//status pagamento
                    }
                }
                fflush(stdin);
                getchar();
                    break;
            case 8: // Efetua uma Busca de uma Ordem de Serviço
                limpar;
                printf("Digite o código da OS: ");
                scanf("%d", &codOs);
                
                for(i = 0; i <= cc; i ++)
                {
                    if(codOs == os[cc - 1].codigoOs)
                    {
                        limpar;
                        printf("Código da %dª Ordem de Serviço: %d\n\n", cc, os[cc - 1].codigoOs);
                        printf("Tipos de serviços: %s, %s, %s, %s\n\n", stServ[0], stServ[1], stServ[2], stServ[3]);//servicos
                        printf("Dias necessários: %d\n\n", os[cc - 1].dias);
                        printf("Valor total: R$%.2f\n\n", os[cc - 1].valorTotal);
                        printf("Nome do cliente: %s\n\n", os[cc - 1].nomeCliente);
                        printf("Status da ordem de serviço: %s\n\n", stOs);//status os
                        printf("Status de pagamento: %s\n\n", stPg);//status pagamento
                    }
                }
                fflush(stdin);
                getchar();
                    break;
            case 9: //Mostra o valor total dos serviços pagos
                limpar;
                for(i = 0; i <= cc; i ++)
                {
                    if(os[cc - 1].statusPag == 2)
                        totalPago == os[i].valorTotal;
                }
                printf("\n\n\nO valor total: R$%.2f!\n\n", totalPago);
                fflush(stdin);
                getchar();
                    break;
            case 10:
                printf("\n\n\nO valor total: R$%.2f!\n\n", os[cc - 1].valorTotal);
                fflush(stdin);
                getchar();
                    break;
            case 11:
                limpar;
                printf("Você escolheu sair desse sistema!\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~  Voltando ao menu  ~~~~~~~~~~~~~~~~~~~~~~~~~~\n\nPressione ENTER para continuar...");
                fflush(stdin);
                getchar();
                menuPrincipal(os);
                    break;
            default: 
                printf("\n\nPor favor, digite uma opção válida!\n");
                printf("\nAperte ENTER para voltar ao menu...");
                fflush(stdin);
                getchar();
                    break;
        }
    }while(x > 0 || x < 11);    
}

//Cadstra uma Ordem de Serviço
void registrarOs(OrdemServico *os)
{   
    //Variáveis de auxílio
    int i = 0;
    char nome[64];

    printf("Digite o código da Ordem de Serviço: (6 digitos)\n");
    scanf("%d", &os[cc].codigoOs);

    do{//Repetir apartir daqui caso o usuário digite uma opção inválida
        limpar;
        
        printf("\n\n                       Selecione os serviços desejados:                      \n\n");
        printf("*****************************************************************************\n");
        printf("*   1 || Formatação com backup-------------------------R$50,00 e 2 dias     *\n");
        printf("*   2 || Formatação sem backup-------------------------R$40,00 e 1 dia      *\n");
        printf("*   3 || Troca de peças (HD, memória RAM, tela, etc.)--R$30,00 e 10 dias    *\n");
        printf("*   4 || Limpeza e manutenção básica-------------------R$100,00 e 7 dias    *\n");
        printf("*****************************************************************************\n\n");
        printf("Digite:\n0 - Não quero esse serviço\n1 - Quero esse serviço\n");
        
        for(i = 0; i < 4;i++)
        {
            printf("\nServiço %d: ", i + 1);
            fflush(stdin);
            scanf("%d", &os[cc].tiposServico[i]);

            if(os[cc].tiposServico[i] != 0 && os[cc].tiposServico[i] != 1)//Caso insira um valor diferente de 0 e 1
            {
                limpar;
                printf("\nEscolha uma opção válida!\n\nDigite:\n0 - Não quero esse serviço\n1 - Quero esse serviço\n\n\nPressione ENTER para inserir os dados   novamente...");
                fflush(stdin);
                getchar();
                    break;
            }
            if(os[cc].tiposServico[0] == 1 && os[cc].tiposServico[1] == 1)//Para não gerar conflito, caso escolha formatacao com e sem backup
            {   
                limpar;
                printf("\nVocê pode escolher somente um dos tipos de formatação, COM ou SEM backup!\n\nPressione ENTER para inserir os dados novamente...\n\n");
                fflush(stdin);
                getchar();
                    break;
            }
        }        
    }while(os[cc].tiposServico[0] == 1 && os[cc].tiposServico[1] == 1 || os[cc].tiposServico[0] != 0 && os[cc].tiposServico[0] != 1 || os[cc].tiposServico[1] != 0 && os[cc].tiposServico[1] != 1 || os[cc].tiposServico[2] != 0 && os[cc].tiposServico[2] != 1 || os[cc].tiposServico[3] != 0 && os[cc].tiposServico[3] != 1);

    os[cc].dias = 0;//Zerando os valores de dia

/*------------------  Somar a quantidade de dias  --------------------------*/
    if(os[cc].tiposServico[0] == 1)
        os[cc].dias += 2;
    if(os[cc].tiposServico[1] == 1)
        os[cc].dias += 1;
    if(os[cc].tiposServico[2] == 1)
        os[cc].dias += 10;
    if(os[cc].tiposServico[3] == 1)
        os[cc].dias += 7;

    for(i = 0; i <= cc; i ++)
        os[cc].valorTotal = 0;//zerando os valores do Valor Total

/*------------------  Somar a quantidade de valores  --------------------------*/
    if(os[cc ].tiposServico[0] == 1)
        os[cc].valorTotal += 50.00;
    if(os[cc].tiposServico[1] == 1)
        os[cc].valorTotal += 40.00;
    if(os[cc].tiposServico[2] == 1)
        os[cc].valorTotal += 30.00;
    if(os[cc].tiposServico[3] == 1)
        os[cc].valorTotal += 100.00;
    
    limpar;

/*------------------  Ler o nome  --------------------------*/
    printf("Digite o nome do cliente (sem acento): ");
    gets(os[cc].nomeCliente);

    do{//Caso o usuário selecione uma opção inválida
        limpar;
        
        printf("\n\n  Selecione o status da ordem de serviço:  \n\n");
        printf("*******************************************\n");
        printf("*       1 || Não iniciado                 *\n");
        printf("*       2 || Serviço em execução          *\n");
        printf("*       3 || Serviço finalizado           *\n");
        printf("*******************************************\n\n\n");
        printf("Sua escolha: ");
        scanf("%d", &os[cc].statusOs);
    }while(os[cc].statusOs < 1 || os[cc].statusOs > 3);

    do{//Caso o usuário selecione uma opção inválida
        limpar;

        printf("            Status de pagamento:            \n\n");
        printf("*********************************************\n");
        printf("*         1 || Aguardando pagamento         *\n");
        printf("*         2 || Serviço Pago                 *\n");
        printf("*********************************************\n\n\n");

        printf("Sua escolha: "); 
        scanf("%d", &os[cc].statusPag);
    }while(os[cc].statusPag < 1 || os[cc].statusPag > 2);
    cc++;//Incrementar a variável global
    menuPrincipal(os);
}