-- This file (Table 14) is used to link the Nutrient Data file with the Sources of Data table.
-- It is needed to resolve the many-to-many relationship between the two tables.
CREATE TABLE DATSRCLN
(
  NDB_NO     CHAR(5) NOT NULL,
  NUTR_NO    CHAR(3) NOT NULL,
  DATASRC_ID CHAR(6) NOT NULL,
  CONSTRAINT SYS_PK_19055 PRIMARY KEY (NDB_NO, NUTR_NO, DATASRC_ID),
  CONSTRAINT FKOG89TM59JJNW5EXEOE4R7L9F9 FOREIGN KEY (NUTR_NO) REFERENCES NUT_DATA (NDB_NO),
  CONSTRAINT FKIT9VVUN660K9LAGDN2327J5JS FOREIGN KEY (DATASRC_ID) REFERENCES DATA_SRC (DATASRC_ID)
  --  Links to the Nutrient Data file by NDB No. and Nutr_No
  --  Links to the Nutrient Definition file by Nutr_No
  --  Links to the Sources of Data file by DataSrc_ID
);

CREATE INDEX SYS_IDX_FKOG89TM59JJNW5EXEOE4R7L9F9_19182
  ON DATSRCLN (NDB_NO, NUTR_NO)
