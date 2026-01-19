1) Mostrar todas las carreras juntos con sus asignaturas.

SELECT NOMCARRERA, NOMASIG
FROM CARRERAS, ASIGNATURAS
WHERE CARRERAS.CODCARRERA = ASIGNATURAS.CODCARRERA;

2) Mostrar solo la carrera de INFORMATICA mostrando el codigo de la asignatura,
el nombre de la asignatura, el numero de alumno y el nombre de la carrera.

SELECT CODASIG, NOMASIG, NUMALUMNOS, NOMCARRERA
FROM ASIGNATURAS, CARRERAS
WHERE NOMCARRERA = 'INFORMATICA' AND ASIGNATURAS.CODCARRERA = CARRERAS.CODCARRERA;

3) Mostrar solo la carrera de TELEMATICA mostrando el codigo de la asignatura,
el nombre de la asignatura, el numero de alumno y el nombre de la carrera.

SELECT CODASIG, NOMASIG, NUMALUMNOS, NOMCARRERA
FROM ASIGNATURAS, CARRERAS
WHERE NOMCARRERA = 'TELEMATICA' AND ASIGNATURAS.CODCARRERA = CARRERAS.CODCARRERA;

4) Mostrar por pantalla cuando se matriculó el alumno LUIS PEREZ, mostrándo el
DNI, NOMBRE, APELLIDOS, EDAD y la propia fecha de matricula.

SELECT A.DNI, A.NOMBRE, A.APELLIDOS, A.EDAD, M.FECHAMATRICULA
FROM ALUMNOS A, MATRICULADOS M
WHERE A.NOMBRE = 'LUIS' AND A.APELLIDOS = 'PEREZ' AND A.DNI = M.DNI;

5) Mostrar las asignaturas de la carrera de INFORMATICA que tengan más de 50
alumnos

SELECT CODASIG, NOMASIG, NUMALUMNOS
FROM ASIGNATURAS, CARRERAS
WHERE NUMALUMNOS > 50 AND NOMCARRERA = 'INFORMATICA' AND ASIGNATURAS.CODCARRERA = CARRERAS.CODCARRERA;

6) Mostrar los alumnos cuyos apellidos empiecen por S

SELECT *
FROM ALUMNOS
WHERE APELLIDOS LIKE 'S%';

7) Mostrar los alumnos cuyos apellidos acaben por Z

SELECT *
FROM ALUMNOS
WHERE APELLIDOS LIKE '%Z';

8) Mostrar las carreras donde el numero de matriculados entre comprendidos entre
200 y 350.

SELECT *
FROM CARRERAS
WHERE NUMMATRICULADOS >= 200 AND NUMMATRICULADOS <= 350;

9) Mostrar todas las carreras menos INFORMATICA.

SELECT *
FROM CARRERAS
WHERE NOMCARRERA != 'INFORMATICA';