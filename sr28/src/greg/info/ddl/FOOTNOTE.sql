-- This file contains additional information about the food item, household weight, and nutrient value.
CREATE TABLE FOOTNOTE
(
  NDB_NO     CHAR(5)      NOT NULL,
  FOOTNT_NO  CHAR(4)      NOT NULL,
  FOOTNT_TYP CHAR(1)      NOT NULL,
  NUTR_NO    CHAR(3),
  FOOTNT_TXT VARCHAR(200) NOT NULL,
  CONSTRAINT SYS_PK_19086 PRIMARY KEY (FOOTNT_NO, NDB_NO),
  CONSTRAINT FKKSFXHFNRQB04P4OGWD1XKO52P FOREIGN KEY (NDB_NO) REFERENCES FOOD_DES (NDB_NO),
  CONSTRAINT FKQ2LMDGTCC0JWGHI7Y36FV0J0X FOREIGN KEY (NUTR_NO) REFERENCES NUTR_DEF (NUTR_NO)
  --  Links to the Food Description file by NDB_No
  --  Links to the Nutrient Data file by NDB_No and when applicable, Nutr_No
  --  Links to the Nutrient Definition file by Nutr_No, when applicable
)
