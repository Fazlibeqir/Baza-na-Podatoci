select c.embg , c.ime , c.prezime,
	count(distinct t.broj_transakcija) as broj_uplati,
	count(distinct t2.broj_transakcija) as broj_isplati
from klient k
left join chovek c on k.embg_klient = c.embg 
left join grad g on k.id_grad =g.id_grad 
left join smetka s on k.embg_klient =s.embg_klient 
left join transakcija t on s.broj_smetka = t.broj_smetka_uplata 
left join transakcija t2 on s.broj_smetka =t2.broj_smetka_isplata 
where g.ime_grad ilike 'Skopje'
group by 1,2,3