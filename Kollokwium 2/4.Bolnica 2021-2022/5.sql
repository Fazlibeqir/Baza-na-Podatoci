--5
select l.embg as embg_lekar, c.ime as ime_lekar, c.prezime as prezime_lekar,
count(distinct p.id_pregled) as broj_pregledi,
count(distinct u.id_upat) as broj_kreirani_upati,
count(distinct case when u.id_pregled is not null then u.id_upat end) as broj_realizirani_upati,
count( d.mkb10) as broj_dijagnozi,
count(distinct d.mkb10) as broj_razlicni_dijagnozi
from lekar as l
left join pregled p on l.embg = p.embg_lekar
join chovek as c on l.embg = c.embg 
left join upat as u on p.id_pregled = u.id_pregled
left join upat as u2 on p.embg_lekar = u2.embg_lekar_upaten
left join dijagnosticira as d on p.id_pregled = d.id_pregled 
group by 1,2,3