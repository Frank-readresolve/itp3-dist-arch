DROP TABLE IF EXISTS persons;


CREATE TABLE persons (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

