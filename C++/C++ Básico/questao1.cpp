/*
    INTEGRANTES DO GRUPO:
        1 - Caio César Nascimento da Silva
        2 - Felipe Augusto do Nascimento
        3 - Thayllon Ryan Bragança de Almeida
*/

#include<iostream>
#include<windows.h>

using namespace std;

int main()
{
    SetConsoleOutputCP(CP_UTF8);

    int capacidadeMax, quantPessoas;

    inicioCapacidadeMax:
    cout << "Digite a capacidade máxima de pessoas na sala: ";
    cin >> capacidadeMax;

    if(capacidadeMax < 0)
    {
        cout << "\nValor INVÁLIDO, insira novamente...";
        setbuf(stdin, NULL);
        getchar();
        system("cls");
        goto inicioCapacidadeMax;
    }
    
    inicioQuantPessoas:
    cout << endl << "Digite a quantidadede pessoas presentes na sala: ";
    cin >> quantPessoas;

    if(quantPessoas < 0)
    {
        cout << "\nValor INVÁLIDO, insira novamente...";
        setbuf(stdin, NULL);
        getchar();
        system("cls");
        cout << "Digite a capacidade máxima de pessoas na sala: " << capacidadeMax << endl;
        goto inicioQuantPessoas;
    }

    if(quantPessoas <= capacidadeMax)
        cout << "\nMuito bem!" << endl
             << "A conferência está de acordo com as normas legais!" << endl
             << "Um total de " << capacidadeMax - quantPessoas << " pessoa(s) podem entrar na conferência.";
    else
        cout << "\nSUA CONFERÊNCIA É UM ERRO!!!" << endl
             << "A conferência NÃO está  nem um pouco de acordo com as normas legais!" << endl
             << "Um total de " << -1 * (capacidadeMax - quantPessoas) << " pessoa(s) devem sair."; 
             
    cout << endl << endl;
    return 0;
}