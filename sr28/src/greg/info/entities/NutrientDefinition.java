package greg.info.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "NUTR_DEF")
public class NutrientDefinition {
    private String Nutr_No;
    private String Units;
    private String Tagname;
    private String NutrDesc;
    private String Num_Dec;
    private String SR_Order;
    private Set<NutrientDefinition> nutrientDefinitionSet;
    private Set<FoodDescription> foodDescriptions;

    @Id
    @Column(name = "Nutr_No", columnDefinition = "character(3)", nullable = false, unique = true)
    public String getNutr_No() {
        return Nutr_No;
    }

    public void setNutr_No(String nutr_No) {
        Nutr_No = nutr_No;
    }

    @Column(name = "Units", columnDefinition = "character(7)", nullable = false)
    public String getUnits() {
        return Units;
    }

    public void setUnits(String units) {
        Units = units;
    }

    @Column(name = "Tagname", columnDefinition = "varchar(20)")
    public String getTagname() {
        return Tagname;
    }

    public void setTagname(String tagname) {
        Tagname = tagname;
    }

    @Column(name = "NutrDesc", columnDefinition = "varchar(60)", nullable = false)
    public String getNutrDesc() {
        return NutrDesc;
    }

    public void setNutrDesc(String nutrDesc) {
        NutrDesc = nutrDesc;
    }

    @Column(name = "Num_Dec", columnDefinition = "character(1)", nullable = false)
    public String getNum_Dec() {
        return Num_Dec;
    }

    public void setNum_Dec(String num_Dec) {
        Num_Dec = num_Dec;
    }

    @Column(name = "SR_Order", columnDefinition = "Integer", nullable = false)
    public String getSR_Order() {
        return SR_Order;
    }

    public void setSR_Order(String SR_Order) {
        this.SR_Order = SR_Order;
    }

    //  Links to the Nutrient Data file by Nutr_No
    @OneToMany
    @JoinColumn(name = "Nutr_No", columnDefinition = "character(3)")
    public Set<NutrientDefinition> getNutrientDefinitionSet() {
        return nutrientDefinitionSet;
    }

    public void setNutrientDefinitionSet(Set<NutrientDefinition> nutrientDefinitionSet) {
        this.nutrientDefinitionSet = nutrientDefinitionSet;
    }

    @ManyToMany
    @JoinTable(name = "Nut_Data", joinColumns = {@JoinColumn(name = "NDB_No")}, inverseJoinColumns = {@JoinColumn(name = "Nutr_No")})
    public Set<FoodDescription> getFoodDescriptions() {
        return foodDescriptions;
    }

    public void setFoodDescriptions(Set<FoodDescription> nutrients) {
        this.foodDescriptions = nutrients;
    }
}
