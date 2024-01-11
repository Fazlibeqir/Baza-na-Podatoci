select v.embg as embg_vraboten ,c2.ime as ime_vraboten 
,c2.prezime as prezime_vraboten,v.id_filijala as id_filijala 
,f.adresa_filijala ,g.ime_grad as grad_filijala,v.embg_shef 
,c.ime as ime_shef ,c.prezime as prezime_shef
from vraboten v
left join filijala f on v.id_filijala =f.id_filijala 
left join grad g ON f.id_grad =g.id_grad 
left join chovek c on v.embg_shef =c.embg 
left join chovek c2 on v.embg =c2.embg 