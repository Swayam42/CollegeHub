#include <stdio.h>
#include <stdlib.h>

int main() {
    int *ptr = malloc(2 * sizeof(int));
    ptr[0] = 10;
    ptr[1] = 20;
    ptr = realloc(ptr, 4 * sizeof(int));
    ptr[2] = 30;
    ptr[3] = 40;
    for (int i = 0; i < 4; i++)
        printf("%d ", ptr[i]);
    free(ptr);
    return 0;
}

