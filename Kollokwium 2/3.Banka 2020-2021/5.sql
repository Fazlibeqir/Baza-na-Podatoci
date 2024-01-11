--5
select g.id_grad , g.ime_grad ,count(distinct f.id_filijala) as broj_filijali,
count(distinct k.embg_klient)as broj_klienti
from grad g 
left join filijala f on g.id_grad =f.id_grad 
left join klient k on g.id_grad =k.id_grad 
group by 1,2