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

CREATE TABLE locations(
    location_id serial PRIMARY KEY,
    latitude numeric(18, 16) NOT NULL,
    longitude numeric(18, 16) NOT NULL,
    location_date time without time zone NOT NULL,
    user_id integer NOT NULL REFERENCES users (user_id)
)

INSERT INTO user_entity(first_name,last_name,email) VALUES('Chouki','Tibermacine','chouki.tibermacine@test.com');
INSERT INTO user_entity(first_name,last_name,email) VALUES('Mathis','Bourrat','mathis.bourrat@etu.umontpellier.fr');
INSERT INTO user_entity(first_name,last_name,email) VALUES('Félix','Potie','felix.potie@etu.umontpellier.fr');
INSERT INTO user_entity(first_name,last_name,email) VALUES('Camille','Thomas','camille.thomas@etu.umontpellier.fr');
INSERT INTO user_entity(first_name,last_name,email) VALUES('Justine','Foulquier','justine.foulquier@etu.umontpellier.fr');