# BankSpringBatch
tentative d'utilisation de spring batch via springboot, on lit un fichier csv et on insere son contenu dans une bdd h2,j 'ai créé un controleur


apres avoir lancé le boot on lance le job via l'adresse "http://localhost:8080/startJob"

on verifie que les données bancaires issues du fichier interne au projet data.csv du dossier src/main/resources ont été lues et stockées en base

et on verifie le resultat du job a l'adresse "http://localhost:8080/analytics"
-----> theoriquement a chaque rafraichissement de page le debit total et le credit total s'ajoutent.
