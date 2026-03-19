#include<iostream>
using namespace std;

class Test{
    public:
        Test()
            {cout<<"Construction called"; }
};
int main(){
    Test *t=new Test();
    return 0;
}
