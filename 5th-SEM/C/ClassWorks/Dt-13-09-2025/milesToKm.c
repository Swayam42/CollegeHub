#include <stdio.h>
#define MILE_TO_KM 1.609
int main(){
    double mile,km;
    printf("Input miles: ");
    scanf("%lf", &mile);
    km=MILE_TO_KM*mile;
    printf("%.2lf miles = %.2lf kms\n", mile, km);
    return 0;
}