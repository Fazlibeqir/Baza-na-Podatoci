select extract(month from u.termin) as mesec,
extract(year from u.termin) as godina,
count(distinct u.id_upat)as broj_zakzani,
count(distinct u.id_pregled) as broj_odrzani
from upat u
group by 1,2w