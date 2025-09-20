#include <stdio.h>
#include <ctype.h>
int main(){
    char in;
    printf("Input first letter of color: ");
    scanf("%c",&in);
    in=tolower(in);
    switch(in){
        case 'o':
            printf("Ammonia");
            break;
        case 'y':
            printf("Hydrogen");
            break;
        case 'b':
            printf("Carbon Monoxide");
            break;
        case 'g':
            printf("Oxygen");
            break;
        default:
            printf("Invalid Input");
    }
}