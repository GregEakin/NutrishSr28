-- This file (Table 11) provides information on how the nutrient values were determined. The file contains the derivation codes and their descriptions.
CREATE TABLE DERIV_CD
(
  DERIV_CD   CHAR(4) PRIMARY KEY NOT NULL,
  DERIV_DESC VARCHAR(120)        NOT NULL
  --  Links to the Nutrient Data file by Deriv_Cd
)
