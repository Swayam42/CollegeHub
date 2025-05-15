        PRESERVE8                      ; Ensure 8-byte stack alignment (required for ARM EABI)
        AREA    |.text|, CODE, READONLY ; Define a code section named .text, read-only

        ; Export function names so they are visible to the linker and other files
        EXPORT  add_asm
        EXPORT  sub_asm
        EXPORT  mul_asm
        EXPORT  div_asm
        EXPORT  mod_asm
        EXPORT  pow_asm
        EXPORT  fact_asm
        EXPORT  sqrt_asm
        EXPORT  sin_asm
        EXPORT  cos_asm
        EXPORT  tan_asm
        EXPORT  log_asm
        EXPORT  exp_asm

        ; Import math library functions for floating-point operations (from C stdlib)
        EXTERN  sinf
        EXTERN  cosf
        EXTERN  tanf
        EXTERN  logf
        EXTERN  expf

;-----------------------------------------------------------
; int add_asm(int a, int b)
; R0 = a, R1 = b; returns a + b in R0
;-----------------------------------------------------------
add_asm
        ADD     R0, R0, R1         ; R0 = R0 + R1 (add a and b)
        BX      LR                 ; Return to caller

;-----------------------------------------------------------
; int sub_asm(int a, int b)
; R0 = a, R1 = b; returns a - b in R0
;-----------------------------------------------------------
sub_asm
        SUB     R0, R0, R1         ; R0 = R0 - R1 (subtract b from a)
        BX      LR                 ; Return to caller

;-----------------------------------------------------------
; int mul_asm(int a, int b)
; R0 = a, R1 = b; returns a * b in R0
;-----------------------------------------------------------
mul_asm
        MUL     R0, R0, R1         ; R0 = R0 * R1 (multiply a and b)
        BX      LR                 ; Return to caller

;-----------------------------------------------------------
; int div_asm(int a, int b)
; R0 = a, R1 = b; returns a / b in R0
; If b == 0, returns 0 to avoid division by zero
;-----------------------------------------------------------
div_asm
        CMP     R1, #0             ; Compare b (R1) to 0
        BEQ     div_zero           ; If b==0, branch to div_zero
        SDIV    R0, R0, R1         ; R0 = R0 / R1 (signed division)
        BX      LR                 ; Return to caller
div_zero
        MOV     R0, #0             ; R0 = 0 (return zero if divide by zero)
        BX      LR                 ; Return to caller

;-----------------------------------------------------------
; int mod_asm(int a, int b)
; R0 = a, R1 = b; returns a % b in R0
; If b == 0, returns 0 to avoid division by zero
;-----------------------------------------------------------
mod_asm
        CMP     R1, #0             ; Compare b (R1) to 0
        BEQ     mod_zero           ; If b==0, branch to mod_zero
        SDIV    R2, R0, R1         ; R2 = R0 / R1 (quotient)
        MLS     R0, R2, R1, R0     ; R0 = R0 - (R2 * R1) (remainder)
        BX      LR                 ; Return to caller
mod_zero
        MOV     R0, #0             ; R0 = 0 (return zero if modulo by zero)
        BX      LR                 ; Return to caller

;-----------------------------------------------------------
; int pow_asm(int base, int exp)
; R0 = base, R1 = exponent; returns base^exp in R0
;-----------------------------------------------------------
pow_asm
        PUSH    {R4, LR}           ; Save R4 and return address on stack
        MOV     R2, R0             ; R2 = base (copy base to R2)
        MOV     R3, R1             ; R3 = exponent (copy exp to R3)
        MOV     R0, #1             ; R0 = 1 (initialize result)
        CMP     R3, #0             ; If exponent == 0...
        BEQ     pow_done           ; ...result is 1, skip loop
pow_loop
        MUL     R0, R0, R2         ; R0 *= base (multiply result by base)
        SUBS    R3, R3, #1         ; Decrement exponent (R3 = R3 - 1)
        BNE     pow_loop           ; If exponent != 0, repeat loop
pow_done
        POP     {R4, LR}           ; Restore R4 and return address
        BX      LR                 ; Return to caller

