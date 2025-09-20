#include <stdio.h>

int main(){
    float height,weight,bmi;
    printf("Input height(inch): ");
    scanf("%f",&height);
    printf("Input Weight(kg): ");
    scanf("%f",&weight);
    weight=2.20*weight;
    bmi=(703*weight)/(height*height);
    printf("BMI = %f : ",bmi);
    if(bmi>=0 && bmi<18.5){
        printf("Underweight");
    }else if(bmi>=18.5 && bmi<24.9){
        printf("Normal");
    }else if(bmi >=25.0 && bmi<29.9){
        printf("OverWeight");
    }else{
        printf("Obese");
    }
    return 0;
}
