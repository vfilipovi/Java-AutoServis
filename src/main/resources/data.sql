INSERT INTO MJESTO(created_at, updated_at, naziv_mjesta) VALUES (CURRENT_TIMESTAMP, null, 'Zagreb');
INSERT INTO MJESTO(created_at, updated_at, naziv_mjesta) VALUES (CURRENT_TIMESTAMP, null, 'Rijeka');
INSERT INTO MJESTO(created_at, updated_at, naziv_mjesta) VALUES (CURRENT_TIMESTAMP, null, 'Split');
INSERT INTO MJESTO(created_at, updated_at, naziv_mjesta) VALUES (CURRENT_TIMESTAMP, null, 'Osijek');

INSERT INTO KVAR(created_at, updated_at, naziv_kvara, opis_kvara) VALUES (CURRENT_TIMESTAMP, null, 'Zamjena motora','Opsežan popravak');

INSERT INTO KLIJENT(created_at, updated_at, ime, oib, prezime, broj_mob, email, mjesto_id)
VALUES (CURRENT_TIMESTAMP, null, 'Filip', '01234567890', 'Vučemilovič-Grgić', '0123456789', 'fvucemilo@tvz.hr', 1);

