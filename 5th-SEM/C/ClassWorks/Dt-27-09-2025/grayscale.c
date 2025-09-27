#include <stdio.h>
int main(){
    int image[3][3];
    printf("Enter Pixel Values(0-255): \n");
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            scanf("%d",&image[i][j]);
        }
    }
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            printf("%d ",image[i][j]);
        }
        printf("\n");
    }
    return 0;
}