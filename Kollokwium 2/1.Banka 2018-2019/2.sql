--2
select extract(year from vreme_izvrsuvanje) as godina,sum(suma)
from transakcija t
where valuta ilike 'USD' or valuta ilike 'EUR'
group by 1;