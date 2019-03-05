# calculator

För att bli godkänd på denna laboration skall ni skapa de sedvanliga funktionerna som behövs, alltså divide(..), add(…) osv. Datatypen som skall användas på dessa funktioner är flyttal (doubles), alltså ni skall ha flyttal som returtyp och flyttal som inparametrar.

Huvudfunktionen som skall återfinnas och testas noggrant är:
public String calculateExpression(String expression)
Denna funktion skall ta emot en sträng med ett matematiskt uttryck och returnerar en sträng med rätt resultat. 
Funktionen skall på denna nivå kunna klara att räkna ut obegränsat antal operander och operatorer ihop utan krav på parenteser. 

Exempel på vad funktionen skall klara:
5*4+7-3*0+4-10 
7*4+6-3/2
Exempel på vad funktionen inte behöver klara

5 - -5
5+(6*7)


Ni måste här tänka på att prioritet på operatorerna går från vänster och * / och % har högre prioritet, alltså:
7*6/2 = 21
5+6/2*2 = 11 

Ni skall kasta en ArithmeticException ur funktionen calculateExpression om ett tal divideras med noll. Detta skall testas med expectedExceptions. 
Det går att bli godkänd utan att implementerat en total lösning, men då skall det finnas omfattande tester. På godkänt-nivå får ni samarbeta med någon annan och det skall framgå i kodfilerna genom att högst upp skriva en kommentar om programmet och vilka som varit med och skapat det, men var och en måste fortfarande lämna in individuellt.

Väl Godkänt (VG)

All funktionalitet som krävs för Godkänt skall även uppfyllas för Väl godkänt. Det är inte tillåtet att arbeta tillsammans med någon annan på Väl godkänt nivå. Det skall i detta fall också finnas en fungerade lösning som är implementerad och testad som på godkänt-nivå inte krävdes fullt ut.
Utöver ovan nämnda skall:
Det skall kastas lämpliga undantag ur calculateExpression vid ett overflow, alltså där två för stora tal adderas ihop och resulterar ett tal för stort för att kunna hanteras av datatypen double.
Det skall kastas undantag eller resultera i ett felmeddelande om input är felaktigt. 
En felaktig input kan t.ex. vara flera operatorer ihop i följd, bokstäver, för många mellanrum(space) mellan operanderna osv. 
Ni skall genom tester fånga upp tillfredställande antal fel. Med det menas att det inte finns några krav på att fånga upp alla fel. Testerna skall visa att funktionen calculateExpression svarar allmänt tillfredsställande vid felaktiga inputs.
Exempel på felaktiga inputs:
5++p
5++4
3    4
sdf
*3
0+0//
osv...
Annat att tänka på:
Hantering av två minustecken i följd, t.ex. 3--1, 10--1 och liknande uttryck (subtraktion med negativt tal)
Hantering av uttryck som innehåller parenteser
Och mycket mer (ju mer du gör desto större chans naturligtvis att få VG)
Allt ovan skall bevisas genom tester och det är viktigt att ni testar gränsvärden och udda värden. 
