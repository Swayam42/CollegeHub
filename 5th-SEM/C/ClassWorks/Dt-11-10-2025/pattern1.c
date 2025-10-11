#include <stdio.h>
int main(){
    int n=7;
    for (int i=1;i<=n;i++){
       char c='A';
       for(int j=0;j<i;j++){
            printf("%c",c+j);             
       }
       printf("\n");
    }
}
/*
A
AB
ABC
ABCD
ABCDE
ABCDEF
ABCDEFG
*/