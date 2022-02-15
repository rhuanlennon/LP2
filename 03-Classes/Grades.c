#include <stdio.h>

typedef struct {
	float largura, altura;
	int qtdHorizontais,qtdVerticais;
} Grades;

void print(Grades* g){
	printf("Grades com %.1f px de largura, %.1f px de altura, %d divisores horizontais e %d divisores verticais \n", g->largura, g->altura, g->qtdHorizontais, g -> qtdVerticais);
}

void main(void){
	Grades g1 = {150.5, 120.6, 20, 20 };
	print(&g1);
}