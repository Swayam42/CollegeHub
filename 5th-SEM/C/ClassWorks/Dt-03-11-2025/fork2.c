#include <stdio.h>
#include <unistd.h>
int main(){
pid_t pid=fork();
pid_t pid2=fork();
pid_t pid3=fork();
printf("hello PID: %d\n",getpid());
printf("hi PPID: %d\n",getppid());
return 0;
}
