//write a prog to reverse an array
#include <iostream>
using namespace std;
int main(){
int arr[]={1,2,3,4,5};
int n=sizeof(arr)/sizeof(arr[0]);
for (int i=0;i<n/2;i++){
        int temp=arr[i];
        arr[i]=arr[n-1-i];
        arr[n-1-i]=temp;
    }
for(int i=0;i<n;i++){
	cout << arr[i]<<" "	;
}
return 0;
}
