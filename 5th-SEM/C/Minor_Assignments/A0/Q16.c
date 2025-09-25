#include <stdio.h>
int main()
{
char line[]="hexadecimal";
printf(":%10s: :%15s: :%15.5s: :%.5s:\n",line,line,line,line);
return 0;
}
/*
:hexadecimal: :    hexadecimal: :          hexad: :hexad:
*/