#include <stdio.h>
int main()
{
int ivar=1234;
printf(":%*d:\n",10,ivar);
printf(":%-*d:\n",10,ivar);
return 0;
}

/*
:      1234:
:1234      :
*/