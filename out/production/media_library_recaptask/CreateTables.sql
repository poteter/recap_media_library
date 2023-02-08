CREATE TABLE author(
    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    fname VARCHAR(30),
    lname VARCHAR(30),
    PRIMARY KEY (id)
);

CREATE TABLE director(
    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    fname VARCHAR(30),
    lname VARCHAR(30),
    PRIMARY KEY (id)
);

CREATE TABLE studio(
    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    sname VARCHAR(45),
    PRIMARY KEY (id)
);

CREATE TABLE genre(
    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    gname VARCHAR(30),
    PRIMARY KEY (id)
);

CREATE TABLE category(
    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    cname VARCHAR(30),
    PRIMARY KEY (id)
);

CREATE TABLE book(
    isbn BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    title VARCHAR(60),
    authorid BIGINT,
    pagecount BIGINT,
    genreid BIGINT,
    CONSTRAINT bookauthorid
                 FOREIGN KEY (authorid)
                 REFERENCES author(id),
    CONSTRAINT bookgenreid
                 FOREIGN KEY (genreid)
                 REFERENCES genre(id),
    PRIMARY KEY (isbn)
);

CREATE TABLE movie(
    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    title VARCHAR(60),
    directorid BIGINT,
    runtime BIGINT,
    genreid BIGINT,
    CONSTRAINT moviedirectorid
                  FOREIGN KEY (directorid)
                  REFERENCES director(id),
    CONSTRAINT moviegenreid
                  FOREIGN KEY (genreid)
                  REFERENCES genre(id),
    PRIMARY KEY (id)
);

CREATE TABLE game(
    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    title VARCHAR(45),
    studioid BIGINT,
    genreid BIGINT,
    categoryid BIGINT,
    CONSTRAINT gamestudioid
                 FOREIGN KEY (studioid)
                 REFERENCES studio(id),
    CONSTRAINT gamegenreid
                FOREIGN KEY (genreid)
                REFERENCES genre(id),
    CONSTRAINT gamecategoryid
                 FOREIGN KEY (categoryid)
                 REFERENCES category(id),
    PRIMARY KEY (id)
);