-- This file (Table 10) contains codes indicating the type of data (analytical, calculated,
-- assumed zero, and so on) in the Nutrient Data file. To improve the usability of the database
-- and to provide values for the FNDDS, NDL staff imputed nutrient values for a number of proximate
-- components, total dietary fiber, total sugar, and vitamin and mineral values.
CREATE TABLE SRC_CD
(
  SRC_CD     CHAR(2) PRIMARY KEY NOT NULL,
  SRCCD_DESC VARCHAR(60)         NOT NULL,
  CONSTRAINT FXP36DAS3234DDWE33XMDDE13CR FOREIGN KEY (SRC_CD) REFERENCES NUT_DATA (SRC_CD)
  --  Links to the Nutrient Data file by Src_Cd
)
