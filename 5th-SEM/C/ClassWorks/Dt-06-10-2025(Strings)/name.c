#include <stdio.h>
int main(){
  char name[20];
  printf("Input Your Name: ");
  scanf("%s",name);
  printf("Printed Using %%s: %s \n",name);

  char naam[10];
  printf("Input Your Name: ");
  for(int i=0;i<10;i++){
	scanf(" %c",&naam[i]);
  }
  printf("Printed Using %%c:");
  for(int i=0;i<10;i++){
	printf("%c",naam[i]);
  }
  
  return 0;
}
