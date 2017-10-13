INSERT INTO identitystore_attribute_right ( id_client_app, id_attribute, readable, writable, certifiable) VALUES
	(200, 11, 1, 1, 1),
	(200, 1, 1, 1, 1),
	(200, 3, 1, 1, 1),
	(200, 4, 1, 1, 1),
	(200, 10, 1, 1, 1);

INSERT INTO identitystore_client_application (id_client_app, name, code) VALUES
	(200 , 'CNI Certifier', 'CNICertifier');

INSERT INTO identitystore_client_application_certifiers (id_client_app, certifier_code) VALUES
	(200, 'cnicertifier');