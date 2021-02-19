DROP TABLE IF EXISTS documents;

CREATE TABLE documents
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    type          VARCHAR(64) NOT NULL,
    serial_number VARCHAR(64),
    pages         INT         NOT NULL DEFAULT 0
);

INSERT INTO documents (type, serial_number, pages)
VALUES ('pdf', null, 4),
       ('pdf', 'dWDz8mh6NLcCVLqm', 8),
       ('pdf', null, 15),
       ('jpg', 'PeXTDHagPYj5mHnn', 16),
       ('png', null, 23),
--        millions of rows in between
       ('jpg', '6RQfrfYdspUbj2m7', 42);