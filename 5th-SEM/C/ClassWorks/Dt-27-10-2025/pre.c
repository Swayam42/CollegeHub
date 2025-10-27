#include <stdio.h>
#define qty 10
#define pf printf
int main(){
  float rate=1.5;
  #ifdef qty 
     float amount= qty*rate;
     pf("%f",amount);
  #undef qty
  #endif
  return 0;
}
