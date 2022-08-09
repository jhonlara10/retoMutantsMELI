# mutantsMELI
Repo con el desarrollo del reto de MELI

Jhon Alexander Lara Barrera
jhonalexlara10@hotmail.com
El despliegue y la base de datos se encuentran en Heroku

Se utilizo para desarrollar esta prueba spring-Boot,base de datos postgres y despliegue de la app en heroku, java 8, JUnit

Para correr el proyecto--->

import maven proyect

MutantsMeliApplication Run as-> Java Application

Para invocar servicios

GET --> https://mutans-meli.herokuapp.com/mutants/stats

POST --> https://mutans-meli.herokuapp.com/mutants/mutant
Ejemplo de body json --> 
{
"dna":["ATGCAAA","CAGTGCA","TTATGTA","AGAAGGA","CCTCTAA","TCACTGC", "TCACTGC"]
}



