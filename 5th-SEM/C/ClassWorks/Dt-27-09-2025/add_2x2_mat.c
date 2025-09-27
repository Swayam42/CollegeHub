#include <stdio.h>
int main(){
    int mat1[2][2];
    printf("Initialize Values of mat1: \n");
    for(int i=0;i<2;i++){
        for(int j=0;j<2;j++){
            scanf("%d",&mat1[i][j]);
        }
    }
    int mat2[2][2];
    printf("Initialize Values of mat1: \n");
    for(int i=0;i<2;i++){
        for(int j=0;j<2;j++){
            scanf("%d",&mat2[i][j]);
        }
    }
    int sum[2][2];
    for(int i=0;i<2;i++){
        for(int j=0;j<2;j++){
            sum[i][j]=mat1[i][j]+mat2[i][j];
        }
    }

    for(int i=0;i<2;i++){
        for(int j=0;j<2;j++){
            printf("%d ",sum[i][j]);
        }
        printf("\n");
    }
    return 0;
}