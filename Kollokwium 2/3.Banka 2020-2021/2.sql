--2
select extract(month from t.vreme_izvrsuvanje)as mesec, sum(t.suma)as suma
from transakcija t
where t.valuta='MKD'
group by 1;