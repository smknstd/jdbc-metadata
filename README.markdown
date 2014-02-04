## Connaitre le type d'une colonne avec JDBC

Quand on écrit une requete SQL, connaitre le type de données renvoyé n'est généralement pas déterminant. Mais quand on base le fonctionement d'une application sur le typage dynamique de ses variables en fonction du resultat d'une requete, le détails peut avoir de l'importance.

Quand on demande au SGBD une colonne sans transformation, le type retourné est évident. Mais dès lors qu'on concatène plusieurs valeurs ou qu'utilise des fonctions, prédire le type renvoyé est un exercice difficile. Pire, à ma connaissance, aucun outil sauf ceux basés sur jdbc sont capable d'apporter une réponse.

Si mes souvenirs sont bons c'est en voulant généré une cléf unique "md5", j'ai découvert qu'Oracle avait la mauvaise idée de me renvoyer un varchar2(4000) très gourmand, dans les allocations mémoires en C qui en découlaient.
