#include <stdio.h>
#define MATH_PI 3.14
int main(){
    double r,area;
    printf("Input radius of Circle: ");
    scanf("%lf", &r);
    area=MATH_PI*r*r;
    printf("Area of circle with r = %.2lf is %.2lf sq.units ",r,area);
    return 0;

}