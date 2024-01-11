
-- edno od niv ke raboti(rabotat se)
set search_path to banka
--1
select c.embg ,c.ime ,c.prezime , k.adresa_ziveenje , tb.telefonski_broj
from klient k
join chovek c on k.embg_klient  =c.embg  
join telefonski_broj tb on k.embg_klient =tb.embg_klient 
left join grad g on k.id_grad =g.id_grad
where g.ime_grad ilike 'Skopje' or g.ime_grad ilike'Ohird';
--1
select embg ,c.ime ,c.prezime ,adresa_ziveenje ,telefonski_broj
from klient as k 
left join grad as g on k.id_grad = g.id_grad
join telefonski_broj tb on k.embg_klient =tb.embg_klient 
join chovek c on k.embg_klient =c.embg 
where g.ime_grad ilike 'Skopje' or g.ime_grad ilike 'Ohrid';

--1
select c.embg ,c.ime ,c.prezime , k.adresa_ziveenje , tb.telefonski_broj
from chovek c 
join klient k on c.embg =k.embg_klient 
join telefonski_broj tb on k.embg_klient =tb.embg_klient 
left join grad g on k.id_grad =g.id_grad
where g.ime_grad ilike 'Skopje' or g.ime_grad ilike 'Ohrid';

--1
select c.embg , c.ime ,c.prezime , k.adresa_ziveenje , tb.telefonski_broj 
from telefonski_broj tb 
join klient k on k.embg_klient =tb.embg_klient
join chovek c on k.embg_klient =c.embg 
left join grad g on k.id_grad =g.id_grad 
where g.ime_grad ilike 'Skopje' or g.ime_grad ilike 'Ohrid';
