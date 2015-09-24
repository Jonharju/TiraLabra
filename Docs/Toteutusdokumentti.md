Ohjelman rakenne

Koodi koostuu kahdesta osasta, logiikasta paketissa Logiikka ja käyttöliittymästä paketissa UI. Laskimen toiminnoista vastaa
siis logiikka osa. Se sisältää laskutoimitukset summan,keskiarvon, kertolaskun, skalaarin, transpoosin ja determinantin.
Näistä surin osa on toteutettu siten, että ohjelma käy läpi koko matriisin alkio kerrallaan, ja laskee niistä uuden matriisin tai arvon.
Determinantti lasketaan toistaiseksi rekursiivisesti, joten siinä saatta tulla käytyä useamman kerran samat alkiot läpi.

Saavutetut aika- ja tilavaatimukset

Ohjelmiston aika- ja tilavaatimukset ovat testien mukaisesti lineaarisia, determinanttia lukuun ottamatta.
Koska matriisi käydään vaan kerran läpi maksimissaan, tai kahta käydään samalla, on täten sen aikavaativuus n*m, jossa n ja m on 
alkioiden määrä matriisin riveissä ja sarakkeissa, eli kaikki matriisin alkioiden määrä. Tilavaatimuksetkin ovat samaa luokkaa.


Työn puutteet ja parannusehdotukset

Tällä hetkellä determinantin lasku on hyvin epätehokasta, joten sen algoritmissä on paljon parannettavaa. Lisäksi graafinen käyttöliittymä 
on vielä työn alla, joten hiottavaa työssä löytyy.