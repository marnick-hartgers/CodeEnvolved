#include "MatrixDisplay.h"

MatrixDisplayController c;

bool animated = false;
bool animatedFrame = false;

void setup() {
  c.init();
<<<<<<< HEAD
  for(int x = 0; x < 5;x++){
      for(int y = 0; y < 7;y++){
      c.setPixel(x,y, (x+y) % 2 == 0);
    }
  }
  

}

void loop() {
  c.draw();
  delay(500);
=======
  setTimer(0, 2000, toggleAnimation);
  setTimer(1, 500, toggleHi);
}

void toggleAnimation() {  
  animated = !animated;
}

void offIcon() {
  c.setPixel(0,2, true);
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
  c.clear();
  maintainTimers();
  if (animated == false) {
    hi();
  } else { 
    offIcon();
  }
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
}

void drawI() {
  c.setPixel(2,0, true);
  c.setPixel(2,1, true);
  c.setPixel(2,2, true);
  c.setPixel(2,3, true);
  c.setPixel(2,4, true);
  c.setPixel(2,6, true);
}

void hi() {
  if (animatedFrame == false) {
    drawH();
  } else { 
    drawI(); 
  }
}

void toggleHi() {
  animatedFrame = !animatedFrame;
>>>>>>> d81c2e990c2bf932db1ae6eb38a326316c9694f4
}

