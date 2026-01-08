#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main()
{
    pid_t pid;
    int i = 5;

    pid = vfork();

    if (pid == 0) {              // Child process
        printf("Child: %d\n", i);
        _exit(0);                // Mandatory with vfork
    } else {                     // Parent process
        i = i + 1;
        printf("Parent: %d\n", i);
    }

    return 0;
}
