package info.gdbtech.dao.entities;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class NutrientDataKey implements Serializable {

    private FoodDescription foodDescription;        // The food item
    private NutrientDefinition nutrientDefinition;  // The nutrient to which footnote applies.

    public NutrientDataKey() {
    }

    public NutrientDataKey(FoodDescription foodDescription, NutrientDefinition nutrientDefinition) {
        this.foodDescription = foodDescription;
        this.nutrientDefinition = nutrientDefinition;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
    public FoodDescription getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(FoodDescription foodDescription) {
        this.foodDescription = foodDescription;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Nutr_No", columnDefinition = "character(3)", nullable = false)
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
