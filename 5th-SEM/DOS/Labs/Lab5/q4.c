#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

sem_t down, up;

void* countdown(void* arg)
{
    for (int i = 10; i >= 1; i--) {
        sem_wait(&down);
        printf("Down: %d\n", i);
        sem_post(&up);
    }
    return NULL;
}

void* countup(void* arg)
{
    for (int i = 1; i <= 10; i++) {
        sem_wait(&up);
        printf("Up: %d\n", i);
        sem_post(&down);
    }
    return NULL;
}

int main()
{
    pthread_t t1, t2;
    sem_init(&down, 0, 1);
    sem_init(&up, 0, 0);

    pthread_create(&t1, NULL, countdown, NULL);
    pthread_create(&t2, NULL, countup, NULL);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);
    return 0;
}
