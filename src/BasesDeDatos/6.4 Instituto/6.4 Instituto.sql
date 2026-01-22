1) Mostrar toda la tabla de profesores

SELECT *
FROM PROFESORES;

2) Mostrar los alumnos que cursan DAI

SELECT *
FROM ALUMNOS
WHERE GRUPO = 'DAI';

3) Mostrar los alumnos que cursan ASI

SELECT *
FROM ALUMNOS
WHERE GRUPO = 'ASI';

4) Mostrar los alumnos donde el tutor sea FEDE

SELECT *
FROM ALUMNOS
WHERE TUTOR = 'FEDE';

5) Mostrar los alumnos donde el tutor sea FEDE y que hayan
aprobado el trimestre 1

SELECT *
FROM ALUMNOS
WHERE TUTOR = 'FEDE' AND NOTA1 >=5;  // si se usan las tres notas para el 1ºtrimestre (nota1 + nota2 + nota3)/3 >= 5;

6) Mostrar el nombre del profesor que dá la asignatura de ADAI

SELECT P.NOMPROFESOR, A.NOMASIG
FROM PROFESORES P, ASIGNATURAS A
WHERE P.CODASIG = A.CODASIG AND A.CODASIG = 111;

7) Mostrar el nombre de las asignaturas que dá el profesor EVA

SELECT P.NOMPROFESOR, A.NOMASIG
FROM PROFESORES P, ASIGNATURAS A
WHERE P.CODASIG = A.CODASIG AND P.NOMPROFESOR = 'EVA';

8) Alumnos Ordenados alfabéticamente

SELECT *
FROM ALUMNOS
ORDER BY APELLIDO1 ASC;

9) Alumnos DAI ordenados alfabéticamente

SELECT *
FROM ALUMNOS
WHERE GRUPO = 'DAI'
ORDER BY APELLIDO1 ASC;

10) Total de los alumnos que dá el profesor FEDE

SELECT NOMPROFESOR, SUM(NUMALUMNOS) AS "Suma de alumnos de Fede"
FROM PROFESORES
WHERE NOMPROFESOR = 'FEDE'
GROUP BY NOMPROFESOR;

11) Total de los alumnos que dá el profesor EVA

SELECT NOMPROFESOR, SUM(NUMALUMNOS) AS "Suma de alumnos de Eva"
FROM PROFESORES
WHERE NOMPROFESOR = 'EVA'
GROUP BY NOMPROFESOR;