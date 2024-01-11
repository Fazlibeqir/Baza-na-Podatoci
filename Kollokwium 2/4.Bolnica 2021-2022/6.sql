--6
set search_path to banka;
select extract (month from t.vreme_izvrsuvanje)as mesec,
extract(year from t.vreme_izvrsuvanje) as godina,
t.valuta, sum(t.suma)as promet
from smetka s 
left join transakcija t on s.broj_smetka = t.broj_smetka_isplata
group by 1,2,3;