#include <stdio.h>
int main(){
    int i;
    printf("Under which range your ritcher scale number falls: \n\
    1. n<5.0\n\
    2. 2.5.0<=n<5.5\n\
    3. 5.5<=n<6.5\n\
    4. 6.5<=n<7.5\n\
    5. n>=7.5\n\
    Enter your choice: ");
    scanf("%d",&i);
    switch (i)
    {
    case 1:
        printf("Little or No Damage");
        break;
    case 2:
        printf("Some damage");
        break;
    case 3:
        printf("Serious Damage");
        break;
    case 4:
        printf("Disastrous Effect");
        break;
    case 5:
        printf("Catastrophic Effect");
        break;
    default:
        printf("Invalid Input");
    }


}