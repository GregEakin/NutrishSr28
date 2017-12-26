drop table ABBREV if exists
drop table DATA_SRC if exists
drop table DATSRCLN if exists
drop table DERIV_CD if exists
drop table FD_GROUP if exists
drop table FOOD_DES if exists
drop table FOOTNOTE if exists
drop table LANGDESC if exists
drop table LANGUAL if exists
drop table NUT_DATA if exists
drop table NUTR_DEF if exists
drop table SRC_CD if exists
drop table WEIGHT if exists
drop sequence hibernate_sequence if exists
create sequence hibernate_sequence start with 1 increment by 1
create table ABBREV (NDB_No character(5) not null, FA_Mono float, FA_Poly float, FA_Sat float, Alpha_Carot integer, Ash float, Beta_Carot integer, Beta_Crypt integer, Calcium integer, Carbohydrt float not null, Cholestrl float, Choline_Tot float, Copper float, Energ_Kcal integer, Fiber_TD float, Folate_DFE integer, Folate_Tot integer, Folic_acid integer, Food_Folate integer, GmWt_1 float, GmWt_2 float, GmWt_Desc1 varchar(120), GWt_Desc2 varchar(120), Iron float, Lipid_Tot float, Lut_Zea integer, Lycopene integer, Magnesium integer, Manganese float, Niacin float, Panto_acid float, Phosphorus integer, Potassium integer, Protein float, Refuse_Pct integer, Retinol integer, Riboflavin float, Selenium float, Shrt_Desc varchar(60) not null, Sodium integer, Sugar_Tot float, Thiamin float, Vit_A_IU integer, Vit_A_RAE integer, Vit_B12 float, Vit_B6 float, Vit_C float, Vit_D_IU integer, Vit_D_mcg float, Vit_E float, Vit_K float, Water float, Zinc float, primary key (NDB_No))
create table DATA_SRC (DataSrc_ID character(6) not null, Authors varchar(255), End_Page character(5), Issue_State character(5), Journal varchar(135), Start_Page character(5), Title varchar(255) not null, Vol_City character(16), Year character(4), primary key (DataSrc_ID))
create table DATSRCLN (Nutr_No character(3) not null, DataSrc_ID character(6) not null, NDB_No character(5) not null, primary key (Nutr_No, DataSrc_ID, NDB_No))
create table DERIV_CD (Deriv_Cd character(4) not null, Deriv_Desc varchar(120) not null, primary key (Deriv_Cd))
create table FD_GROUP (FdGrp_Cd character(4) not null, FdGrp_Desc varchar(60) not null, primary key (FdGrp_Cd))
create table FOOD_DES (NDB_No character(5) not null, CHO_Factor float, ComName varchar(100), Fat_Factor float, FdGrp_Cd character(4) not null, Long_Desc varchar(200) not null, ManufacName varchar(65), N_Factor float, Pro_Factor float, Ref_desc varchar(135), Refuse tinyint, SciName varchar(65), Shrt_Desc varchar(60) not null, Survey character(1), primary key (NDB_No))
create table FOOTNOTE (id integer not null, NDB_No character(5) not null, Footnt_No character(4) not null, Footnt_Txt varchar(200) not null, Footnt_Typ character(1) not null, Nutr_No character(3), primary key (id))
create table LANGDESC (Factor_Code character(5) not null, Description varchar(140) not null, primary key (Factor_Code))
create table LANGUAL (Factor_Code character(5) not null, NDB_No character(5) not null, primary key (Factor_Code, NDB_No))
create table NUT_DATA (Nutr_No character(3) not null, NDB_No character(5) not null, CC character(1), DF integer, AddMod_Date character(10), Add_Nutr_Mark character(1), Deriv_Cd character(4), Low_EB float, Max float, min double, Num_Data_Pts integer not null, Num_Studies integer, Nutr_Val float not null, Ref_NDB_No character(5), Src_Cd character(2) not null, Stat_cmt character(10), Std_Error float, Up_EB float, primary key (Nutr_No, NDB_No))
create table NUTR_DEF (Nutr_No character(3) not null, SR_Order Integer not null, Num_Dec character(1) not null, NutrDesc varchar(60) not null, Tagname varchar(20), Units character(7) not null, primary key (Nutr_No))
create table SRC_CD (Src_Cd character(2) not null, SrcCd_Desc varchar(60) not null, primary key (Src_Cd))
create table WEIGHT (Seq character(2) not null, NDB_No character(5) not null, Amount float not null, Gm_Wgt float not null, Msre_Desc varchar(84) not null, Num_Data_Pts integer, Std_Dev float, primary key (Seq, NDB_No))
drop table ABBREV if exists
drop table DATA_SRC if exists
drop table DATSRCLN if exists
drop table DERIV_CD if exists
drop table FD_GROUP if exists
drop table FOOD_DES if exists
drop table FOOTNOTE if exists
drop table LANGDESC if exists
drop table LANGUAL if exists
drop table NUT_DATA if exists
drop table NUTR_DEF if exists
drop table SRC_CD if exists
drop table WEIGHT if exists
drop sequence hibernate_sequence if exists
create sequence hibernate_sequence start with 1 increment by 1
create table ABBREV (NDB_No character(5) not null, FA_Mono float, FA_Poly float, FA_Sat float, Alpha_Carot integer, Ash float, Beta_Carot integer, Beta_Crypt integer, Calcium integer, Carbohydrt float not null, Cholestrl float, Choline_Tot float, Copper float, Energ_Kcal integer, Fiber_TD float, Folate_DFE integer, Folate_Tot integer, Folic_acid integer, Food_Folate integer, GmWt_1 float, GmWt_2 float, GmWt_Desc1 varchar(120), GWt_Desc2 varchar(120), Iron float, Lipid_Tot float, Lut_Zea integer, Lycopene integer, Magnesium integer, Manganese float, Niacin float, Panto_acid float, Phosphorus integer, Potassium integer, Protein float, Refuse_Pct integer, Retinol integer, Riboflavin float, Selenium float, Shrt_Desc varchar(60) not null, Sodium integer, Sugar_Tot float, Thiamin float, Vit_A_IU integer, Vit_A_RAE integer, Vit_B12 float, Vit_B6 float, Vit_C float, Vit_D_IU integer, Vit_D_mcg float, Vit_E float, Vit_K float, Water float, Zinc float, primary key (NDB_No))
create table DATA_SRC (DataSrc_ID character(6) not null, Authors varchar(255), End_Page character(5), Issue_State character(5), Journal varchar(135), Start_Page character(5), Title varchar(255) not null, Vol_City character(16), Year character(4), primary key (DataSrc_ID))
create table DATSRCLN (Nutr_No character(3) not null, DataSrc_ID character(6) not null, NDB_No character(5) not null, primary key (Nutr_No, DataSrc_ID, NDB_No))
create table DERIV_CD (Deriv_Cd character(4) not null, Deriv_Desc varchar(120) not null, primary key (Deriv_Cd))
create table FD_GROUP (FdGrp_Cd character(4) not null, FdGrp_Desc varchar(60) not null, primary key (FdGrp_Cd))
create table FOOD_DES (NDB_No character(5) not null, CHO_Factor float, ComName varchar(100), Fat_Factor float, FdGrp_Cd character(4) not null, Long_Desc varchar(200) not null, ManufacName varchar(65), N_Factor float, Pro_Factor float, Ref_desc varchar(135), Refuse tinyint, SciName varchar(65), Shrt_Desc varchar(60) not null, Survey character(1), primary key (NDB_No))
create table FOOTNOTE (id integer not null, NDB_No character(5) not null, Footnt_No character(4) not null, Footnt_Txt varchar(200) not null, Footnt_Typ character(1) not null, Nutr_No character(3), primary key (id))
create table LANGDESC (Factor_Code character(5) not null, Description varchar(140) not null, primary key (Factor_Code))
create table LANGUAL (Factor_Code character(5) not null, NDB_No character(5) not null, primary key (Factor_Code, NDB_No))
create table NUT_DATA (Nutr_No character(3) not null, NDB_No character(5) not null, CC character(1), DF integer, AddMod_Date character(10), Add_Nutr_Mark character(1), Deriv_Cd character(4), Low_EB float, Max float, min double, Num_Data_Pts integer not null, Num_Studies integer, Nutr_Val float not null, Ref_NDB_No character(5), Src_Cd character(2) not null, Stat_cmt character(10), Std_Error float, Up_EB float, primary key (Nutr_No, NDB_No))
create table NUTR_DEF (Nutr_No character(3) not null, SR_Order Integer not null, Num_Dec character(1) not null, NutrDesc varchar(60) not null, Tagname varchar(20), Units character(7) not null, primary key (Nutr_No))
create table SRC_CD (Src_Cd character(2) not null, SrcCd_Desc varchar(60) not null, primary key (Src_Cd))
create table WEIGHT (Seq character(2) not null, NDB_No character(5) not null, Amount float not null, Gm_Wgt float not null, Msre_Desc varchar(84) not null, Num_Data_Pts integer, Std_Dev float, primary key (Seq, NDB_No))
