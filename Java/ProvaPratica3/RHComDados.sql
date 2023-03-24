-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.6.35 - MySQL Community Server (GPL)
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              11.0.0.6115
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para recursoshumanos
CREATE DATABASE IF NOT EXISTS `recursoshumanos` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `recursoshumanos`;

-- Copiando estrutura para tabela recursoshumanos.pessoal
CREATE TABLE IF NOT EXISTS `pessoal` (
  `cargo` varchar(50) DEFAULT NULL,
  `matricula` int(11) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  `turma` varchar(50) DEFAULT NULL,
  `setor` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela recursoshumanos.pessoal: ~100 rows (aproximadamente)
DELETE FROM `pessoal`;
/*!40000 ALTER TABLE `pessoal` DISABLE KEYS */;
INSERT INTO `pessoal` (`cargo`, `matricula`, `nome`, `email`, `senha`, `turma`, `setor`) VALUES
	('Administrativo', 11111, 'Rica Ashwood', 'rashwood0@unc.edu', '11111', '', 'Secretaria'),
	('Administrativo', 95187, 'Carlota McNevin', 'cmcnevin4@vk.com', '5ySSLEMF', '', 'Estágio'),
	('Administrativo', 80068, 'Evita Breton', 'ebreton7@businessweek.com', 'ZxlLTDTwh6ng', '', 'Biblioteca'),
	('Administrativo', 85306, 'Al Gross', 'agross8@tumblr.com', 'uP0f7qZ', '', 'Estágio'),
	('Administrativo', 75190, 'Lynette Marquet', 'lmarqueta@indiatimes.com', 'C04Y8V', '', 'Estágio'),
	('Administrativo', 19617, 'Penrod Goodhand', 'pgoodhandb@zimbio.com', '7qMw3JjCb', '', 'Secretaria'),
	('Administrativo', 87422, 'Lyndsie Niesel', 'lniesELE', '8kvygux', '', 'Secretaria'),
	('Administrativo', 44767, 'Barbra Bruckenthal', 'bbruckenthalg@noaa.gov', 'JfiIl7rbfY', '', 'Estágio'),
	('Administrativo', 4010, 'Halsy Doust', 'hdousti@usgs.gov', 'tFThgKmOPQ', '', 'Biblioteca'),
	('Administrativo', 87782, 'Sampson Colquyte', 'scolquytej@sfgate.com', 'D0xzJ7VDWS75', '', 'Biblioteca'),
	('Administrativo', 10954, 'Mirabel MacGahy', 'mmacgahyl@businesswire.com', 'VL6zPH', '', 'Biblioteca'),
	('Administrativo', 6100, 'Farlee Crayk', 'fcraykw@ifeng.com', 'DPaxFw', '', 'Secretaria'),
	('Administrativo', 75033, 'Daune Siddle', 'dsiddlez@ustream.tv', 'Br1ab8', '', 'Estágio'),
	('Administrativo', 54616, 'Ban Girardi', 'bgirardi11@mayoclinic.com', 'SmkwQQM5rbfr', '', 'Secretaria'),
	('Administrativo', 19965, 'Andreana Leavy', 'aleavy15@huffingtonpost.com', '7z1kPg', '', 'Estágio'),
	('Administrativo', 54477, 'Gil Bendix', 'gbendix18@umich.edu', '0KA1iPgKcjE', '', 'Estágio'),
	('Administrativo', 19013, 'Cristin Riddich', 'criddich19@abc.net.au', '9Bo5yQkW2', '', 'Biblioteca'),
	('Administrativo', 35100, 'Lindie Fass', 'lfass1d@tripod.com', 'FMWXNRCieazb', '', 'Estágio'),
	('Administrativo', 65898, 'Vevay Mandy', 'vmandy1e@drupal.org', '1Yy7sh1', '', 'Biblioteca'),
	('Administrativo', 83899, 'Daryl Frost', 'dfrost1g@google.com.br', 'dSU7GkXeqNY', '', 'Estágio'),
	('Administrativo', 98130, 'Andreana Mugford', 'amugford1h@unicef.org', 'TgEf0oR', '', 'Biblioteca'),
	('Administrativo', 20824, 'Barbara-anne Hansana', 'bhansana1k@sphinn.com', 'DswyrxKpFad', '', 'Secretaria'),
	('Administrativo', 39432, 'Dominique Eldred', 'deldred1m@nyu.edu', '2mA9DjwYba', '', 'Estágio'),
	('Administrativo', 11925, 'Karon Loalday', 'kloalday1p@utexas.edu', 'Fk3mpvZb', '', 'Estágio'),
	('Administrativo', 12036, 'Dory Kenner', 'dkenner1r@posterous.com', 'Bv6gvknf3u', '', 'Estágio'),
	('Administrativo', 8691, 'Alain Lippingwell', 'alippingwell1t@jalbum.net', 'zBxn7xh', '', 'Biblioteca'),
	('Administrativo', 4879, 'Enriqueta Bryan', 'ebryan23@biblegateway.com', 'xTRygIG', '', 'Biblioteca'),
	('Administrativo', 95969, 'Brande Heaphy', 'bheaphy2d@moonfruit.com', 'Vkw1Su4aY0h', '', 'Estágio'),
	('Administrativo', 74585, 'Patrice Dyball', 'pdyball2f@livejournal.com', 'A5Va3Ww5d', '', 'Secretaria'),
	('Administrativo', 93076, 'Florian Pendered', 'fpendered2g@mapquest.com', 'JKPPj5lQILwf', '', 'Biblioteca'),
	('Administrativo', 68270, 'Cynthie Broxholme', 'cbroxholme2h@weibo.com', '1rCDqGVQb7W', '', 'Estágio'),
	('Administrativo', 50775, 'Corrine Kobera', 'ckobera2j@mac.com', 'y5fE8O', '', 'Biblioteca'),
	('Administrativo', 88693, 'Addy Pandie', 'apandie2l@friendfeed.com', '0lMh6C7XNey', '', 'Estágio'),
	('Administrativo', 40295, 'Gaspar Fautley', 'gfautley2q@cbc.ca', '4Exz4e8B', '', 'Secretaria'),
	('Aluno', 400000, 'Leonhard Lurriman', 'llurriman2@utexas.edu', '44444', 'INF', ''),
	('Aluno', 6294, 'Redford Fearenside', 'rfearensidec@vistaprint.com', '0s032BQ', 'CAM', ''),
	('Aluno', 68210, 'Dame Ammer', 'dammerd@nba.com', 'Pjnadsv', 'CAM', ''),
	('Aluno', 68698, 'Raddie Jurgensen', 'rjurgenseno@goo.gl', '6eUrnOfoT', 'CAM', ''),
	('Aluno', 94109, 'Aigneis Gillean', 'agilleanp@economist.com', '98cIcV', 'CAM', ''),
	('Aluno', 36115, 'Allys Barchrameev', 'abarchrameevv@vistaprint.com', 'soj54iXthjL2', 'ELE', ''),
	('Aluno', 10394, 'Winthrop Colbourne', 'wcolbournex@storify.com', 'ud7djzNoyD', 'INF', ''),
	('Aluno', 26314, 'Jonell Zorro', 'jzorroy@blogtalkradio.com', 'Bspm9u', 'ELE', ''),
	('Aluno', 50888, 'Gerik Breukelman', 'gbreukelman13@constantcontact.com', '7GZzigceWHEv', 'CAM', ''),
	('Aluno', 64042, 'Christiano Hutchinson', 'chutchinson14@prnewswire.com', 'lsj7Ia', 'CAM', ''),
	('Aluno', 70552, 'Justen Tulk', 'jtulk17@abc.net.au', 'Oz282pNtu', 'CAM', ''),
	('Aluno', 9638, 'Quintilla Durran', 'qdurran1b@state.tx.us', 'DJpV6jlLRBf', 'ELE', ''),
	('Aluno', 42174, 'Kellie Armfield', 'karmfield1f@behance.net', '38e1LW', 'CAM', ''),
	('Aluno', 27261, 'Jilli Morgan', 'jmorgan1j@prnewswire.com', 'EQtr3J', 'INF', ''),
	('Aluno', 3782, 'Danni Ethridge', 'dethridge1n@archive.org', 'IFdNcke16K', 'ELE', ''),
	('Aluno', 51864, 'Tallie Wilshire', 'twilshire1u@blogtalkradio.com', 'PU5BRfIJq0', 'INF', ''),
	('Aluno', 29195, 'Bibbye Goldbourn', 'bgoldbourn1v@lulu.com', 'mSMbUfK', 'ELE', ''),
	('Aluno', 44318, 'Devland Battaille', 'dbattaille1x@shutterfly.com', 'ZSdJaVp', 'INF', ''),
	('Aluno', 48097, 'Chery Leaney', 'cleaney1y@statcounter.com', 'Fh0olJc', 'ELE', ''),
	('Aluno', 42718, 'Jere Goodson', 'jgoodson1z@usnews.com', 'qk3Vxb', 'ELE', ''),
	('Aluno', 74533, 'Kristofer Erswell', 'kerswell20@twitpic.com', 'tLt0ZqAy6y0g', 'CAM', ''),
	('Aluno', 18246, 'Adel Comberbach', 'acomberbach22@4shared.com', '5wCOkfmLr', 'CAM', ''),
	('Aluno', 79609, 'Sloane Lissett', 'slissett25@hexun.com', 'GNeS4g46uC2', 'INF', ''),
	('Aluno', 37083, 'Niko Beachem', 'nbeachem26@nature.com', 'S1BceuC', 'CAM', ''),
	('Aluno', 96888, 'Alyss Print', 'aprint29@clickbank.net', '7Q0VDsmDI', 'INF', ''),
	('Aluno', 83098, 'Elwin Erbain', 'eerbain2a@ox.ac.uk', '0cS8CAzpb', 'ELE', ''),
	('Aluno', 40861, 'Rahel AbELE', 'rabELE', '2ZQK9w4evon', 'ELE', ''),
	('Aluno', 8208, 'Odelle Beavors', 'obeavors2k@blogtalkradio.com', 'NZcOnxOP', 'ELE', ''),
	('Aluno', 19943, 'Charmaine Calderon', 'ccalderon2m@netvibes.com', 'qF1KRo', 'INF', ''),
	('Aluno', 52969, 'Pansy Heino', 'pheino2n@naver.com', 'tXpKtq9NHpE', 'INF', ''),
	('Aluno', 99957, 'Amara Bax', 'abax2o@geocities.jp', 'iwU8XpcRW', 'CAM', ''),
	('Aluno', 35981, 'Maddy Pacitti', 'mpacitti2p@noaa.gov', 'SJYSS0', 'CAM', ''),
	('Aluno', 82912, 'Merilee Garth', 'mgarth2r@reference.com', '8vRov7mPsE', 'CAM', ''),
	('Professor', 33000, 'Karlis Winterbourne', 'kwinterbourne1@unicef.org', '333', '', ''),
	('Professor', 87156, 'Alanah Reuss', 'areuss3@sourceforge.net', 'LQ27EVRhSR4g', '', ''),
	('Professor', 48742, 'Ada Trayte', 'atrayte5@ox.ac.uk', 'BOGZLTh', '', ''),
	('Professor', 37244, 'Gabie McEntagart', 'gmcentagart6@hc360.com', 'Xn8ufR', '', ''),
	('Professor', 84813, 'Rudolph Lacasa', 'rlacasa9@skyrock.com', '4sR26fBp9T', '', ''),
	('Professor', 53648, 'Finley Ritelli', 'fritellif@yale.edu', 'AOP7rf', '', ''),
	('Professor', 79432, 'Isis Wiggin', 'iwigginh@ted.com', 'KcSgBJtbN', '', ''),
	('Professor', 58427, 'Romona Slite', 'rslitek@t.co', 'M0EVVUO3tI9E', '', ''),
	('Professor', 59539, 'Ulric Pomfret', 'upomfretm@odnoklassniki.ru', '3AiRaEg5nmm', '', ''),
	('Professor', 16054, 'Dix Ellam', 'dellamn@imdb.com', 'sMZB3KL', '', ''),
	('Professor', 95816, 'Audrey Portail', 'aportailq@fda.gov', 'E4uxpZjLG7Gg', '', ''),
	('Professor', 56618, 'Darelle Gamlen', 'dgamlenr@dailymotion.com', 'xjDAjVGKb', '', ''),
	('Professor', 8038, 'Eddy Wadly', 'ewadlys@bigcartel.com', 'F00V4RxFI', '', ''),
	('Professor', 33961, 'Ynes Commin', 'ycommint@a8.net', 'r5HRsWcAW8', '', ''),
	('Professor', 13817, 'Dulcie Cumo', 'dcumou@booking.com', '9q6LD74kqo', '', ''),
	('Professor', 19287, 'Cullin Attwooll', 'cattwooll10@aboutads.INF', '06TqIM', '', ''),
	('Professor', 23939, 'Caryl Ledes', 'cledes12@mapy.cz', '1kza95', '', ''),
	('Professor', 27343, 'Deedee Smythe', 'dsmythe16@msn.com', 'VxraUM', '', ''),
	('Professor', 91583, 'Tamarah Quinnette', 'tquinnette1a@bloglines.com', 'EeYwvu1a', '', ''),
	('Professor', 79490, 'Teirtza Hughman', 'thughman1c@phpbb.com', '6E4HqJJf', '', ''),
	('Professor', 3079, 'Melody Pleaden', 'mpleaden1i@admin.ch', 'hGDbPGFLCKhS', '', ''),
	('Professor', 35694, 'Rosabelle Boldra', 'rboldra1l@blogtalkradio.com', 'eH0Rksqw', '', ''),
	('Professor', 29574, 'Read Polkinghorne', 'rpolkinghorne1o@narod.ru', 'YCGOrAE', '', ''),
	('Professor', 84445, 'Nataline Mulroy', 'nmulroy1q@army.mil', 'jhTCM1o2', '', ''),
	('Professor', 14976, 'Didi Chalfain', 'dchalfain1s@google.es', 'otaZJZfc1', '', ''),
	('Professor', 17333, 'Petunia Manske', 'pmanske1w@go.com', '2FAzJQ', '', ''),
	('Professor', 60448, 'Franciskus Andriolli', 'fandriolli21@privacy.gov.au', 'O5cYmalbI8', '', ''),
	('Professor', 42810, 'Gael Murrow', 'gmurrow24@flavors.me', 'z03Qrxwil', '', ''),
	('Professor', 58602, 'Walt O\'Luby', 'woluby27@flavors.me', 'UuQE5iQhuI', '', ''),
	('Professor', 9968, 'Ulrikaumeko Aliberti', 'ualiberti28@cnbc.com', 'bpHyiq7', '', ''),
	('Professor', 76871, 'Ruby Toomey', 'rtoomey2b@angelfire.com', 'f8US9ExmPU', '', ''),
	('Professor', 94697, 'Daryle Buzza', 'dbuzza2c@chronoengine.com', 'lfYV0kFcDS', '', ''),
	('Professor', 67243, 'Joey Teanby', 'jteanby2i@huffingtonpost.com', 'SkoHEvWhiPC', '', '');
/*!40000 ALTER TABLE `pessoal` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
