#include "MatrixDisplay.h"

MatrixDisplayController c;

void setup() {
  
  c.init();
  c.setPixel(0,1, true);
  c.setPixel(0,3, true);
  c.setPixel(1,1, true);
  c.setPixel(1,4, true);
  c.setPixel(2,1, true);
  c.setPixel(2,3, true);
  c.setPixel(2,4, true);
  c.setPixel(2,5, true);
  c.setPixel(2,6, true);
  c.setPixel(3,1, true);
  c.setPixel(3,4, true);
  c.setPixel(4,2, true);
  c.setPixel(4,3, true);
}

void loop() {
  c.draw();
}

void drawH() {
  c.setPixel(0,0, true);
  c.setPixel(0,1, true);
  c.setPixel(0,2, true);
  c.setPixel(0,3, true);
  c.setPixel(0,4, true);
  c.setPixel(0,5, true);
  c.setPixel(0,6, true);

  c.setPixel(1,3, true);
  c.setPixel(2,3, true);
  c.setPixel(3,3, true);

  c.setPixel(4,0, true);
  c.setPixel(4,1, true);
  c.setPixel(4,2, true);
  c.setPixel(4,3, true);
  c.setPixel(4,4, true);
  c.setPixel(4,5, true);
  c.setPixel(4,6, true);
  c.draw();
}
void hi() {
    


}

