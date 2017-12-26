-- This file provides a citation to the DataSrc_ID in the Sources of Data Link file.
CREATE TABLE DATA_SRC
(
  DATASRC_ID  CHAR(6) PRIMARY KEY NOT NULL,
  AUTHORS     VARCHAR(255),
  TITLE       VARCHAR(255)        NOT NULL,
  YEAR        CHAR(4),
  JOURNAL     VARCHAR(135),
  VOL_CITY    CHAR(16),
  ISSUE_STATE CHAR(5),
  START_PAGE  CHAR(5),
  END_PAGE    CHAR(5)
  --  Links to Nutrient Data file by NDB No. through the Sources of Data Link file
)
