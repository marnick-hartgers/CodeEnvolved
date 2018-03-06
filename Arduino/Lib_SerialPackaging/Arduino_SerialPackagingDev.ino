

void setup() {
  Serial.begin(9600);
}

void loop() {
  serialSendString(0x1,"hello");
  serialSendChar(0x2,'T');
  serialSendByte(0x3,255);
  serialSendInt(0x4,1024);
  delay(3000);
}
