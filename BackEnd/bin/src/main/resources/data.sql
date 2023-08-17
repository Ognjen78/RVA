insert into Bioskop(id, adresa, naziv)
values (nextval('BIOSKOP_SEQ'), 'Danila Kisa 13', 'Cinemax');

insert into Bioskop(id, adresa, naziv)
values (nextval('BIOSKOP_SEQ'), 'Promenada', 'Cinestar');

insert into Bioskop(id, adresa, naziv)
values (nextval('BIOSKOP_SEQ'), 'Heroja Pinkija 2', 'Arena');

insert into Bioskop(id, adresa, naziv)
values (nextval('BIOSKOP_SEQ'), 'Cara Dusana 5', 'BBioskop');

insert into Bioskop(id, adresa, naziv)
values (nextval('BIOSKOP_SEQ'), 'Mike Antica 7', 'Kino202');

insert into Bioskop(id, adresa, naziv)
values (nextval('BIOSKOP_SEQ'), 'Cara Lazara 117', 'Kventin');

insert into Bioskop(id, adresa, naziv)
values (nextval('BIOSKOP_SEQ'), 'Brace Ribnikar 17', 'Fuji');

insert into Bioskop(id, adresa, naziv)
values (nextval('BIOSKOP_SEQ'), 'Mise Dimitrijevica 30', 'Fox');



insert into Film(id, naziv, recenzija, trajanje, zanr)
values (nextval('FILM_SEQ'), 'Sindlerova lista', 9, 185, 'Biografski');

insert into Film(id, naziv, recenzija, trajanje, zanr)
values (nextval('FILM_SEQ'), 'Inception',8, 140, 'Sci-fi');

insert into Film(id, naziv, recenzija, trajanje, zanr)
values (nextval('FILM_SEQ'), 'Kum', 10, 185, 'Drama');

insert into Film(id, naziv, recenzija, trajanje, zanr)
values (nextval('FILM_SEQ'), 'Tenet', 9, 120, 'Sci-fi');

insert into Film(id, naziv, recenzija, trajanje, zanr)
values (nextval('FILM_SEQ'), 'Seven', 9, 130, 'Mistery');

insert into Film(id, naziv, recenzija, trajanje, zanr)
values (nextval('FILM_SEQ'), 'Platoon', 9, 150, 'War');

insert into Film(id, naziv, recenzija, trajanje, zanr)
values (nextval('FILM_SEQ'), 'Sakal', 6, 120, 'Drama');

insert into Film(id, naziv, recenzija, trajanje, zanr)
values (nextval('FILM_SEQ'), 'Wild Tales', 7, 90, 'Drama');




insert into Sala(id, kapacitet, broj_redova, bioskop)
values (nextval('SALA_SEQ'), 150, 10, 2);

insert into Sala(id, kapacitet, broj_redova, bioskop)
values (nextval('SALA_SEQ'), 100, 10, 1);

insert into Sala(id, kapacitet, broj_redova, bioskop)
values (nextval('SALA_SEQ'), 90, 9, 4);

insert into Sala(id, kapacitet, broj_redova, bioskop)
values (nextval('SALA_SEQ'), 75, 5, 3);

insert into Sala(id, kapacitet, broj_redova, bioskop)
values (nextval('SALA_SEQ'), 200, 20, 5);

insert into Sala(id, kapacitet, broj_redova, bioskop)
values (nextval('SALA_SEQ'), 250, 10, 8);

insert into Sala(id, kapacitet, broj_redova, bioskop)
values (nextval('SALA_SEQ'), 270, 10, 6);

insert into Sala(id, kapacitet, broj_redova, bioskop)
values (nextval('SALA_SEQ'), 130, 10, 7);





insert into Rezervacija(id, broj_osoba, cena_karte, datum, placeno, film, sala)
values(nextval('REZERVACIJA_SEQ'), 2, 1000, to_date('14.03.2023', 'dd.mm.yyyy'), true, 5, 1); 

insert into Rezervacija(id, broj_osoba, cena_karte, datum, placeno, film, sala)
values(nextval('REZERVACIJA_SEQ'), 2, 1000, to_date('14.03.2023', 'dd.mm.yyyy'), false, 4, 2); 
insert into Rezervacija(id, broj_osoba, cena_karte, datum, placeno, film, sala)
values(nextval('REZERVACIJA_SEQ'), 1, 400, to_date('12.03.2023', 'dd.mm.yyyy'), true, 3, 4); 
insert into Rezervacija(id, broj_osoba, cena_karte, datum, placeno, film, sala)
values(nextval('REZERVACIJA_SEQ'), 2, 1000, to_date('12.01.2023', 'dd.mm.yyyy'), true, 2, 3); 
insert into Rezervacija(id, broj_osoba, cena_karte, datum, placeno, film, sala)
values(nextval('REZERVACIJA_SEQ'), 4, 1500, to_date('10.02.2023', 'dd.mm.yyyy'), true, 1, 6); 
insert into Rezervacija(id, broj_osoba, cena_karte, datum, placeno, film, sala)
values(nextval('REZERVACIJA_SEQ'), 2, 1000, to_date('14.03.2023', 'dd.mm.yyyy'), false, 6, 8); 
insert into Rezervacija(id, broj_osoba, cena_karte, datum, placeno, film, sala)
values(nextval('REZERVACIJA_SEQ'), 3, 1250, to_date('04.02.2023', 'dd.mm.yyyy'), true, 5, 2); 
insert into Rezervacija(id, broj_osoba, cena_karte, datum, placeno, film, sala)
values(nextval('REZERVACIJA_SEQ'), 1, 600, to_date('27.02.2023', 'dd.mm.yyyy'), true, 8, 7); 