INSERT INTO MJESTO(created_at, updated_at, naziv_mjesta) VALUES (CURRENT_TIMESTAMP, null, 'Zagreb');
INSERT INTO MJESTO(created_at, updated_at, naziv_mjesta) VALUES (CURRENT_TIMESTAMP, null, 'Rijeka');
INSERT INTO MJESTO(created_at, updated_at, naziv_mjesta) VALUES (CURRENT_TIMESTAMP, null, 'Split');
INSERT INTO MJESTO(created_at, updated_at, naziv_mjesta) VALUES (CURRENT_TIMESTAMP, null, 'Osijek');

INSERT INTO KVAR(created_at, updated_at, naziv_kvara, opis_kvara) VALUES (CURRENT_TIMESTAMP, null, 'Zamjena motora','Opsezan popravak');
INSERT INTO KVAR(created_at, updated_at, naziv_kvara, opis_kvara) VALUES (CURRENT_TIMESTAMP, null, 'Zamjena ulja Peugeot','brzi serivs ulja Peugeot');
INSERT INTO KVAR(created_at, updated_at, naziv_kvara, opis_kvara) VALUES (CURRENT_TIMESTAMP, null, 'Zamjena ulja Renault','brzi serivs ulja Renault');
INSERT INTO KVAR(created_at, updated_at, naziv_kvara, opis_kvara) VALUES (CURRENT_TIMESTAMP, null, 'Zamjena guma ALU felge','zamjena ALU felgi ili zamjena guma na ALU felgama');
INSERT INTO KVAR(created_at, updated_at, naziv_kvara, opis_kvara) VALUES (CURRENT_TIMESTAMP, null, 'Zamjena guma celicne felge','zamjena guma na celicnim felgama');
INSERT INTO KVAR(created_at, updated_at, naziv_kvara, opis_kvara) VALUES (CURRENT_TIMESTAMP, null, 'Promjena svjetala','Zamjena prednjih ili stražnijh svjetala');

INSERT INTO KLIJENT(created_at, updated_at, ime, oib, prezime, broj_mob, email, mjesto_id)
VALUES (CURRENT_TIMESTAMP, null, 'Filip', '01234567890', 'Vučemilovič-Grgić', '0123456789', 'fvucemilo@tvz.hr', 1);
INSERT INTO KLIJENT(created_at, updated_at, ime, oib, prezime, broj_mob, email, mjesto_id)
VALUES (CURRENT_TIMESTAMP, null, 'Marko', '11342098460', 'Tojčić', '0913457807', 'mtojcic@tvz.hr', 1);
INSERT INTO KLIJENT(created_at, updated_at, ime, oib, prezime, broj_mob, email, mjesto_id)
VALUES (CURRENT_TIMESTAMP, null, 'Petar', '95122572171', 'Lucić', '0993455567', 'plucic@tvz.hr', 3);
INSERT INTO KLIJENT(created_at, updated_at, ime, oib, prezime, broj_mob, email, mjesto_id)
VALUES (CURRENT_TIMESTAMP, null, 'Karlo', '25144572171', 'Horvat', '0999875567', 'khorvat@tvz.hr', 3);
INSERT INTO KLIJENT(created_at, updated_at, ime, oib, prezime, broj_mob, email, mjesto_id)
VALUES (CURRENT_TIMESTAMP, null, 'Danijel', '18493404214', 'Bauman', '0953454164', 'dbauman@tvz.hr', 4);



