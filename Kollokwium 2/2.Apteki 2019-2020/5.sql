select  l1.id_lek AS id_lek1,
    l2.id_lek AS id_lek2,
    l1.ime_lek AS ime_lek1,
    l2.ime_lek AS ime_lek2,
    l1.atc_code AS atc1,
    l2.atc_code AS atc2,
    COUNT(*) AS br_prepisuvanja_zaedno
from prodazba p1
join prodazba p2 on p1.id_smetka=p2.id_smetka
join lekovi l1 on p1.id_lek=l1.id_lek
join lekovi l2 on p2.id_lek =l2.id_lek 
join smetki s1 on p1.id_smetka=s1.id_smetka 
join smetki s2 on p2.id_smetka =s2.id_smetka 
join apteki a1 on s1.id_apteka=a1.id_apteka 
join apteki a2 on s2.id_smetka = a2.id_apteka 
where 
	l1.id_lek< l2.id_lek 
	and a1.id_grad=a2.id_grad 
	and s1.datum_prodazba between s2.datum_prodazba - interval '7 days'
	and s2.datum_prodazba 
	and left(l1.atc_code,5)<> left(l2.atc_code,5)
group by id_lek1,id_lek2,
ime_lek1,
ime_lek2,
atc1,
atc2 
order by br_prepisuvanja_zaedno desc;