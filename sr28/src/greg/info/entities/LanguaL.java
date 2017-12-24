package greg.info.entities;

import javax.persistence.*;
import java.util.Set;

// language of food
@Entity
@Table(name="LANGDESC")
public class LanguaL {
    @Id
    @Column(name = "Factor_Code", columnDefinition = "character(5)", nullable = false, unique = true)
    private String Factor_Code;

    @Column(name = "Description", columnDefinition = "varchar(140)", nullable = false)
    private String Description;

    @ManyToMany
    @JoinTable(name = "LANGUAL", joinColumns = {@JoinColumn(name = "Factor_Code")}, inverseJoinColumns = {@JoinColumn(name = "NDB_No")})
    private Set<FoodDescription> foodDescriptions;

    public String getFactor_Code() {
        return Factor_Code;
    }

    public void setFactor_Code(String factor_Code) {
        Factor_Code = factor_Code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Set<FoodDescription> getFoodDescriptions() {
        return foodDescriptions;
    }

    public void setFoodDescriptions(Set<FoodDescription> foodDescriptions) {
        this.foodDescriptions = foodDescriptions;
    }
}
