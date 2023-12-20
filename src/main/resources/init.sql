CREATE TABLE agency (
    name VARCHAR(255) NOT NULL ,
    address VARCHAR(255) NOT NULL,
    PRIMARY KEY (name, address)
);

CREATE TABLE tours(
    name VARCHAR(255) NOT NULL,
    departure DATE NOT NULL,
    arrival DATE,
    city VARCHAR(255) NOT NULL,
    price INTEGER NOT NULL,
    agency_name VARCHAR(255) NOT NULL,
    agency_address VARCHAR(255) NOT NULL,
    FOREIGN KEY (agency_name, agency_address) REFERENCES agency(name, address) ON DELETE CASCADE,
    PRIMARY KEY (name, departure)
);

CREATE TABLE clients(
    passport INTEGER PRIMARY KEY NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL
);

CREATE TABLE sights (
    longitude DECIMAL(9, 6) NOT NULL,
    latitude DECIMAL(8, 6) NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY (longitude, latitude)
);

CREATE TABLE orders (
    order_number SERIAL PRIMARY KEY,
    passport INTEGER NOT NULL,
    tours_name VARCHAR(255) NOT NULL,
    departure DATE NOT NULL,
    agency_name VARCHAR(255) NOT NULL,
    agency_address VARCHAR(255) NOT NULL,
    FOREIGN KEY (tours_name, departure, agency_name, agency_address) REFERENCES tours(name, departure, agency_name, agency_address) ON DELETE CASCADE,
    FOREIGN KEY (passport) REFERENCES clients(passport) ON DELETE CASCADE
);

CREATE TABLE excursion (
    excursion_code SERIAL PRIMARY KEY,
    tours_name VARCHAR(255) NOT NULL,
    departure DATE NOT NULL,
    agency_name VARCHAR(255) NOT NULL,
    agency_address VARCHAR(255) NOT NULL,
    longitude DECIMAL(9, 6) NOT NULL,
    latitude DECIMAL(8, 6) NOT NULL,
    FOREIGN KEY (tours_name, departure, agency_name, agency_address) REFERENCES tours(name, departure, agency_name, agency_address) ON DELETE CASCADE,
    FOREIGN KEY (longitude, latitude) REFERENCES sights(longitude, latitude) ON DELETE CASCADE
);