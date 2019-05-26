
struct MyStruct {
    int a = 6;
    string b;
   };

int main(void){
  MyStruct struct_1 = { b = "Test" };

  print(fibo(5) + fact(3));
  print(fact(6));
  print(fibo(9));
  print(fibo(6));

  print(fact(struct_1.a));

  int x = 3;
  switchTest(x);
}
int fibo(int a) {
    if( a == 1) {
        return 1;
    }
    if( a == 0) {
     return 0;
     }
      int b1 = a - 1;
      int b2 = a - 2;
     return fibo(a - 1) + fibo(a - 2);
}
int fact(int a) {
    if( a == 1) {
        return 1;
        }
    return a * fact(a - 1);
}

void switchTest(int a) {

    switch(a) {
        case 1:
           print("1. durum");
        case 2:
           print("2. durum");
        case 3:
           print("3. durum");

        default :
            print("default calisti");
    }
}


