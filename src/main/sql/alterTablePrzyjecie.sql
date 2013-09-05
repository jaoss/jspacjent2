-- ALTER TABLE Przyjecie DROP COLUMN Ksg;
-- ALTER TABLE Przyjecie ADD COLUMN Ksg VARCHAR(4);
--
-- UPDATE Przyjecie SET Ksg = '07' 
-- WHERE Ksg IS NULL;

ALTER TABLE `Lekarz` ADD COLUMN `email` varchar(100) collate utf8_unicode_ci;
ALTER TABLE `Lekarz` ADD COLUMN `password` varchar(32) collate utf8_unicode_ci;



