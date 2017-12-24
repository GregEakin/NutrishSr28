package greg.info.entities;

import javax.persistence.*;
import java.io.Serializable;

/*
    Weight File  (file name = WEIGHT). This file (Table 12) contains the weight in grams of a number of common measures for each food item.
 */

@Entity
@Table(name = "WEIGHT")
public class Weight implements Serializable {

    //  Links to Food Description file by NDB_No
    //  Links to Nutrient Data file by NDB_No
    // NDB_No A 5* N 5-digit Nutrient Databank number that uniquely identifies a food item.
    @Id
    @ManyToOne
    @JoinColumn(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
    private FoodDescription foodDescription;

    // Seq A 2* N Sequence number.
    @Id
    @Column(name = "Seq", columnDefinition = "character(2)", nullable = false)
    private String Seq;

    // Amount N 5.3 N Unit modifier (for example, 1 in “1 cup”).
    @Column(name = "Amount", columnDefinition = "float", nullable = false)
    private Double Amount;

    // Msre_Desc A 84 N Description (for example, cup, diced, and 1-inch pieces).
    @Column(name = "Msre_Desc", columnDefinition = "varchar(84)", nullable = false)
    private String Msre_Desc;

    // Gm_Wgt N 7.1 N Gram weight.
    @Column(name = "Gm_Wgt", columnDefinition = "float", nullable = false)
    private Double Gm_Wgt;

    // Num_Data_Pts N 3 Y Number of data points.
    @Column(name = "Num_Data_Pts", columnDefinition = "integer")
    private Integer Num_Data_Pts;

    // Std_Dev N 7.3 Y Standard deviation.
    @Column(name = "Std_Dev", columnDefinition = "float")
    private Double Std_Dev;

//    @ManyToOne
//    @JoinColumn(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
//    private NutrientData nutrientData;

    public FoodDescription getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(FoodDescription foodDescription) {
        this.foodDescription = foodDescription;
    }

    public String getSeq() {
        return Seq;
    }

    public void setSeq(String seq) {
        Seq = seq;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public String getMsre_Desc() {
        return Msre_Desc;
    }

    public void setMsre_Desc(String msre_Desc) {
        Msre_Desc = msre_Desc;
    }

    public Double getGm_Wgt() {
        return Gm_Wgt;
    }

    public void setGm_Wgt(Double gm_Wgt) {
        Gm_Wgt = gm_Wgt;
    }

    public Integer getNum_Data_Pts() {
        return Num_Data_Pts;
    }

    public void setNum_Data_Pts(Integer num_Data_Pts) {
        Num_Data_Pts = num_Data_Pts;
    }

    public Double getStd_Dev() {
        return Std_Dev;
    }

    public void setStd_Dev(Double std_Dev) {
        Std_Dev = std_Dev;
    }

//    public NutrientData getNutrientData() {
//        return nutrientData;
//    }
//
//    public void setNutrientData(NutrientData nutrientData) {
//        this.nutrientData = nutrientData;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weight that = (Weight) o;

        if (foodDescription != null ? !foodDescription.equals(that.foodDescription) : that.foodDescription != null)
            return false;
        if (Seq != null ? !Seq.equals(that.Seq) : that.Seq != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (foodDescription != null ? foodDescription.hashCode() : 0);
        result = 31 * result + (Seq != null ? Seq.hashCode() : 0);
        return result;
    }
}
