CREATE TABLE person (
    id bigint NOT NULL,
    deleted boolean NOT NULL DEFAULT false,
    CONSTRAINT pkey_person PRIMARY KEY (id)
);

CREATE TABLE person_information (
    id bigint NOT NULL,
    person_id bigint NOT NULL,
    CONSTRAINT pk_person_information PRIMARY KEY (id),
    CONSTRAINT fk_person_information_person FOREIGN KEY (person_id) REFERENCES person(id) ON DELETE CASCADE
);

CREATE TABLE car (
    id bigint NOT NULL,
    deleted boolean NOT NULL DEFAULT false,
    CONSTRAINT pkey_car PRIMARY KEY (id)
);

CREATE TABLE car_information (
    id bigint NOT NULL,
    car_id bigint NOT NULL,
    CONSTRAINT pk_car_information PRIMARY KEY (id),
    CONSTRAINT fk_car_information_car FOREIGN KEY (car_id) REFERENCES car(id) ON DELETE CASCADE
);

