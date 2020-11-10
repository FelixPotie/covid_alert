CREATE TABLE alerts(
    alert_id serial NOT NULL PRIMARY KEY,
    contamination_date DATE NOT NULL,
    alert_date DATE NOT NULL,
    user_id varchar(36) NOT NULL REFERENCES user_entity (id)
);

CREATE TABLE tests(
    test_id serial PRIMARY KEY,
    test_date DATE NOT NULL,
    user_id varchar(36) NOT NULL REFERENCES user_entity (id)
);

CREATE TABLE locations(
    location_id serial PRIMARY KEY,
    latitude numeric(18, 16) NOT NULL,
    longitude numeric(18, 16) NOT NULL,
    location_date DATE NOT NULL,
    user_id varchar(36) NOT NULL REFERENCES user_entity (id)
);

INSERT INTO user_entity(id,first_name,last_name,email) VALUES('1','Chouki','Tibermacine','chouki.tibermacine@test.com');
INSERT INTO user_entity(id,first_name,last_name,email) VALUES('2','Mathis','Bourrat','mathis.bourrat@etu.umontpellier.fr');
INSERT INTO user_entity(id,first_name,last_name,email) VALUES('3','Félix','Potie','felix.potie@etu.umontpellier.fr');
INSERT INTO user_entity(id,first_name,last_name,email) VALUES('4','Camille','Thomas','camille.thomas@etu.umontpellier.fr');
INSERT INTO user_entity(id,first_name,last_name,email) VALUES('5','Justine','Foulquier','justine.foulquier@etu.umontpellier.fr');