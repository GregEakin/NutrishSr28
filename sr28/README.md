# Nutrish Sr28
:fire: **Greg Eakin**

## Database:
Download the [USDA National Nutrient Database SR28](https://www.ars.usda.gov/northeast-area/beltsville-md-bhnrc/beltsville-human-nutrition-research-center/methods-and-application-of-food-composition-laboratory/mafcl-site-pages/sr17-sr28/), ASCII file format suitable for RDBMS systems, and save the text files in the `/data` folder

## External Libraries:
- hsqldb-2.4.0
- hibernate-core-5.4.9.Final
- JUnit5.0

## Database Server:
Run this database server
>`info.gdbtech.server.Database`

## Import the Data:
Run this program, to load the text files into the database
>`info.gdbtech.Ddl`

## Run the Unit Tests:
Everything in the `/tests` folder:
> `info.gdbtech`
