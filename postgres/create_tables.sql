CREATE TABLE users(
    user_id serial NOT NULL PRIMARY KEY,
    first_name varchar(30) NOT NULL,
    last_name varchar(30) NOT NULL,
    email varchar(80) NOT NULL,
    phone_number varchar(20) NOT NULL,
    password varchar(100) NOT NULL
);

CREATE TABLE alerts(
    alert_id serial NOT NULL PRIMARY KEY,
    contamination_date time without time zone NOT NULL,
    alert_date time without time zone NOT NULL,
    user_id integer NOT NULL REFERENCES users (user_id)
);

CREATE TABLE tests(
    test_id serial PRIMARY KEY,
    test_date time without time zone NOT NULL,
    user_id integer NOT NULL REFERENCES users (user_id)
);

CREATE TABLE contacts
(
    contact_id serial NOT NULL PRIMARY KEY,
    first_user_id integer NOT NULL REFERENCES users (user_id),
    second_user_id integer NOT NULL REFERENCES users (user_id)
);

INSERT INTO users(first_name,last_name,email,phone_number,password) VALUES('Chouki','Tibermacine','chouki.tibermacine@test.com','+15103754657','123456');
INSERT INTO users(first_name,last_name,email,phone_number,password) VALUES('Mathis','Bourrat','mathis.bourrat@etu.umontpellier.fr','+33645893421','123456');
INSERT INTO users(first_name,last_name,email,phone_number,password) VALUES('Félix','Potie','felix.potie@etu.umontpellier.fr','+15103754657','123456');
INSERT INTO users(first_name,last_name,email,phone_number,password) VALUES('Camille','Thomas','camille.thomas@etu.umontpellier.fr','+15103754657','123456');
INSERT INTO users(first_name,last_name,email,phone_number,password) VALUES('Justine','Foulquier','justine.foulquier@etu.umontpellier.fr','++33645658983','123456');