Projet Compilo
=============

Projet Compilateur pour Eclipse, INSA Rennes


Instructions pour installer le dépot en local
-------------

- Installer Git
- Créer un dossier sur votre ordinateur à l'endroit voulu pour le projet
- Ouvrir un terminal Git et ce rendre dans le dossier précédement créé
- Initialiser le dépot avec cette suite de commandes :
	* <code>git init</code>
	* <code>git add remote GitHub https://github.com/romaincarlsen/Projet-Compilateur.git</code>
	* <code>git pull GitHub master</code>


Instructions pour metter à jour le dépot en ligne
-------------
- Ajouter les fichiers nouveaux/modifiés ( Ou tout les fichiers )
- Faire un commit en laissant un message bref et explicite sur votre mise à jour
- Récupérer le dépot en ligne pour le mettre à jour sur votre ordinateur
- Corriger les conflits eventuels liés à la mise à jour
- Puis mettre à jour le dépot en ligne
- Cette suite d'instructions correspond aux commandes suivantes :
	* <code>git add nom_du_fichier</code> ( Ou <code>git add .</code> )
	* <code>git commit -m "Un message explicite"</code>
	* <code>git pull GitHub master</code>
	* <code>git push GitHub master</code>
