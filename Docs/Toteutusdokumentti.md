Ohjelman rakenne

Koodi koostuu kahdesta osasta, logiikasta paketissa Logiikka ja k�ytt�liittym�st� paketissa UI. Laskimen toiminnoista vastaa
siis logiikka osa. Se sis�lt�� laskutoimitukset summan,keskiarvon, kertolaskun, skalaarin, transpoosin ja determinantin.
N�ist� surin osa on toteutettu siten, ett� ohjelma k�y l�pi koko matriisin alkio kerrallaan, ja laskee niist� uuden matriisin tai arvon.
Determinantti lasketaan LU-hajotelmaa k�ytt�en. K��nteismatriisi lasketaan Gaussiin-Jordanin eliminointimenetelm�� k�ytt�en apuna.
Saavutetut aika- ja tilavaatimukset

Ohjelmiston aika- ja tilavaatimukset ovat testien mukaisesti lineaarisia, determinanttia lukuun ottamatta.
Koska matriisi k�yd��n vaan kerran l�pi maksimissaan, tai kahta k�yd��n samalla, on t�ten sen aikavaativuus n*m, jossa n ja m on 
alkioiden m��r� matriisin riveiss� ja sarakkeissa, eli kaikki matriisin alkioiden m��r�. Tilavaatimuksetkin ovat samaa luokkaa.


Ty�n puutteet ja parannusehdotukset
Determinantin laskeminen on nyt tehokkaampaa, mutta ongelmana on tarkkuusongelma, jossa laskiessa tulee p��ttym�tt�mi� desimaalilukuja, jotka t�ytyy py�rist��. 
Lis�ksi graafinen k�ytt�liittym� on viel� ty�n alla, joten hiottavaa ty�ss� l�ytyy.