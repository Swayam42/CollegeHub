#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/mman.h>

int isPrime(int n)
{
    if (n < 2) return 0;
    for (int i = 2; i * i <= n; i++)
        if (n % i == 0) return 0;
    return 1;
}

int main()
{
    int n;
    printf("Enter length of Fibonacci series: ");
    scanf("%d", &n);

    int *fib = mmap(NULL, n * sizeof(int),
                    PROT_READ | PROT_WRITE,
                    MAP_SHARED | MAP_ANONYMOUS, -1, 0);

    pid_t pid = fork();

    if (pid == 0) {
        fib[0] = 0;
        if (n > 1) fib[1] = 1;
        for (int i = 2; i < n; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
        _exit(0);
    } else {
        wait(NULL);

        printf("Fibonacci Series:\n");
        for (int i = 0; i < n; i++)
            printf("%d ", fib[i]);
        printf("\n");

        printf("Prime Fibonacci Numbers:\n");
        for (int i = 0; i < n; i++) {
            if (isPrime(fib[i]))
                printf("Prime %d at position %d\n", fib[i], i + 1);
        }
    }

    return 0;
}
