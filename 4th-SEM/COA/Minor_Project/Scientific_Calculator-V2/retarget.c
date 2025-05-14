#include "ARMCM4.h"
#include <stdio.h>

// UART0 base address for ARMCM4 (usually 0x4000C000)
#define UART0_BASE 0x4000C000
#define UART0_DR   (*((volatile unsigned int *)(UART0_BASE + 0x00)))
#define UART0_FR   (*((volatile unsigned int *)(UART0_BASE + 0x18)))

struct __FILE { int handle; };
FILE __stdout;
FILE __stdin;

int fputc(int ch, FILE *f) {
    // Wait until UART0 is ready to transmit
    while (UART0_FR & (1 << 5)); // TXFF (Transmit FIFO Full)
    UART0_DR = (ch & 0xFF);
    return ch;
}
