#include <stdio.h>
int findMax(int a,int b,int c){
    int max=a;
    if(b>max){
        max=b;
    }if(c>max){
        max=c;
    }
    return max;
}
int findMin(int a,int b,int c){
    int min=a;
    if(b<min){
        min=b;
    }if(c<min){
        min=c;
    }
    return min;
}

int main(){
    int a=10,b=-3,c=90;
    printf("%d",findMax(a,b,c));
    printf("%d",findMin(a,b,c));
    return 0;
}