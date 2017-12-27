package greg.info.relational.entities;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class NutrientDataKey implements Serializable {

    //    private String NDB_No;
//    private String Nutr_No;
    private FoodDescription foodDescription;        // The food item
    private NutrientDefinition nutrientDefinition;  // The nutrient to which footnote applies.

    public NutrientDataKey() {
    }

    public NutrientDataKey(FoodDescription foodDescription, NutrientDefinition nutrientDefinition) {
        this.foodDescription = foodDescription;
        this.nutrientDefinition = nutrientDefinition;
    }

//    @Column(name = "NDB_No", columnDefinition = "character(5)", nullable = false, insertable = false, updatable = false)
//    public String getNDB_No() {
//        return NDB_No;
//    }
//
//    public void setNDB_No(String nDB_No) {
//        this.NDB_No = nDB_No;
//    }
//
//    @Column(name = "Nutr_No", columnDefinition = "character(3)", nullable = false, insertable = false, updatable = false)
//    public String getNutr_No() {
//        return Nutr_No;
//    }
//
//    public void setNutr_No(String nutr_No) {
//        Nutr_No = nutr_No;
//    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
    //@JoinColumn(name = "NDB_No")
    public FoodDescription getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(FoodDescription foodDescription) {
        this.foodDescription = foodDescription;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Nutr_No", columnDefinition = "character(3)", nullable = false)
    //@JoinColumn(name = "Nutr_No")
    public NutrientDefinition getNutrientDefinition() {
        return nutrientDefinition;
    }

    public void setNutrientDefinition(NutrientDefinition nutrientDefinition) {
        this.nutrientDefinition = nutrientDefinition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NutrientDataKey that = (NutrientDataKey) o;

        if (foodDescription != null ? !foodDescription.equals(that.foodDescription) : that.foodDescription != null)
            return false;
        if (nutrientDefinition != null ? !nutrientDefinition.equals(that.nutrientDefinition) : that.nutrientDefinition != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (foodDescription != null ? foodDescription.hashCode() : 0);
        result = 31 * result + (nutrientDefinition != null ? nutrientDefinition.hashCode() : 0);
        return result;
    }
}
