#include <stdio.h>
int main(){
    int n=7;
    for (int i=n;i>0;i--){
       char c='A';
       for(int j=i-1;j>=0;j--){
            printf("%c",c+j);
       }
       printf("\n");
       
       
    }
}

/*
GFEDCBA
FEDCBA
EDCBA
DCBA
CBA
BA
A
 */
