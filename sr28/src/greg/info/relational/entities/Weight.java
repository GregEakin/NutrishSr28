package greg.info.relational.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*
    Weight File  (file name = WEIGHT). This file (Table 12) contains the weight in grams of a number of common measures for each food item.
 */

@Entity
@Table(name = "WEIGHT")
public class Weight implements Serializable {

    private String NDB_No;
    // private FoodDescription foodDescription;
    private String Seq;
    private Double Amount;
    private String Msre_Desc;
    private Double Gm_Wgt;
    private Integer Num_Data_Pts;
    private Double Std_Dev;
    // private Set<NutrientData> nutrientData;

    //  Links to Food Description file by NDB_No
    //  Links to Nutrient Data file by NDB_No

    // NDB_No A 5* N 5-digit Nutrient Databank number that uniquely identifies a food item.
    @Id
    @Column(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
    public String getNDB_No() {
        return NDB_No;
    }

    public void setNDB_No(String nDB_No) {
        this.NDB_No = nDB_No;
    }

//    @Id
//    @ManyToOne
//    @JoinColumn(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
//    public FoodDescription getFoodDescription() {
//        return foodDescription;
//    }
//
//    public void setFoodDescription(FoodDescription foodDescription) {
//        this.foodDescription = foodDescription;
//    }

    // Seq A 2* N Sequence number.
    @Id
    @Column(name = "Seq", columnDefinition = "character(2)", nullable = false)
    public String getSeq() {
        return Seq;
    }

    public void setSeq(String seq) {
        Seq = seq;
    }

    // Amount N 5.3 N Unit modifier (for example, 1 in “1 cup”).
    @Column(name = "Amount", columnDefinition = "float", nullable = false)
    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    // Msre_Desc A 84 N Description (for example, cup, diced, and 1-inch pieces).
    @Column(name = "Msre_Desc", columnDefinition = "varchar(84)", nullable = false)
    public String getMsre_Desc() {
        return Msre_Desc;
    }

    public void setMsre_Desc(String msre_Desc) {
        Msre_Desc = msre_Desc;
    }

    // Gm_Wgt N 7.1 N Gram weight.
    @Column(name = "Gm_Wgt", columnDefinition = "float", nullable = false)
    public Double getGm_Wgt() {
        return Gm_Wgt;
    }

    public void setGm_Wgt(Double gm_Wgt) {
        Gm_Wgt = gm_Wgt;
    }

    // Num_Data_Pts N 3 Y Number of data points.
    @Column(name = "Num_Data_Pts", columnDefinition = "integer")
    public Integer getNum_Data_Pts() {
        return Num_Data_Pts;
    }

    public void setNum_Data_Pts(Integer num_Data_Pts) {
        Num_Data_Pts = num_Data_Pts;
    }

    // Std_Dev N 7.3 Y Standard deviation.
    @Column(name = "Std_Dev", columnDefinition = "float")
    public Double getStd_Dev() {
        return Std_Dev;
    }

    public void setStd_Dev(Double std_Dev) {
        Std_Dev = std_Dev;
    }

//    @ManyToMany
//    @JoinColumn(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
//    public Set<NutrientData> getNutrientData() {
//        return nutrientData;
//    }
//
//    public void setNutrientData(Set<NutrientData> nutrientData) {
//        this.nutrientData = nutrientData;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weight that = (Weight) o;

        if (NDB_No != null ? !NDB_No.equals(that.NDB_No) : that.NDB_No != null)
            return false;
        if (Seq != null ? !Seq.equals(that.Seq) : that.Seq != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (NDB_No != null ? NDB_No.hashCode() : 0);
        result = 31 * result + (Seq != null ? Seq.hashCode() : 0);
        return result;
    }
}
