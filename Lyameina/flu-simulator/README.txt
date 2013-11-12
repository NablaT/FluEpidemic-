Bienvenu à flu-simulator
-----------------------

Le programme se lance en terminal par la commande:
java -jar flu-simulator.jar

Une fois lancé le programme vous demande de rentrer quelques paramètres:
	* La probalité qu'une entité soit contaminée par un voisin. (sous forme de pourcentage)
	* Le taux de mortalité (sous forme de pourcentage)
	* Le rayon de contamination i.e le nombre de case maximum entre un individu contaminé et son voisin.
	* Les dimentions de la grille hauteur et largeur.

La simulation commence au jour 0 où les hommes sont en bonne santé et tous 
les animaux malades. Puis l'évolution suis son cours.

Vous reconnaitrer un individu et son stade grâce à ses caractères:

Humains:
	
	Saint: 			(^_^)
	Mort : 			(X_X)
	Malade: 		(~_~)
	Contagieux:    *(~_~)*
	Guerissant: 	(u_u) 
	
Poulets:

	Saint: 			ε(°v°)3
	Malade: 		ε(~v~)3
	Contagieux:    *ε(~v~)3*
	Guerrisant: 	ε(-v-)3 

Canards:

	Saint: 			( °)=
	Malade: 		( ~)=
	Contagieux:    *( ~)=*
	Guerrisant: 	( u)= 
	
Cochons:

	Saint: 			(°oo°)
	Malade: 		(~oo~)
	Contagieux:    *(~oo~)*
	Guerrisant: 	(-oo-) 


Variante: Welcome to the farm!

La variante mise en place consiste à reproduire un environement semblable
à une ferme. c'est à dire qu'il y a plus d'animaux que d'hommes.
(3 fois plus d'animaux en moyenne).
