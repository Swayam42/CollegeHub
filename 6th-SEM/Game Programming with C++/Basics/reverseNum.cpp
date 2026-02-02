//write a prog to reverse an input integer
#include <iostream>
using namespace std;
int main(){
int num;
cout << "Enter an integer: ";
cin >> num;
int rev=0;
while(num!=0){
	rev=rev*10+(num%10);
	num/=10;
}
cout <<"Reverse: " <<rev;

return 0;
}
