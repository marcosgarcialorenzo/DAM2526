1) Mostrar toda la información de la tabla PERSONAS.

SELECT *
FROM PERSONAS

2) Mostrar sólo las personas que tengan 40 años o más independientemente que sean
hombres o mujeres.

SELECT *
FROM PERSONAS
WHERE EDAD >= 40;

3) Mostrar cuántas personas tienen 40 años o más independientemente que sean
hombres o mujeres.

SELECT COUNT(*) as "Personas con 40 años o mas"
FROM PERSONAS
WHERE EDAD >= 40;


4) Mostrar sólo los hombres que tengan 40 años o más.

SELECT *
FROM PERSONAS
WHERE EDAD >= 40 AND SEXO = 'HOMBRE';


5) Mostrar sólo las mujeres que tengan 40 años o más.

SELECT *
FROM PERSONAS
WHERE EDAD >= 40 AND SEXO = 'MUJER';

6) Mostrar las personas que tengan menos de 30 años.

SELECT *
FROM PERSONAS
WHERE EDAD < 30;

7) Contar las personas que tengan menos de 30 años.

SELECT COUNT(*) as "Personas con menos de 30 años"
FROM PERSONAS
WHERE EDAD < 30;

8) Mostrar la media de las edades.

SELECT AVG(EDAD)
FROM PERSONAS

9) Mostrar la media de las edades de los hombres

SELECT AVG(EDAD)
FROM PERSONAS
WHERE SEXO = 'HOMBRE';

10) Mostrar la media de las edades de las mujeres.

SELECT AVG(EDAD)
FROM PERSONAS
WHERE SEXO = 'MUJER';

11) Mostrar sólo las personas que tengan menos de 35 o que su nombre empiece por J

SELECT *
FROM PERSONAS
WHERE EDAD <= 35 OR NOMPERSONA LIKE 'J%';

12) Mostrar la persona de mayor edad.

SELECT *
FROM PERSONAS
WHERE EDAD = (SELECT MAX(EDAD) FROM PERSONAS);

13) Mostrar la persona de menor edad

SELECT *
FROM PERSONAS
WHERE EDAD = (SELECT MIN(EDAD) FROM PERSONAS);

14) Mostrar cuántos hombres y cuántas mujeres hay

SELECT SEXO, COUNT(*) AS "Numero"
FROM PERSONAS
GROUP BY SEXO;

15) Mostrar la edad máxima, mínima y promedio de todas las personas

SELECT  MAX(EDAD) AS "Edad maxima",
        MIN(EDAD) AS "Edad minima",
        AVG(EDAD) AS "Media de edad"
FROM PERSONAS;

16) Mostrar la edad promedio por sexo.

SELECT SEXO, AVG(EDAD) AS "Media de edad"
FROM PERSONAS
GROUP BY SEXO;

17) Mostrar cuántas personas tienen entre 20 y 30 años (inclusive).

SELECT *
FROM PERSONAS
WHERE EDAD >= 20 AND EDAD <= 30;

18) Mostrar las personas cuyo nombre termina en "A"

SELECT *
FROM PERSONAS
WHERE NOMPERSONA LIKE '%A';

19) Mostrar las personas cuyo nombre contiene la letra "E"

SELECT *
FROM PERSONAS
WHERE NOMPERSONA LIKE '%E%';

20) Mostrar los nombres de personas en mayúscula y su edad.

SELECT UPPER(NOMPERSONA) AS NOMBRE_MAYUS, EDAD
FROM PERSONAS;

21) Mostrar el total de personas y la suma de todas las edades

SELECT COUNT(*) AS TOTAL_PERSONAS,
       SUM(EDAD) AS SUMA_EDADES
FROM PERSONAS;