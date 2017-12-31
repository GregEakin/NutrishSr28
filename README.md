# Nutrish Sr28
:fire: **Greg Eakin**

This is an experiment in configuring an existing database in Hibernate and JUnit 5.
Here we defined the schema with annotation in Java files.

## Tags
- [Hibernate](http://hibernate.org/orm/) Object-Relation Mapping
- [JUnit 5](http://junit.org/junit5/) Unit Tests
- [HPL/SQL](http://www.hplsql.org/) Database
- [USDA National Nutrient Database](https://www.ars.usda.gov/northeast-area/beltsville-md/beltsville-human-nutrition-research-center/nutrient-data-laboratory/docs/usda-national-nutrient-database-for-standard-reference/) for Standard Reference SR28

## Database:
Download the [USDA National Nutrient Database SR28](https://www.ars.usda.gov/northeast-area/beltsville-md/beltsville-human-nutrition-research-center/nutrient-data-laboratory/docs/sr28-download-files/)
database and save the text files in the `/data` folder
[![USDA Nutrition Database](sr28/docs/Nutrish%20SR28.jpg "USDA Nutrition Database")](https://www.ars.usda.gov/northeast-area/beltsville-md/beltsville-human-nutrition-research-center/nutrient-data-laboratory/docs/sr28-download-files/)

## Libraries:
These jars need to be installed in the `/SR28/Lib` folder.
- antlr-2.7.7.jar
- classmate-1.3.0.jar
- dom4j-1.6.1.jar
- hibernate-commons-annotations-5.0.1.Final.jar
- hibernate-core-5.2.12.Final.jar
- hibernate-jpa-2.1-api-1.0.0.Final.jar
- jandex-2.0.3.Final.jar
- javassist-3.20.0-GA.jar
- jboss-logging-3.3.0.Final.jar
- jboss-transaction-api_1.2_spec-1.0.1.Final.jar

## Database Server:
Run this database server
>`info.gdbtech.server.Database`

## Import the Data:
Run this program, to load the text files into the database
>`info.gdbtech.Ddl`

## Run the Unit Tests:
Everything in the `/tests` folder:
> `info.gdbtech`
