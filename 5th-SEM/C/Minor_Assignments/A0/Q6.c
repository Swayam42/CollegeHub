#include <stdio.h>
int main(){
    float side,area;
    printf("Input Side: ");
    scanf("%f",&side);
    area=side*side;
    printf("The area of a square whose side length is %.2f cm is %.2f square cm",side,area);
}