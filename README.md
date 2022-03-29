#Nemo Finder: utility for converting numbers to words using mnemonic's Herigone method

![nemofinder in searching words](anemonefish.jpg?raw=true "Nemofinder") (image reference = Nhobgood - Nick Hobgood, CC BY-SA 3.0 &lt;https://creativecommons.org/licenses/by-sa/3.0&gt;, via Wikimedia Commons 
https://commons.wikimedia.org/wiki/File:Anemone_purple_anemonefish.jpg )



[more info in wikipedia](https://en.wikipedia.org/wiki/Mnemonic_major_system)

[more info in wikipedia spanish](https://es.wikipedia.org/wiki/C%C3%B3digo_mnemot%C3%A9cnico)

Currently this utility is only implemented for Spanish using this translation table, but the utility may be modified as you want for others languages/translations
The software is published as GPL. Read LICENSE.txt.
 
``` [table]
Dígito 	Nemónico 	Comentario
0 	   r, rr 	   El cero tiene la R (no se usa la C porque estará asociada con el 4). La RR es de misma familia.
1 	   t, d 	   El 1 parece una T. La D se parecen fonéticamente.
2 	   n, ñ 	   El 2 parece una N tumbada y tiene 2 patitas
3 	   m 	       La M parece un 3 tumbado y tiene 3 patitas
4 	   c          (fuerte), k, q 	El 4 empieza por C. La Q y K se parecen fonéticamente
5 	   l, ll 	   El número romano L es 50. La LL es de misma familia.
6 	   s, z, c    (débil) 	El 6 empieza por S. Z y C se parecen fonéticamente
7 	   f, j 	   El 7 parece una F al revés y tiene forma de J
8 	   g, ch 	   El 8 tiene la Ch y la G parece un 8
9 	   v, b, p    El 9 parece una b tumbada y la p y la v es similar fonéticamente 
```

How works internally:
The utility converts the number to the "phonetic space" and find all words in the dictionary that matches the number in this phonetic space
In spanish it is simple because the conversion of words to phonetic is tricky, only "ce" and "ci" sounds differently


Requisites to run: jvm >= 1.8

Requisites to build: maven tool. No other requisites. The spanish dictionary is inside de source code as a simple txt file.

How to Build:
Run maven command: mvn package, you will get the utility in /target folder

How it works:

Herigone method transfor number to words. The word is more easy to remember beacuse you can visualize that.
You must elaborate somehow a history around the words and the concept you want to pin with so that be easy to visualize and remember the whole concept.
After remembering the words, you transform the words and get the number back.

Nemofinder helps you to find all alternatives by using brute force over a dictionary.

running utility. example usage:

let imagine you need to remember the number "118143", so by using herigone method you need to transform this number into a list of words. You can split the number and get various alternatives of word combinations:
{1}{18143}, {11}{81143}, {118}{1143} etc...

usually it is better to find words as longer as possible. So that, by default nemofinder will only show you alternatives with at most 1 letter/digit. If you want all posibilites, enter another parameter with "0": java -jar nemofinder-1.0.0.jar 118143 0

nemofinder will show you all alternative solutions. You must choose the best for you. 

So what words to pick?
of course! only pick words that you know its meaning and words that dont be confused with other words.



% java -jar nemofinder-1.0.0.jar 118143
Nemo Finder. Found 5 alternative split solutions for number [118143]


===============
alternative 1 {118143}
===============

118143 is...
sorry, no words found



===============
alternative 2 {1181}{43}
===============

1181 is...
sorry, no words found


43 is...
acmé, caima, cama, camao, camio, camá, coima, coime, coma, como, cuaima, cuma, cómo, ocume, ocumo, quema, quemí, quima, quimo


===============
alternative 3 {118}{143}
===============

118 is...
tatagua

143 is...
atacama


===============
alternative 4 {11}{8143}
===============

11 is...
adeudo, adiado, atado, ataúd, atutía, audito, dada, dado, dadá, data, dato, daudá, dedeo, dedo, deuda, deudo, diado, dieta, diodo, dita, ditá, dote, duda, dueto, díada, edad, idiota, otate, taita, tata, tate, tato, tatú, tauteo, teda, tedio, teta, titeo, titi, tito, tití, todo, todía, tote, toti, totí, tuatúa, tuda, tuta, tute, tuteo, tuto, tutu, tutía, tutú

8143 is...
sorry, no words found



===============
alternative 5 {11}{81}{43}
===============

11 is...
adeudo, adiado, atado, ataúd, atutía, audito, dada, dado, dadá, data, dato, daudá, dedeo, dedo, deuda, deudo, diado, dieta, diodo, dita, ditá, dote, duda, dueto, díada, edad, idiota, otate, taita, tata, tate, tato, tatú, tauteo, teda, tedio, teta, titeo, titi, tito, tití, todo, todía, tote, toti, totí, tuatúa, tuda, tuta, tute, tuteo, tuto, tutu, tutía, tutú

81 is...
agote, aguada, aguado, aguaite, aguate, agudo, agutí, augita, ágata, egida, égida, gaita, gata, gato, geoda, geoide, geta, godeo, godo, gota, goteo, guado, guadua, guaita, guata, guate, gueto, guiado, guido, guita, guito, iguado

43 is...
acmé, caima, cama, camao, camio, camá, coima, coime, coma, como, cuaima, cuma, cómo, ocume, ocumo, quema, quemí, quima, quimo



