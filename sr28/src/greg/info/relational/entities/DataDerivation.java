package greg.info.relational.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DERIV_CD")
public class DataDerivation {
    private String Deriv_Cd;
    private String Deriv_Desc;
    private Set<NutrientData> nutrientDataSet = new HashSet<>(0);

    //  Links to the Nutrient Data file by Deriv_Cd

    @Id
    @Column(name = "Deriv_Cd", columnDefinition = "character(4)", nullable = false)
    public String getDeriv_Cd() {
        return Deriv_Cd;
    }

    public void setDeriv_Cd(String deriv_Cd) {
        Deriv_Cd = deriv_Cd;
    }

    @Column(name = "Deriv_Desc", columnDefinition = "varchar(120)", nullable = false)
    public String getDeriv_Desc() {
        return Deriv_Desc;
    }

    public void setDeriv_Desc(String deriv_Desc) {
        Deriv_Desc = deriv_Desc;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dataDerivation")
    public Set<NutrientData> getNutrientDataSet() {
        return nutrientDataSet;
    }

    public void setNutrientDataSet(Set<NutrientData> nutrientDataSet) {
        this.nutrientDataSet = nutrientDataSet;
    }
}