INSERT INTO RADNIK(created_at, updated_at, ime, oib, prezime, iznos_osnovice, koef_place, status_radnog_odnosa,vrsta_radnog_odnosa,mjesto_id)
VALUES (CURRENT_TIMESTAMP, null, 'Ante', '45611325216', 'Perić', '2200.00','1.43','NEZAPOSLEN','ODREDENO', 1);
INSERT INTO RADNIK(created_at, updated_at, ime, oib, prezime, iznos_osnovice, koef_place, status_radnog_odnosa,vrsta_radnog_odnosa,mjesto_id)
VALUES (CURRENT_TIMESTAMP, null, 'Antonio', '18122871200', 'Gošek', '2200.00','2.45','ZAPOSLEN','NEODREDENO', 1);
INSERT INTO RADNIK(created_at, updated_at, ime, oib, prezime, iznos_osnovice, koef_place, status_radnog_odnosa,vrsta_radnog_odnosa,mjesto_id)
VALUES (CURRENT_TIMESTAMP, null, 'Matej', '39511655581', 'Livanić', '2200.00','2.90','ZAPOSLEN','NEODREDENO', 1);
INSERT INTO RADNIK(created_at, updated_at, ime, oib, prezime, iznos_osnovice, koef_place, status_radnog_odnosa,vrsta_radnog_odnosa,mjesto_id)
VALUES (CURRENT_TIMESTAMP, null, 'Marko', '24100976241', 'Halilović', '2200.00','2.90','ZAPOSLEN','ODREDENO', 1);

INSERT INTO NALOG(created_at, updated_at, datum_izdavanja, datum_preuzimanja, prioritet, registracija_vozila, utroseni_radni_sati_servisa, klijent_id,kvar_id,radnik_id)
VALUES (CURRENT_TIMESTAMP, null, '2020-02-02', '2020-02-04', 'SREDNJI', 'ZG-6747-BG','2',1,3, 1);
INSERT INTO NALOG(created_at, updated_at, datum_izdavanja, datum_preuzimanja, prioritet, registracija_vozila, utroseni_radni_sati_servisa, klijent_id,kvar_id,radnik_id)
VALUES (CURRENT_TIMESTAMP, null, '2020-04-14', '2020-04-25', 'VISOKI', 'ZG-DIREKTOR','5',2,1, 2);
INSERT INTO NALOG(created_at, updated_at, datum_izdavanja, datum_preuzimanja, prioritet, registracija_vozila, utroseni_radni_sati_servisa, klijent_id,kvar_id,radnik_id)
VALUES (CURRENT_TIMESTAMP, null, '2020-04-12', '2020-04-12', 'NISKI', 'ZG-0000-ZF','2',3,2, 3);
INSERT INTO NALOG(created_at, updated_at, datum_izdavanja, datum_preuzimanja, prioritet, registracija_vozila, utroseni_radni_sati_servisa, klijent_id,kvar_id,radnik_id)
VALUES (CURRENT_TIMESTAMP, null, '2020-05-02', '2020-05-03', 'NISKI', 'ZG-4632-UH','1',4,4, 3);
INSERT INTO NALOG(created_at, updated_at, datum_izdavanja, datum_preuzimanja, prioritet, registracija_vozila, utroseni_radni_sati_servisa, klijent_id,kvar_id,radnik_id)
VALUES (CURRENT_TIMESTAMP, null, '2020-05-05', '2020-05-05', 'NISKI', 'RI-8573-AJ','1',5,4, 2);

create table if not exists user (
id identity,
username varchar(100) not null,
password varchar(250) not null,
first_name varchar(250) not null,
last_name varchar(250) not null
);
create table if not exists authority (
id identity,
name varchar(100) not null
);
create table if not exists user_authority (
user_id bigint not null,
authority_id bigint not null,
constraint fk_user foreign key (user_id) references user(id),
constraint fk_authority foreign key (authority_id) references authority(id)
);

insert into user (id, username, password, first_name, last_name)
values (1, 'admin', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'admin', 'admin');
insert into user (id, username, password, first_name, last_name)
values (2, 'user', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'user', 'user');
insert into authority (id, name)
values (1, 'ROLE_ADMIN');
insert into authority (id, name)
values (2, 'ROLE_USER');
insert into user_authority (user_id, authority_id)
values (1, 1);
insert into user_authority (user_id, authority_id)
values (2, 2);

