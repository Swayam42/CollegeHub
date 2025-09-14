#include <stdio.h>
int main(){
    int x,y,temp;
    printf("Enter 2 Numbers: ");
    scanf("%d%d",&x,&y);
    printf("Before Swapping: x=%d y=%d \n",x,y);
    temp=x;
    x=y;
    y=temp;
    printf("After Swapping: x=%d y=%d ",x,y);
    return 0;
}