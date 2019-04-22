


struct MyStruct2 {
    string serhan = "BO$ ADAM";
    int a = 15;
};


int main(void){

    struct MyStruct {
        int a = 5;
        string s = "test";
        string b = "striiiiiiiing";
    };

    MyStruct structTest = { a = 12, s= "hehe" };

    structTest  = { s = "kes sesini serhan" };

    MyStruct2 structTest2 = { a = 1116 };

    print(structTest2.a + 3);
    print(structTest2.serhan + " STRUCT2");

    structTest2 = {serhan = "SERHAN HALA BO$ ADAM"};

    print(structTest2.serhan);

    structTest2.serhan = "BO$ YAPMA SERHAN";
    print(structTest2.serhan);

    print(structTest.s + "   qweqweqweqwe");
    print(structTest.b);

}
