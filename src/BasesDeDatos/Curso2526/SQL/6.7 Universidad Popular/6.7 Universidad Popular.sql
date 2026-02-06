1) Mostrar el nombre de las asignaturas y las horas de crédito de las
asignaturas que dio el profesor BARNES en PRIMAVERA.

SELECT NOMASIG, HORASCREDITO
FROM ASIGNATURAS
WHERE PROFESOR = 'BARNES' AND SEMESTRE = 'PRIMAVERA';

2) Mostrar el nombre de las asignaturas y las horas de crédito de las
asignaturas que dio el profesor BARNES en OTOÑO o el profesor
MARTIN en OTOÑO.

SELECT NOMASIG, HORASCREDITO
FROM ASIGNATURAS
WHERE PROFESOR = 'BARNES' AND SEMESTRE = 'OTOÑO' 
OR PROFESOR = 'MARTIN' AND SEMESTRE = 'OTOÑO'

3) Sacar todas las categorías distintas.

SELECT DISTINCT CATEGORIA
FROM PROFESORES;

4) Sacar todos los profesores junto con sus asignaturas.


5) Sacar todos los profesores juntos con las asignaturas que se imparten en
PRIMAVERA.


6) Sacar la asignatura con mayor número de créditos indicando el nombre de
dicha asignatura


7) Sacar la asignatura con menor número de créditos indicando el nombre de
dicha asignatura


8) Para cada asignatura sacar el total de sus horas de crédito


9) Para cada asignatura, sacar el total de sus horas de crédito siempre que sea
superior a 6 horas de créditos.


10) Mostrar el profesor y la asignatura que tiene la mayor cantidad de horas
crédito.


11) Mostrar los profesores que han impartido más de 6 horas crédito en total.


12.) Mostrar los profesores cuya categoría es "PROFESOR AYUDANTE" y
que dictaron asignaturas en PRIMAVERA.


13) Mostrar los nombres de asignaturas dictadas por profesores que también
dictaron "BIOLOGIA".


14) Mostrar los profesores que han dictado más de una asignatura distinta.


15) Mostrar los profesores que NO han dictado "SICOLOGIA".


16) Mostrar la cantidad total de horas crédito impartidas por profesores
catedráticos.


17) Mostrar nombre y categoría de profesores que dictaron asignaturas en 3
semestres


18) Mostrar los profesores con el promedio de horas crédito que dictaron.


19) Mostrar el nombre de los profesores que dictaron al menos una asignatura
que tenga el mismo número de horas que "ASTRONOMIA".

