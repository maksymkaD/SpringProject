/* SUBJECTS */
INSERT INTO subjects (id, name)
VALUES (1, 'back end development');

/* USERS WITH ROLE: ADMIN */
INSERT INTO users (id, email, password, name, lastName, role)
VALUES (0, 'admin@gmail.com', '123', 'admin name', 'admin last name', 'admin');

/* USERS WITH ROLE: TEACHER */
INSERT INTO users (id, email, password, name, lastName, role, position)
VALUES (1, 'andriy@gmail.com', '123', 'andriy', 'last name', 'teacher', 'sr. teacher');

/* USERS WITH ROLE: STUDENT */
INSERT INTO users (id, email, password, name, lastName, role, year)
VALUES (2, 'maks@gmail.com', '123', 'maks', 'last name', 'student', 1984);
INSERT INTO users (id, email, password, name, lastName, role, year)
VALUES (3, 'denis@gmail.com', '123', 'denis', 'last name', 'student', 2077);
INSERT INTO users (id, email, password, name, lastName, role, year)
VALUES (4, 'max@gmail.com' , '123', 'max', 'last name', 'student', 1939);
INSERT INTO users (id, email, password, name, lastName, role, year)
VALUES (5, 'gleb@gmail.com', '123', 'gleb', 'last name', 'student', 1914);
INSERT INTO users (id, email, password, name, lastName, role, year)
VALUES (6, 'vlad@gmail.com', '123', 'vlad', 'last name', 'student', 1991);

/* TEACHERS SUBJECTS */
INSERT INTO user_subjects(user_id, subject_id)
VALUES (1, 1);

/* STUDENTS SUBJECTS */
INSERT INTO user_subjects(user_id, subject_id)
VALUES (2, 1);

/*GROUPS*/
INSERT INTO groups (id, subject, number)
VALUES (11, 'Math', '1');
INSERT INTO groups (id, subject, number)
VALUES (12, 'OKA', '1');

/* STUDENTS IN GROUPS */
/*INSERT INTO users_in_group (id, subject)
VALUES (11,3);*/