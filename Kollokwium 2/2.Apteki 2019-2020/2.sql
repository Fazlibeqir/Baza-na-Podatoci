--2
select s.id_smetka
from smetki s
left join prodazba p on s.id_smetka =p.id_smetka 
left join lekovi l on p.id_lek =l.id_lek 
where l.atc_code ilike 'a02%';