--4
select c1.embg as embg_uplakjach,c1.ime as ime_uplakjach,c1.prezime as prezime_uplakjach,
c2.embg as embg_isplaten ,c2.ime as ime_isplaten ,c2.prezime as prezime_isplaten,
t.valuta ,t.suma ,t.vreme_izvrsuvanje as vreme_transakcija
from transakcija t
join smetka s1 on t.broj_smetka_uplata =s1.broj_smetka  
join klient k1 on s1.embg_klient=k1.embg_klient
join chovek c1 on k1.embg_klient = k1.embg_klient 
join smetka s2 on t.broj_smetka_isplata =s2.broj_smetka
join klient k2 on s2.embg_klient =k2.embg_klient 
join chovek c2 on k2.embg_klient =c2.embg 
where extract (month from t.vreme_izvrsuvanje) = extract(month from now())
