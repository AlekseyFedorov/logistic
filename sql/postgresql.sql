-- logistics.clients �����������

CREATE TABLE clients (
  client_id int NOT NULL,
  organization_name varchar(20) NOT NULL DEFAULT '',
  customer varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (client_id)
);

INSERT INTO clients (client_id,organization_name,customer) VALUES
	 (1,'�������','�������� �.�.'),
	 (4,'�������� ���','������ �.�.'),
	 (5,'����','������� �.�.'),
	 (8,'���','������ �.�.'),
	 (15,'�������','��������� �.�.'),
	 (16,'��������','�������� �.�.'),
	 (26,'��������� ���','������� �.�.'),
	 (27,'����� �����','������'),
	 (30,'��������� ���','�������� �.�.'),
	 (32,'��� "���� � ������"','������� �.�.');
INSERT INTO clients (client_id,organization_name,customer) VALUES
	 (33,'��� "������ � ����"','����� �.�.');
