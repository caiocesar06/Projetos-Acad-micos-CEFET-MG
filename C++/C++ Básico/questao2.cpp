/*
    INTEGRANTES DO GRUPO:
        1 - Caio César Nascimento da Silva
        2 - Felipe Augusto do Nascimento
        3 - Thayllon Ryan Bragança de Almeida
*/

#include <iostream>

#define MAX 50

using namespace std;


int main() {   
    int numeroVetor[MAX], variavelAux, cont, i;

    cout << "Quantos valores deseja escrever?" << endl << "R: ";
    cin >> cont;
    
    cout << endl << "Digite os valores: " << endl;
    
    for(i = 0; i < cont; i++)
    {   
        numeroVetor[i] = 0;
    }
    
    for(i = 0; i < cont; i++){
        cin >> numeroVetor[i];
    }
    
    i = 0;
    
    while(i != cont){
        if(numeroVetor[i] > numeroVetor[i+1]){
            variavelAux = numeroVetor[i];
            numeroVetor[i] = numeroVetor[i+1];
            numeroVetor[i+1] = variavelAux;
            if(i!=0){
                i--;
            }
        }else{
            i++;
        }
    }
    
    for(i = 0; i<cont; i++){
        cout << endl << numeroVetor[i] << endl;
        
    }

    return 0;
}