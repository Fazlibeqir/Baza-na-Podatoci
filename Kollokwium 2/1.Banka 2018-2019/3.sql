select broj_smetka , count(t.broj_transakcija) as suma
from transakcija t 
left join smetka s on t.broj_smetka_uplata =s.broj_smetka
where t.valuta ilike 'MKD'
group by 1;