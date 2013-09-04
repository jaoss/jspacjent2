-- -------------------------------------------------------------------
--     Nazwa pliku: ddt_jspacjent.sql
--       Utworzony: 04.09.2013
--           Autor: Janusz Sw 2013
--           Firma: 
--       Dziaanie: utworzenie tabel systemu JSPacjent, baza MySQL
--        Podstawa:
-- Etap realizacji: Test
--           Uwagi:
-- -------------------------------------------------------------------

-- CREATE DATABASE jspacjent;
-- USE jspacjent;
--
-- DROP TABLE IF EXISTS `badanie`;
-- DROP TABLE IF EXISTS `leczenie`;
-- DROP TABLE IF EXISTS `przyjecie`;
-- DROP TABLE IF EXISTS `rodzbad`;
-- DROP TABLE IF EXISTS `rodzlecz`;
-- DROP TABLE IF EXISTS `rozpoznanie`;
-- DROP TABLE IF EXISTS `lekarz`;
-- DROP TABLE IF EXISTS `skierow`;
-- DROP TABLE IF EXISTS `pacjen`t;
-- DROP TABLE IF EXISTS `kasaCh`;
--
-- -------------------------------------------------------------------
-- Struktura tabeli dla KAS CHORYCH pacjenta
--  informacje o kasach chorych
-- -------------------------------------------------------------------
--
CREATE TABLE `kasaCh` (    
  --
  `id_kasa` INT(10) unsigned NOT NULL auto_increment, -- identyfikator kasy chorych                         
  `opis`    VARCHAR(35) NOT NULL,                     -- opis kasy chorych 
  --
  `uwagi`   VARCHAR(20),                              -- uwagi do kasy chorych
  --
  CONSTRAINT `kasaCh_pk` PRIMARY KEY( `id_kasa` )  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;
--
--
-- -------------------------------------------------------------------
-- Struktura tabeli dla  PACJENT?
--  oglne informacje o pacjencie
-- -------------------------------------------------------------------
--
CREATE TABLE `pacjent` ( 
  --
  `id_pacj`  INT(10) unsigned NOT NULL auto_increment, -- identyfikator pacjenta
  `pesel`    DECIMAL(11),                              -- pesel pacjenta
  `imie`     VARCHAR(15),                              -- imi?acjenta
  `nazwisko` VARCHAR(25) NOT NULL,                     -- nazwisko pacjenta
  `wiek`     FLOAT,                                    -- wiek pacjenta
  `adres`    VARCHAR(55),                              -- adres zamieszkania pacjenta 
  `kontakt`  VARCHAR(35),                              -- osoba kontaktowa
  `telKont`  VARCHAR(15),                              -- telefon kontaktowy     
  `id_kasa`  INT(10) unsigned,                         -- identyfikator kasy chorych  
  --  
  `uwagi`    VARCHAR(20),
  --
  CONSTRAINT `pacjent_pk` PRIMARY KEY(`id_pacj`),
  CONSTRAINT `pacjent_kasaCh_fk` FOREIGN KEY( `id_kasa` )
                                 REFERENCES `kasaCh`( `id_kasa` ) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;
--
--
-- -------------------------------------------------------------------
-- Struktura tabeli dla MIEJSC SKD SKIEROWANO pacjenta
--  informacje 
-- -------------------------------------------------------------------
--
CREATE TABLE `skierow` (    
  --
  `id_skier` INT(10) unsigned NOT NULL auto_increment, -- id miejsca skierowania 
  `opis`     VARCHAR(35) NOT NULL,                     -- opis miejsca skierowania 
  --
  `uwagi`    VARCHAR(20),
  --
  CONSTRAINT `skierow_pk` PRIMARY KEY( `id_skier` )   
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;
--
--
-- -------------------------------------------------------------------
-- Struktura tabeli dla LEKARZY na oddziale
--  informacje o lekarzach
-- -------------------------------------------------------------------
--
CREATE TABLE `lekarz` (  
  --
  `id_lekarz` INT(10) unsigned NOT NULL auto_increment, -- identyfikator lekarza  
  `imie`      VARCHAR(15),                              -- imi?ekarza 
  `nazwisko`  VARCHAR(25)  NOT NULL,                    -- nazwisko lekarza   
  --
  `uwagi`     VARCHAR(20),
  --
  CONSTRAINT `lekarz_pk` PRIMARY KEY( `id_lekarz` )  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;
--
--
-- -------------------------------------------------------------------
-- Struktura tabeli dla ROZPOZNANIA CHOROBY na oddziale
--  informacje o rozpoznaniu
-- -------------------------------------------------------------------
--
CREATE TABLE `rozpoznanie` (    
  --
  `id_rozp`  INT(10) unsigned NOT NULL auto_increment,  -- id rozpoznania 
  `opis`     VARCHAR(55),                               -- opis rozpoznania 
  --
  `uwagi`    VARCHAR(20),
  --
  CONSTRAINT `rozpoznanie_pk` PRIMARY KEY( `id_rozp` )   
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;
--
-- -------------------------------------------------------------------
-- Struktura tabeli dla RODZAJ? LECZENIA na oddziale
--  informacje o rodzajach leczenia
-- -------------------------------------------------------------------
--
CREATE TABLE `rodzlecz` (    
  --
  `id_rodzl` INT(10) unsigned NOT NULL auto_increment,  -- rodzaj leczenia 
  `opis`     VARCHAR(35),                               -- opis leczenia 
  --
  `uwagi`    VARCHAR(20),
  --
  CONSTRAINT `rodzlecz_pk` PRIMARY KEY( `id_rodzl` )   
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;
--
--
-- -------------------------------------------------------------------
-- Struktura tabeli dla RODZAJ? BADANIA na oddziale
--  informacje o rodzajach badania
-- -------------------------------------------------------------------
--
CREATE TABLE `rodzbad` (    
  --
  `id_rodzb` INT(10) unsigned NOT NULL auto_increment,  -- rodzaj badania 
  `opis`     VARCHAR(35),                               -- opis badania 
  --
  `uwagi`    VARCHAR(20),
  --
  CONSTRAINT `rodzbad_pk` PRIMARY KEY( `id_rodzb` )   
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;
--
--
-- -------------------------------------------------------------------
-- Struktura tabeli dla  PRZYJ? na oddzia
--  informacje o przyj?u
-- -------------------------------------------------------------------
--
CREATE TABLE `przyjecie` (
  --
  `id_przyj`  INT(10) unsigned NOT NULL auto_increment, -- identyfikator przyj?a  
  `nrGlowny`  INT(10) unsigned NOT NULL, -- numer gwny ksi? szpitala
  `nrOddzial` INT(10) unsigned NOT NULL, -- numer odziaowy
  `ksg`       VARCHAR(4),                -- sygnatura ksi?      
  `id_pacj`   INT(10) unsigned NOT NULL, -- identyfikator pacjenta
  --
  `data_prz`  TIMESTAMP,           -- data i czas przyj?a do szpitala
  `sskierow`  VARCHAR(35),         -- skd skierowany
  `sk_uwagi`  VARCHAR(25),         -- uwagi o skierowaniu
  `id_lekarz` INT(10) unsigned,    -- identyfikator lekarza prowadzcego
  `rozpWst`   VARCHAR(45),         -- rozpoznanie wst?e
  `rozpOst`   VARCHAR(45),         -- rozpoznanie ostateczne   
  `data_wyp`  TIMESTAMP,           -- data i czas wypisania ze szpitala
  `gdzieWyp`  VARCHAR(35),         -- gdzie wypisany  
  --
  `uwagi`   VARCHAR(20),
  --
  CONSTRAINT `przyjecie_pk` PRIMARY KEY( `id_przyj` ),
  -- Kadego roku numery zaczynaj si?d nowa, nie s unikalne  
  -- CONSTRAINT przyjecie_nrGlowny_uq  UNIQUE(nrGlowny),
  -- CONSTRAINT przyjecie_nrOddzial_uq UNIQUE(nrOddzial),
  CONSTRAINT `przyjecie_pacjent_fk` FOREIGN KEY( `id_pacj` )
                                    REFERENCES `pacjent`( `id_pacj` ),
  CONSTRAINT `przyjecie_lekarz_fk`  FOREIGN KEY( `id_lekarz` )
                                    REFERENCES lekarz( `id_lekarz` ) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;
--
--
-- -------------------------------------------------------------------
-- Struktura tabeli dla LECZENIA na oddziale
--  informacje o leczeniu
-- -------------------------------------------------------------------
--
CREATE TABLE `leczenie` (  
  --
  `id_lecz`  INT(10) unsigned NOT NULL auto_increment,  -- identyfikator leczenia  
  `id_przyj` INT(10) unsigned NOT NULL,  -- identyfikator przyj?a
  `data`     DATE,             -- data leczenia
  `id_rodzl` INT(10) unsigned, -- rodzaj leczenia 
  `opis`     VARCHAR(75),      -- opis leczenia 
  --
  `uwagi`    VARCHAR(20),
  --
  CONSTRAINT `leczenie_pk` PRIMARY KEY( `id_lecz` ),
  CONSTRAINT `leczenie_przyjecie_fk` FOREIGN KEY( `id_przyj` )
                                     REFERENCES `przyjecie`( `id_przyj` )
                                     ON DELETE CASCADE,
  CONSTRAINT `leczenie_rodzlecz_fk`  FOREIGN KEY( `id_rodzl` )
                                     REFERENCES `rodzlecz`( `id_rodzl` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;
--
--
-- -------------------------------------------------------------------
-- Struktura tabeli dla BADA?na oddziale
--  informacje o badaniach
-- -------------------------------------------------------------------
--
CREATE TABLE `badanie` (  
  --
  `id_badan` INT(10) unsigned NOT NULL auto_increment,  -- identyfikator badania
  `id_przyj` INT(10) unsigned NOT NULL,  -- identyfikator przyj?a  
  `data`     DATE,             -- data badania
  `id_rodzb` INT(10) unsigned, -- rodzaj badania 
  `opis`     VARCHAR(75),      -- opis badania 
  --
  `uwagi`    VARCHAR(20),
  --
  CONSTRAINT `badanie_pk` PRIMARY KEY( `id_badan` ),
  CONSTRAINT `badanie_przyjecie_fk` FOREIGN KEY( `id_przyj` )
                                    REFERENCES `przyjecie`( `id_przyj` )
                                    ON DELETE CASCADE,
  CONSTRAINT `badanie_rodzbad_fk`   FOREIGN KEY( `id_rodzb` )
                                    REFERENCES `rodzbad`( `id_rodzb` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;
--
--
-- -------------------------------------------------------------------
COMMIT;
