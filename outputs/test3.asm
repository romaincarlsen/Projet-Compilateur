; imports
	extrn ecrch:proc
	extrn lirent:proc
	extrn ligsuiv:proc
	extrn ecrent:proc

; entete
.MODEL SMALL
	.586

.DATA
	mess1 DB "n=$"
	mess2 DB "s=$"

.CODE
debut:
 	STARTUPCODE

; ouvrePrinc 6
	mov bp, sp
	sub sp, 6

; ecrireChaine "n="
	lea dx, mess1
	push dx
	call ecrch

; lireEnt -6
	lea dx,[bp-6]
	push dx
	call lirent

; iconst 1
	push word ptr 1

; istore -4
	pop ax
	mov word ptr [bp-4], ax

; iconst 0
	push word ptr 0

; istore -2
	pop ax
	mov word ptr [bp-2], ax

FAIRE0:
; iload -4
	push word ptr [bp-4]

; iload -6
	push word ptr [bp-6]

; iinfegal
	pop bx
	pop ax
	cmp ax, bx
	jg $+6
	push -1
	jmp $+4
	push 0

; iffaux
	pop ax
	cmp ax, 0
	je FAIT0

; iload -2
	push word ptr [bp-2]

; iload -4
	push word ptr [bp-4]

; iadd
	pop bx
	pop ax
	add ax, bx
	push ax

; istore -2
	pop ax
	mov word ptr [bp-2], ax

; iload -4
	push word ptr [bp-4]

; iconst 1
	push word ptr 1

; iadd
	pop bx
	pop ax
	add ax, bx
	push ax

; istore -4
	pop ax
	mov word ptr [bp-4], ax

FAIRE1:
; iload -4
	push word ptr [bp-4]

; iconst 0
	push word ptr 0

; iegal
	pop bx
	pop ax
	cmp ax, bx
	jne $+6
	push -1
	jmp $+4
	push 0

; iffaux
	pop ax
	cmp ax, 0
	je FAIT1

; goto FAIRE1
	jmp FAIRE1

FAIT1:
; goto FAIRE0
	jmp FAIRE0

FAIT0:
FAIRE2:
; iload -4
	push word ptr [bp-4]

; iconst 0
	push word ptr 0

; iegal
	pop bx
	pop ax
	cmp ax, bx
	jne $+6
	push -1
	jmp $+4
	push 0

; iffaux
	pop ax
	cmp ax, 0
	je FAIT2

; goto FAIRE2
	jmp FAIRE2

FAIT2:
; aLaLigne
	call ligsuiv

; ecrireChaine "s="
	lea dx, mess2
	push dx
	call ecrch

; iload -2
	push word ptr [bp-2]

	call ecrent

; queue
	nop
	exitcode
	END debut
