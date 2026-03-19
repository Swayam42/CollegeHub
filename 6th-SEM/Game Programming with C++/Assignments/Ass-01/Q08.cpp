#include <iostream>
using namespace std;
class MyClass{
    public:
        ~MyClass(){
            cout<<"My destructor"<<endl;
        }
    };
void main(){
        MyClass obj;
        obj.~MyClass();
    }