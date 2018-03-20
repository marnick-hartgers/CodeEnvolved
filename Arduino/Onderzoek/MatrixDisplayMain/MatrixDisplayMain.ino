#include "MatrixDisplay.h"

MatrixDisplayController c;

void setup() {
  
  c.init();
  c.setPixel(0,0, true);
  c.setPixel(0,1, true);
  c.setPixel(1,2, true);
  c.setPixel(2,3, true);
  c.setPixel(3,4, true);

  c.setPixel(4,5, true);
  c.setPixel(4,6, true);
}

void loop() {
  c.draw();
}
