#include <iostream>
using namespace std;
int main(){
    int arr1[]={1,2,3,4};
    int arr2[]={5,6,7,8};
    int n=sizeof(arr1)/sizeof(arr1[0]);
    int m=sizeof(arr2)/sizeof(arr2[0]);
    int merged[m+n];
    int i=0,j=0,k=0;
    while(i<n && j<m){
        if(arr1[i]<arr2[j]){
            merged[k++]=arr1[i++];
        }else{
            merged[k++]=arr2[j++];
        }
    }
    while(i<n){
        merged[k++]=arr1[i++];
    }
    while(j<m){
        merged[k++]=arr2[j++];
    }

    cout << "Merged Array: ";
    for(int i=0;i<n+m;i++){
        cout << merged[i] << " ";
    }
    return 0;
}