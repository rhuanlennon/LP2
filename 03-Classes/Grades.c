#include <stdio.h>

typedef struct {
	int largura, altura;
	int qtdHorizontais,qtdVerticais;
} Grades;

void print(Grades* g){
	printf("Grades com %dpx de largura, %dpx de altura, %d divisores horizontais e %d divisores verticais \n", g->largura, g->altura, g->qtdHorizontais, g -> qtdVerticais);
}

void main(void){
	Grades g1 = {100, 100, 20, 20 };
	print(&g1);
}