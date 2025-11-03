#include <stdio.h>
#include <unistd.h>
int main(){
printf("PID:%d\n",getpid());
printf("Parent PID:%d\n",getppid());
return 0;
}
