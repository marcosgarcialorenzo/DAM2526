1) Mostrar el código y nombre de la línea de metro por dónde
pasa el TREN1

SELECT L.CODLINEA, L.NOMLINEA, T.NOMTREN
FROM LINEAS L, TRENES T
WHERE L.CODLINEA = T.CODLINEA AND T.NOMTREN = 'TREN 1';

2) Mostrar sólo la línea de metro 9

SELECT CODLINEA, NOMLINEA
FROM LINEAS
WHERE IDLINEA = 9;

3) Ordenar todas las líneas de la red de metro por su nombre (no
por su código)

SELECT CODLINEA, NOMLINEA
FROM LINEAS
ORDER BY NOMLINEA;

4) Ordenar todas las líneas de la red de metro por su código (no
por su nombre)

SELECT CODLINEA, NOMLINEA
FROM LINEAS
ORDER BY CODLINEA;

5) Mostrar sólo las cinco primeras líneas de metro.

SELECT CODLINEA, NOMLINEA
FROM LINEAS
WHERE ROWNUM <= 5;

6) Mostrar sólo las cinco ultimas líneas de metro.

SELECT CODLINEA, NOMLINEA
FROM (
  SELECT CODLINEA, NOMLINEA
  FROM LINEAS
  ORDER BY CODLINEA DESC
)
WHERE ROWNUM <= 5;

7) Mostrar las líneas que empiecen por A

SELECT CODLINEA, NOMLINEA
FROM LINEAS
WHERE NOMLINEA LIKE 'A%';

8) Mostrar las líneas que empiecen por A o por M

SELECT CODLINEA, NOMLINEA
FROM LINEAS
WHERE NOMLINEA LIKE 'A%' OR NOMLINEA LIKE 'M%'

9) Mostrar las líneas que tengan una O entre medio del nombre
de la línea.

SELECT CODLINEA, NOMLINEA
FROM LINEAS
WHERE NOMLINEA LIKE '%O%';

10) Mostrar cuántos trenes hay por línea.

SELECT CODLINEA, SUM(NUMTRENES) AS TOTAL_TRENES
FROM TRENES
GROUP BY CODLINEA;

11) Mostrar las líneas que tienen más de 5 trenes en total.(no se puede usar where con cosas como sum)

SELECT CODLINEA, SUM(NUMTRENES) AS "TOTAL_TRENES"
FROM TRENES
GROUP BY CODLINEA
HAVING SUM(NUMTRENES) > 5;

12) Mostrar el promedio de trenes por línea.

SELECT CODLINEA, AVG(NUMTRENES) AS "PROMEDIO_TRENES"
FROM TRENES
GROUP BY CODLINEA;

13) Mostrar las líneas con un promedio de trenes mayor a 3

SELECT CODLINEA, AVG(NUMTRENES) AS "PROMEDIO_TRENES"
FROM TRENES
GROUP BY CODLINEA
HAVING AVG(NUMTRENES) > 3;

14) Mostrar los nombres de líneas que tienen un tren registrado.

SELECT NOMLINEA
FROM LINEAS
WHERE CODLINEA IN (
    SELECT CODLINEA 
    FROM TRENES
    GROUP BY CODLINEA
    HAVING COUNT(*) >= 1
);

15) Mostrar el nombre del tren con el mayor número de trenes

SELECT NOMTREN, NUMTRENES
FROM TRENES
WHERE NUMTRENES = (
    SELECT MAX(NUMTRENES) 
    FROM TRENES
);

16) Mostrar la línea con menor cantidad total de trenes.

SELECT CODLINEA, SUM(NUMTRENES) AS "TOTAL"
FROM TRENES
GROUP BY CODLINEA
HAVING SUM(NUMTRENES) = (
    SELECT MIN(SUM(NUMTRENES))
    FROM TRENES
    GROUP BY CODLINEA
);

17) Mostrar los trenes que están en líneas cuyo nombre contiene
la letra 'R'

SELECT T.NOMTREN 
FROM TRENES T, LINEAS L
WHERE T.CODLINEA = L.CODLINEA AND L.NOMLINEA LIKE '%R%';

SELECT NOMTREN
FROM TRENES
WHERE CODLINEA IN (
    SELECT CODLINEA
    FROM LINEAS
    WHERE NOMLINEA LIKE '%R%'
);

18) Mostrar la línea con más trenes diferentes

SELECT CODLINEA, SUM(NUMTRENES) AS CANT_TRENES
FROM TRENES
GROUP BY CODLINEA
HAVING SUM(NUMTRENES) = (
    SELECT MAX(SUM(NUMTRENES))
    FROM TRENES
    GROUP BY CODLINEA
);

19) Mostrar el número total de trenes en toda la red.

SELECT SUM(NUMTRENES) AS "TOTAL_TRENES_RED"
FROM TRENES;