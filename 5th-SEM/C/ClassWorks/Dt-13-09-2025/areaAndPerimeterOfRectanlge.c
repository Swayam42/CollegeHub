#include <stdio.h>
int main(){
    double l,b,area,peri;
    printf("Enter the length and breadth of rectangle: ");
    scanf("%lf %lf",&l,&b);
    area=l*b;
    peri=2*(l+b);
    printf("Area: %.2f sq.units \nPerimeter: %.2f units",area,peri);
    return 0;
}