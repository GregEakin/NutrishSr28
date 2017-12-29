package info.gdbtech.dao.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LANGDESC")
public class Language {

    private String Factor_Code;
    private String Description;
    private Set<FoodDescription> foodDescriptionSet = new HashSet<>(0);

    //  Links to the LanguaL Factor file by the Factor_Code field

    @Id
    @Column(name = "Factor_Code", columnDefinition = "character(5)", nullable = false)
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

    @ManyToMany(mappedBy = "languageSet")
    public Set<FoodDescription> getFoodDescriptionSet() {
        return foodDescriptionSet;
    }

    public void setFoodDescriptionSet(Set<FoodDescription> foodDescriptionSet) {
        this.foodDescriptionSet = foodDescriptionSet;
    }
}
