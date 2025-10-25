#include <stdio.h>
//Recursion Method
int gcd(int a,int b){
    if(a<b){
        return gcd(b,a);
    }else if(b==0){
        return a;
    }else if(a>b){
        return gcd(b,a%b);
    }
}
//Iterative Method
int gcdM2(int a,int b){
    while(a%b!=0){
        int rem=a%b;
        a=b;
        b=rem;
    }
    return b;
}
int main(){
    printf("%d",gcd(12,18));
    printf("%d",gcdM2(12,18));
}