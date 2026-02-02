//write a prog to read and print all elements of an array
#include <iostream>
using namespace std;
int main(){
int arr[]={1,2,3,4,5};
for (int i=0;i<sizeof(arr)/sizeof(arr[0]);i++){
	cout << arr[i] <<" ";
}

return 0;
}
