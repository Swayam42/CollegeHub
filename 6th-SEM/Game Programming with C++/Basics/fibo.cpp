//write a prog to generate a fibo series

#include <iostream>
using namespace std;
int fibo(int n){
	if(n<=1){
	return n;	
	}
	return fibo(n-1)+fibo(n-2);
}
int main(){
int x;
cout << "Enter no. of terms : ";
cin >> x;
for(int i=0;i<x;i++){
	cout << fibo(i)<<" ";
}

return 0;
}
