/*write a prog in c to find no. of vowels and consonants 
 and convert the vowels to lowerCase
*/
#include <stdio.h>
#include<string.h>
int main(){
   char str[]="INDIA";
   int v=0,c=0;
   for(int i=0;i<strlen(str)-1;i++){
      if(str[i]=='A'||str[i]=='E'||str[i]=='I'||str[i]=='O'||str[i]=='U'){
	  v++;
	  str[i]+=32;
	}
       else if(str[i]=='a'||str[i]=='e'||str[i]=='i'||str[i]=='o'||str[i]=='u'){
	  v++;
	  str[i]-=32;
	}
       else{
	c++;
	}
   }
   
   printf("Converted String: %s \nNo. Of Vowels: %d \nNO. of Consonants: %d ",str,v,c);
   
    
    return 0;
}


