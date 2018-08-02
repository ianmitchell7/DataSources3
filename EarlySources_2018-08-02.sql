# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.38)
# Database: EarlySources
# Generation Time: 2018-08-02 08:34:02 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table DataSources
# ------------------------------------------------------------

DROP TABLE IF EXISTS `DataSources`;

CREATE TABLE `DataSources` (
  `dataSourceId` int(11) NOT NULL AUTO_INCREMENT,
  `dataSourceName` varchar(255) DEFAULT '',
  `url` varchar(255) DEFAULT '',
  `sourceType` varchar(255) DEFAULT '',
  `updateInterval` varchar(255) DEFAULT '',
  `nextUpdateEarliest` varchar(255) DEFAULT '',
  `comments` varchar(2000) DEFAULT '',
  `parentId` int(11) DEFAULT NULL,
  `nextUpdateLatest` varchar(255) DEFAULT '',
  `latestUpdate` varchar(255) DEFAULT '',
  `updateMethod` varchar(255) DEFAULT '',
  `processedUpdate` varchar(255) DEFAULT '',
  `commentsUpdate` varchar(255) DEFAULT '',
  `dependancyBrotherId` varchar(255) DEFAULT '',
  `dependancySisterId` varchar(11) DEFAULT '',
  `deactivated` varchar(255) DEFAULT '',
  `transferredToMaster` varchar(255) DEFAULT '',
  `ewControllerId` varchar(255) DEFAULT '',
  `wacheteUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dataSourceId`),
  KEY `ParentID` (`parentId`),
  CONSTRAINT `datasources_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `ParentSources` (`parentSourceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `DataSources` WRITE;
/*!40000 ALTER TABLE `DataSources` DISABLE KEYS */;

