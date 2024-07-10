-- logistics.clients определение

CREATE TABLE clients (
  client_id int NOT NULL,
  organization_name varchar(20) NOT NULL DEFAULT '',
  customer varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (client_id)
);

INSERT INTO clients (client_id,organization_name,customer) VALUES
	 (1,'ЭкоАгро','Васнецов О.В.'),
	 (4,'Носочный мир','Авилов В.В.'),
	 (5,'УУУУ','Иванова У.У.'),
	 (8,'Ура','Маснев П.К.'),
	 (15,'ЭкоАгро','Васильева А.А.'),
	 (16,'Мираторг','Успенцев К.В.'),
	 (26,'Батарейки ооо','Волкова Е.П.'),
	 (27,'Новая орган','вфыаыф'),
	 (30,'Батарейки ооо','Алексеев В.Ф.'),
	 (32,'ООО "Рога и копыта"','Копытян Р.Р.');
INSERT INTO clients (client_id,organization_name,customer) VALUES
	 (33,'ООО "Копыта и Рога"','Рогов К.К.');
