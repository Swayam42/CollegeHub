//write a prog to sum all digits of an integer
#include <iostream>
using namespace std;
int main(){
int num;
int t;
cout << "Enter an integer: ";
cin >> num;
t=num;
int sum=0;
while(num!=0){
	sum+=num%10;
	num/=10;
}
cout <<"Sum of digits of " <<t <<":" <<sum;

return 0;
}
