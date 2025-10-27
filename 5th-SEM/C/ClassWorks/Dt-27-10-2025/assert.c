#include <stdio.h>
#define NDEBUG
#include <assert.h>
#define pf printf
int main(){
  int x;
  pf("Enter x: ");
  scanf("%d",&x);
  assert(x>=0);
  return 0;
}
