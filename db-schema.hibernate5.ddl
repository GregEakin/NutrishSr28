alter table DATSRCLN drop constraint FKit9vvun660k9lagdn2327j5js
alter table DATSRCLN drop constraint FKog89tm59jjnw5exeoe4r7l9f9
alter table FOOD_DES drop constraint FKjne55ny77h9eaujlluf03jhr3
alter table FOOTNOTE drop constraint FKksfxhfnrqb04p4ogwd1xko52p
alter table FOOTNOTE drop constraint FKq2lmdgtcc0jwghi7y36fv0j0x
alter table LANGUAL drop constraint FKmlg2nre4idcddb8ypr3u4itjq
alter table LANGUAL drop constraint FKa8neid025osq8ws4gmq0j605i
alter table NUT_DATA drop constraint FKc06gx6mc1402y442wpk7gma3d
alter table NUT_DATA drop constraint FK2m0ffylc2w46a10cn5c1iufut
alter table NUT_DATA drop constraint FK611i1pxqhfysdyrh0u5aervi1
alter table NUT_DATA drop constraint FKmxhigxlkwr25ya9hpn64d6e3w
alter table NUT_DATA drop constraint FKs029m1rl5g5tvbi6u7u8hm139
alter table WEIGHT drop constraint FKp5sfyb791m2gf1jxjpsrgi6jr
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
create table ABBREV (NDB_No varchar(5) not null, FA_Mono double, FA_Poly double, FA_Sat double, Alpha_Carot integer, Ash double, Beta_Carot integer, Beta_Crypt integer, Calcium integer, Carbohydrt double not null, Cholestrl double, Choline_Tot double, Copper double, Energ_Kcal integer, Fiber_TD double, Folate_DFE integer, Folate_Tot integer, Folic_acid integer, Food_Folate integer, GmWt_1 double, GmWt_2 double, GmWt_Desc1 varchar(120), GWt_Desc2 varchar(120), Iron double, Lipid_Tot double, Lut_Zea integer, Lycopene integer, Magnesium integer, Manganese double, Niacin double, Panto_acid double, Phosphorus integer, Potassium integer, Protein double, Refuse_Pct integer, Retinol integer, Riboflavin double, Selenium double, Shrt_Desc varchar(60) not null, Sodium integer, Sugar_Tot double, Thiamin double, Vit_A_IU integer, Vit_A_RAE integer, Vit_B12 double, Vit_B6 double, Vit_C double, Vit_D_IU integer, Vit_D_mcg double, Vit_E double, Vit_K double, Water double, Zinc double, primary key (NDB_No))
create table DATA_SRC (DataSrc_ID varchar(6) not null, Authors varchar(255), End_Page varchar(5), Issue_State varchar(5), Journal varchar(135), Start_Page varchar(5), Title varchar(255) not null, Vol_City varchar(16), Year varchar(4), primary key (DataSrc_ID))
create table DATSRCLN (NDB_No varchar(5) not null, Nutr_No varchar(3) not null, DataSrc_ID varchar(6) not null, primary key (NDB_No, Nutr_No, DataSrc_ID))
create table DERIV_CD (Deriv_Cd varchar(4) not null, Deriv_Desc varchar(120) not null, primary key (Deriv_Cd))
create table FD_GROUP (FdGrp_Cd varchar(4) not null, FdGrp_Desc varchar(60) not null, primary key (FdGrp_Cd))
create table FOOD_DES (NDB_No varchar(5) not null, CHO_Factor double, ComName varchar(100), Fat_Factor double, Long_Desc varchar(200) not null, ManufacName varchar(65), N_Factor double, Pro_Factor double, Ref_desc varchar(135), Refuse integer, SciName varchar(65), Shrt_Desc varchar(60) not null, Survey varchar(1), FdGrp_Cd varchar(4) not null, primary key (NDB_No))
create table FOOTNOTE (id integer not null, Footnt_No varchar(4) not null, Footnt_Txt varchar(200) not null, Footnt_Typ varchar(1) not null, NDB_No varchar(5) not null, Nutr_No varchar(3), primary key (id))
create table LANGDESC (Factor_Code varchar(5) not null, Description varchar(140) not null, primary key (Factor_Code))
create table LANGUAL (NDB_No varchar(5) not null, Factor_Code varchar(5) not null, primary key (NDB_No, Factor_Code))
create table NUT_DATA (CC varchar(1), DF integer, AddMod_Date varchar(10), Add_Nutr_Mark varchar(1), Low_EB double, Max double, min double, Num_Data_Pts integer not null, Num_Studies integer, Nutr_Val double not null, Stat_cmt varchar(10), Std_Error double, Up_EB double, Nutr_No varchar(3) not null, NDB_No varchar(5) not null, Deriv_Cd varchar(4), Ref_NDB_No varchar(5), Src_Cd varchar(2) not null, primary key (NDB_No, Nutr_No))
create table NUTR_DEF (Nutr_No varchar(3) not null, SR_Order integer not null, Num_Dec varchar(1) not null, NutrDesc varchar(60) not null, Tagname varchar(20), Units varchar(7) not null, primary key (Nutr_No))
create table SRC_CD (Src_Cd varchar(2) not null, SrcCd_Desc varchar(60) not null, primary key (Src_Cd))
create table WEIGHT (Seq varchar(2) not null, Amount double not null, Gm_Wgt double not null, Msre_Desc varchar(84) not null, Num_Data_Pts integer, Std_Dev double, NDB_No varchar(5) not null, primary key (NDB_No, Seq))
alter table DATSRCLN add constraint FKit9vvun660k9lagdn2327j5js foreign key (DataSrc_ID) references DATA_SRC
alter table DATSRCLN add constraint FKog89tm59jjnw5exeoe4r7l9f9 foreign key (NDB_No, Nutr_No) references NUT_DATA
alter table FOOD_DES add constraint FKjne55ny77h9eaujlluf03jhr3 foreign key (FdGrp_Cd) references FD_GROUP
alter table FOOTNOTE add constraint FKksfxhfnrqb04p4ogwd1xko52p foreign key (NDB_No) references FOOD_DES
alter table FOOTNOTE add constraint FKq2lmdgtcc0jwghi7y36fv0j0x foreign key (Nutr_No) references NUTR_DEF
alter table LANGUAL add constraint FKmlg2nre4idcddb8ypr3u4itjq foreign key (Factor_Code) references LANGDESC
alter table LANGUAL add constraint FKa8neid025osq8ws4gmq0j605i foreign key (NDB_No) references FOOD_DES
alter table NUT_DATA add constraint FKc06gx6mc1402y442wpk7gma3d foreign key (Nutr_No) references NUTR_DEF
alter table NUT_DATA add constraint FK2m0ffylc2w46a10cn5c1iufut foreign key (NDB_No) references FOOD_DES
alter table NUT_DATA add constraint FK611i1pxqhfysdyrh0u5aervi1 foreign key (Deriv_Cd) references DERIV_CD
alter table NUT_DATA add constraint FKmxhigxlkwr25ya9hpn64d6e3w foreign key (Ref_NDB_No) references FOOD_DES
alter table NUT_DATA add constraint FKs029m1rl5g5tvbi6u7u8hm139 foreign key (Src_Cd) references SRC_CD
alter table WEIGHT add constraint FKp5sfyb791m2gf1jxjpsrgi6jr foreign key (NDB_No) references FOOD_DES
