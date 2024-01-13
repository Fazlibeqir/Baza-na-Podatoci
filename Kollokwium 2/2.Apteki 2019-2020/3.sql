--3
select brLek.id_pacient,brLek.ime_pacient
from gradovi g 
join (
 select
 p.id_pacient , 
 p.ime_pacient ,
 a.id_grad ,
 count(l.id_lek)as lekovite 
	from pacienti p
	inner join recepti r on p.id_pacient =r.id_pacient 
	left join prodazba p2 on r.id_recept =p2.id_recept 
	left join smetki s on s.id_smetka=p2.id_smetka
	left join apteki a on a.id_apteka = s.id_apteka
	left join lekovi l on p2.id_lek =l.id_lek 
	group by 1,2,3
	)as brLek on g.id_grad =brLek.id_grad
where 
(g.ime_grad ilike 'skopje' or g.ime_grad  ilike 'stip')
and brLek.lekovite>10;