-- This file contains long and short descriptions and food group designators for all food items,
-- along with common names, manufacturer name, scientific name, percentage and description of refuse,
-- and factors used for calculating protein and kilocalories, if applicable. Items used in the FNDDS
-- are also identified by value of “Y” in the Survey field.

CREATE TABLE FOOD_DES
(
  NDB_NO      CHAR(5) PRIMARY KEY NOT NULL,
  FDGRP_CD    CHAR(4)             NOT NULL,
  LONG_DESC   VARCHAR(200)        NOT NULL,
  SHRT_DESC   VARCHAR(60)         NOT NULL,
  COMNAME     VARCHAR(100),
  MANUFACNAME VARCHAR(65),
  SURVEY      CHAR(1),
  REF_DESC    VARCHAR(135),
  REFUSE      TINYINT,
  SCINAME     VARCHAR(65),
  N_FACTOR    DOUBLE,
  PRO_FACTOR  DOUBLE,
  FAT_FACTOR  DOUBLE,
  CHO_FACTOR  DOUBLE,

  CONSTRAINT FKJNE55NY77H9EAUJLLUF03JHR3 FOREIGN KEY (FDGRP_CD) REFERENCES FD_GROUP (FDGRP_CD)
  --  Links to the Food Group Description file by the FdGrp_Cd field
  --  Links to the Nutrient Data file by the NDB_No field
  --  Links to the Weight file by the NDB_No field
  --  Links to the Footnote file by the NDB_No field
  --  Links to the LanguaL Factor file by the NDB_No field
)
