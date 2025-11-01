#include <stdio.h>

int main() {
    int rows, cols;

    printf("Enter number of rows: ");
    scanf("%d", &rows);
    printf("Enter number of columns: ");
    scanf("%d", &cols);

    int a[10][10], trans[10][10];

    printf("Enter elements of the matrix:\n");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            scanf("%d", (*(a + i) + j)); // using pointers
        }
    }

    // Transpose using pointers
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            *(*(trans + j) + i) = *(*(a + i) + j);
        }
    }

    // Display original matrix
    printf("\nOriginal matrix:\n");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("%d ", *(*(a + i) + j));
        }
        printf("\n");
    }

    // Display transpose
    printf("\nTranspose of the matrix:\n");
    for (int i = 0; i < cols; i++) {
        for (int j = 0; j < rows; j++) {
            printf("%d ", *(*(trans + i) + j));
        }
        printf("\n");
    }

    return 0;
}

