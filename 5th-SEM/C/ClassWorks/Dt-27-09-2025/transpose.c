#include <stdio.h>
int main(){
    int mat[3][4];
    int trans[4][3];
    printf("Initialize Values (3x4): \n");
    for(int i=0;i<3;i++){
        for(int j=0;j<4;j++){
            scanf("%d",&mat[i][j]);
        }
    }
    for(int i=0;i<4;i++){
        for(int j=0;j<3;j++){
            trans[i][j]=mat[j][i];
        }
    }

    for(int i=0;i<4;i++){
        printf("Row %d : ",i);
        for(int j=0;j<3;j++){
            printf("%d ",trans[i][j]);
        }
        printf("\n");
    }
    return 0;
}