--3
select f.id_filijala,f.adresa_filijala,g.ime_grad , count(distinct v.embg)
from vraboten as v
right join filijala as f on v.id_filijala =f.id_filijala  
join grad as g on f.id_grad =g.id_grad 
where v.rabotno_mesto ilike 'shalter' or v.rabotno_mesto isnull 
group by 1,2,3