select g.id_grad ,
g.ime_grad ,
l.id_lek ,
l.atc_code as atc_kod,
count(distinct s.id_smetka) as broj_kupuvanja_nadvor
from gradovi as g
join apteki as a on g.id_grad = a.id_grad 
join smetki as s on a.id_apteka =s.id_apteka 
join prodazba as pr on s.id_smetka =pr.id_smetka 
join lekovi as l on pr.id_lek = l.id_lek 
where a.id_grad <>g.id_grad 
group by 1,2,3,4
limit 10;