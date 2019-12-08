--  This file is a support file to the Nutrient Data file. It provides the 3-digit nutrient code,
-- unit of measure, INFOODS tagname, and description.
CREATE TABLE NUTR_DEF
(
  NUTR_NO  CHAR(3) PRIMARY KEY NOT NULL,
  UNITS    CHAR(7)             NOT NULL,
  TAGNAME  VARCHAR(20),
  NUTRDESC VARCHAR(60)         NOT NULL,
  NUM_DEC  CHAR(1)             NOT NULL,
  SR_ORDER INTEGER             NOT NULL,
  CONSTRAINT FKP61QNSLSW9F0F49FPNF35Q133 FOREIGN KEY (NUTR_NO) REFERENCES NUTR_DEF (NUTR_NO)
  --  Links to the Nutrient Data file by Nutr_No
)
