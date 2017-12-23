package greg.info;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FOOD_DES")
public class FoodDescription {
    private String NDB_No;
    private String FdGrp_Cd;
    private String Long_Desc;
    private String Shrt_Desc;
    private String ComName;
    private String ManufacName;
    private String Survey;
    private String Ref_desc;
    private Byte Refuse;
    private String SciName;
    private Double N_Factor;
    private Double Pro_Factor;
    private Double Fat_Factor;
    private Double CHO_Factor;

    @Id
    @Column(name = "NDB_No", columnDefinition = "character(5)", nullable = false, unique = true)
    public String getNDB_No() {
        return NDB_No;
    }

    public void setNDB_No(String id) {
        this.NDB_No = id;
    }

    @Column(name = "FdGrp_Cd", columnDefinition = "character(4)", nullable = false)
    public String getFdGrp_Cd() {
        return FdGrp_Cd;
    }

    public void setFdGrp_Cd(String fdGrp_Cd) {
        FdGrp_Cd = fdGrp_Cd;
    }

    @Column(name = "Long_Desc", columnDefinition = "varchar(200)", nullable = false)
    public String getLong_Desc() {
        return Long_Desc;
    }

    public void setLong_Desc(String long_Desc) {
        Long_Desc = long_Desc;
    }

    @Column(name = "Shrt_Desc", columnDefinition = "varchar(60)", nullable = false)
    public String getShrt_Desc() {
        return Shrt_Desc;
    }

    public void setShrt_Desc(String shrt_Desc) {
        Shrt_Desc = shrt_Desc;
    }

    @Column(name = "ComName", columnDefinition = "varchar(100)")
    public String getComName() {
        return ComName;
    }

    public void setComName(String comName) {
        ComName = comName;
    }

    @Column(name = "ManufacName", columnDefinition = "varchar(65)")
    public String getManufacName() {
        return ManufacName;
    }

    public void setManufacName(String manufacName) {
        ManufacName = manufacName;
    }

    @Column(name = "Survey", columnDefinition = "character(1)")
    public String getSurvey() {
        return Survey;
    }

    public void setSurvey(String survey) {
        Survey = survey;
    }

    @Column(name = "Ref_desc", columnDefinition = "varchar(135)")
    public String getRef_desc() {
        return Ref_desc;
    }

    public void setRef_desc(String ref_desc) {
        Ref_desc = ref_desc;
    }

    @Column(name = "Refuse", columnDefinition = "tinyint")
    public Byte getRefuse() {
        return Refuse;
    }

    public void setRefuse(Byte refuse) {
        Refuse = refuse;
    }

    @Column(name = "SciName", columnDefinition = "varchar(65)")
    public String getSciName() {
        return SciName;
    }

    public void setSciName(String sciName) {
        SciName = sciName;
    }

    @Column(name = "N_Factor", columnDefinition = "float")
    public Double getN_Factor() {
        return N_Factor;
    }

    public void setN_Factor(Double n_Factor) {
        N_Factor = n_Factor;
    }

    @Column(name = "Pro_Factor", columnDefinition = "float")
    public Double getPro_Factor() {
        return Pro_Factor;
    }

    public void setPro_Factor(Double pro_Factor) {
        Pro_Factor = pro_Factor;
    }

    @Column(name = "Fat_Factor", columnDefinition = "float")
    public Double getFat_Factor() {
        return Fat_Factor;
    }

    public void setFat_Factor(Double fat_Factor) {
        Fat_Factor = fat_Factor;
    }

    @Column(name = "CHO_Factor", columnDefinition = "float")
    public Double getCHO_Factor() {
        return CHO_Factor;
    }

    public void setCHO_Factor(Double CHO_Factor) {
        this.CHO_Factor = CHO_Factor;
    }
}
