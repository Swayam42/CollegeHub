#include <stdio.h>
int main() {
    int mat[2][3] = {1,2,3,4,5,6};
    for(int i =0;i<2;i++){
        printf("Row %d : ",i);
        for(int j=0;j<3;j++) {
            printf("%d ",mat[i][j]);
        }
        printf("\n");
    }
    return 0;
}