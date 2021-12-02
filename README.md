# Comunicazione_P2P
Programma che consente la comunicazione p2p, funzionando come una chat testuale in cui si vogliono scambiare messaggi con un computer collegato alla rete di colui che invia i messaggi. 
PROTOCOLLO DI COMUNICAZIONE
Apertura
fase1:
	a;NOME_MITTENTE;  
	( chiamata NON bloccante)

fase2:	
se posso/voglio accettare la connessione ->	
	y;NOME_DESTINATARIO;
se non posso/voglio accettare la connessione ->	
	n;
	
fase3:	
	y;
	n;
	
Se ho una connessione in attesa di rispo
e mi arriva un'altra connessione
la annullo a prescindere

se richiedo ma non ricevo risposta, 
annullo 
se poi mi risponde, invio "n;"
( se non mi risponde, non invio niente durante la fase
di annulla)



Dialogo

	m;CONTENUTO_MESSAGGIO
	
prevedere la possibilità di espandere i "comandi"
	
	
se ricevo un messaggio da una comunicazione già chiusa
( o non ancora aperta)
invio "c;"
	
	

Chiusura

	c;
