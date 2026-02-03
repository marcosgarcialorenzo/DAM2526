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
