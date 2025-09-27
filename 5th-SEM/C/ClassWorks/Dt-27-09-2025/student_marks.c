#include <stdio.h>
int main(){
    int marks[5][3];
    printf("Enter Marks Of 5 students\n");
    for(int i=0;i<5;i++){
        printf("For Student %d- \n",i);
        for(int j=0;j<3;j++){
            printf("Enter Mark for Sub %d: ",j);
            scanf("%d",&marks[i][j]);
        }
    }
    for(int i=0;i<5;i++){
        printf("Student %d\n",i);
        for(int j=0;j<3;j++){
            printf("Sub %d: %d, ",j,marks[i][j]);
        }printf("\n");
    }
    return 0;

}