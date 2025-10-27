#include <stdio.h>
#include <string.h>
#define TP(a,b) a##b
#define convertToStr(s) #s
int main(){
  int valZ=20;
  printf("%d\n",TP(val,Z));
  printf("%s\n",convertToStr(Swayam));
  return 0;
}
