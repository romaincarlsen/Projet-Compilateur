; imports
	extrn lirent:proc
	extrn ligsuiv:proc
	extrn ecrent:proc

; entete
.MODEL SMALL
	.586

.CODE
debut:
 	STARTUPCODE

; ouvrePrinc 6
	mov bp, sp
	sub sp, 6

; iload 4
	push word ptr [bp4]

; istore -6
	pop ax
	mov word ptr [bp-6], ax

; iload -6
	push word ptr [bp-6]

; iload 6
	push word ptr [bp6]

; isup
	pop bx
	pop ax
	cmp ax, bx
	jle $+6
	push -1
	jmp $+4
	push 0

; iffaux
	pop ax
	cmp ax, 0
	je SINON1

; iload -6
	push word ptr [bp-6]

; goto FSI1
	jmp FSI1

SINON1:
; iload 6
	push word ptr [bp6]

FSI1:
; ouvrePrinc 0
	mov bp, sp
	sub sp, 0

; iload 4
	push word ptr [bp4]

; iload 6
	push word ptr [bp6]

; iinf
	pop bx
	pop ax
	cmp ax, bx
	jge $+6
	push -1
	jmp $+4
	push 0

; iffaux
	pop ax
	cmp ax, 0
	je SINON2

; iload 4
	push word ptr [bp4]

; goto FSI2
	jmp FSI2

SINON2:
; iload 6
	push word ptr [bp6]

FSI2:
; ouvrePrinc 0
	mov bp, sp
	sub sp, 0

; iload 4
	push word ptr [bp4]

; iload 6
	push word ptr [bp6]

; isup
	pop bx
	pop ax
	cmp ax, bx
	jle $+6
	push -1
	jmp $+4
	push 0

; ouvrePrinc 8
	mov bp, sp
	sub sp, 8

; iconst 5
	push word ptr 5

; istore -2
	pop ax
	mov word ptr [bp-2], ax

; lireEnt -4
	lea dx,[bp-4]
	push dx
	call lirent

; aLaLigne
	call ligsuiv

; iload -2
	push word ptr [bp-2]

; iload -4
	push word ptr [bp-4]

; iconst 5
	push word ptr 5

; iconst 2
	push word ptr 2

; iadd
	pop bx
	pop ax
	add ax, bx
	push ax

; istore -6
	pop ax
	mov word ptr [bp-6], ax

; iconst 1
	push word ptr 1

; iload -2
	push word ptr [bp-2]

; iload -4
	push word ptr [bp-4]

; iconst 5
	push word ptr 5

; isub
	pop bx
	pop ax
	sub ax, bx
	push ax

; iadd
	pop bx
	pop ax
	add ax, bx
	push ax

; iload -2
	push word ptr [bp-2]

; iconst 2
	push word ptr 2

; imul
	pop bx
	pop ax
	imul bx
	push ax

; iload -4
	push word ptr [bp-4]

; istore -8
	pop ax
	mov word ptr [bp-8], ax

; aLaLigne
	call ligsuiv

; iload -6
	push word ptr [bp-6]

	call ecrent

; aLaLigne
	call ligsuiv

; iload -8
	push word ptr [bp-8]

	call ecrent

; queue
	nop
	exitcode
	END debut