;-----------------------------------------------------------
; int fact_asm(int n)
; R0 = n; returns n! in R0
;-----------------------------------------------------------
fact_asm
        PUSH    {R1, R2, LR}       ; Save R1, R2, and return address on stack
        MOV     R1, R0             ; R1 = n (copy n to R1)
        MOV     R0, #1             ; R0 = 1 (initialize result)
        CMP     R1, #0             ; If n == 0...
        BEQ     fact_done          ; ...result is 1, skip loop
fact_loop
        MUL     R0, R0, R1         ; R0 *= R1 (multiply result by n)
        SUBS    R1, R1, #1         ; Decrement n (R1 = R1 - 1)
        BNE     fact_loop          ; If n != 0, repeat loop
fact_done
        POP     {R1, R2, LR}       ; Restore R1, R2, and return address
        BX      LR                 ; Return to caller

;-----------------------------------------------------------
; int sqrt_asm(int n)
; R0 = n; returns approximate sqrt(n) in R0
; (Basic iterative method, not very accurate)
;-----------------------------------------------------------
sqrt_asm
        PUSH    {R1, R2, LR}       ; Save R1, R2, and return address
        MOV     R1, R0             ; R1 = n (copy n to R1)
        CMP     R1, #0             ; If n == 0...
        BEQ     sqrt_done          ; ...result is 0, skip loop
        MOV     R2, R1             ; R2 = n (iteration counter)
        MOV     R0, #0             ; R0 = 0 (initialize guess)
        ADD     R0, R0, #1         ; R0 = 1 (start guess at 1)
sqrt_iter
        MOV     R3, R1             ; R3 = n
        SDIV    R3, R1, R0         ; R3 = n / guess
        ADD     R0, R0, R3         ; R0 = guess + (n/guess)
        ASR     R0, R0, #1         ; R0 = (guess + n/guess) / 2 (average)
        SUBS    R2, R2, #1         ; Decrement iteration counter
        BGT     sqrt_iter          ; Repeat if more iterations
sqrt_done
        POP     {R1, R2, LR}       ; Restore R1, R2, and return address
        BX      LR                 ; Return to caller

;-----------------------------------------------------------
; float sin_asm(float x)
; R0 = x (float bits); returns sin(x) as float in R0
;-----------------------------------------------------------
sin_asm
        PUSH    {R4, LR}           ; Save R4 and return address
        BL      sinf               ; Call standard C library sinf(x)
        POP     {R4, LR}           ; Restore R4 and return address
        BX      LR                 ; Return to caller

;-----------------------------------------------------------
; float cos_asm(float x)
; R0 = x (float bits); returns cos(x) as float in R0
;-----------------------------------------------------------
cos_asm
        PUSH    {R4, LR}           ; Save R4 and return address
        BL      cosf               ; Call standard C library cosf(x)
        POP     {R4, LR}           ; Restore R4 and return address
        BX      LR                 ; Return to caller

;-----------------------------------------------------------
; float tan_asm(float x)
; R0 = x (float bits); returns tan(x) as float in R0
;-----------------------------------------------------------
tan_asm
        PUSH    {R4, LR}           ; Save R4 and return address
        BL      tanf               ; Call standard C library tanf(x)
        POP     {R4, LR}           ; Restore R4 and return address
        BX      LR                 ; Return to caller

;-----------------------------------------------------------
; float log_asm(float x)
; R0 = x (float bits); returns log(x) as float in R0
;-----------------------------------------------------------
log_asm
        PUSH    {R4, LR}           ; Save R4 and return address
        BL      logf               ; Call standard C library logf(x)
        POP     {R4, LR}           ; Restore R4 and return address
        BX      LR                 ; Return to caller

;-----------------------------------------------------------
; float exp_asm(float x)
; R0 = x (float bits); returns exp(x) as float in R0
;-----------------------------------------------------------
exp_asm
        PUSH    {R4, LR}           ; Save R4 and return address
        BL      expf               ; Call standard C library expf(x)
        POP     {R4, LR}           ; Restore R4 and return address
        BX      LR                 ; Return to caller

        END                        ; End of file