#include <stdio.h>
int main(){
    int n=7;
    for(int i=0;i<n;i++){
        char c='A';
        for(int j=0;j<n-i;j++){
            printf("%c",c+j);
        }
        for(int s=1;s<=2*i;s++){
            printf(" ");
        }
        for(int k=n-i-1;k>=0;k--){
            printf("%c",c+k);       
       }
        printf("\n");
    }
}
