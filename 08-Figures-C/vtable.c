#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect* this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}


///////////////////////////////////////////////////////////////////////////////
typedef struct {
    Figure super;
    int w, h;
    int xpoints[5];
    int ypoints[5];
} Polygon;

void Polygon_print (Polygon* this) {
    Figure* sup = (Figure*) this;
    printf("Polígono de tamanho (%d,%d) na posicao (%d,%d). ",
           this->w, this->h, sup->x, sup->y);
    printf("Com os pontos: ");
    for (int i=0; i<5; i++) {
    	printf("(%d, %d)", this->xpoints[i], this->ypoints[i]);
	}
	printf("\n");
}

Polygon*polygon_new (int x, int y, int w, int h) {
    Polygon* this = malloc(sizeof(Polygon));
    Figure* sup = (Figure*) this;
    sup-> print = (Figure_Print) Polygon_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    
    this->xpoints[0] = (x + w/2);
    this->xpoints[1] = x + w;
    this->xpoints[2] = (x + w*0.50);
    this->xpoints[3] = (x + w*0.30);
    this->xpoints[4] = x;
    
    this->ypoints[0] = y;
    this->ypoints[1] = (y + h*0.40);
    this->ypoints[2] = y+h;
    this->ypoints[3] = y+h;
    this->ypoints[4] = (y + h*0.40);
}

///////////////////////////////////////////////////////////////////////////////
void main (void) {
    Figure* figs[6] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) polygon_new(100,150,130,140),
        (Figure*) polygon_new(200,200,353,353)
    };

    ///

    for (int i=0; i<6; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (int i=0; i<6; i++) {
        free(figs[i]);
    }
}