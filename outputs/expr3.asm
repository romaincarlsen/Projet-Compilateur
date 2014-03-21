; imports
	extrn ecrch:proc
	extrn lirent:proc
	extrn ligsuiv:proc
	extrn ecrent:proc

; entete
.MODEL SMALL
	.586

.DATA
	mess1 DB "c1=$"
	mess2 DB "c3=$"
	mess3 DB "c4=$"

.CODE
debut:
 	STARTUPCODE

; ouvrePrinc 14
	mov bp, sp
	sub sp, 14

; ecrireChaine "c1="
	lea dx, mess1
	push dx
	call ecrch

; lireEnt -2
	lea dx,[bp-2]
	push dx
	call lirent

; aLaLigne
	call ligsuiv

; ecrireChaine "c3="
	lea dx, mess2
	push dx
	call ecrch

; lireEnt -6
	lea dx,[bp-6]
	push dx
	call lirent

; aLaLigne
	call ligsuiv

; ecrireChaine "c4="
	lea dx, mess3
	push dx
	call ecrch

; lireEnt -8
	lea dx,[bp-8]
	push dx
	call lirent

; aLaLigne
	call ligsuiv

; iload -6
	push word ptr [bp-6]

; iload -8
	push word ptr [bp-8]

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

; queue
	nop
	exitcode
	END debut
