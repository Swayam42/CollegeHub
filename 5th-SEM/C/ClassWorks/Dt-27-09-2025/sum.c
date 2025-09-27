#include <stdio.h>
int main(){
    int mat[3][4];
    int sum=0;
    printf("Initialize Values: \n");
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            scanf("%d",&mat[i][j]);
        }
    }
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            sum+=mat[i][j];
        }
        
    }
    printf("Sum of all elements: %d",sum);
    return 0;
}