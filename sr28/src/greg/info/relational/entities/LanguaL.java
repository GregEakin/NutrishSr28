package greg.info.relational.entities;

import javax.persistence.*;
import java.io.Serializable;

// language of food
@Entity
@Table(name = "LANGUAL")
public class LanguaL implements Serializable {
    private FoodDescription foodDescription;
    private LanguaLDescription languaLDescription;

    //  Links to the Food Description file by the NDB_No field
    //  Links to LanguaL Factors Description file by the Factor_Code field

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
    public FoodDescription getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(FoodDescription foodDescription) {
        this.foodDescription = foodDescription;
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Factor_Code", columnDefinition = "character(5)", nullable = false)
    public LanguaLDescription getLanguaLDescription() {
        return languaLDescription;
    }

    public void setLanguaLDescription(LanguaLDescription languaLDescription) {
        this.languaLDescription = languaLDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguaL that = (LanguaL) o;

        if (foodDescription != null ? !foodDescription.equals(that.foodDescription) : that.foodDescription != null)
            return false;
        if (languaLDescription != null ? !languaLDescription.equals(that.languaLDescription) : that.languaLDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (foodDescription != null ? foodDescription.hashCode() : 0);
        result = 31 * result + (languaLDescription != null ? languaLDescription.hashCode() : 0);
        return result;
    }
}
