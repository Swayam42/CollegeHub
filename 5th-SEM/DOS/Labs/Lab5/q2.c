#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

sem_t odd, even;

void* printOdd(void* arg)
{
    for (int i = 1; i <= 19; i += 2) {
        sem_wait(&odd);
        printf("%d\n", i);
        sem_post(&even);
    }
    return NULL;
}

void* printEven(void* arg)
{
    for (int i = 2; i <= 20; i += 2) {
        sem_wait(&even);
        printf("%d\n", i);
        sem_post(&odd);
    }
    return NULL;
}

int main()
{
    pthread_t t1, t2;
    sem_init(&odd, 0, 1);
    sem_init(&even, 0, 0);

    pthread_create(&t1, NULL, printOdd, NULL);
    pthread_create(&t2, NULL, printEven, NULL);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);
    return 0;
}
