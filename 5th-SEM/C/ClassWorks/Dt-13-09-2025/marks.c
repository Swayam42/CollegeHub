#include <stdio.h>
int main(){
    float sub1,sub2,sub3,sub4,sub5,total,per;
    printf("Input marks of 5 subjects: ");
    scanf("%f %f %f %f %f",&sub1,&sub2,&sub3,&sub4,&sub5);
    total=sub1+sub2+sub3+sub4+sub5;
    per=(total/500)*100;
    printf("Total Marks Secured: %.2f \nPercentage: %.2f%%",total,per);
    return 0;

}