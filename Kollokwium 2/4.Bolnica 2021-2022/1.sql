--1
select k.id_klinika, 
ime_klinika, 
ulica,
broj, 
l.embg, 
c.ime, 
c.prezime,
naziv_specijalnost as naziv_specijalnost_lekar
from klinika as k
left join lekar_vraboten_klinika as lvk on k.id_klinika = lvk.id_klinika
left join lekar as l on lvk.embg_lekar = l.embg
join chovek as c on l.embg = c.embg
left join specijalnost as s on l.id_specijalnost = s.id_specijalnost
where k.ime_klinika ilike '%medika%';