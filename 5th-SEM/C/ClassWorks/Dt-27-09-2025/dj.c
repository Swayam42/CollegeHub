#include <stdio.h>
int main(){
    int mat[3][4];
    printf("Initialize Values: \n");
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            scanf("%d",&mat[i][j]);
        }
    }
    for(int i=0;i<3;i++){
        for(int j=0;j<4;j++){
            if(i==2&&j==3)
                printf("%d",mat[i][j]);
            else
                printf("%d, ",mat[i][j]);
        }
    }
    return 0;
}