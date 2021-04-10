CREATE TABLE BOOKS_AUD (
                           EVENT_ID       INT NOT NULL AUTO_INCREMENT,
                           EVENT_DATE     DATETIME NOT NULL,
                           EVENT_TYPE     VARCHAR(10) DEFAULT NULL,
                           BOOK_ID        INT NOT NULL,
                           OLD_TITLE      VARCHAR(255),
                           NEW_TITLE      VARCHAR(255),
                           OLD_PUBYEAR    INT,
                           NEW_PUBYEAR    INT,
                           OLD_BESTSELLER TINYINT(1),
                           NEW_BESTSELLER TINYINT(1),
                           PRIMARY KEY (EVENT_ID)
);

CREATE TABLE READERS_AUD (
                             EVENT_ID    INT NOT NULL AUTO_INCREMENT,
                             EVENT_DATE  DATETIME NOT NULL,
                             EVENT_TYPE  VARCHAR(10) DEFAULT NULL,
                             READER_ID   INT NOT NULL,
                             OLD_FIRSTNAME   VARCHAR(255),
                             NEW_FIRSTNAME   VARCHAR(255),
                             OLD_LASTNAME    VARCHAR(255),
                             NEW_LASTNAME    VARCHAR(255),
                             OLD_PESELID     VARCHAR(11),
                             NEW_PESELID     VARCHAR(11),
                             OLD_VIP_LEVEL   VARCHAR(20),
                             NEW_VIP_LEVEL   VARCHAR(20),
                             PRIMARY KEY (EVENT_ID)
);

DELIMITER $$
CREATE TRIGGER BOOKS_DELETE
    AFTER DELETE
    ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID)
        VALUE (CURTIME(), "DELETE", OLD.BOOK_ID);
END $$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER BOOKS_INSERT
    AFTER INSERT
    ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID, NEW_TITLE, NEW_PUBYEAR, NEW_BESTSELLER)
        VALUE (CURTIME(), "INSERT", NEW.BOOK_ID, NEW.TITLE, NEW.PUBYEAR, NEW.BESTSELLER);
END $$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER BOOKS_UPDATE
    AFTER UPDATE
    ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD (EVENT_DATE, EVENT_TYPE, BOOK_ID, NEW_TITLE, NEW_PUBYEAR, NEW_BESTSELLER,
                           OLD_TITLE, OLD_PUBYEAR, OLD_BESTSELLER)
        VALUE (CURTIME(), "UPDATE", OLD.BOOK_ID, NEW.TITLE, NEW.PUBYEAR, NEW.BESTSELLER,
               OLD.TITLE, OLD.PUBYEAR, OLD.BESTSELLER);
END $$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER READERS_DELETE
    AFTER DELETE
    ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID)
        VALUE (CURTIME(), "DELETE", OLD.READER_ID);
END $$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER READERS_INSERT
    AFTER INSERT
    ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID, NEW_FIRSTNAME, NEW_LASTNAME, NEW_PESELID, NEW_VIP_LEVEL)
        VALUE (CURTIME(), "INSERT", NEW.READER_ID, NEW.FIRSTNAME, NEW.LASTNAME, NEW.PESELID, NEW.VIP_LEVEL);
END $$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER READERS_UPDATE
    AFTER UPDATE
    ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD (EVENT_DATE, EVENT_TYPE, READER_ID, OLD_FIRSTNAME, NEW_FIRSTNAME,
                             OLD_LASTNAME, NEW_LASTNAME, OLD_PESELID, NEW_PESELID, OLD_VIP_LEVEL, NEW_VIP_LEVEL)
        VALUE (CURTIME(), "UPDATE", OLD.READER_ID, OLD.FIRSTNAME, NEW.FIRSTNAME,
               OLD.LASTNAME, NEW.LASTNAME, OLD.PESELID, NEW.PESELID, OLD.VIP_LEVEL, NEW.VIP_LEVEL);
END $$
DELIMITER ;

select * from books;
insert into books (title, pubyear) values ("Mały Książe", 1943);
update books set bestseller=true where title = "Mały Książe";
delete from books where title = "Mały Książe";
select * from books_aud;
select * from readers;
insert into readers(firstname, lastname, peselid, vip_level) values ("Jan", "Kowalski", 80023012345, "Gold customer");
update readers set firstname="Jan Maria" where lastname="Kowalski";
delete from readers where firstname="Jan Maria";
select * from readers_aud;