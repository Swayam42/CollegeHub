        PRESERVE8
        AREA    |.text|, CODE, READONLY
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
        EXPORT  log_asm
        EXPORT  exp_asm
        EXTERN  sinf
        EXTERN  cosf
        EXTERN  logf
        EXTERN  expf

; int add_asm(int a, int b)
add_asm
        ADD     R0, R0, R1
        BX      LR

; int sub_asm(int a, int b)
sub_asm
        SUB     R0, R0, R1
        BX      LR

; int mul_asm(int a, int b)
mul_asm
        MUL     R0, R0, R1
        BX      LR

; int div_asm(int a, int b)
div_asm
        CMP     R1, #0
        BEQ     div_zero
        SDIV    R0, R0, R1
        BX      LR
div_zero
        MOV     R0, #0
        BX      LR

; int mod_asm(int a, int b)
mod_asm
        CMP     R1, #0
        BEQ     mod_zero
        SDIV    R2, R0, R1
        MLS     R0, R2, R1, R0
        BX      LR
mod_zero
        MOV     R0, #0
        BX      LR

; int pow_asm(int base, int exp)
pow_asm
        PUSH    {R4, LR}
        MOV     R2, R0
        MOV     R3, R1
        MOV     R0, #1
        CMP     R3, #0
        BEQ     pow_done
pow_loop
        MUL     R0, R0, R2
        SUBS    R3, R3, #1
        BNE     pow_loop
pow_done
        POP     {R4, LR}
        BX      LR

; int fact_asm(int n)
fact_asm
        PUSH    {R1, R2, LR}
        MOV     R1, R0
        MOV     R0, #1
        CMP     R1, #0
        BEQ     fact_done
fact_loop
        MUL     R0, R0, R1
        SUBS    R1, R1, #1
        BNE     fact_loop
fact_done
        POP     {R1, R2, LR}
        BX      LR

; int sqrt_asm(int n)
sqrt_asm
        PUSH    {R1, R2, LR}
        MOV     R1, R0
        CMP     R1, #0
        BEQ     sqrt_done
        MOV     R2, R1
        MOV     R0, #0
        ADD     R0, R0, #1
sqrt_iter
        MOV     R3, R1
        SDIV    R3, R1, R0
        ADD     R0, R0, R3
        ASR     R0, R0, #1
        SUBS    R2, R2, #1
        BGT     sqrt_iter
sqrt_done
        POP     {R1, R2, LR}
        BX      LR

; float sin_asm(float x)
sin_asm
        PUSH    {R4, LR}
        BL      sinf
        POP     {R4, LR}
        BX      LR

; float cos_asm(float x)
cos_asm
        PUSH    {R4, LR}
        BL      cosf
        POP     {R4, LR}
        BX      LR

; float log_asm(float x)
log_asm
        PUSH    {R4, LR}
        BL      logf
        POP     {R4, LR}
        BX      LR

; float exp_asm(float x)
exp_asm
        PUSH    {R4, LR}
        BL      expf
        POP     {R4, LR}
        BX      LR

        END
			