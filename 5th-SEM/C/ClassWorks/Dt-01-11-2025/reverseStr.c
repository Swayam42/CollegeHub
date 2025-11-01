//write a program in C to reverse a string using pointer create a function that takes strings's base address and reverse it 
#include <stdio.h>
void reverseString(char *str){
  char *start=str;
  char *end=str;
  
  while(*end !='\0'){
    end++;
  }
  end--;
  while(start<end){
    char temp=*start;
    *start=*end;
    *end=temp;
    start++;
    end--;
  }
}
int main (void){
char str[100];
printf("Enter a string: ");
scanf("%s",&str);
reverseString(str);
printf("After reversing: %s\n", str);
return 0;
}

