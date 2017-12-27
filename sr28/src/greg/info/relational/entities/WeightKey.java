package greg.info.relational.entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class WeightKey implements Serializable {

    private FoodDescription foodDescription;
    private String Seq;

    public WeightKey() {
    }

    public WeightKey(FoodDescription foodDescription, String Seq) {
        this.foodDescription = foodDescription;
        this.Seq = Seq;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
    public FoodDescription getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(FoodDescription foodDescription) {
        this.foodDescription = foodDescription;
    }

    @Column(name = "Seq", columnDefinition = "character(2)", nullable = false)
    public String getSeq() {
        return Seq;
    }

    public void setSeq(String seq) {
        Seq = seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeightKey that = (WeightKey) o;

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
