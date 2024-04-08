INSERT INTO company (name)
VALUES ('Acme Inc.'),
       ('Technovation'),
       ('Global Consulting'),
       ('Green Solutions'),
       ('Fashion Avenue'),
       ('Happy Travels'),
       ('Media Buzz');


INSERT INTO company_locales (company_id, lang, description)
VALUES (1, 'en', 'Leading provider of innovative solutions.'),
       (1, 'fr', 'Fournisseur leader de solutions innovantes.'),
       (2, 'en', 'Pioneering advancements in technology.'),
       (2, 'es', 'A la vanguardia de los avances tecnológicos.');

-- Add descriptions for other companies following the same pattern (company_id, lang, description)

INSERT INTO users (username, birth_date, firstname, lastname, role, company_id)
VALUES ('john.doe', '1985-05-12', 'John', 'Doe', 'USER', 1),
       ('jane.smith', '1990-10-21', 'Jane', 'Smith', 'ADMIN', 2),
       ('maria.garcia', '1978-02-04', 'Maria', 'Garcia', 'ADMIN', 3),
       ('chen.li', '1982-09-18', 'Chen', 'Li', 'USER', 4),
       ('anna.belova', '1995-03-27', 'Anna', 'Belova', 'ADMIN', 5),
       ('david.miller', '1980-12-11', 'David', 'Miller', 'USER', 6),
       ('kim.jung', '1992-08-23', 'Kim', 'Jung', 'USER', 7);


-- Assuming payments for different users (adjust user IDs as needed)
INSERT INTO payment (amount, receiver_id)
VALUES (500, 1),
       (1200, 3),
       (800, 4),
       (2000, 5),
       (750, 6),
       (1500, 2),
       (1000, 7);


INSERT INTO chat (name)
VALUES ('General Chat'),
       ('Tech Talk'),
       ('Customer Support'),
       ('Marketing Ideas'),
       ('Design Studio'),
       ('Travel Buddies'),
       ('News & Current Events');


-- Assign users to various chats (adjust user and chat IDs as needed)
INSERT INTO users_chat (user_id, chat_id)
VALUES (1,7),
       (2,6),
       (3,5),
       (4,4),
       (5,3),
       (6,2),
       (7,1);

