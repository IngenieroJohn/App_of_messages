SELECT* from "Users";
CREATE TABLE Messages (
	id_sms SERIAL NOT NULL,
	idfrom INTEGER NOT NULL,
	idto INTEGER NOT NULL,
	contenido VARCHAR NOT NULL,
	datesms TIMESTAMP NOT NULL,
	CONSTRAINT pk_Messages PRIMARY KEY (id_sms),
	CONSTRAINT fk_Users FOREIGN KEY (idfrom) REFERENCES "Users" (id),
	CONSTRAINT fk_Users2 FOREIGN KEY (idto) REFERENCES "Users" (id)
);
--drop TABLE Messages
--TRUNCATE TABLE messages;
--TRUNCATE table "Users"
select * FROM Messages
--last message
SELECT * FROM messages where idfrom=1 and idto=2 or idfrom=2 and idto=1
ORDER BY id_sms DESC LIMIT 1;


SELECT * FROM messages 
ORDER BY id_sms DESC LIMIT 1;


INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 2, 'añadiendo desde addsms', '2022/08/25 8:30')

-- mensajes;
entre jhon y will jhon 1 y will 2
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Hola jhon ayudame con el deber de programacion', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 2, 'Como estas diego, claro ya te ayudo con eso dame unos segundos xd', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Dale aqui te espero, no te vayas a olvidar','2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Por cierto que otros deberes mandaron', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 2, 'Estadistica creo y el proyecto de programa :v',  '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Ya con programa es como tener 10 deberes xd', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 1, 'Ojala me lleve el diablo jaja', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 2, 'jajaja oye tu si que eres dramatica ya le pusiste 10 deberes :v', '2022/08/25 8:30')
		
		// entre jhon y diego
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'hola crack', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 3, 'Hola diego', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'Hola jhon ayudame con el deber de programacion', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'está complicado', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 3, 'con gusto', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (1, 3, 'estamos en el mismo team', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'aprecio tu ayuda', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 1, 'Hablamos', '2022/08/25 8:30')
		
		// entre diego y will
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 2, 'Hola', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (2, 3, 'Hola men', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 2, 'todo bien?', '2022/08/25 8:30')
INSERT INTO Messages(idfrom, idto, contenido, datesms) VALUES (3, 2, 'pa jugar xd', '2022/08/25 8:30')
		