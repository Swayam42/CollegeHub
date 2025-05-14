                AREA    RESET, CODE, READONLY
                THUMB

                EXPORT  __Vectors
                EXPORT  Reset_Handler
                EXPORT  __initial_sp

; Stack area (size 0x400 = 1KB)
                AREA    STACK, NOINIT, READWRITE, ALIGN=3
__initial_sp    SPACE   0x400

; Vector table
                AREA    RESET, CODE, READONLY
__Vectors       DCD     __initial_sp              ; Top of Stack
                DCD     Reset_Handler             ; Reset Handler

                AREA    |.text|, CODE, READONLY

Reset_Handler   PROC
                EXPORT  Reset_Handler             [WEAK]
                IMPORT  SystemInit
                IMPORT  main

                BL      SystemInit
                BL      main
endloop         B       endloop
                ENDP

                ALIGN

                END
					