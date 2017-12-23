package greg.info.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NUTR_DEF")
public class NutrientDefinition {
    private String Nutr_No;
    private String Units;
    private String Tagname;
    private String NutrDesc;
    private String Num_Dec;
    private String SR_Order;

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

    public String getTagname() {
        return Tagname;
    }

    public void setTagname(String tagname) {
        Tagname = tagname;
    }

    public String getNutrDesc() {
        return NutrDesc;
    }

    public void setNutrDesc(String nutrDesc) {
        NutrDesc = nutrDesc;
    }

    public String getNum_Dec() {
        return Num_Dec;
    }

    public void setNum_Dec(String num_Dec) {
        Num_Dec = num_Dec;
    }

    public String getSR_Order() {
        return SR_Order;
    }

    public void setSR_Order(String SR_Order) {
        this.SR_Order = SR_Order;
    }
}
