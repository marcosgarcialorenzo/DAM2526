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

select nombre, cuota
from vendedores
where cuota > (select avg(cuota) from vendedores)
order by cuota asc;

9) Mostrar todas las empresas atendidas por Jesús Serrano

select c.empresa
from clientes c, vendedores v
where c.num_emp = v.num_emp
  and v.nombre = 'Jesus Serrano';

10) Mostrar los nombres de los empleados que no trabajen en oficinas dirigidas por
Carlos Ruiz

select nombre
from vendedores
where num_ofi not in (select num_ofi 
                      from oficinas 
                      where num_dir = 108);

11) Mostrar el número de cliente, la cantidad y el importe de los pedidos que hay
sobre el producto ‘Tirador’

select p.num_cli, p.canti, p.importe
from pedidos p, productos pr 
where p.id_fab = pr.id_fab 
  and p.id_prod = pr.id_prod
  and pr.descripcion = 'Tirador';

12) Sacar el nombre, ventas y numero de oficina de los vendedores cuyas ventas sean
mayores que la media de ventas de su oficina

select nombre, ventas, num_ofi
from vendedores v1
where ventas > (select avg(ventas) 
                from vendedores v2 
                where v2.num_ofi = v1.num_ofi);

13) Mostrar las oficinas que superan el promedio de ventas de la región ‘Este’.

select *
from oficinas
where ventas > (select avg(ventas) 
                from oficinas 
                where region = 'Este');

14) Mostrar aquellos vendedores que han realizado ventas mayores al límite de
crédito de sus clientes

select distinct v.nombre
from vendedores v, clientes c, pedidos p
where v.num_emp = p.num_emp
  and c.num_cli = p.num_cli
  and p.importe > c.limite_credito;

15) Mostrar aquellos productos cuyo precio es superior al promedio de los productos
de su fabricante

select descripcion, precio, id_fab
from productos p1
where precio > (select avg(precio) 
                from productos p2 
                where p2.id_fab = p1.id_fab);

16) Mostrar aquellos vendedores que han vendido productos con un precio superior
al promedio de precio por oficina

select distinct v.num_emp ,v.nombre
from vendedores v, pedidos p, productos pr
where v.num_emp = p.num_emp
  and p.id_fab = pr.id_fab
  and p.id_prod = pr.id_prod
  and pr.precio > (
      select avg(pr2.precio)
      from productos pr2, pedidos p2, vendedores v2
      where p2.id_fab = pr2.id_fab 
        and p2.id_prod = pr2.id_prod
        and p2.num_emp = v2.num_emp
        and v2.num_ofi = v.num_ofi
  );
