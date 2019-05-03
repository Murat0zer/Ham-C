
int main(void){
  print(fibo(5) + fact(3));
  print(fact(6));
  print(fibo(9));
  print(fibo(6));
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
     return fibo(b1) + fibo(b2);
}
int fact(int a) {
    if( a == 1) {
        return 1;
        }
    int newA = a - 1;
    return a * fact(newA);
}


int test(int a) {
    if(a == 2)
      return a;
    else
        return 5;
}

int myFunc(int a){

   return a;

}


