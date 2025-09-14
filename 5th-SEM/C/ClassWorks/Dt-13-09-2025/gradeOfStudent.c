#include <stdio.h>
int main(){
    float s1,s2,s3,s4,s5,total,per;
    char grade;
    printf("Input Marks of 5 Subjects: ");
    scanf("%f %f %f %f %f",&s1,&s2,&s3,&s4,&s5);
    total=s1+s2+s3+s4+s5;
    per=(total/500)*100;
    
    if(per>90){
        grade='O';
    }else if(per>80 && per<=90){
        grade='A';
    }else if(per>70 && per<=80){
        grade='B';
    }else if(per>60 && per<=70){
        grade='C';
    }else if(per>50 && per<=60){
        grade='D';
    }else{
        grade='F';
    }
    printf("Total Marks: %.2lf \nPercentage: %.2lf%% \nGrade: %c",total,per,grade);
    return 0;

}