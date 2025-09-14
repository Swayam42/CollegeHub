#include <stdio.h>
int main(){
    int x;
    printf("Input an Integer: ");
    scanf("%d",&x);
    if(x%2==0){
        printf("%d is Even",x);
    }else{
        printf("%d is Odd",x);
    }
    return 0;
}