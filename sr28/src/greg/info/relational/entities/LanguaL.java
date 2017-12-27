package greg.info.relational.entities;

import javax.persistence.*;
import java.io.Serializable;

// language of food
@Entity
@Table(name = "LANGUAL")
public class LanguaL implements Serializable {
    private String NDB_No;
    private String Factor_Code;
    private FoodDescription foodDescription;
    private LanguaLDescription languaLDescription;
    // private Set<FoodDescription> foodDescriptionSet = new HashSet<>(0);

    //  Links to the Food Description file by the NDB_No field
    //  Links to LanguaL Factors Description file by the Factor_Code field

    @Id
    @Column(name = "NDB_No", columnDefinition = "character(5)", nullable = false, insertable = false, updatable = false)
    public String getNDB_No() {
        return NDB_No;
    }

    public void setNDB_No(String nDB_No) {
        this.NDB_No = nDB_No;
    }

    @Id
    @Column(name = "Factor_Code", columnDefinition = "character(5)", nullable = false, insertable = false, updatable = false)
    public String getFactor_Code() {
        return Factor_Code;
    }

    public void setFactor_Code(String factor_Code) {
        Factor_Code = factor_Code;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NDB_No")
    public FoodDescription getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(FoodDescription foodDescription) {
        this.foodDescription = foodDescription;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Factor_Code")
    public LanguaLDescription getLanguaLDescription() {
        return languaLDescription;
    }

    public void setLanguaLDescription(LanguaLDescription languaLDescription) {
        this.languaLDescription = languaLDescription;
    }

//    @Column(name = "Description", columnDefinition = "varchar(140)", nullable = false)
//    public String getDescription() {
//        return Description;
//    }
//
//    public void setDescription(String description) {
//        Description = description;
//    }

//    @ManyToMany
//    @JoinTable(name = "LANGUAL", joinColumns = {@JoinColumn(name = "Factor_Code")}, inverseJoinColumns = {@JoinColumn(name = "NDB_No")})
//    public Set<FoodDescription> getFoodDescriptionSet() {
//        return foodDescriptionSet;
//    }
//
//    public void setFoodDescriptionSet(Set<FoodDescription> foodDescriptions) {
//        this.foodDescriptionSet = foodDescriptions;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguaL that = (LanguaL) o;

        if (NDB_No != null ? !NDB_No.equals(that.NDB_No) : that.NDB_No != null)
            return false;
        if (Factor_Code != null ? !Factor_Code.equals(that.Factor_Code) : that.Factor_Code != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (NDB_No != null ? NDB_No.hashCode() : 0);
        result = 31 * result + (Factor_Code != null ? Factor_Code.hashCode() : 0);
        return result;
    }
}
