Matriisilaskinohjelman toimintaa on testattu sek� laskimen toimintalogiikan yksikk�testeill� ett� 
manuaalisesti sy�tt�m�ll� erikokoisia matriiseja laskimen laskettavaksi. Yksikk�testit testaavat laskimen 
metodien toimivuutta, kun taas manuaalisella testauksella on tutkittu l�hinn� metodien algoritmien tehokkuutta 
ja aikavaatimuksia. K�ytt�liittym�lle ei ole JUnit-testej�, sen testaaminen on hoidettu p��asiassa k�sin, tapaus kerrallaan.

Testit on tehty pienikokoisilla sy�tteill�. Matriisit ja niiden vastaukset olen tarkistanut etuk�teen, jonka j�lkeen olen ajanut ne 
oman koodin l�pi, tarkistaen toiminnan oikeellisuuden. Sama toiminto on tarkistettu eri kokoisilla matriiseilla, ja jos sy�te ei 
kuulu tuottaa tulosta, on testattu ett� metodi heitt�� exceptionin.

Yksikk�testit voidaan ajaa uudestaan milloin vaan, k�sin teht�v�t testit joudutaan tekem��n alusta alkaen
joka kerta.