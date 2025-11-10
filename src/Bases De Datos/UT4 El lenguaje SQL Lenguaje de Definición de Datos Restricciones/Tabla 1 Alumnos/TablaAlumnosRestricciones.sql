CREATE TABLE ALUMNOS
(
    CODALUMNO NUMBER(3) NOT NULL,
    NOMALUMNO VARCHAR2(30) NOT NULL,
    NOTAT1    NUMBER (2),
    NOTAT2    NUMBER (2),
    NOTAT3    NUMBER (2),
    EDAD      NUMBER (2),
    CONSTRAINT pk_alumnos PRIMARY KEY (CODALUMNO),
    CONSTRAINT ck1_alumnos CHECK ( NOTAT1 between 1 and 10),
    CONSTRAINT ck2_alumnos CHECK ( NOTAT2 between 1 and 10),
    CONSTRAINT ck3_alumnos CHECK ( NOTAT3 between 1 and 10),
    CONSTRAINT ck4_alumnos CHECK ( EDAD between 1 and 99)
);