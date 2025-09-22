#include <stdio.h>
int main(){
    int arr[10];
    printf("Input 10 Elements: \n");
    for(int i=0;i<10;i++){
        scanf("%d",&arr[i]);
    }
    printf("Even elements: ");
    for(int i=0;i<10;i++){
        if(arr[i]%2==0){
            printf("%d ",arr[i]);
        }
    }
    return 0;
}