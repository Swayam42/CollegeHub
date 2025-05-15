        PRESERVE8                          ; Ensure 8-byte stack alignment (required for ARM EABI)
        AREA    RESET, DATA, READONLY      ; Define a read-only data area for the vector table
        EXPORT  __Vectors                  ; Export __Vectors symbol for the linker

;--------------------------------------------------
; Interrupt Vector Table (minimal: SP + Reset)
;--------------------------------------------------
__Vectors
        DCD     0x20001000                ; Initial stack pointer address (top of RAM)
        DCD     Reset_Handler             ; Reset vector: address of Reset_Handler

        AREA    |.text|, CODE, READONLY   ; Define a code section named .text, read-only
        EXPORT  Reset_Handler             ; Export Reset_Handler symbol

        ; Import arithmetic and scientific functions
        EXTERN  add_asm                   ; int add_asm(int, int)
        EXTERN  sub_asm                   ; int sub_asm(int, int)
        EXTERN  mul_asm                   ; int mul_asm(int, int)
        EXTERN  div_asm                   ; int div_asm(int, int)
        EXTERN  mod_asm                   ; int mod_asm(int, int)
        EXTERN  pow_asm                   ; int pow_asm(int, int)
        EXTERN  fact_asm                  ; int fact_asm(int)
        EXTERN  sqrt_asm                  ; int sqrt_asm(int)

        ; Import trigonometric and scientific functions
        EXTERN  sin_asm                   ; float sin_asm(float)
        EXTERN  cos_asm                   ; float cos_asm(float)
        EXTERN  tan_asm                   ; float tan_asm(float)
        EXTERN  log_asm                   ; float log_asm(float)
        EXTERN  exp_asm                   ; float exp_asm(float)

        ; Import C math library for float operations (called by above)
        EXTERN  sinf
        EXTERN  cosf
        EXTERN  tanf
        EXTERN  logf
        EXTERN  expf

;--------------------------------------------------
; Main Reset Handler: calls various math functions
;--------------------------------------------------
Reset_Handler
        ;----------------------------------------------
        ; Enable FPU (Floating Point Unit) for Cortex-M4/M7
        ;----------------------------------------------
        LDR     R0, =0xE000ED88          ; Load CPACR register address (FPU control)
        LDR     R1, [R0]                 ; Read current CPACR value
        ORR     R1, R1, #(0xF << 20)     ; Set bits for full access to CP10 and CP11
        STR     R1, [R0]                 ; Write back to CPACR
        DSB                              ; Data Synchronization Barrier
        ISB                              ; Instruction Synchronization Barrier

        ;----------------------------------------------
        ; Arithmetic Operations (Integer)
        ;----------------------------------------------
        MOV     R0, #12                  ; R0 = 12 (first operand)
        MOV     R1, #8                   ; R1 = 8 (second operand)
        BL      add_asm                  ; Call add_asm(12, 8)
        LDR     R3, =result_add          ; Address of result_add
        STR     R0, [R3]                 ; Store result (20) in result_add

        MOV     R0, #15                  ; R0 = 15
        MOV     R1, #5                   ; R1 = 5
        BL      sub_asm                  ; Call sub_asm(15, 5)
        LDR     R3, =result_sub
        STR     R0, [R3]                 ; Store result (10) in result_sub

        MOV     R0, #4                   ; R0 = 4
        MOV     R1, #6                   ; R1 = 6
        BL      mul_asm                  ; Call mul_asm(4, 6)
        LDR     R3, =result_mul
        STR     R0, [R3]                 ; Store result (24) in result_mul

        MOV     R0, #20                  ; R0 = 20
        MOV     R1, #4                   ; R1 = 4
        BL      div_asm                  ; Call div_asm(20, 4)
        LDR     R3, =result_div
        STR     R0, [R3]                 ; Store result (5) in result_div

        MOV     R0, #17                  ; R0 = 17
        MOV     R1, #5                   ; R1 = 5
        BL      mod_asm                  ; Call mod_asm(17, 5)
        LDR     R3, =result_mod
        STR     R0, [R3]                 ; Store result (2) in result_mod

        MOV     R0, #2                   ; R0 = 2
        MOV     R1, #5                   ; R1 = 5
        BL      pow_asm                  ; Call pow_asm(2, 5)
        LDR     R3, =result_pow
        STR     R0, [R3]                 ; Store result (32) in result_pow

        MOV     R0, #5                   ; R0 = 5
        BL      fact_asm                 ; Call fact_asm(5)
        LDR     R3, =result_fact
        STR     R0, [R3]                 ; Store result (120) in result_fact

        MOV     R0, #49                  ; R0 = 49
        BL      sqrt_asm                 ; Call sqrt_asm(49)
        LDR     R3, =result_sqrt
        STR     R0, [R3]                 ; Store result (7) in result_sqrt

        ;----------------------------------------------
        ; Trigonometric Operations (Float arguments)
        ;----------------------------------------------
        LDR     R0, =0x3F0C1524          ; R0 = 0.5235988 (30 deg in radians, IEEE 754 float)
        BL      sin_asm                  ; Call sin_asm(0.5235988f)
        LDR     R3, =result_sin
        STR     R0, [R3]                 ; Store float result (should be 0.5 for sin(30°))

        LDR     R0, =0x3f86a7f0          ; R0 = 1.0471976 (cos 60° in radians)
        BL      cos_asm                  ; Call cos_asm(60°)
        LDR     R3, =result_cos
        STR     R0, [R3]                 ; Store result (cos(60°))

        LDR     R0, =0x3fc90fdb          ; R0 = 1.5707963 (tan 90° in radians)
        BL      tan_asm                  ; Call tan_asm(90°)
        LDR     R3, =result_tan
        STR     R0, [R3]                 ; Store result (tan(90°))

        ;----------------------------------------------
        ; Logarithmic and Exponential (Float arguments)
        ;----------------------------------------------
        LDR     R0, =0x41000000          ; R0 = 8.0 (for log(8))
        BL      log_asm                  ; Call log_asm(8.0)
        LDR     R3, =result_log
        STR     R0, [R3]                 ; Store result (ln(8))

        LDR     R0, =0x40000000          ; R0 = 2.0 (for exp(2))
        BL      exp_asm                  ; Call exp_asm(2.0)
        LDR     R3, =result_exp
        STR     R0, [R3]                 ; Store result (e^2)

stop    B       stop                     ; Infinite loop to halt here for debugging

;--------------------------------------------------
; Data section for results (all zero-initialized)
;--------------------------------------------------
        AREA    |.data|, DATA, READWRITE ; Define a read/write data section
result_add   DCD 0                       ; Result of addition (int)
result_sub   DCD 0                       ; Result of subtraction (int)
result_mul   DCD 0                       ; Result of multiplication (int)
result_div   DCD 0                       ; Result of division (int)
result_mod   DCD 0                       ; Result of modulo (int)
result_pow   DCD 0                       ; Result of power (int)
result_fact  DCD 0                       ; Result of factorial (int)
result_sqrt  DCD 0                       ; Result of square root (int)
result_sin   DCD 0                       ; Result of sine (float bits)
result_cos   DCD 0                       ; Result of cosine (float bits)
result_tan   DCD 0                       ; Result of tangent (float bits)
result_log   DCD 0                       ; Result of logarithm (float bits)
result_exp   DCD 0                       ; Result of exponential (float bits)

        END                              ; End of file
			