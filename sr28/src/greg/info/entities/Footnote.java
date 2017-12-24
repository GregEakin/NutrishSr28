package greg.info.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "FOOTNOTE")
public class Footnote implements Serializable {
    private FoodDescription foodDescription;    // 5-digit Nutrient Databank number that uniquely identifies a food item.
    private String Footnt_No;                   // Sequence number.
    private String Footnt_Typ;                  // Type of footnote:
    private NutrientDefinition nutrientDefinition; // The nutrient to which footnote applies.
    private String Footnt_Txt;                  // Footnote text.

    //  Links to the Food Description file by NDB_No
    //  Links to the Nutrient Data file by NDB_No and when applicable, Nutr_No
    //  Links to the Nutrient Definition file by Nutr_No, when applicable

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

    @Column(name = "Footnt_Typ", columnDefinition = "character(1)", nullable = false)
    public String getFootnt_Typ() {
        return Footnt_Typ;
    }

    public void setFootnt_Typ(String footnt_Typ) {
        Footnt_Typ = footnt_Typ;
    }

    // NutrientDefinition
    @OneToOne
    @JoinColumn(name = "Nutr_No", columnDefinition = "character(3)")
    public NutrientDefinition getNutrientDefinition() {
        return nutrientDefinition;
    }

    public void setNutrientDefinition(NutrientDefinition nutrientDefinition) {
        this.nutrientDefinition = nutrientDefinition;
    }

    @Column(name = "Footnt_Txt", columnDefinition = "varchar(200)", nullable = false)
    public String getFootnt_Txt() {
        return Footnt_Txt;
    }

    public void setFootnt_Txt(String footnt_Txt) {
        Footnt_Txt = footnt_Txt;
    }

    private Set<NutrientData> nutrientData;

//    @OneToMany
//    @JoinColumn(name = "NutrientData", columnDefinition = "character(5)", nullable = false)
//    public Set<NutrientData> getNutrientData() {
//        return nutrientData;
//    }
//
//    public void setNutrientData(Set<NutrientData> nutrients) {
//        this.nutrientData = nutrients;
//    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Footnote that = (Footnote) o;

        if (foodDescription != null ? !foodDescription.equals(that.foodDescription) : that.foodDescription != null)
            return false;
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
}
