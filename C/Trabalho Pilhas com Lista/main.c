/*--------------------------------------------------------------------------------
						THE SAMUKINHA'S LIBRARY PROJECT
--------------------------------------------------------------------------------*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <locale.h>
#include "samuka.h"		// é uma piada rs

int main(void)
{	
	//setlocale(LC_ALL, "Portuguese");
  	bs *s1 = (bs*) malloc(sizeof(bs));

  	if(s1 == NULL){
        printf("Erro de alocação da pilha");
        exit(0);
    }else{
        Menu();
    }
}