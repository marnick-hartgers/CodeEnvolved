#include "MatrixDisplay.h"

MatrixDisplayController c;

void setup() {
  
  c.init();
  for(int x = 0; x < 5;x++){
      for(int y = 0; y < 7;y++){
      c.setPixel(x,y, (x+y) % 2 == 0);
    }
  }
  

}

void loop() {
  c.draw();
  delay(500);
}
