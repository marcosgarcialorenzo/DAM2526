2. Sacar el nombre de la empresa y del jefe de toda la tabla MULTINACIONAL

SELECT NOMBREEMPRESA, NOMBREJEFE
FROM MULTINACIONAL;

3. Sacar todos los datos de la tabla MULTINACIONAL que tengan la categoría
profesional de ANALISTA.

SELECT *
FROM MULTINACIONAL
WHERE CATEGORIA = 'ANALISTA';

4. Sacar el nombre del jefe y nombre del empleado de la empresa GETRONICS.

SELECT NOMBREJEFE, NOMBREEMPLEADO
FROM MULTINACIONAL
WHERE NOMBREEMPRESA = 'GETRONICS';

5. Sacar el nombre del jefe y nombre del empleado de todos los ANALISTAS de la
empresa, agrupados por nombre de empresa

SELECT NOMBREJEFE, NOMBREEMPLEADO
FROM MULTINACIONAL
WHERE CATEGORIA = 'ANALISTA'
ORDER BY NOMBREEMPRESA;

6. Sacar el nombre del jefe y nombre del empleado de todos los ANALISTAS de la
empresa, ordenados por nombre de jefe

SELECT NOMBREJEFE, NOMBREEMPLEADO
FROM MULTINACIONAL
WHERE CATEGORIA = 'ANALISTA'
ORDER BY NOMBREJEFE;

7. Sacar el nombre del jefe y nombre del empleado de todos los empleados que ganan
menos de 1800 euros.

SELECT NOMBREJEFE, NOMBREEMPLEADO
FROM MULTINACIONAL
WHERE SUELDONETO < 1800;

8. Sacar el nombre del jefe y nombre del empleado de todos los empleados cuya fecha de
incorporación ha sido a partir del año 2002

SELECT NOMBREJEFE, NOMBREEMPLEADO
FROM MULTINACIONAL
WHERE TO_DATE(FECHA,'YYYY/MM/DD') >= TO_DATE('2002/01/01','YYYY/MM/DD');

9. Sacar por pantalla cuántos TECNICOS hay en la multinacional

SELECT COUNT(*) AS "Tecnicos"
FROM MULTINACIONAL
WHERE CATEGORIA = 'TECNICO';


