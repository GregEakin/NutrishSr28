-- This file is a support file to the Food Description file and contains a list of food groups
-- used in SR28 and their descriptions.
CREATE TABLE FD_GROUP
(
  FDGRP_CD   CHAR(4) PRIMARY KEY NOT NULL,
  FDGRP_DESC VARCHAR(60)         NOT NULL
  --  Links to the Food Description file by FdGrp_Cd
)
