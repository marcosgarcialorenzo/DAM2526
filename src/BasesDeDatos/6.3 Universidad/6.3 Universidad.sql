1) Mostrar todas las carreras juntos con sus asignaturas.

SELECT NOMCARRERA, NOMASIG
FROM CARRERAS, ASIGNATURAS
WHERE CARRERAS.CODCARRERA = ASIGNATURAS.CODCARRERA;

2) Mostrar solo la carrera de INFORMATICA mostrando el codigo de la asignatura,
el nombre de la asignatura, el numero de alumno y el nombre de la carrera.

SELECT CODASIG, NOMASIG, NUMALUMNOS, NOMCARRERA
FROM ASIGNATURAS, CARRERAS
WHERE NOMCARRERA = 'INFORMATICA' AND ASIGNATURAS.CODCARRERA = CARRERAS.CODCARRERA;