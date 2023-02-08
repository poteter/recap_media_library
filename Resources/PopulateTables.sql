INSERT INTO author(fname, lname)
VALUES('J.R.R.', 'Tolkien'),
      ('Stephen', 'King'),
      ('E.A.', 'Poe');

INSERT INTO genre(gname)
VALUES('horror'),
      ('action'),
      ('epic'),
      ('fantasy'),
      ('science fiction'),
      ('drama'),
      ('RTS');

INSERT INTO book(title, authorid, pagecount, genreid)
VALUES('The Silmarillion', 1, 366, 3),
      ('The Lord of the Rings: The Fellowship of the Ring', 1, 423, 3),
      ('IT', 2, 1488, 1),
      ('The Raven', 3, 40, 1);

INSERT INTO director(fname, lname)
VALUES('Peter', 'Jackson'),
      ('Lana', 'Wachowski'),
      ('Frank', 'Darabont');

INSERT INTO movie(title, directorid, runtime, genreid)
VALUES('The Lord of the Rings: The Fellowship of the Ring', 1, 178, 3),
      ('The Matrix', 2, 136, 5),
      ('The Green Mile', 3, 189, 6);

INSERT INTO category(cname)
VALUES('PS1'),
      ('PS2'),
      ('PS3'),
      ('PS4'),
      ('Xbox'),
      ('Xbox 360'),
      ('Xbox One'),
      ('Xbox series x'),
      ('PC');

INSERT INTO studio(sname)
VALUES('Bethesda'),
      ('Relic Entertainment');

INSERT INTO game(title, studioid, genreid, categoryid)
VALUES('Fallout 4', 1, 2, 4),
      ('Age of Empires IV', 2, 7, 9);