#include <stdio.h>
int main(){
    int mat[3][4];
    printf("Initialize Values: \n");
    for(int i=0;i<3;i++){
        for(int j=0;j<4;j++){
            scanf("%d",&mat[i][j]);
        }
    }
    for(int i=0;i<3;i++){
        printf("Row %d : ",i);
        for(int j=0;j<4;j++){
            printf("%d ",mat[i][j]);
        }
        printf("\n");
    }
    return 0;
}