-- This file contains the nutrient values and information about the values,
-- including expanded statistical information.
CREATE TABLE NUT_DATA
(
  NDB_NO        CHAR(5) NOT NULL,
  NUTR_NO       CHAR(3) NOT NULL,
  NUTR_VAL      DOUBLE  NOT NULL,
  NUM_DATA_PTS  INTEGER NOT NULL,
  STD_ERROR     DOUBLE,
  SRC_CD        CHAR(2) NOT NULL,
  DERIV_CD      CHAR(4),
  REF_NDB_NO    CHAR(5),
  ADD_NUTR_MARK CHAR(1),
  NUM_STUDIES   INTEGER,
  "MIN"         DOUBLE,
  "MAX"         DOUBLE,
  DF            INTEGER,
  LOW_EB        DOUBLE,
  UP_EB         DOUBLE,
  STAT_CMT      CHAR(10),
  ADDMOD_DATE   CHAR(10),
  CC            CHAR(1),
  CONSTRAINT SYS_PK_19109 PRIMARY KEY (NUTR_NO, NDB_NO),
  CONSTRAINT FKC06GX6MC1402Y442WPK7GMA3D FOREIGN KEY (NUTR_NO) REFERENCES NUTR_DEF (NUTR_NO),
  CONSTRAINT FKMTDE8JSE4L3V2UL1GLRJ0RFKD FOREIGN KEY (NUTR_NO) REFERENCES FOOTNOTE (NDB_NO),
  CONSTRAINT FK2M0FFYLC2W46A10CN5C1IUFUT FOREIGN KEY (NDB_NO) REFERENCES FOOD_DES (NDB_NO),
  CONSTRAINT FK611I1PXQHFYSDYRH0U5AERVI1 FOREIGN KEY (DERIV_CD) REFERENCES DERIV_CD (DERIV_CD),
  CONSTRAINT FKMXHIGXLKWR25YA9HPN64D6E3W FOREIGN KEY (REF_NDB_NO) REFERENCES FOOD_DES (NDB_NO),
  CONSTRAINT FKS029M1RL5G5TVBI6U7U8HM139 FOREIGN KEY (SRC_CD) REFERENCES SRC_CD (SRC_CD)
  --  Links to the Food Description file by NDB_No
  --  Links to the Food Description file by Ref_NDB_No
  --  Links to the Weight file by NDB_No
  --  Links to the Footnote file by NDB_No and when applicable, Nutr_No
  --  Links to the Sources of Data Link file by NDB_No and Nutr_No
  --  Links to the Nutrient Definition file by Nutr_No
  --  Links to the Source Code file by Src_Cd
  --  Links to the Data Derivation Code Description file by Deriv_Cd
);

CREATE INDEX SYS_IDX_FKMTDE8JSE4L3V2UL1GLRJ0RFKD_19248
  ON NUT_DATA (NDB_NO, NUTR_NO)
