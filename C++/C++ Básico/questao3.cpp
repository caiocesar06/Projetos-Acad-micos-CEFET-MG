/*
    INTEGRANTES DO GRUPO:
        1 - Caio César Nascimento da Silva
        2 - Felipe Augusto do Nascimento
        3 - Thayllon Ryan Bragança de Almeida
*/

#include<iostream>

using namespace std;

int main()
{
    int escolha, i = 0, j;
    
    cout << "Digite um numero impar: " << endl;
    cin >> escolha;

    if(escolha % 2 == 0)
    {
        cout << "Numero invalido!";
        cout << endl;
    }
    else{ 

    for(i; i <= (escolha/2); i++)
    {
        j = i + 1;
        for(j ; j <= escolha - i; j++)
        {
            cout << j;
        }

        cout << endl;

        for(j = 0; j < i+1; j++)
            cout << " ";
        }
    }
    return 0;
}