#include <stdio.h>
int rev(int n,int temp){
    if(n==0){
        return temp;
    }
    temp=(temp*10)+(n%10);
    return rev(n/10,temp);
}
int main(){
    int n=1912;
    int w=rev(n,0);
    printf(w==n?"Palindrome":"Not Palindrome");
}