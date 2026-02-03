1) Mostrar el nombre, ciudad en que trabaja, edad, numero de oficina y oficio de
los vendedores ordenados por el campo ciudad

select v.nombre, o.ciudad, v.edad, v.num_ofi, v.oficio
from vendedores v, oficinas o
where v.num_ofi = o.num_ofi
order by o.ciudad;

2) Mostrar la ciudad donde están las oficinas y los nombres y oficios 
de sus directores

select o.ciudad, v.nombre, v.oficio
from oficinas o, vendedores v
where v.num_emp = o.num_dir;

3) Mostrar el nombre, numero de oficina y ciudad en la que están los vendedores
cuyo oficio sea ‘Dir Ventas’.

select v.nombre, v.num_ofi, o.ciudad, v.oficio
from oficinas o, vendedores v
where v.oficio = 'Dir Ventas' and v.num_ofi = o.num_ofi;

4) Mostrar un listado del número de pedido, importe y descripción del producto
ordenado por número de pedido. Son 30 filas.

select p.num_ped, p.importe, pr.descripcion
from pedidos p, productos pr
where p.id_prod = pr.id_prod
order by p.num_ped;

5) Mostrar el número de pedido, el importe, la empresa y el nombre de vendedor que
tomó el pedido de los pedidos superiores a 25000 euros .

select p.num_ped, p.importe, c.empresa, v.nombre
from pedidos p, clientes c, vendedores v
where p.num_cli = c.num_cli and p.num_emp = v.num_emp and p.importe > 25000;

6) Mostrar el nombre de cada vendedor, su número de empleado y el nombre para
quien trabaja con su número de empleado

select e.nombre as empleado, e.num_emp, j.nombre as jefe, j.num_emp
from vendedores e, vendedores j
where e.num_dir = j.num_emp;

7) Mostrar las ventas totales de cada oficina y el número de oficina.

select num_ofi, sum(ventas) as total_ventas
from oficinas
group by num_ofi;

8) Mostrar el nombre y cuota de los vendedores que tengan más cuota que la media
de las cuotas y clasificado en orden ascendente de cuotas.

SELECT NOMBRE, CUOTA
FROM VENDEDORES
WHERE CUOTA > (SELECT AVG(CUOTA) FROM VENDEDORES)
ORDER BY CUOTA ASC;

9) Mostrar todas las empresas atendidas por Jesús Serrano

SELECT c.EMPRESA
FROM CLIENTES c, VENDEDORES v
WHERE c.NUM_EMP = v.NUM_EMP
  AND v.NOMBRE = 'Jesus Serrano';

10) Mostrar los nombres de los empleados que no trabajen en oficinas dirigidas por
Carlos Ruiz

SELECT NOMBRE
FROM VENDEDORES
WHERE NUM_OFI NOT IN (SELECT NUM_OFI 
                      FROM OFICINAS 
                      WHERE NUM_DIR = 108);

11) Mostrar el número de cliente, la cantidad y el importe de los pedidos que hay
sobre el producto ‘Tirador’

SELECT p.NUM_CLI, p.CANTI, p.IMPORTE
FROM PEDIDOS p, PRODUCTOS pr
WHERE p.ID_FAB = pr.ID_FAB 
  AND p.ID_PROD = pr.ID_PROD
  AND pr.DESCRIPCION = 'Tirador';

12) Sacar el nombre, ventas y numero de oficina de los vendedores cuyas ventas sean
mayores que la media de ventas de su oficina

SELECT NOMBRE, VENTAS, NUM_OFI
FROM VENDEDORES v1
WHERE VENTAS > (SELECT AVG(VENTAS) 
                FROM VENDEDORES v2 
                WHERE v2.NUM_OFI = v1.NUM_OFI);

13) Mostrar las oficinas que superan el promedio de ventas de la región ‘Este’.

SELECT *
FROM OFICINAS
WHERE VENTAS > (SELECT AVG(VENTAS) 
                FROM OFICINAS 
                WHERE REGION = 'Este');

14) Mostrar aquellos vendedores que han realizado ventas mayores al límite de
crédito de sus clientes

SELECT DISTINCT v.NOMBRE
FROM VENDEDORES v, CLIENTES c, PEDIDOS p
WHERE v.NUM_EMP = p.NUM_EMP
  AND c.NUM_CLI = p.NUM_CLI
  AND p.IMPORTE > c.LIMITE_CREDITO;

15) Mostrar aquellos productos cuyo precio es superior al promedio de los productos
de su fabricante

SELECT DESCRIPCION, PRECIO, ID_FAB
FROM PRODUCTOS p1
WHERE PRECIO > (SELECT AVG(PRECIO) 
                FROM PRODUCTOS p2 
                WHERE p2.ID_FAB = p1.ID_FAB);

16) Mostrar aquellos vendedores que han vendido productos con un precio superior
al promedio de precio por oficina

SELECT DISTINCT v.num_emp ,v.NOMBRE
FROM VENDEDORES v, PEDIDOS p, PRODUCTOS pr
WHERE v.NUM_EMP = p.NUM_EMP
  AND p.ID_FAB = pr.ID_FAB
  AND p.ID_PROD = pr.ID_PROD
  AND pr.PRECIO > (
      SELECT AVG(pr2.PRECIO)
      FROM PRODUCTOS pr2, PEDIDOS p2, VENDEDORES v2
      WHERE p2.ID_FAB = pr2.ID_FAB 
        AND p2.ID_PROD = pr2.ID_PROD
        AND p2.NUM_EMP = v2.NUM_EMP
        AND v2.NUM_OFI = v.NUM_OFI
  );