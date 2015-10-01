Matriisilaskinohjelman toimintaa on testattu sekä laskimen toimintalogiikan yksikkötesteillä että 
manuaalisesti syöttämällä erikokoisia matriiseja laskimen laskettavaksi. Yksikkötestit testaavat laskimen 
metodien toimivuutta, kun taas manuaalisella testauksella on tutkittu lähinnä metodien algoritmien tehokkuutta 
ja aikavaatimuksia. Käyttöliittymälle ei ole JUnit-testejä, sen testaaminen on hoidettu pääasiassa käsin, tapaus kerrallaan.

Testit on tehty pienikokoisilla syötteillä. Matriisit ja niiden vastaukset olen tarkistanut etukäteen, jonka jälkeen olen ajanut ne 
oman koodin läpi, tarkistaen toiminnan oikeellisuuden. Sama toiminto on tarkistettu eri kokoisilla matriiseilla, ja jos syöte ei 
kuulu tuottaa tulosta, on testattu että metodi heittää exceptionin.

Yksikkötestit voidaan ajaa uudestaan milloin vaan, käsin tehtävät testit joudutaan tekemään alusta alkaen
joka kerta.