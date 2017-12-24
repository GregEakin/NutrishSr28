package greg.info.entities;

import javax.persistence.*;
import java.util.Set;

// language of food
@Entity
@Table(name="LANGDESC")
public class LanguaL {
    private String Factor_Code;
    private String Description;
    private Set<FoodDescription> foodDescriptionSet;

    @Id
    @Column(name = "Factor_Code", columnDefinition = "character(5)", nullable = false, unique = true)
    public String getFactor_Code() {
        return Factor_Code;
    }

    public void setFactor_Code(String factor_Code) {
        Factor_Code = factor_Code;
    }

    @Column(name = "Description", columnDefinition = "varchar(140)", nullable = false)
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @ManyToMany
    @JoinTable(name = "LANGUAL", joinColumns = {@JoinColumn(name = "Factor_Code")}, inverseJoinColumns = {@JoinColumn(name = "NDB_No")})
    public Set<FoodDescription> getFoodDescriptionSet() {
        return foodDescriptionSet;
    }

    public void setFoodDescriptionSet(Set<FoodDescription> foodDescriptions) {
        this.foodDescriptionSet = foodDescriptions;
    }
}
