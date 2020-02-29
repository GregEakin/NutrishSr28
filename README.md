# Nutrish Sr28
:fire: **Greg Eakin**

This is an experiment in configuring an existing database in Hibernate and JUnit 5.
Here we defined the schema with annotation in Java files.

## Run the Unit Tests
1. Start the HSQLDB server by running `dev.eakin.server.Database.main()`.
1. Initialize the DB schema with `dev.eakin.Ddl.main()`.
1. Download [SR28ASC.zip](https://www.ars.usda.gov/ARSUserFiles/80400535/DATA/SR/sr28/dnload/sr28asc.zip), and unzip into the data folder.
1. Load the data into the database with `dev.eakin.DbLoad.main()`.
1. Run _all unit tests_; everything should pass.
1. Remember to shut down the database when finished, by running `dev.eakin.server.Shudown.main()`.

## Tags
- [Hibernate](http://hibernate.org/orm/) Object-Relation Mapping
- [HyperSQL](http://hsqldb.org/) Database
- [US Department of Agriculture, Agricultural Research Service.](http://www.ars.usda.gov/nea/bhnrc/mafcl) 2016. Nutrient Data Laboratory. USDA National Nutrient Database for Standard Reference, Release 28 (Slightly revised). Version Current: May 2016.
- [Java 11](https://docs.oracle.com/en/java/javase/11/docs/api/index.html)
- [JUnit 5](http://junit.org/junit5/) Unit Tests

## Database:
[![USDA Nutrition Database](sr28/docs/Nutrish%20SR28.jpg "USDA Nutrition Database")](https://www.ars.usda.gov/northeast-area/beltsville-md-bhnrc/beltsville-human-nutrition-research-center/methods-and-application-of-food-composition-laboratory/mafcl-site-pages/sr17-sr28/)
