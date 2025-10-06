//write a prog in c to check given string is palindrome or not
#include <stdio.h>
#include <stdbool.h>
#include <string.h>
int main(){
    char str[10];
    bool pal=true;
    printf("Input first String: ");
    scanf("%s",str);
    int i=0,j=strlen(str) - 1;
    while(i<j){
	if(str[i] != str[j]){
	       pal=false;
	       break;    
	   }
	i++;
	j--;
    }
    if(pal){
    	printf("Palindrome");
    }else{
    	printf("Not Palindrome");
	}
    
    
    return 0;
}

