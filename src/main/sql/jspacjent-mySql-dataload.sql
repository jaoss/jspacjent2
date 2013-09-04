-- -------------------------------------------------------------------
--     Nazwa pliku: jspacjent-mySql-dataload.sql
--       Utworzony: 04.09.2013
--           Autor: Janusz Swół ©2013
--           Firma: 
--       Działanie: Testowe dane systemu JSPacjent
--        Podstawa:
-- Etap realizacji: Test
--           Uwagi:
-- -------------------------------------------------------------------
--
--
--DELETE FROM przyjecie;
--DELETE FROM rodzbad;
--DELETE FROM rodzlecz;
--DELETE FROM rozpoznanie;
--DELETE FROM skierow;
--DELETE FROM lekarz;
--DELETE FROM pacjent;
--DELETE FROM kasach;
--
--
INSERT INTO kasach(opis, uwagi) VALUES('Podkarpacka','09 R');
INSERT INTO kasach(opis, uwagi) VALUES('Mazowiecka','07 R ');
INSERT INTO kasach(opis, uwagi) VALUES('Wojskowa','17 B');
INSERT INTO kasach(opis, uwagi) VALUES('Małopolska','06 R');
INSERT INTO kasach(opis, uwagi) VALUES('Dolnośląska','01 R');
INSERT INTO kasach(opis, uwagi) VALUES('Śląska','12 R');
INSERT INTO kasach(opis, uwagi) VALUES('Pomorska','11 R');
INSERT INTO kasach(opis, uwagi) VALUES('Zachodniopomorska','16 R');
INSERT INTO kasach(opis, uwagi) VALUES('Podlaska','10 R');
INSERT INTO kasach(opis, uwagi) VALUES('Opolska','08 R');
INSERT INTO kasach(opis, uwagi) VALUES('Warmińsko-Mazurska','14 R');
INSERT INTO kasach(opis, uwagi) VALUES('Świętokrzyska','13 R');
INSERT INTO kasach(opis, uwagi) VALUES('Kujawsko-Pomorska','02 R');
INSERT INTO kasach(opis, uwagi) VALUES('Lubelska','03 R');
INSERT INTO kasach(opis, uwagi) VALUES('Lubuska','04 R');
INSERT INTO kasach(opis, uwagi) VALUES('Łódzka','05 R');
INSERT INTO kasach(opis, uwagi) VALUES('Wielkopolska','15 R');
--
INSERT INTO LEKARZ(imie, nazwisko, uwagi) VALUES('Michał','Zubek','profesor');
INSERT INTO LEKARZ(imie, nazwisko, uwagi) VALUES('Zygmunt','Moss','');
INSERT INTO LEKARZ(imie, nazwisko, uwagi) VALUES('Adam','Zarzeczny','');
INSERT INTO LEKARZ(imie, nazwisko, uwagi) VALUES('Piotr','Bilski','');
INSERT INTO LEKARZ(imie, nazwisko, uwagi) VALUES('Roman','Góra','');
INSERT INTO LEKARZ(imie, nazwisko, uwagi) VALUES('Grzegorz','Piwowski','');
INSERT INTO LEKARZ(imie, nazwisko, uwagi) VALUES('Michał','Sobański','');
INSERT INTO LEKARZ(imie, nazwisko, uwagi) VALUES('Stanisław','Dzierzkowski','');
INSERT INTO LEKARZ(imie, nazwisko, uwagi) VALUES('Janina','Jagielska','');
INSERT INTO LEKARZ(imie, nazwisko, uwagi) VALUES('Henryk','Koza','');
--
INSERT INTO pacjent(pesel, nazwisko, imie) VALUES ( 11111111001,'Adamowicz', 'Adolf');
INSERT INTO pacjent(pesel, nazwisko, imie) VALUES ( 11111111002,'Bogdanowicz', 'Bolesław');
INSERT INTO pacjent(pesel, nazwisko, imie) VALUES ( 11111111003,'Ćwiekłowski', 'Światosław');
INSERT INTO pacjent(pesel, nazwisko, imie) VALUES ( 11111111004,'Ącka', 'Łucja');
INSERT INTO pacjent(pesel, nazwisko, imie) VALUES ( 11111111005,'Ńusiński', 'Żelisław');
INSERT INTO pacjent(pesel, nazwisko, imie) VALUES ( 11111111006,'Żełkowski', 'Ćwielisław');
INSERT INTO pacjent(pesel, nazwisko, imie) VALUES ( 11111111007,'Ęckiewicz', 'Qumran');
INSERT INTO pacjent(pesel, nazwisko, imie) VALUES ( 11111111008,'Adamowicz', 'Jan');
INSERT INTO pacjent(pesel, nazwisko, imie) VALUES ( 11111111009,'Adamowicz', 'Jan');
INSERT INTO pacjent(pesel, nazwisko, imie) VALUES ( 11111111010,'Światopełkiewiczówna', 'Genowefa');
INSERT INTO pacjent(pesel, nazwisko, imie) VALUES ( 11111111011,'Fus', 'Maria');
INSERT INTO pacjent(pesel, nazwisko, imie) VALUES ( 11111111012,'Oborski', 'Ursus');
INSERT INTO pacjent(pesel, nazwisko, imie) VALUES ( 11111111013,'Zuber', 'Justyna');
--
--
INSERT INTO SKIEROW(opis, uwagi) VALUES('Neurologia w/m','');
INSERT INTO SKIEROW(opis, uwagi) VALUES('Szpital Siedlce','');
INSERT INTO SKIEROW(opis, uwagi) VALUES('PR Poznańska','');
INSERT INTO SKIEROW(opis, uwagi) VALUES('Chirurgia w/m','');
INSERT INTO SKIEROW(opis, uwagi) VALUES('ESCULAP Przychodnia',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('EVITA Garwolin',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Klinika Neurologii MSWiA',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Miejski Ośrodek Zdrowia Zielonka',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Neurologia, Sokołów Podlaski','');
INSERT INTO SKIEROW(opis, uwagi) VALUES('Neurologia Siedlce','');
INSERT INTO SKIEROW(opis, uwagi) VALUES('Onkologia, Siedlce','');
INSERT INTO SKIEROW(opis, uwagi) VALUES('Poradnia lek. ZPZZLO',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Poradnia Neurologiczna Legnica',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Poradnia Neurologiczna Łowicz',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Poradnia Neurologiczna Siedlce',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('PR Legionowo',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('prof. Friedmański','');
INSERT INTO SKIEROW(opis, uwagi) VALUES('Przychodnia, Krypska, Warszawa',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Przychodnia - Łosice',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Przychodnia Mińsk Mazowiecki',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Przychodnia Warszawa-Mokotów',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Przyjęcie w trybie nagłym',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('SOR',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('STOCER',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Szpital Powiatowy Stalowa Wola',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Szpital Siedlce Neurologia',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('VITAMED NZOZ',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('ZOZ Busko - Zdrój',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('ZOZ Serock',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('ARS MEDICA',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Centrum Medyczne Sadyba',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Centrum Rehabilitacji STOCER',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Neurologia Siedlce',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Neurologia Szpital',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Neurologia Wołomin',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('NZOZ',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Poradnia Ogólna',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Praktyka Lekarska',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Szpital Czerniakowski',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Centrum Medyczne',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('Gabinet Neurologii',NULL);
INSERT INTO SKIEROW(opis, uwagi) VALUES('PR Wołomin',NULL);
--
--
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('guz mózgu','');
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('choroba Parkinsona','');
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('uraz czaszkowo mózgowy','');
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('krwotok podpajęczynówkowy','');
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Dyskopatia lędźwiowa','');
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Dyskopatia szyjna','');
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('wznowa guza mózgu','');
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('ubytek kości sklepienia czaszki','');
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('do plastyki',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Dyskopatia','');
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Dyskopatia C5-C6',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Dyskopatia C5-C6, C6-C7',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Dyskopatia L5/S1',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Dyskopatia L-S',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Guz III  komory. Wodogłowie.',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Guz Th 2- TH 4','');
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('krwawienie podpajęczynówkowe z peknietego tętniaka',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('krwiak','');
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('krwiak podtwardówkowy lewej pókuli mózgu',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('krwiak przymózgowy',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Naczyniak mózgu do embolizacji',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('oponiak',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('oponiak mózgu',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('ostry krwiak nadtwardówkowy',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Stan po usunięciu krwiaka','');
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('tętniaki','');
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('tętniak',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('zespół Arnolda Chiari',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('do arteriografii',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Dyskopatia L5-S1',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('guz mózgu - do biopsji',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Guz prawego płata czołowego',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('krwawienie podpajęczynówkowe',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('odrost oponiaka',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('oponiak przedniego dołu czaszki',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('uraz kręgosłupa',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('wielopoziomowa dyskopatia L-S',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Złamanie L4',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Złamanie trzonu L2',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('guz lewej półkuli mózgu',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('krwiak nadtwardówkowy',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Mnogie zmiany OUN.',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('Naczyniak mózgu.',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('stan po operacji kręgozmyka L4-L5',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('tętniak tętnicy podstawnej',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('uraz czaszkowo - mózgowy',NULL);
INSERT INTO ROZPOZNANIE(opis, uwagi) VALUES('zespół Toureta',NULL);
--
--
INSERT INTO rodzlecz(opis) VALUES ('Operacyjne');
INSERT INTO rodzlecz(opis) VALUES ('Zachowawcze');
--
--
INSERT INTO rodzbad(opis) VALUES ('Histopatologiczne');

--
--
commit;






