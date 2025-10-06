//find the first occurence of a character in a string
#include <stdio.h>
#include <string.h>
int main(){
    char st[]="BANANA";
    char s='A';
    int flag=0;
    for(int i=0;i<strlen(st);i++){
    	if(st[i]==s){
    	    printf("First Occurence: %c",i);
    	    break;
    	 }else{
    	   printf("Not Found");
    	 }
    }
    return 0;
}

