select  extract (year from t.vreme_izvrsuvanje)as godina
,sum(suma)as suma
from klient k
join grad g1 on k.id_grad =g1.id_grad 
join smetka s on k.embg_klient =s.embg_klient 
join transakcija t on t.broj_smetka_isplata =s.broj_smetka 
join otvorena_vo ov on s.broj_smetka =ov.broj_smetka 
join filijala f on ov.id_filijala =f.id_filijala 
join grad as g2 on f.id_grad=g2.id_grad
where g1.ime_grad ilike 'skopje'
and g2.ime_grad ilike 'skopje'
and t.valuta ilike 'mkd'
group by 1