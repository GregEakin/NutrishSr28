package greg.info.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "FOOTNOTE")
public class Footnote implements Serializable {
    // private String NDB_No;
    private FoodDescription foodDescription;
    private String Footnt_No;
    private String Footnt_Typ;
    private String Nutr_No;
    private String Footnt_Txt;

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
    @Column(name = "Footnt_No", columnDefinition = "character(4)", nullable = false)
    public String getFootnt_No() {
        return Footnt_No;
    }

    public void setFootnt_No(String footnt_No) {
        Footnt_No = footnt_No;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Footnote that = (Footnote) o;

        if (foodDescription != null ? !foodDescription.equals(that.foodDescription) : that.foodDescription != null) return false;
        if (Footnt_No != null ? !Footnt_No.equals(that.Footnt_No) : that.Footnt_No != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (foodDescription != null ? foodDescription.hashCode() : 0);
        result = 31 * result + (Footnt_No != null ? Footnt_No.hashCode() : 0);
        return result;
    }

    public String getFootnt_Typ() {
        return Footnt_Typ;
    }

    public void setFootnt_Typ(String footnt_Typ) {
        Footnt_Typ = footnt_Typ;
    }

    @Column(name = "Nutr_No", columnDefinition = "character(3)")
    public String getNutr_No() {
        return Nutr_No;
    }

    public void setNutr_No(String nutr_No) {
        Nutr_No = nutr_No;
    }

    public String getFootnt_Txt() {
        return Footnt_Txt;
    }

    public void setFootnt_Txt(String footnt_Txt) {
        Footnt_Txt = footnt_Txt;
    }

//    private Set<NutrientDefinition> Nutrients;
//
//    @OneToMany(mappedBy = "Nutr_No")
//    public Set<NutrientDefinition> getNutrients() {
//        return Nutrients;
//    }
//
//    public void setNutrients(Set<NutrientDefinition> nutrients) {
//        Nutrients = nutrients;
//    }
}
