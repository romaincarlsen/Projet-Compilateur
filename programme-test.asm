; entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.MODEL SMALL
	.586


.DATA

.CODE
debut:
 	STARTUPCODE

; ouvrePrinc 18
	mov bp, sp
	sub sp, 18

; iconst 2
	push word ptr 2

; istore -2
	pop ax
	mov word ptr [bp-2], ax

; queue
	nop
	exitcode
	END debut
