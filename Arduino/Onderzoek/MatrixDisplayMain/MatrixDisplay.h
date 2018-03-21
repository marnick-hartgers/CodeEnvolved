struct MatrixDisplayController {
  int firLatch = 2;//ROW
  int firClock = 4;
  int firData = 6;
  int secLatch = 3;//COL
  int secClock = 5;
  int secData = 7;

  byte colIndex = 0;

  byte data[7];

  void init() {
    pinMode(firLatch, OUTPUT);
    pinMode(firClock, OUTPUT);
    pinMode(firData, OUTPUT);
    pinMode(secLatch, OUTPUT);
    pinMode(secClock, OUTPUT);
    pinMode(secData, OUTPUT);
  }

  void draw() {
    digitalWrite(firLatch, LOW);
    digitalWrite(secLatch, LOW);
    //shiftOut(secData, secClock, MSBFIRST, );
    shiftOut(firData, firClock, MSBFIRST, data[colIndex]);
    shiftOut(secData, secClock, MSBFIRST, (B00000001 << colIndex) ^ B11111111);
    
    digitalWrite(firLatch, HIGH);
    digitalWrite(secLatch, HIGH);
    delay(3);
    colIndex++;
    if(colIndex == 7){
      colIndex = 0;
    }
  }

  void clear() {
    data[0] = 0;
    data[1] = 0;
    data[2] = 0;
    data[3] = 0;
    data[4] = 0;
    data[5] = 0;
    data[6] = 0;
  }

  void setPixel(byte row, byte col, boolean on) {
    if (on) {
      byte d = data[col];
      bitSet( d, row);
      data[col] = d;
    } else {
      bitSet(row, data[col]);
    }

  }

};

