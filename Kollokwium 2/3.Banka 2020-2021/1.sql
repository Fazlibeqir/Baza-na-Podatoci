set search_path to banka;
--1
select embg,ime,prezime,adresa_ziveenje,telefonski_broj
from klient k
join chovek c on k.embg_klient =c.embg 
left join telefonski_broj tb on k.embg_klient = tb.embg_klient
where char_length(k.embg_klient)=13;