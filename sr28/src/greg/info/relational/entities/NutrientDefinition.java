package greg.info.relational.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "NUTR_DEF")
public class NutrientDefinition {
    private String Nutr_No;
    private String Units;
    private String Tagname;
    private String NutrDesc;
    private String Num_Dec;
    private Integer SR_Order;
    private Set<NutrientData> nutrientDataSet = new HashSet<>(0);
    private Set<Footnote> footnoteSet = new HashSet<>(0);
//    private Set<FoodDescription> foodDescriptions = new HashSet<>(0);

    //  Links to the Nutrient Data file by Nutr_No

    @Id
    @Column(name = "Nutr_No", columnDefinition = "character(3)", nullable = false)
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
    public Integer getSR_Order() {
        return SR_Order;
    }

    public void setSR_Order(Integer SR_Order) {
        this.SR_Order = SR_Order;
    }

    //  Links to the Nutrient Data file by Nutr_No
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nutrientDataKey.nutrientDefinition")
    public Set<NutrientData> getNutrientDataSet() {
        return nutrientDataSet;
    }

    public void setNutrientDataSet(Set<NutrientData> nutrientDataSet) {
        this.nutrientDataSet = nutrientDataSet;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nutrientDefinition")
    public Set<Footnote> getFootnoteSet() {
        return footnoteSet;
    }

    public void setFootnoteSet(Set<Footnote> footnoteSet) {
        this.footnoteSet = footnoteSet;
    }

//    @ManyToMany
//    @JoinTable(name = "Nut_Data", joinColumns = {@JoinColumn(name = "NDB_No")}, inverseJoinColumns = {@JoinColumn(name = "Nutr_No")})
//    public Set<FoodDescription> getFoodDescriptions() {
//        return foodDescriptions;
//    }
//
//    public void setFoodDescriptions(Set<FoodDescription> nutrients) {
//        this.foodDescriptions = nutrients;
//    }
}
