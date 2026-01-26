1) Crear una vista “CopiaPersonas” de la tabla PERSONAS con toda la
información de las personas.

CREATE OR REPLACE VIEW CopiaPersonas AS (
SELECT *
FROM ALUMNOS
);

2) Crear una vista que muestre sólo las personas que tengan 40 años o más
independientemente que sean hombres o mujeres

CREATE OR REPLACE VIEW Personas40oMas AS (
SELECT CODPERSONA, NOMPERSONA, EDAD, SEXO
FROM PERSONAS
WHERE EDAD>=40;
);

3) Crear una vista “PROFESORADAI” de la base de datos Instituto para Mostrar el
nombre del profesor que dá la asignatura de ADAI.

CREATE OR REPLACE VIEW PROFESORADAI AS (
SELECT NOMPROFESOR
FROM PROFESORES
WHERE CODASIG = 111
);

4) Crear una vista “ASIGNATURASEVA” de la base de datos Instituto Mostrar el
nombre de las asignaturas que dá el profesor EVA

CREATE OR REPLACE VIEW ASIGNATURASEVA AS (
SELECT A.NOMASIG
FROM ASIGNATURAS A, PROFESORES P
WHERE A.CODASIG = P.CODASIG AND P.NOMPROFESOR = 'EVA'
);

5) Crear una vista “SUMAFEDE” de la base de datos Instituto para mostrar la
suma de todos los alumnos del profesor FEDE

CREATE OR REPLACE VIEW SUMAFEDE AS (
SELECT SUM(NUMALUMNOS) AS TOTAL_ALUMNOS
FROM PROFESORES
WHERE NOMPROFESOR = 'FEDE'
);