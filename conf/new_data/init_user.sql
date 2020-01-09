-- init default user

INSERT INTO users_profile("type")VALUES('ADMIN'),('USER');

-- user:admin
-- pwd: admin
-- role : ADMIN
INSERT INTO users (email, first_name, last_name, "password", sso_id)
VALUES('admin@domaine.km', 'Default', 'Admin', '$2a$10$xDjXrzBEABQGzOBavNM56e8OOSiuOwH.FhBVqY6t1eyRzTi8uJhgy', 'admin');

INSERT INTO users_users_profile (user_id, user_profile_id) VALUES((select id from users u where u.sso_id='admin'), (select id from users_profile up  where up.type='ADMIN'));




