#include <stdio.h>
#include <unistd.h>
int main(){
pid_t pid=fork(); //creating a new process
if (pid==0){
 printf("Child Process\n");

}
else{
  printf("Parent Process\n");
}
return 0;	
}
