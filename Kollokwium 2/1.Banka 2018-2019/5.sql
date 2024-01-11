select v.embg, c.ime ,c.prezime ,
	count(distinct v2.embg)as broj_vraboteni_shef,
	count(distinct ov.broj_smetka) as broj_otvoreni_smetki
from vraboten v
left join chovek c on v.embg =c.embg 
left join vraboten v2 on v.embg = v2.embg_shef 
left join otvorena_vo ov on v.embg  =ov.embg_vraboten
group by v.embg ,c.ime,c.prezime