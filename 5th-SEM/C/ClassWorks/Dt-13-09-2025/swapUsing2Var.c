#include <stdio.h>
int main(){
    int x,y;
    printf("Input 2 Numbers: ");
    scanf("%d%d",&x,&y);
    printf("Before Swapping: x=%d y=%d\n",x,y);
    x=x+y;
    y=x-y;
    x=x-y;
    printf("After Swapping: x=%d y=%d",x,y);
}