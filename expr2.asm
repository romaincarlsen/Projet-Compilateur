; entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.MODEL SMALL
	.586


.DATA
mess0 DB ""c1="$"
mess1 DB ""c2="$"

.CODE
debut:
 	STARTUPCODE

; ouvrePrinc 14
	mov bp, sp
	sub sp, 14

; ecrireChaine ""c1=""
	lea dx, mess0
	push dx
	call ecrch

; lireEnt -2
	lea dx,[bp-2]
	push dx
	call lirent
; aLaLigne
	call ligsuiv
; ecrireChaine ""c2=""
	lea dx, mess1
	push dx
	call ecrch

; lireEnt -4
	lea dx,[bp-4]
	push dx
	call lirent
; aLaLigne
	call ligsuiv
; iconst 10
	push word ptr 10

; iconst 10
	push word ptr 10

; iconst 2
	push word ptr 2

; idiv
	pop bx
	pop ax
	cwd
	idiv bx
	push ax

; iadd
	pop bx
	pop ax
	add ax, bx
	push ax

; iconst 5
	push word ptr 5

; idiv
	pop bx
	pop ax
	cwd
	idiv bx
	push ax

	call ecrent
; aLaLigne
	call ligsuiv
; iload -2
	push word ptr [bp-2]

; iconst 3
	push word ptr 3

; iload -2
	push word ptr [bp-2]

; imul
	pop bx
	pop ax
	imul bx
	push ax

; iadd
	pop bx
	pop ax
	add ax, bx
	push ax

; iconst 10
	push word ptr 10

; isub
	pop bx
	pop ax
	sub ax, bx
	push ax

	call ecrent
; aLaLigne
	call ligsuiv
; iconst -1
	push word ptr -1

; iconst -1
	push word ptr -1

; ior
	pop bx
	pop ax
	or ax, bx
	push ax

	call ecrent
; aLaLigne
	call ligsuiv
; iload -2
	push word ptr [bp-2]

; iload -4
	push word ptr [bp-4]

; iconst 4
	push word ptr 4

; iadd
	pop bx
	pop ax
	add ax, bx
	push ax

; iinfegal
	pop bx
	pop ax
	cmp ax, bx
	jg $+3
	push -1
	jmp $+2
	push 0

	call ecrent
; aLaLigne
	call ligsuiv
; queue
	nop
	exitcode
	END debut
