#include <stdio.h>
int main(){
    int n,d;
    int sum=0;
    printf("Input n: ");
    scanf("%d",&n);
    int temp=n;
    while(n>0){
        d=n%10;
        printf("%d ",d);
        sum=sum+d;
        n=n/10;
    }
    if(sum % 9 == 0){
        printf("\n%d is divisible by 9",temp);
    }else{
        printf("\n%d is not divisible by 9",temp);
    }
    return 0;
}