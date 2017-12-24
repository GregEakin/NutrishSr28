package greg.info.entities;

import javax.persistence.*;
import java.io.Serializable;

/*
    Weight File  (file name = WEIGHT). This file (Table 12) contains the weight in grams of a number of common measures for each food item.

     Links to Food Description file by NDB_No
     Links to Nutrient Data file by NDB_No
 */

@Entity
@Table(name = "WEIGHT")
public class Weight implements Serializable {
    private FoodDescription foodDescription;
    private String Seq;

    @Id
    @ManyToOne
    @JoinColumn(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
    public FoodDescription getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(FoodDescription foodDescription) {
        this.foodDescription = foodDescription;
    }

    @Id
    @Column(name = "Seq", columnDefinition = "character(2)", nullable = false)
    public String getSeq() {
        return Seq;
    }

    public void setSeq(String seq) {
        Seq = seq;
    }

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

    public int hashCode() {
        int result;
        result = (foodDescription != null ? foodDescription.hashCode() : 0);
        result = 31 * result + (Seq != null ? Seq.hashCode() : 0);
        return result;
    }
}
