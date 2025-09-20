#include <stdio.h>
int main(){
    int x,y;
    printf("Input x coordinate: ");
    scanf("%d",&x);
    printf("Input y coordinate: ");
    scanf("%d",&y);
    if(x>0 && y>0){
        printf("Quadrant I");
    }else if(x<0 && y>0){
        printf("Quadrant II");
    }else if(x<0 && y<0){
        printf("Quadrant III");
    }else if(x>0 && y<0){
        printf("Quadrant IV");
    }else{
        printf("Origin");
    }
    return 0;
}