--4
select u.embg_pacient,u.termin ,c.ime as ime_pacient,
c.prezime as prezime_pacient, c2.ime as ime_lekar_upatuva,
c2.ime as prezime_lekar_upatuva,c3.ime as ime_lekar_upaten,
c3.prezime as prezime_lekar_upaten,
s.naziv_specijalnost as naziv_specijalnost_lekar_upaten,
k.ime_klinika ,o.ime_oddel 
from upat u 
join pacient p on u.embg_pacient = p.embg 
join chovek c on p.embg =c.embg 
join lekar l on u.embg_lekar_upatuva = l.embg 
join lekar l2 on u.embg_lekar_upaten =l2.embg 
join chovek c2 on l.embg=c2.embg 
join chovek c3 on l2.embg =c3.embg 
join specijalnost s on l2.id_specijalnost =s.id_specijalnost 
join klinika k on u.id_klinika =k.id_klinika 
join oddel o on u.id_oddel =o.id_oddel 
where 
extract(month from u.termin) = extract(month from now()+interval '1 month');
