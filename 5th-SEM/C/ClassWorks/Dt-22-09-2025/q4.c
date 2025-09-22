#include <stdio.h>
int main(){
    int arr[10];
    printf("Input 5 Elements: \n");
    for(int i=0;i<5;i++){
        scanf("%d",&arr[i]);
    }
    printf("In Reverse Order: ");
    for(int i=5-1;i>=0;i--){
        printf("%d ",arr[i]);
        
    }
    return 0;
}