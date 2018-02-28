

void setup() {
  Serial.begin(9600);
}

void loop() {
  serialSendString(0x1,"hello");
  delay(3000);
}
