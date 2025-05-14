#include <stdio.h>
#include <math.h>

// Assembly function declarations
extern int add_asm(int, int);
extern int sub_asm(int, int);
extern int mul_asm(int, int);
extern int div_asm(int, int);
extern int mod_asm(int, int);
extern int pow_asm(int, int);
extern int fact_asm(int);
extern int sqrt_asm(int);
// The following are for floating-point, so use float as argument and return type
extern float sin_asm(float);
extern float cos_asm(float);
extern float log_asm(float);
extern float exp_asm(float);

void flush_input() {
    int ch;
    while ((ch = getchar()) != '\n' && ch != EOF);
}

void print_menu() {
		printf("\n--- Scientific Calculator ---\n");
    printf("1. Addition (a + b)\n");
    printf("2. Subtraction (a - b)\n");
    printf("3. Multiplication (a * b)\n");
    printf("4. Division (a / b)\n");
    printf("5. Modulo (a %% b)\n");
    printf("6. Power (a ^ b)\n");
    printf("7. Factorial (n!)\n");
    printf("8. Square Root (sqrt(n))\n");
    printf("9. Sine (sin(x)) [Radians]\n");
    printf("10. Cosine (cos(x)) [Radians]\n");
    printf("11. Logarithm (log(x)) [Natural log]\n");
    printf("12. Exponential (exp(x)) [e^x]\n");
    printf("0. Exit\n");
    printf("----------------------------\n");
    printf("Enter your choice: ");
}

int main(void) {
    int choice=1;
    int a=2, b=5, n, result;
    float x, fres;

    while (1) {
        print_menu();
        if (scanf("%d", &choice) != 1) {
            printf("Invalid input! Please enter a number.\n");
            flush_input();
            continue;
        }
        if (choice == 0) {
            printf("Exiting calculator.\n");
            break;
        }

        switch (choice) {
            case 1: // Addition
                printf("Enter two integers: ");
                if (scanf("%d %d", &a, &b) != 2) {
                    printf("Invalid input!\n"); flush_input(); break;
                }
                result = add_asm(a, b);
                printf("%d + %d = %d\n", a, b, result);
                break;
            case 2: // Subtraction
                printf("Enter two integers: ");
                if (scanf("%d %d", &a, &b) != 2) {
                    printf("Invalid input!\n"); flush_input(); break;
                }
                result = sub_asm(a, b);
                printf("%d - %d = %d\n", a, b, result);
                break;
            case 3: // Multiplication
                printf("Enter two integers: ");
                if (scanf("%d %d", &a, &b) != 2) {
                    printf("Invalid input!\n"); flush_input(); break;
                }
                result = mul_asm(a, b);
                printf("%d * %d = %d\n", a, b, result);
                break;
            case 4: // Division
                printf("Enter two integers: ");
                if (scanf("%d %d", &a, &b) != 2) {
                    printf("Invalid input!\n"); flush_input(); break;
                }
                if (b == 0) {
                    printf("Error: Division by zero!\n");
                } else {
                    result = div_asm(a, b);
                    printf("%d / %d = %d\n", a, b, result);
                }
                break;
            case 5: // Modulo
                printf("Enter two integers: ");
                if (scanf("%d %d", &a, &b) != 2) {
                    printf("Invalid input!\n"); flush_input(); break;
                }
                if (b == 0) {
                    printf("Error: Modulo by zero!\n");
                } else {
                    result = mod_asm(a, b);
                    printf("%d %% %d = %d\n", a, b, result);
                }
                break;
            case 6: // Power
                printf("Enter base and exponent (integers): ");
                if (scanf("%d %d", &a, &b) != 2) {
                    printf("Invalid input!\n"); flush_input(); break;
                }
                result = pow_asm(a, b);
                printf("%d ^ %d = %d\n", a, b, result);
                break;
            case 7: // Factorial
                printf("Enter a non-negative integer: ");
                if (scanf("%d", &n) != 1 || n < 0) {
                    printf("Invalid input! n must be >= 0\n"); flush_input(); break;
                }
                result = fact_asm(n);
                printf("%d! = %d\n", n, result);
                break;
            case 8: // Square Root
                printf("Enter a non-negative integer: ");
                if (scanf("%d", &n) != 1 || n < 0) {
                    printf("Invalid input! n must be >= 0\n"); flush_input(); break;
                }
                result = sqrt_asm(n);
                printf("sqrt(%d) ˜ %d\n", n, result);
                break;
            case 9: // Sine
                printf("Enter x (in radians): ");
                if (scanf("%f", &x) != 1) {
                    printf("Invalid input!\n"); flush_input(); break;
                }
                fres = sin_asm(x);
                printf("sin(%.4f) = %.6f\n", x, fres);
                break;
            case 10: // Cosine
                printf("Enter x (in radians): ");
                if (scanf("%f", &x) != 1) {
                    printf("Invalid input!\n"); flush_input(); break;
                }
                fres = cos_asm(x);
                printf("cos(%.4f) = %.6f\n", x, fres);
                break;
            case 11: // Logarithm
                printf("Enter x (> 0): ");
                if (scanf("%f", &x) != 1 || x <= 0) {
                    printf("Invalid input! x must be > 0\n"); flush_input(); break;
                }
                fres = log_asm(x);
                printf("log(%.4f) = %.6f\n", x, fres);
                break;
            case 12: // Exponential
                printf("Enter x: ");
                if (scanf("%f", &x) != 1) {
                    printf("Invalid input!\n"); flush_input(); break;
                }
                fres = exp_asm(x);
                printf("exp(%.4f) = %.6f\n", x, fres);
                break;
            default:
                printf("Invalid choice! Please try again.\n");
        }
    }
    return 0;
}
