
int tempo = 500;

void setup() {
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  digitalWrite(8, LOW);
  digitalWrite(9, LOW);
  digitalWrite(10, LOW);
}

void loop() {
  fecha();
  delay(tempo);
  abre();
  delay(tempo);
}

void fecha(){
  digitalWrite(9, LOW);
  digitalWrite(10, LOW); 
  delay(100); 
  digitalWrite(8, HIGH);
  delay(tempo); 
  digitalWrite(8, LOW);
}

void abre(){
  digitalWrite(9, HIGH);
  digitalWrite(10, HIGH); 
  delay(100); 
  digitalWrite(8, HIGH);
  delay(tempo); 
  digitalWrite(8, LOW);
  delay(100);
  digitalWrite(9, LOW);
  digitalWrite(10, LOW);
}
