--  This file (Table 6) is a support file to the Food Description file and contains the factors
-- from the LanguaL Thesaurus used to code a particular food.
CREATE TABLE LANGUAL
(
  NDB_NO      CHAR(5) NOT NULL,
  FACTOR_CODE CHAR(5) NOT NULL,
  CONSTRAINT SYS_PK_19100 PRIMARY KEY (NDB_NO, FACTOR_CODE),
  CONSTRAINT FKA8NEID025OSQ8WS4GMQ0J605I FOREIGN KEY (NDB_NO) REFERENCES FOOD_DES (NDB_NO),
  CONSTRAINT FKMLG2NRE4IDCDDB8YPR3U4ITJQ FOREIGN KEY (FACTOR_CODE) REFERENCES LANGDESC (FACTOR_CODE)
  --  Links to the Food Description file by the NDB_No field
  --  Links to LanguaL Factors Description file by the Factor_Code field
)
