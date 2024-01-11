SET search_path TO apteki;

--1
select g.id_grad,g.ime_grad,
count(id_apteka) as broj_apteki
from apteki a
right join gradovi g on a.id_grad =g.id_grad
group by 1,2;