INSERT INTO `DataSources` (`dataSourceId`, `dataSourceName`, `url`, `sourceType`, `updateInterval`, `nextUpdateEarliest`, `comments`, `parentId`, `nextUpdateLatest`, `latestUpdate`, `updateMethod`, `processedUpdate`, `commentsUpdate`, `dependancyBrotherId`, `dependancySisterId`, `deactivated`, `transferredToMaster`, `ewControllerId`, `wacheteUrl`)
VALUES
	(1,'NAV - Arbeidsledighet Fylke/Kommune','https://www.nav.no/no/NAV+og+samfunn/Statistikk/Arbeidssokere+og+stillinger+-+statistikk/Hovedtall+om+arbeidsmarkedet','2','1',NULL,'Rundt 1. i måneden, har publiseringskalender. 2 Filer.',46,'2018-07-01','2018-06-29','2','','','','','','','5','https://www.wachete.com/wachet/1cec04af-a9e6-4058-af14-b6f17f9609c4'),
	(2,'FN - Skadeforsikring Premiestatistikk','https://www.finansnorge.no/statistikk/skadeforsikring/kvartalsvise-statistikk-publikasjoner/premiestatistikk-skadeforsikring/','2','7',NULL,'Feb/Mai/Aug/Nov. Varierer fra gang til gang\n\nsamme som Markedsdata Skadeforsikring ?',23,'2018-08-30','','2','','','','','','','5','https://www.wachete.com/wachet/eed3e528-0108-4d54-8f9b-f75337244a30'),
	(3,'VFF - Fondsparing','https://www.vff.no/siste-måned','2','1',NULL,'Kommer som regel 20-25 i måneden\n\nKalkuleres når FN Liv og VFF kvartalsmåned er inne',62,'2018-07-20','','2','','','','','','','5','https://www.wachete.com/wachet/ac9b3af8-aa38-4255-800b-85991938fc46'),
	(4,'Oslo Børs - NIBOR','https://www.oslobors.no/markedsaktivitet/#/list/nibor/quotelist','2','1',NULL,'Kommer som regel 1. eller 2. i måneden',30,'2018-08-01','','1','','','','','','','5',''),
	(5,'NB - Styringsrente','https://www.norges-bank.no/Statistikk/Rentestatistikk/Styringsgrente-manedlig/','2','1',NULL,'Kommer som regel 1. eller 2. i måneden',51,'2018-07-15','','1','','','','','','','5',''),
	(6,'SSB - Makrofremskrivninger','http://www.ssb.no/nasjonalregnskap-og-konjunkturer?de=Konjunkturer&innholdstype=artikkel&se=Konjunkturtendensene&sortering=dato','2','7',NULL,'4 x per år - Des/Mar/Jun/Sep',24,'2018-09-01','','2','','','','','','','5',''),
	(7,'FN - Liv og Pensjon - Markeds-og regnskapsstatistikk','https://www.finansnorge.no/statistikk/livsforsikring/regnskap-og-balanse/','2','7',NULL,'Brukes på forskjellige måter (Storebrand og Finans Norge)\n\nStorebrand :-\n1. Rundt 8 uker etter kvartalsslutt.  \n2. Utvagte nøkkeltall hentes manuelt ut fra Excel ark.  \n3. Utvalgte nøkkeltall 3 og 12 mnd vekst beregnes-',23,'2018-09-03','','2','','','','','','','5','https://www.wachete.com/wachet/95929801-e454-47b2-8109-3fa4d54c1709'),
	(8,'IMF - Commodities','http://www.imf.org/external/np/res/commod/index.aspx','2','8',NULL,'Den som er ansvarlig for portal må legge inn rett data for oppdatering',25,'2018-07-08','','2','','','','','','','5',''),
	(9,'IMF - Macro prognoser','http://www.imf.org/external/ns/cs.aspx?id=28','4','3',NULL,'Apr/Okt\nsiste data : http://www.imf.org/external/pubs/ft/weo/2017/02/weodata/index.aspx',25,'2018-10-03','','2','','','','','','','5','https://www.wachete.com/wachet/06841e86-f33a-4f2d-a41a-5503b5856846'),
	(10,'Avinor - Flybevegelser','https://avinor.no/konsern/om-oss/trafikkstatistikk/trafikkstatistikk','2','1',NULL,'Rundt 10. hver måned',47,'2018-07-10','','2','','','','','','','5','https://www.wachete.com/wachet/c08b5fda-56c6-4c43-b104-e329df4f8c2c'),
	(11,'SSB - Varehandel termin','http://www.ssb.no/statbank/sq/10001874/','5','6',NULL,'',24,'2018-08-31','','2','','','','','','','5',''),
	(12,'DNB Markets - Valutaprognoser','https://www.dnb.no/bedrift/markets/analyser/arkiv/okonomiske-utsikter.html','1','2',NULL,'Usikkert.   4 x per år - kort og lang',27,'2018-08-13','','2','','','','','','','5','https://www.wachete.com/wachet/3454a9c1-ad4e-4ef5-ad40-c18a650a92e4'),
	(13,'Taxfree - Folkehelseinstituttet','','1','2',NULL,'Feed og FHInettside\n\nManuell kontakt',28,'2018-07-01','','2','','','','','','','5',''),
	(14,'Tobakksvolum Norge - Folkehelseinstituttet','','1','2',NULL,'Feed og FHInettside\n\nNeste dato : vet ikke',41,'2018-07-01','','2','','','','','','','5',''),
	(15,'European Commission - Tobakk Skatter i EU','https://ec.europa.eu/taxation_customs/sites/taxation/files/resources/documents/taxation/excise_duties/tobacco_products/rates/excise_duties-part_iii_tobacco_en.pdf','1','2',NULL,'Wachete - difficult to setup',79,'2019-01-01','','2','','','','','','','5',''),
	(16,'European Commission - Alkohol Skatter i EU','https://ec.europa.eu/taxation_customs/sites/taxation/files/resources/documents/taxation/excise_duties/alcoholic_beverages/rates/excise_duties-part_i_alcohol_en.pdf','1','2',NULL,'Wachete - difficult to setup',79,'2019-01-01','','2','','','','','','','5',''),
	(17,'SCB - Overnatting SE','http://www.statistikdatabasen.scb.se/pxweb/sv/ssd/START__NV__NV1701__NV1701B/NV1701T910M/?rxid=0883298e-c521-4842-a0cc-3774dc1941b6','2','1',NULL,'Rundt 10. hver måned',80,'2018-07-10','','2','','','','','','','5',''),
	(18,'Overnatting DK - Dansk Statistikk','','2','1',NULL,'Rundt 10. hver måned, varsel ved oppdatering',81,'2018-07-10','','2','','','','','','','5',''),
	(19,'Avinor - Flyplassinntekter','https://avinor.no/konsern/om-oss/finansiell-informasjon/rapporter','1','1',NULL,'Kalender : https://avinor.no/konsern/om-oss/finansiell-informasjon/finansiell-kalender\n30.08.2018    2. kvartal rapport\n29.11.2018     3- kvartal rapport\nWatchete can only be set up to both \"(1) report monthly financial info, AND also (2) report all other documents which are published.by Avinor)\"',47,'2018-08-30','','2','','','','','','','5','https://www.wachete.com/wachet/4312b34d-7b5b-467b-bcf4-cc0e758da4bd'),
	(20,'Torp - Flyplassinntekter','https://www.torp.no/footer/om-torp/arsrapport/','1','2',NULL,'Er denne i bruk i det hele tatt?',82,'2019-05-15','','2','','','','','','','5','https://www.wachete.com/wachet/4ded6331-08bc-4d7d-9000-a88ae32e7dae'),
	(21,'Cruise Norway','http://www.cruise-norway.no/Public-info/Statistics/','2','2',NULL,'Sendes inn av Kåre Sandvik',42,'2018-09-01','','2','','','','','','','5',''),
	(23,'Tertial Calc','','6','4',NULL,'',43,'2018-07-31','','1','','','','','','','5',''),
	(25,'Fjordline - Finansrapporter KF','https://www.fjordline.com/nb/p/finansiell-informasjon','1','7',NULL,'',31,'2018-08-20','','2','','','','','','','5','https://www.wachete.com/wachet/c4622d41-9d5a-45a1-b847-002773f29a97'),
	(26,'Viking Line - Finansrapporter KF','https://www.vikingline.com/en/investors/financial-reports/','1','7',NULL,'Kalender : https://www.vikingline.com/en/investors/investor-calendar/',52,'2018-08-16','','2','','','','','','','5','https://www.wachete.com/wachet/d7248a17-ac37-48be-8a3a-dc0202ff068d'),
	(27,'Tallink - Finansrapporter KF','https://www.tallink.com/reports#tabs-content-3','1','7',NULL,'Kalender : https://cns.omxgroup.com/cdsPublic/viewDisclosure.action?disclosureId=816296&messageId=1025699\n\n09.08.2018 - Unaudited 2. kvartal rapport\n08-11.2018 - Unaudited 3. kvartal rapport',53,'2018-08-09','','2','','','','','','','5','https://www.wachete.com/wachet/4a559c8d-62a0-4539-a7ae-cd550e58b298'),
	(28,'Torghatten Sjø - Finansrapporter','http://www.torghatten.no/finans/arsrapporter','1','2',NULL,'Kun i Q4/årsrapporten',54,'2019-04-15','','2','','','','','','','5','https://www.wachete.com/wachet/a5042c11-ec89-417e-978b-1c989fb7eefd'),
	(29,'Stena AB Group - Finansrapporter','https://www.stena.com/investor-relations/','1','7',NULL,'3. kvartal rapport : 29.11.2018\n',55,'2018-08-29','','2','','','','','','','5',''),
	(30,'DFDS - Finansrapporter KF','https://www.dfds.com/group/investors/reports-and-presentations','1','7',NULL,'',56,'2018-08-09','','2','','','','','','','5','https://www.wachete.com/wachet/c4c3e17e-2486-4de5-ab2d-0d7582b1eca8'),
	(31,'Color Group - Finansrapporter KF','https://www.colorline.no/om-oss/finans','1','3',NULL,'',57,'2018-08-30','','2','','','','','','','5','https://www.wachete.com/wachet/e310b073-3c9f-461c-a4b6-526f4d3d242b'),
	(32,'RCCL - Finansrapporter KF','http://www.rclcorporate.com/investors/financial-information/financial-toolkit/','1','2',NULL,'gammel URL  http://www.rclcorporate.com/investors/financial-information/financial-reports/#annual-reports',58,'2018-08-01','','2','','','','','','','5','https://www.wachete.com/wachet/b5b5db1e-dd54-4c67-8bfa-7f804626dfa5'),
	(33,'Carnival - Finansrapporter KF','http://phx.corporate-ir.net/phoenix.zhtml?c=140690&p=irol-reportsannual','1','2',NULL,'',59,'2018-06-30','','2','','','','','','','5','https://www.wachete.com/wachet/bed92f61-4049-44bd-8abc-b00157394e6b'),
	(34,'Hurtigruten - Finansrapporter KF','https://www.purehelp.no/m/company/account/hurtigrutenas/914904633','1','2',NULL,'Purehelp/Brønnøysund\nEr denne i bruk?  \"2016\" er siste år som er vist på Purehelp\nHurtigruten sier \"Vi publiserer ikke lenger finansielle rapporter på vår offentlig hjemmeside\" - (Juni 2018)\n\nWachete setup, but not working properly -giving daily messages : \"Unable to find monitored element\"',32,'2018-07-01','','2','','','','','','','5','https://www.wachete.com/wachet/975bf839-fbf2-4592-b586-8ebd07517476'),
	(35,'Hurtigruten Group - Finansrapporter KF','https://www.hurtigruten.com/about-us/investor-relations/financial-reports/','1','3',NULL,'Bond reports\n\nStopper Q2 17. Fortsatt relevant og ha i denne listen?\nDe sier \"Vi publiserer ikke lenger finansielle rapporter på vår offentlig hjemmeside\" - (Juni 2018)',32,'2018-09-01','','1','','','','','','','3',''),
	(36,'Hurtigruten Explorer - Finansrapporter KF','https://www.hurtigruten.com/about-us/investor-relations/financial-reports/','1','3',NULL,'Stopper Q2 17. Fortsatt relevant og ha i denne listen?\n\nDe sier \"Vi publiserer ikke lenger finansielle rapporter på vår offentlig hjemmeside\" - (Juni 2018)',32,'2018-09-01','','2','','','','','','','5',''),
	(37,'Hurtigruten Kystrute - Finansrapporter KF','https://www.hurtigruten.com/about-us/investor-relations/financial-reports/','1','3',NULL,'Stopper Q2 17. Fortsatt relevant og ha i denne listen?\nDe sier \"Vi publiserer ikke lenger finansielle rapporter på vår offentlig hjemmeside\" - (Juni 2018)',32,'2018-09-01','','2','','','','','','','5',''),
	(38,'Norwegian Cruise Line - Finansrapporter KF','http://www.nclhltdinvestor.com/financial-information/quarterly-results','1','7',NULL,'',60,'2018-08-02','','2','','','','','','','5','https://www.wachete.com/wachet/b309517b-dbe3-4929-a601-671cf3eec403'),
	(39,'Lindblad - Finansrapporter KF','http://investors.expeditions.com/Investor-Relations','1','7',NULL,'',33,'2018-08-03','','2','','','','','','','5',''),
	(40,'Norwegian - Finansrapporter KF','https://www.norwegian.no/om-oss/selskapet/investor-relations/reports-and-presentations/interim-reports-and-presentations/','1','7',NULL,'',35,'2018-07-12','','1','','','','','','','5','https://www.wachete.com/wachet/ac74de4b-4dea-41d5-9c09-664eabb645db'),
	(41,'SAS - Finansrapporter KF','https://www.sasgroup.net/en/category/investor-relations/financial-reports/annual-reports/','1','7',NULL,'',36,'2018-08-30','','2','','','','','','','5','https://www.wachete.com/wachet/b5857fa0-1ddf-4821-ac86-d85b82231235'),
	(42,'Wideroe - Finansrapporter KF','https://www.purehelp.no/m/company/details/wideroeeas/917281629','1','2',NULL,'Purehelp/Brønnøysund\n\nWachete setup, but not working properly -giving daily messages : \"Unable to find monitored element\"',61,'2019-04-01','','2','','','','','','','5',''),
	(43,'NETS - Korthandel per måned','https://www.nets.eu/no-nb/nyheter/Pages/default.aspx','2','1',NULL,'1-10 i måneden',64,'2018-07-02','','3','','','','','','','5','https://www.wachete.com/wachet/e62c9724-3287-4c02-8611-4592467a2fb4'),
	(44,'Bankaxept - Korthandel per måned','https://bankaxept.no/artikler/','2','1',NULL,'1-10 i måneden',65,'2018-07-02','','3','','','','','','','5','https://www.wachete.com/wachet/e62c9724-3287-4c02-8611-4592467a2fb4'),
	(45,'Finfo - Andre utlån/ulike utlånstyper','https://www.finfo.no/statistikk/','2','7',NULL,'',66,'2021-06-21','','3','','','','','','','5','https://www.wachete.com/wachet/ae1ca0c4-b51e-4323-8704-d7b284dbe26f'),
	(46,'NB - Betalingsstatistikk','https://www.norges-bank.no/Statistikk/betalingsstatistikk/','2','2',NULL,'',51,'2019-05-18','','3','','','','','','','5','https://www.wachete.com/wachet/2d184f9c-5c2d-473f-98f0-1372d12d59a6'),
	(47,'FN - Resultater Skadeforsikring KF','https://www.finansnorge.no/statistikk/skadeforsikring/','2','2',NULL,'Kilde : Nøkkeltall Skadeforsikring',23,'2018-09-01','','3','','','','','','','5','https://www.wachete.com/wachet/2767c273-95de-4a9e-a1bd-ac1d4530907e'),
	(48,'FN - Tariffområdet - Forhandlingsstatistikken','https://www.finansnorge.no/arbeidsgiver/statistikker/loennstatistikk/aarganger/20162/','2','2',NULL,'Kilde : Tariffområdet\nTabell 3- B10, D10',23,'2019-05-04','','3','','','','','','','5','https://www.wachete.com/wachet/d4f236f6-4059-40a3-86a1-7976286f3cf4'),
	(49,'FN - Erstatningsdata - Livsforsikring og Pensjon KF','https://www.finansnorge.no/statistikk/livsforsikring/statistikk-og-nokkeltall-for-livsforsikring-og-pensjon-2017/9.-privat-kollektiv-pensjon/','2','2',NULL,'Kilde : Erstatningsdata',23,'2021-06-21','','3','','','','','','','5','https://www.wachete.com/wachet/971dedec-a0a4-4c89-a829-aaa9968f8e80'),
	(50,'FN - Lønn - Forhandingsstatistikken','https://www.finansnorge.no/arbeidsgiver/statistikker/loennstatistikk/aarganger/20162/','2','2',NULL,'Kilde : Lønn\nTabell 14. Kvinnelige ledere\n\nDe sier : Lønnstatistikken for 2018 kommer primo mars 2019.   Måletidspunktet er septemberlønn i 2018.',23,'2019-03-01','','3','','','','','','','5',''),
	(51,'FN - Skadeskatistikk - Landbasert forsikring','https://www.finansnorge.no/statistikk/skadeforsikring/kvartalsvise-statistikk-publikasjoner/skadestatistikk-for-landbasert-forsikring/','2','7',NULL,'Kilde : Skadestatistikk\nKildenavn : Skadeskatistikk for landbasert forsikring',23,'2018-08-11','','3','','','','','','','5','https://www.wachete.com/wachet/7ff73659-cbe9-43ac-9fd7-ac3f63b2ba5a'),
	(52,'FN - Erstatningsbeløp - Skadeskatistikk for landbasert forsikring','https://www.finansnorge.no/statistikk/skadeforsikring/kvartalsvise-statistikk-publikasjoner/skadestatistikk-for-landbasert-forsikring/','2','7',NULL,'Kilde : Erstatningsbeløp',23,'2018-08-30','','3','','','','','','','5',''),
	(55,'NB - Finanstilsynet - Finansiell stabilitet','http://static.norges-bank.no/contentassets/f3a45cb94d334c4cb619cc549952d553/fs_rapport_2017.pdf?v=11/02/2017091701&ft=.pdf','1','2',NULL,'Finansiell stabilitet rapport',51,'2018-11-02','','3','','','','','','','5','https://www.wachete.com/wachet/e7f96c52-d287-41cb-a653-ded7753527fb'),
	(56,'Statsbudsjett - Makrotall','https://www.regjeringen.no/no/','1','3',NULL,'2 ganger i året eller årlig ?',68,'2019-05-01','','3','','','','','','','5',''),
	(57,'EW - Næringsstrukturer','','2','7',NULL,'',69,'2021-06-21','','3','','','','','','','2',''),
	(67,'FN - Finansnæringen - Likestillingsindikatorer for finanssektoren','https://www.finansnorge.no/arbeidsgiver/tema/arbeidslivssporsmal/likestilling/likestillingsindikatorene/','1','2',NULL,'',23,'2019-03-01','','3','','','','','','','5','https://www.wachete.com/wachet/082c2ef2-adad-40bd-9262-bca045dd3e3a'),
	(68,'NB - Pengepolitisk rapport Makrotall','https://www.norges-bank.no/Publisert/Publikasjoner/Pengepolitisk-rapport-med-vurdering-av-finansiell-stabilitet/','1','7',NULL,'Pengepolitisk rapport med vurdering av finansiell stabilitet',51,'2018-09-20','2018-06-21','3','','','','','','','5','https://www.wachete.com/wachet/a17d8e5f-f5bd-4381-bfab-95e878d45cbe'),
	(69,'FN - Pensjoner - Finans Norge','https://www.finansnorge.no/statistikk/livsforsikring/statistikk-og-nokkeltall-for-livsforsikring-og-pensjon-2017/9.-privat-kollektiv-pensjon/','1','2',NULL,'Privat kollektiv pensjon\nUnder innskuddsgrensen og satser\n',23,'2021-06-21','','3','','','','','','','5','https://www.wachete.com/wachet/54edee0e-8d88-44ed-8cd3-e6155a909fe3'),
	(70,'Finanstilsynet - Finansforetak - Forbrukslån volum i Norge','https://www.finanstilsynet.no/publikasjoner-og-analyser/resultatrapport-for-finansforetak/','1','7',NULL,'Resultatrapport for finansforetak / likviditet-soliditet\nForbrukslån volum i Norge',70,'2018-09-06','','3','','','','','','','5','https://www.wachete.com/wachet/2adf71bd-1179-4b75-8c57-21ca18d33939'),
	(71,'NB - Bank - Finansiell stabilitet','https://www.norges-bank.no/Publisert/Publikasjoner/Finansiell-stabilitet---rapport/','1','2',NULL,'',23,'2018-11-02','','3','','','','','','','5','https://www.wachete.com/wachet/e7f96c52-d287-41cb-a653-ded7753527fb'),
	(72,'Statsbudsjett - Inntektsoppgjørene','https://www.regjeringen.no/no/dokumenter/nou-2017-10/id2551919/sec2#KAP1-5','1','2',NULL,'Finansnæringen: Statsbudsjett - Grunnlaget for inntektsoppgjørene\n\nWachete - ikke mulig å sette opp.',68,'2019-05-01','','3','','','','','','','5',''),
	(73,'Statsbudsjett - Pensjoner','https://www.regjeringen.no/no/','1','2',NULL,'Tabell 1.13 Gjennomsnittlig årslønn1 for kvinner i forhold til gjennomsnittlig årslønn for menn i noen store forhandlingsområder, finansthjenester',68,'2019-05-01','','3','','','','','','','5',''),
	(74,'Sampo Konsern - Finansrapporter KF','http://www.sampo.com/figures/financial-reports/','1','7',NULL,'',71,'2018-08-09','','2','','','','','','','5','https://www.wachete.com/wachet/d5a50c2f-ed56-480e-b31e-0eaa3edddfe1'),
	(75,'Sampo Norge - Finansrapporter KF','http://www.sampo.com/figures/financial-reports/','1','7',NULL,'Supplementary info',71,'2018-08-09','','2','','','','','','','5','https://www.wachete.com/wachet/d5a50c2f-ed56-480e-b31e-0eaa3edddfe1'),
	(76,'Gjensidige Konsern - Finansrapporter KF','https://www.gjensidige.no/group/investor-relations/reports','1','7',NULL,'Kalender : https://www.gjensidige.no/group/investor-relations/financial-calendar\n\n13 07 2018  -  Q2 2018 results published at 07:00 CET\n25 10 2018  -  Q3 2018 results published at 07:00 CET\n\n(Cannot set up Wachete.  Have asked Gjensidige to amend the web-page so it should be possible)',72,'2018-07-13','','2','','','','','','','5',''),
	(77,'Tryg Konsern - Finansrapporter KF','http://tryg.com/en/investor/downloads/index.html','1','7',NULL,'Kalender : http://tryg.com/en/investor/calendar/index.html\n\n3. kvartal - 11.10.2018',73,'2018-07-10','','2','','','','','','','5','https://www.wachete.com/wachet/417a859c-fd0a-4efc-bea9-43b7ae1470c4'),
	(78,'Tryg Norge - Finansrapporter KF','http://tryg.com/en/investor/downloads/index.html','1','7',NULL,'Kalendar : http://tryg.com/en/investor/calendar/index.html\n\n3. kvartal - 11.10.2018',73,'2018-07-10','','2','','','','','','','5','https://www.wachete.com/wachet/417a859c-fd0a-4efc-bea9-43b7ae1470c4'),
	(83,'VFF (auto)','www.vff.no','3','1',NULL,'Kommer ut ca den 18. ++ måneden etter',62,'2018-07-18','','1','','','','','','','5',''),
	(84,'Storebrand - Finansrapporter KF','https://www.storebrand.no/site/stb.nsf/Pdfkvartalsrapporterprselskapenglish?Openview&RestrictToCategory=Storebrand%20Asa%202018','1','7',NULL,'13th July Results 2Q 2018\n24th October Results 3Q 2018\nFebruary 2019 Results 4Q 2018',74,'2018-07-13','','2','','','','','','','5','https://www.wachete.com/wachet/b745c89a-8b5a-4ddc-b9e7-51c6bbbf6a26'),
	(85,'SB1 - Finansrapporter KF','https://www.sparebank1.no/nb/bank/om-oss/investor.html#sparebank-1-gruppen','1','7',NULL,'2. kvartal 2018: 7. august\n3. kvartal 2018: 18. oktober',75,'2018-08-07','','2','','','','','','','5','https://www.wachete.com/wachet/2cff600a-9553-461d-9509-4eca0529532e'),
	(86,'DNB - Finansrapporter KF','https://www.ir.dnb.no/press-and-reports/other-quarterly-reports','1','7',NULL,'Kalender : https://www.ir.dnb.no/financial-calendar\n\n     Date              Event\n12.07.2018     2. kv 2018\n25.10.2018     3. kv 2018\n07.02.2019     4. kv 2018\n07.03.2019     Årlig rapporter 2018\n03.05.2019    1. kv 2019\n11.07.2019     2. kv 2019\n24.10.2019    3. kv 2019',27,'2018-07-12','','2','','','','','','','5','https://www.wachete.com/wachet/77e8443d-4716-41a1-8c15-34a0b604c481'),
	(87,'KLP - Finansrapporter KF','https://www.klp.no/om-klp/finans-og-ir/rapporter-og-presentasjoner','1','7',NULL,'Setting up wachete - cannot dynamically go down 2 levels (only 1).  Am waiting for response from Wachete support.',76,'2018-08-16','','2','','','','','','','5','https://www.wachete.com/wachet/22560935-cd96-4d88-84c8-bd354d33101e'),
	(88,'Eika Finansrapporter KF','https://eikbol.no/Investor-relations/financial-reports?_ga=2.267132234.557960351.1522055263-276835700.1516696469','1','7',NULL,'Kalender : https://eikbol.no/Investor-relations/Financial-Calendar\n\n10.08.2018    2. kvartal rapport\n08.11.2018    3. kvartal rapport',77,'2018-08-10','','2','','','','','','','5','https://www.wachete.com/wachet/04f2e6c5-9b0d-486e-98f8-78f579665d8e'),
	(89,'Frende Finansrapporter KF','https://www.frende.no/om-oss/finansiell-informasjon/frende-skadeforsikring/','1','7',NULL,'',78,'2018-09-20','','2','','','','','','','5','https://www.wachete.com/wachet/855a478f-e4ad-468a-b3ef-36935e7140f2'),
	(91,'Nordea - Finansrapport KF','https://www.nordea.com/no/investor-relations/rapporter-og-presentasjoner/resultatet-for-siste-kvartal/','1','7',NULL,'',83,'2018-07-19','','3','','','','','','','8','https://www.wachete.com/wachet/c637bf8c-1416-47cd-a2bb-42d9d896a5d2'),
	(92,'Danske Bank Finansrapporter KF','https://danskebank.com/investor-relations/reports','1','7',NULL,'',84,'2018-07-18','','3','','','','','','','8','https://www.wachete.com/wachet/186d868d-2b80-4d76-8b74-77f37948695b'),
	(93,'Sbanken Finansrapporter KF','https://sbanken.no/IR/','1','7',NULL,'',85,'2018-07-13','','3','','','','','','','8','https://www.wachete.com/wachet/adf594c5-06a3-4da1-b7f2-e1f49d263d16'),
	(94,'SB1 SMN - Finansrapport','https://www.sparebank1.no/nb/smn/om-oss/investor/finansiell-info/kvartals-og-arsrapporter.html','1','7',NULL,'',75,'2018-08-07','','3','','','','','','','8','https://www.wachete.com/wachet/c054fe38-18b9-472c-a6ef-b95ef7a2a2a0'),
	(95,'SB1 SNN - Finansrapport','https://www.sparebank1.no/nb/nord-norge/om-oss/investor/finansiell-info/rapporter-og-presentasjoner.html','1','7',NULL,'',75,'2018-08-08','','3','','','','','','','8','https://www.wachete.com/wachet/030ea629-e6d5-468a-b262-8adb9c58a936'),
	(96,'SB1 SR-Bank - Finansrapport','https://www.sparebank1.no/nb/sr-bank/om-oss/investor/finansiell-info/rapporter.html','1','7',NULL,'',75,'2018-08-08','','3','','','','','','','8','https://www.wachete.com/wachet/f1d09d7f-d5d9-4d61-98f9-099197ffc9be'),
	(97,'SB1 ØA - Finansrapport','https://www.sparebank1.no/nb/ostfold-akershus/om-oss/investor/finansiell-info/rapporter.html','1','7',NULL,'',75,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/c1547db3-4664-487f-af3f-3c919f028630'),
	(98,'SB1 Østlandet - Finansrapport','https://www.sparebank1.no/nb/ostlandet/om-oss/investor/rapporter.html','1','7',NULL,'',75,'2018-08-07','','3','','','','','','','8','https://www.wachete.com/wachet/505c10f7-c70e-44be-b311-09e22a81b31f'),
	(99,'SB1 BV - Finansrapport','https://www.sparebank1.no/nb/bv/om-oss/investor/finansiell-info/kvartals-og-aarsrapporter.html','1','7',NULL,'',75,'2018-08-09','','3','','','','','','','8','https://www.wachete.com/wachet/03bf0b83-1d3e-4f89-8478-fbe7830e118c'),
	(100,'SB1 Telemark - Finansrapport','https://www.sparebank1.no/nb/telemark/om-oss/investor/finansiell-info/rapporter.html','1','7',NULL,'',75,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/3022b020-14a2-4c3b-8b5d-fc807c85b61b'),
	(101,'SB1 RH - Finansrapport','https://www.sparebank1.no/nb/ringerike-hadeland/om-oss/investor/finansiell-info/rapporter.html','1','7',NULL,'',75,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/e9ef4c92-99df-4f45-9eb0-40deccb1d1d0'),
	(102,'SB1 Nordvest - Finansrapprt','https://www.sparebank1.no/nb/nordvest/om-oss/investor/finansiell-info/rapporter.html','1','7',NULL,'',75,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/58bc04fd-ead2-4a35-b641-fc5601ef8568'),
	(103,'SB1 HV - Finansrapport','https://www.sparebank1.no/nb/hallingdal/om-oss/investor/resultater.html','1','7',NULL,'No financial calender',75,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/e292aeab-27cd-44e3-8a51-8b200ada0f65'),
	(104,'SB1 SS - Finansrapport','https://www.sparebank1.no/nb/sore-sunnmore/om-oss/investor/rapporter.html','1','7',NULL,'',75,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/20a0cd3b-048c-4db9-b045-dc059fbc2304'),
	(105,'SB1 Modum - Finansrapport','https://www.sparebank1.no/nb/modum/om-oss/investor/finansiell-info/rapporter.html','1','7',NULL,'No financial calender',75,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/3c0c2b58-7119-4226-b9ab-a44c5ecb7fe3'),
	(106,'SB1 Gudbrandsdal - Finansrapport','https://www.sparebank1.no/nb/gudbrandsdal/om-oss/investor/finansiell-info/rapporter.html','1','7',NULL,'No financial calender',75,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/29927a43-55d4-4bfd-a2dd-400b85ff399e'),
	(107,'SB1 Lom og Skjåk - Finansrapport','https://www.sparebank1.no/nb/lom-skjaak/om-oss/investor/kvartalsrapporter.html','1','7',NULL,'No financial calender',75,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/0e6f9bf4-7db2-41dc-b8ed-2f7039e970ce'),
	(108,'SB Vest - Finansrapport','https://www.spv.no/om-oss/investor-relations/rapporter','1','7',NULL,'',86,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/e1c4a6c3-724b-4d58-ad39-5c004cf4f52f'),
	(109,'SB Sør','https://www.sor.no/felles/om-sparebanken-sor/investor/finansiell-rapportering/','1','7',NULL,'',86,'2018-08-10','','3','','','','','','','8','https://www.wachete.com/wachet/43fd9c53-f2eb-41c9-b5cf-386704efe1b3'),
	(110,'SB Møre - Finansrapport','https://www.sbm.no/investor-relations/81/0/','1','7',NULL,'',86,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/0289bc4d-4ac4-4b92-b72b-cd1ed129d6f0'),
	(111,'SB SogF','https://www.ssf.no/om-oss/investor-informasjon/ars--og-kvartalsrapportar/','1','7',NULL,'',86,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/b1b25584-5214-45f7-8bb8-d9b960c544cc'),
	(112,'SB Øst','https://www.oest.no/ars-og-delarsrapporter/','1','7',NULL,'',86,'2018-07-13','','3','','','','','','','8','https://www.wachete.com/wachet/9f60c2a6-ef76-416b-bb69-5b222493ec88'),
	(113,'Helgeland','https://www.hsb.no/om-oss/investorinformasjon/finansiell-informasjon/ars--og-delarsrapporter/','1','7',NULL,'',86,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/ab8e5854-672d-4824-bb6f-b797383f5208'),
	(114,'BN Bank','https://www.bnbank.no/informasjon/om-oss/finansiell-informasjon/rapporter-presentasjoner/','1','7',NULL,'',86,'2018-08-08','','3','','','','','','','8','https://www.wachete.com/wachet/8d66a4d5-b177-472d-bbce-0333b18aa8e3'),
	(115,'Landkreditt Bank','https://www.landkredittbank.no/om-oss/investorinformasjon/rapporter/','1','7',NULL,'No financial calendar',86,'2018-07-14','','3','','','','','','','8','https://www.wachete.com/wachet/78614199-2115-4ed9-a49a-eabfbb91e9d9'),
	(116,'OBOS Banken','https://www.obos.no/bedrift/ir/rapporter-og-presentasjoner#obosbank','1','7',NULL,'',86,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/4f4425b4-c69b-4c14-9d67-bae2f5949a55'),
	(117,'KommunalBanken','http://www.kommunalbanken.no/no/innl%C3%A5n/investorkontakt/finansielle-rapporter','1','7',NULL,'',86,'2018-07-31','','3','','','','','','','8','https://www.wachete.com/wachet/160cb2db-6ae2-4b31-997c-1bf95f324e55'),
	(118,'Fana','https://www.fanasparebank.no/om-oss/kvartalsrapporter','1','7',NULL,'',86,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/1deace46-3bc5-4ee0-841e-385ebe23296b'),
	(119,'Haugesund','https://haugesund-sparebank.no/om-oss/investortjenester/','1','7',NULL,'',86,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/697e4842-6cbe-48a2-92ca-21384b402fe7'),
	(120,'Spareskillingsbanken','https://spareskillingsbanken.no/om-oss/#finansiell-informasjon','1','7',NULL,'no financial calender',86,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/320f73fc-c288-488f-8b75-46247375676c'),
	(121,'Skudenes Sparebank','https://skudeaakra.no/om-oss/investorinformasjon-2/','1','7',NULL,'',86,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/7c3aa305-68b6-4a53-bcc5-d4a9d79e8f04'),
	(122,'Melhus Spb','https://melhusbanken.no/ombanken/rapporter','1','7',NULL,'',77,'2018-08-17','','3','','','','','','','8','https://www.wachete.com/wachet/18221cfc-90ce-4498-b796-a857a0be641a'),
	(123,'Sandnes Spb','https://sandnes-sparebank.no/investor-relations','1','7',NULL,'',77,'2018-08-16','','3','','','','','','','8','https://www.wachete.com/wachet/82e60c14-cdd4-40bf-8167-506a0d51de62'),
	(124,'Jæren Spb','https://jaerensparebank.no/Investorinformasjon/rapporterogpresentasjoner','1','7',NULL,'',77,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/282d3f1c-2a2e-4a1c-9b9c-f1bb622e3353'),
	(125,'Hjelmeland Spb','https://hjelmeland-sparebank.no/omoss/Rapporter','1','7',NULL,'',77,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/23360287-019c-48c1-bd24-a58418424ee7'),
	(126,'Handelsbanken','https://www.handelsbanken.com/shb/Inet/ICentSv.nsf/default/qB363A48A780D94E2C12575FA003FE444','1','7',NULL,'',87,'2018-07-18','','3','','','','','','','8',''),
	(127,'Santander - Finansrapport','https://www.santanderconsumer.no/om-oss/investor-relations/financial-reports/','1','7',NULL,'3. kvartal : 15 November 2018',88,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/12cc3388-1387-436c-85c1-77620a38ea9a'),
	(128,'Bank Norwegian - Finansrapport','https://www.banknorwegian.no/OmOss/InvestorRelations#','1','7',NULL,'3. Quarter 2018	30.10.2018',88,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/066f3e7b-436f-452d-8cc2-1f6b56930208'),
	(129,'Entercard Norge - Finansrapport','https://www.entercard.se/om-oss/717-2/','1','7',NULL,'no financial calender',88,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/72560393-a121-4d4b-9027-e037b00b4897'),
	(130,'YA Bank - Finansrapport','https://ya.no/om-ya-bank/investorinformasjon/finansiell-informasjon','1','7',NULL,'',88,'2018-08-08','','3','','','','','','','8','https://www.wachete.com/wachet/52a9ab47-18a9-49e0-8b76-98933df6d91b'),
	(131,'Bank2 - Finansrapport','https://bank2.no/investor-relations/kvartalsrapporter','1','7',NULL,'Rapport 3Q 2018	31.10.18',88,'2018-08-06','','3','','','','','','','8','https://www.wachete.com/wachet/62e9c21a-df69-4f3f-8aa5-9b66711301a0'),
	(132,'Komplett Bank - Finansrapport','https://www.komplettbank.no/om-komplett-bank/','1','7',NULL,'18.10.2018 - Quarterly Report - Q3 2018\n13.02.2019 - Quarterly Report - Q4 2018',88,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/b754edaf-2b49-4b35-855f-bef7ffd9f947'),
	(133,'Easybank - Finansrapport','https://easybank.no/om-oss/investor/finansiell-informasjon/','1','7',NULL,'Kvartalsrapport 3.kvartal:	 01. november 2018',88,'2018-08-22','','3','','','','','','','8','https://www.wachete.com/wachet/6c6c190d-aa5f-4416-b5d4-739cb3860f53'),
	(134,'Instabank - Finansrapport','https://instabank.no/om-oss/investor/rapporter','1','7',NULL,'3. kvartal ... 29.10.2018',88,'2018-07-13','','3','','','','','','','8','https://www.wachete.com/wachet/672e5bae-c2e0-46c5-a190-14517e14fde7'),
	(135,'Monobank - Finansrapport','https://monobank.no/om-banken/finansiell-informasjon/financial-reporting/','1','7',NULL,'Q3 2018 -  17.10.2018\nQ4 2018  -  14.02.2019',88,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/6ca460d9-596a-4268-a958-812e153c0838'),
	(136,'SB DIN - Finansrapport','https://sparebankendin.no/ombanken/Rapporter','1','7',NULL,'no financial calender',77,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/1fe3ef6d-abd8-4e7b-adf9-5c2984082e82'),
	(137,'HjartdalGransherad Sparebank - Finansrapport','https://hjartdalbanken.no/investorinformasjon/rapporter','1','7',NULL,'',77,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/c2b6e4bf-aed0-4848-849a-6f179903010a'),
	(138,'Skagerrak Sparebank','https://skagerraksparebank.no/ombanken/rapporter','1','7',NULL,'',77,'2018-08-10','','3','','','','','','','8','https://www.wachete.com/wachet/04af47bf-6ba9-4b04-84f3-77aea3441453'),
	(139,'Jernbanepersonalets Sparebank - Finansrapport','https://jbf.no/om_jbf/rapporter','1','7',NULL,'',77,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/49a9c532-8153-47c6-8e51-e2e9e093a98c'),
	(140,'Tolga-Os Sparebank - Finansrapport','https://tos.no/ombanken/rapporter','1','7',NULL,'',77,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/edit-wachet/4fb926ff-c1fa-4001-a7ac-e36e5824456c'),
	(141,'Grue Sparebank - Finansrapport','https://gruesparebank.no/ombanken/rapporter','1','7',NULL,'',77,'2018-07-30','','3','','','','','','','8','https://www.wachete.com/wachet/2050a8fc-910e-4878-b3e8-98b60049faf4'),
	(142,'Odal Sparebank - Finansrapport','https://odal-sparebank.no/ombanken/Rapporter/kvartalsrapporter','1','7',NULL,'De sier \"Vi ha ingen annen finanskalkulatrr enn den som ligger på Oslo Børs.\"',77,'2018-08-29','','3','','','','','','','8','https://www.wachete.com/wachet/ea65bd65-fbda-48d0-a110-2b35b3d8de2d'),
	(143,'Strømmen Sparebank - Finansrapport','https://strommensparebank.no/investorinformasjon/delarsrapporter','1','7',NULL,'',77,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/5f7e680b-54cf-40e1-b679-0533eb8fa879'),
	(144,'Lillestrømbanken - Finansrapport','https://lillestrombanken.no/ombanken/investor','1','7',NULL,'',77,'2018-08-14','','3','','','','','','','8','https://www.wachete.com/wachet/3b066880-3307-45c9-b458-b38ce59a6afd'),
	(145,'Aurskog Sparebank - Finansrapport','https://aurskog-sparebank.no/ombanken/Investor-relations/Delaarsrapporter','1','7',NULL,'Kalender : https://aurskog-sparebank.no/ombanken/Investor-relations/Finanskalender\n3. kvartal - 18.10.2018',77,'2018-08-16','','3','','','','','','','8','https://www.wachete.com/wachet/9370a2ef-6e95-4f20-9edb-2489fbfc42c9'),
	(146,'Totens Sparebank - Finansrapport','https://totenbanken.no/omoss/investor_relations/rapporter','1','7',NULL,'no financial URL\nno calender',77,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/7a3529eb-1f2a-4d2f-b2f2-1fc405e17a8f'),
	(147,'Harstad Sparebank - Finansrapport','https://harstad-sparebank.no/ombanken/rapporter','1','7',NULL,'',77,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/747e6f88-4696-491c-9b5f-a664e2cbb6ba'),
	(148,'SB Narvik - Finansrapport','https://sn.no/investorinformasjon/rapporter','1','7',NULL,'',77,'2018-08-15','','3','','','','','','','8','https://www.wachete.com/wachet/a490b21f-0d5e-416f-b609-5a8485e931fc'),
	(149,'Finanstilsynet - Finansielt Utsyn','https://www.finanstilsynet.no/publikasjoner-og-analyser/finansielt-utsyn/','2','3',NULL,'',70,'2018-11-30','','3','','','','','','','2','https://www.wachete.com/wachet/0b096458-f2d4-41bb-9c9a-735330bbee4c'),
	(150,'SSB - Sysselsatte','https://www.ssb.no/statbank/table/07984','6','8',NULL,'',24,'','','3','','','','','','','2','https://www.wachete.com/wachet/2a12b9ae-c7b0-4e16-8a04-f5e4c95fdf9e'),
	(151,'Regjeringen - Grunnlaget for inntektsoppgjørene','https://www.regjeringen.no/no/dokument/nou-ar/id1767/?ownerid=165&topic=','6','2',NULL,'',68,'2019-03-25','','3','','','','','','','2','https://www.wachete.com/wachet/00247a7d-3cb9-4a1d-91c8-c9185ba755cb'),
	(152,'Regjeringen - Statsbudsjettet ','https://www.statsbudsjettet.no/Revidert-budsjett-2018/Dokumenter/','1','2',NULL,'',68,'2019-05-01','','2','','','','','','','2','https://www.wachete.com/wachet/57315add-1cd6-461f-b771-30341f93f76b');

/*!40000 ALTER TABLE `DataSources` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Dependencies
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Dependencies`;

CREATE TABLE `Dependencies` (
  `dependenciesId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `dataSourceId` int(11) NOT NULL,
  `dependentOnDataSourceId` int(11) NOT NULL,
  `dependentForDataSourceId` int(11) NOT NULL,
  PRIMARY KEY (`dependenciesId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Dependencies` WRITE;
/*!40000 ALTER TABLE `Dependencies` DISABLE KEYS */;

INSERT INTO `Dependencies` (`dependenciesId`, `dataSourceId`, `dependentOnDataSourceId`, `dependentForDataSourceId`)
VALUES
	(1,50,1,2),
	(2,50,3,4);

/*!40000 ALTER TABLE `Dependencies` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table EwControllers
# ------------------------------------------------------------

DROP TABLE IF EXISTS `EwControllers`;

CREATE TABLE `EwControllers` (
  `ewControllerId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ewControllerName` varchar(255) DEFAULT '',
  `ewControllerComments` varchar(255) DEFAULT '',
  PRIMARY KEY (`ewControllerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `EwControllers` WRITE;
/*!40000 ALTER TABLE `EwControllers` DISABLE KEYS */;

INSERT INTO `EwControllers` (`ewControllerId`, `ewControllerName`, `ewControllerComments`)
VALUES
	(1,'Jon',''),
	(2,'Ieva',''),
	(3,'Trond',''),
	(4,'Simon',''),
	(5,'Ian',''),
	(6,'Rolf',''),
	(7,'Sondre',''),
	(8,'Loayar','');

/*!40000 ALTER TABLE `EwControllers` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table HistoryUpdates
# ------------------------------------------------------------

DROP TABLE IF EXISTS `HistoryUpdates`;

CREATE TABLE `HistoryUpdates` (
  `historyUpdatesId` int(11) NOT NULL AUTO_INCREMENT,
  `dataSourceId` int(11) DEFAULT NULL,
  `nextUpdateDue` varchar(255) DEFAULT '',
  `updateReceived` varchar(255) DEFAULT '',
  `updateTransferredToMaster` varchar(255) DEFAULT '',
  `updateProcessed` varchar(255) DEFAULT '',
  `updateComments` varchar(255) DEFAULT '',
  PRIMARY KEY (`historyUpdatesId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `HistoryUpdates` WRITE;
/*!40000 ALTER TABLE `HistoryUpdates` DISABLE KEYS */;

INSERT INTO `HistoryUpdates` (`historyUpdatesId`, `dataSourceId`, `nextUpdateDue`, `updateReceived`, `updateTransferredToMaster`, `updateProcessed`, `updateComments`)
VALUES
	(29,51,'2018-05-12','2018-05-30','2018-06-01','2018-06-01',''),
	(30,3,'2018-05-17','2018-05-18','2018-05-18','2018-05-18',''),
	(31,1,'2018-06-01','2018-06-01','2018-06-01','2018-06-01',''),
	(32,4,'2018-06-01','2018-06-01','2018-06-01','2018-06-01',''),
	(33,60,'2018-06-01','2018-06-02','2018-06-03','2018-06-04',''),
	(45,7,'2018-06-03','2018-06-04','2018-06-04','2018-06-04',''),
	(46,2,'2018-05-30','2018-05-31','2018-05-31','2018-05-31',''),
	(47,5,'2018-06-12','2018-06-15','2018-06-15','2018-06-15',''),
	(48,80,'2018-06-14','2018-06-15','2018-06-15','2018-06-15',''),
	(49,3,'2018-06-16','2018-06-21','2018-06-21','2018-06-21',''),
	(54,70,'2018-06-06','2018-06-06','2018-06-06','2018-06-06',''),
	(55,11,'2018-06-21','2018-07-02','2018-07-02','2018-07-02',''),
	(56,4,'2018-07-01','2018-07-02','2018-07-02','2018-07-02',''),
	(57,48,'2018-05-04','2018-05-04','2018-05-04','2018-05-04','');

/*!40000 ALTER TABLE `HistoryUpdates` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ParentSources
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ParentSources`;

CREATE TABLE `ParentSources` (
  `parentSourceId` int(11) NOT NULL AUTO_INCREMENT,
  `parentSourceName` varchar(50) DEFAULT '',
  `url` varchar(255) DEFAULT '',
  PRIMARY KEY (`parentSourceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `ParentSources` WRITE;
/*!40000 ALTER TABLE `ParentSources` DISABLE KEYS */;

INSERT INTO `ParentSources` (`parentSourceId`, `parentSourceName`, `url`)
VALUES
	(23,'Finans Norge','www.finansnorge.no'),
	(24,'SSB','www.ssb.no'),
	(25,'IMF','www.imf.no'),
	(27,'DNB','www.DNBMarkets.no'),
	(28,'Taxfree','www.Taxfree.no'),
	(29,'Eurostat','www.Eurostat.no'),
	(30,'Oslo Børs','www.OsloBørs.no'),
	(31,'Fjordline','www.Fjordline.no'),
	(32,'Hurtigruten','www.Hurtigruten.no'),
	(33,'Lindblad','www.Lindblad.no'),
	(35,'Norwegian','www.Norwegian.no'),
	(36,'SAS','www.Wideroe.no'),
	(41,'Tobakksvolum Norge','www.TobakksvolumNorge.no'),
	(42,'Cruise Norway','www.CruiseNorway.no'),
	(43,'Tertial Calc','www.TertialCalc.no'),
	(46,'NAV','www.nav.no'),
	(47,'Avinor','www.avinor.no'),
	(51,'Norges Bank','www.norgesbank.no'),
	(52,'Viking Line','www.vikingline.no'),
	(53,'Tallink','www.Tallink.no'),
	(54,'Torghatten Sjø','www.TorghattenSjo.no'),
	(55,'Stena AB Group','www.Stena.no'),
	(56,'DFDS','www.DFDS.no'),
	(57,'Color Group','www.ColorGroup.no'),
	(58,'RCCL','www.RCCL.no'),
	(59,'Carnival','www.Carnival.no'),
	(60,'Norwegian Cruise Line','www.NorwegianCruiseLine.no'),
	(61,'Wideroe','www.Wideroe.no'),
	(62,'VFF','www.vff.no'),
	(64,'NETS','www.nets.no'),
	(65,'Bankaxept','www.Bankaxept.no'),
	(66,'Finfo','www.finfo.no'),
	(67,'Other','www'),
	(68,'Regjeringen','https://www.regjeringen.no/no/'),
	(69,'Early Warning','www.earlywarning.no'),
	(70,'Finanstilsynet','www. Finanstilsynet.no'),
	(71,'Sampo','www.sampo.com'),
	(72,'Gjensidige','www.Gjensidige.no'),
	(73,'Tryg','www.tryg.com'),
	(74,'Storebrand','www.storebrand.no'),
	(75,'Sparebank 1','www.sparebank1.no'),
	(76,'KLP','www.klp.no'),
	(77,'Eika','www.Eika.no'),
	(78,'Frende','www.frende.no'),
	(79,'European Commission','https://ec.europa.eu/commission/index_en'),
	(80,'Statistiska Centralbyrå','http://www.scb.se/hitta-statistik/'),
	(81,'Danmarks Statistik','www.dst.dk/da/'),
	(82,'Torp','www.torp.no'),
	(83,'Nordea','www.nordea.no'),
	(84,'Danske Bank','www.danskebank.no'),
	(85,'Sbanken','www.sbanken.no'),
	(86,'Andre Norske Banker','http://bank.businessmonitor.no/pdfeditor#'),
	(87,'Handelsbanken','www.handelsbanken.no'),
	(88,'Forbrukslån banker','http://bank.businessmonitor.no/pdfeditor#');

/*!40000 ALTER TABLE `ParentSources` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Portals
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Portals`;

CREATE TABLE `Portals` (
  `portalId` int(11) NOT NULL AUTO_INCREMENT,
  `portalName` varchar(255) DEFAULT '',
  `url` varchar(255) DEFAULT '',
  `ewControllerPortal` varchar(255) DEFAULT '',
  PRIMARY KEY (`portalId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Portals` WRITE;
/*!40000 ALTER TABLE `Portals` DISABLE KEYS */;

INSERT INTO `Portals` (`portalId`, `portalName`, `url`, `ewControllerPortal`)
VALUES
	(25,'Colorline','http://color-line.businessmonitor.no/login.php','3'),
	(31,'KLP','http://klp.businessmonitor.no/login.php','2'),
	(32,'OBOS','http://obos.businessmonitor.no/login.php','2'),
	(33,'Finans Norge','http://finans-norge.businessmonitor.no/login.php','2'),
	(34,'SpareBank 1 Telemark','http://telemark.businessmonitor.no/login.php','3'),
	(35,'Storebrand Bank','http://storebrand-bank.businessmonitor.no/login.php','2'),
	(36,'SpareBank 1 Østlandet','http://hedmark.businessmonitor.no/login.php','1'),
	(37,'Sparebanken Vest','http://sb-vest.businessmonitor.no/login.php','2'),
	(42,'Eika','http://eika.businessmonitor.no/login.php','3'),
	(43,'Storebrand Forsikring','http://storebrand-forsikring.businessmonitor.no/login.php','3');

/*!40000 ALTER TABLE `Portals` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table PortalSources
# ------------------------------------------------------------

DROP TABLE IF EXISTS `PortalSources`;

CREATE TABLE `PortalSources` (
  `portalSourceId` int(11) NOT NULL AUTO_INCREMENT,
  `portalId` int(11) DEFAULT NULL,
  `dataSourceId` int(11) DEFAULT NULL,
  PRIMARY KEY (`portalSourceId`),
  KEY `PortalID` (`portalId`),
  KEY `DataSourceID` (`dataSourceId`),
  CONSTRAINT `portalsources_ibfk_1` FOREIGN KEY (`portalId`) REFERENCES `Portals` (`portalId`),
  CONSTRAINT `portalsources_ibfk_2` FOREIGN KEY (`dataSourceId`) REFERENCES `DataSources` (`dataSourceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `PortalSources` WRITE;
/*!40000 ALTER TABLE `PortalSources` DISABLE KEYS */;

INSERT INTO `PortalSources` (`portalSourceId`, `portalId`, `dataSourceId`)
VALUES
	(160,25,1),
	(161,25,9),
	(162,25,6),
	(163,25,4),
	(164,25,28),
	(165,25,34),
	(166,31,43),
	(168,25,13),
	(169,25,8),
	(170,25,16),
	(172,25,21),
	(173,25,19),
	(174,25,20),
	(175,25,17),
	(176,25,18),
	(177,25,14),
	(179,25,11),
	(183,25,25),
	(184,25,26),
	(185,25,27),
	(186,25,29),
	(187,25,30),
	(188,25,31),
	(189,25,32),
	(190,25,33),
	(191,25,36),
	(192,25,35),
	(193,25,37),
	(194,25,38),
	(195,25,39),
	(196,25,40),
	(197,25,41),
	(198,25,42),
	(200,34,3),
	(201,34,1),
	(202,34,51),
	(203,34,4),
	(204,34,5),
	(205,34,57),
	(216,33,69),
	(217,33,72),
	(224,31,44),
	(225,31,45),
	(226,31,46),
	(227,33,47),
	(228,33,48),
	(229,33,49),
	(230,33,50),
	(231,33,51),
	(232,33,52),
	(233,33,2),
	(234,33,7),
	(235,33,71),
	(236,33,55),
	(237,33,56),
	(238,33,68),
	(239,33,67),
	(240,33,73),
	(241,33,70),
	(242,43,7),
	(243,43,3),
	(244,43,76),
	(245,43,74),
	(246,43,77),
	(247,43,78),
	(248,43,75),
	(249,43,84),
	(250,43,85),
	(251,43,87),
	(252,43,88),
	(253,43,86),
	(254,43,89),
	(255,36,70),
	(256,37,1),
	(257,37,5),
	(258,37,4),
	(259,37,51),
	(260,32,1),
	(261,32,5),
	(262,32,4),
	(263,25,15),
	(264,25,5),
	(276,25,10),
	(280,25,12),
	(416,42,48),
	(417,42,1),
	(418,42,4),
	(419,33,86),
	(420,42,86),
	(421,32,86),
	(422,31,86),
	(423,37,86),
	(424,34,86),
	(425,35,86),
	(426,36,86),
	(427,42,92),
	(428,33,92),
	(429,31,92),
	(430,32,92),
	(431,35,92),
	(432,37,92),
	(433,36,92),
	(434,43,92),
	(435,34,92),
	(436,42,93),
	(437,31,93),
	(438,33,93),
	(439,34,93),
	(440,36,93),
	(441,37,93),
	(442,32,93),
	(443,35,93),
	(444,42,94),
	(445,36,94),
	(446,33,94),
	(447,32,94),
	(448,31,94),
	(449,34,94),
	(450,35,94),
	(451,37,94),
	(452,33,95),
	(453,42,95),
	(454,32,95),
	(455,31,95),
	(456,34,95),
	(457,36,95),
	(458,37,95),
	(459,35,95),
	(460,42,96),
	(461,33,96),
	(462,34,96),
	(463,31,96),
	(464,32,96),
	(465,37,96),
	(466,35,96),
	(467,36,96),
	(468,31,97),
	(469,34,97),
	(470,36,97);

/*!40000 ALTER TABLE `PortalSources` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table SourceTypes
# ------------------------------------------------------------

DROP TABLE IF EXISTS `SourceTypes`;

CREATE TABLE `SourceTypes` (
  `sourceTypeId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sourceTypeName` varchar(255) DEFAULT '',
  PRIMARY KEY (`sourceTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `SourceTypes` WRITE;
/*!40000 ALTER TABLE `SourceTypes` DISABLE KEYS */;

INSERT INTO `SourceTypes` (`sourceTypeId`, `sourceTypeName`)
VALUES
	(1,'PDF'),
	(2,'Excel'),
	(3,'Excel script'),
	(4,'Excel IMF script'),
	(5,'SSB tabell -> Excel -> Termin'),
	(6,'Vet ikke');

/*!40000 ALTER TABLE `SourceTypes` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table UpdateIntervals
# ------------------------------------------------------------

DROP TABLE IF EXISTS `UpdateIntervals`;

CREATE TABLE `UpdateIntervals` (
  `updateIntervalId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `updateIntervalName` varchar(255) DEFAULT NULL,
  `updateIntervalDaysIncrement` int(11) DEFAULT NULL,
  `updateIntervalComments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`updateIntervalId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `UpdateIntervals` WRITE;
/*!40000 ALTER TABLE `UpdateIntervals` DISABLE KEYS */;

INSERT INTO `UpdateIntervals` (`updateIntervalId`, `updateIntervalName`, `updateIntervalDaysIncrement`, `updateIntervalComments`)
VALUES
	(1,'Månedsvis',30,''),
	(2,'Årsvis',365,''),
	(3,'Halvårsvis',182,''),
	(4,'Daglig',1,''),
	(5,'Ukentlig',7,''),
	(6,'Annenhver måned',60,''),
	(7,'Kvartalsvis',91,''),
	(8,'Usikkert',999,'');

/*!40000 ALTER TABLE `UpdateIntervals` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table UpdateMethods
# ------------------------------------------------------------

DROP TABLE IF EXISTS `UpdateMethods`;

CREATE TABLE `UpdateMethods` (
  `updateMethodId` int(11) NOT NULL AUTO_INCREMENT,
  `updateMethodName` varchar(255) DEFAULT '',
  PRIMARY KEY (`updateMethodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `UpdateMethods` WRITE;
/*!40000 ALTER TABLE `UpdateMethods` DISABLE KEYS */;

INSERT INTO `UpdateMethods` (`updateMethodId`, `updateMethodName`)
VALUES
	(1,'Automatisk'),
	(2,'Semimanuell'),
	(3,'Manuell');

/*!40000 ALTER TABLE `UpdateMethods` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
