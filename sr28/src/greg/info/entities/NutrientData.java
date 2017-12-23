package greg.info.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "NUT_DAT")
public class NutrientData implements Serializable {
    private String NDB_No;
    private String Nutr_No;
    private Double Nutr_Val;
    private Double Num_Data_Pts;
    private Double Std_Error;
    private SourceCode sourceCode;  // Src_Cd
    private String Deriv_Cd;
    private String Ref_NDB_No;
    private String Add_Nutr_Mark;
    private Integer Num_Studies;
    private Double Min;
    private Double Max;
    private Integer DF;
    private Double Low_EB;
    private Double Up_EB;
    private String Stat_cmt;
    private String AddMod_Date;
    private String CC;

    @Id
    @Column(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
    public String getNDB_No() {
        return NDB_No;
    }

    public void setNDB_No(String NDB_No) {
        this.NDB_No = NDB_No;
    }

    @Id
    @Column(name = "Nutr_No", columnDefinition = "character(3)", nullable = false)
    public String getNutr_No() {
        return Nutr_No;
    }

    public void setNutr_No(String nutr_No) {
        Nutr_No = nutr_No;
    }

    @Column(name = "Nutr_Val", columnDefinition = "float", nullable = false)
    public Double getNutr_Val() {
        return Nutr_Val;
    }

    public void setNutr_Val(Double nutr_Val) {
        Nutr_Val = nutr_Val;
    }

    @Column(name = "Num_Data_Pts", columnDefinition = "integer", nullable = false)
    public Double getNum_Data_Pts() {
        return Num_Data_Pts;
    }

    public void setNum_Data_Pts(Double num_Data_Pts) {
        Num_Data_Pts = num_Data_Pts;
    }

    @Column(name = "Std_Error", columnDefinition = "float")
    public Double getStd_Error() {
        return Std_Error;
    }

    public void setStd_Error(Double std_Error) {
        Std_Error = std_Error;
    }

    @ManyToOne
    @JoinColumn(name = "Src_Cd", columnDefinition = "character(2)", nullable = false)
    public SourceCode getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(SourceCode sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Column(name = "Deriv_Cd", columnDefinition = "character(4)")
    public String getDeriv_Cd() {
        return Deriv_Cd;
    }

    public void setDeriv_Cd(String deriv_Cd) {
        Deriv_Cd = deriv_Cd;
    }

    @Column(name = "Ref_NDB_No", columnDefinition = "character(5)")
    public String getRef_NDB_No() {
        return Ref_NDB_No;
    }

    public void setRef_NDB_No(String ref_NDB_No) {
        Ref_NDB_No = ref_NDB_No;
    }

    @Column(name = "Add_Nutr_Mark", columnDefinition = "character(1)")
    public String getAdd_Nutr_Mark() {
        return Add_Nutr_Mark;
    }

    public void setAdd_Nutr_Mark(String add_Nutr_Mark) {
        Add_Nutr_Mark = add_Nutr_Mark;
    }

    @Column(name = "Num_Studies", columnDefinition = "integer")
    public Integer getNum_Studies() {
        return Num_Studies;
    }

    public void setNum_Studies(Integer num_Studies) {
        Num_Studies = num_Studies;
    }

    @Column(name = "Min", columnDefinition = "float")
    public Double getMin() {
        return Min;
    }

    public void setMin(Double min) {
        Min = min;
    }

    @Column(name = "Max", columnDefinition = "float")
    public Double getMax() {
        return Max;
    }

    public void setMax(Double max) {
        Max = max;
    }

    @Column(name = "DF", columnDefinition = "integer")
    public Integer getDF() {
        return DF;
    }

    public void setDF(Integer DF) {
        this.DF = DF;
    }


    @Column(name = "Low_EB", columnDefinition = "float")
    public Double getLow_EB() {
        return Low_EB;
    }

    public void setLow_EB(Double low_EB) {
        Low_EB = low_EB;
    }

    @Column(name = "Up_EB", columnDefinition = "float")
    public Double getUp_EB() {
        return Up_EB;
    }

    public void setUp_EB(Double up_EB) {
        Up_EB = up_EB;
    }

    @Column(name = "Stat_cmt", columnDefinition = "character(10)")
    public String getStat_cmt() {
        return Stat_cmt;
    }

    public void setStat_cmt(String stat_cmt) {
        Stat_cmt = stat_cmt;
    }

    @Column(name = "AddMod_Date", columnDefinition = "character(10)")
    public String getAddMod_Date() {
        return AddMod_Date;
    }

    public void setAddMod_Date(String addMod_Date) {
        AddMod_Date = addMod_Date;
    }

    @Column(name = "CC", columnDefinition = "character(1)")
    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NutrientData that = (NutrientData) o;

        if (NDB_No != null ? !NDB_No.equals(that.NDB_No) : that.NDB_No != null) return false;
        if (Nutr_No != null ? !Nutr_No.equals(that.Nutr_No) : that.Nutr_No != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (NDB_No != null ? NDB_No.hashCode() : 0);
        result = 31 * result + (Nutr_No != null ? Nutr_No.hashCode() : 0);
        return result;
    }
}
