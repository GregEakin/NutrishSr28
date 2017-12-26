-- This file is a support file to the LanguaL Factor file and contains the descriptions for
-- only those factors used in coding the selected food items codes in this release of SR.
CREATE TABLE LANGDESC
(
  FACTOR_CODE CHAR(5) PRIMARY KEY NOT NULL,
  DESCRIPTION VARCHAR(140)        NOT NULL
  --  Links to the LanguaL Factor file by the Factor_Code field
)
