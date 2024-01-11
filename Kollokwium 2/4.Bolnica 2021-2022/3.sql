--3
select p.embg as embg_pacient ,
c.ime as ime_pacient ,
c.prezime as prezime_pacient ,d2.mkb10 ,
d2.opis as opis_dijagnoza,
count( d.mkb10) as broj_dijagnozi
from pacient p
  join chovek c on p.embg = c.embg 
left join pregled p2 on p.embg =p2.embg_pacient 
left join dijagnosticira d on p2.id_pregled = d.id_pregled 
left join dijagnoza d2 on d.mkb10 = d2.mkb10 
group by 1,2,3,4,5;