#include <stdio.h>
int main()
{
float x=123.456;
printf("%f %.3f %.1f %.0f\n",x,x,x,x);
printf("%e %.5e %.3e %.0e\n",x,x,x,x);
return 0;
}
/*
123.456001 123.456 123.5 123
1.234560e+02 1.23456e+02 1.235e+02 1e+02
*/