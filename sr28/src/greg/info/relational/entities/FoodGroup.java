package greg.info.relational.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "FD_GROUP")
public class FoodGroup {
    private String FdGrp_Cd;
    private String FdGrp_Desc;
    private Set<FoodDescription> foodDescriptionSet;

    //  Links to the Food Description file by FdGrp_Cd

    @Id
    @Column(name = "FdGrp_Cd", columnDefinition = "character(4)", nullable = false)
    public String getFdGrp_Cd() {
        return FdGrp_Cd;
    }

    public void setFdGrp_Cd(String fdGrp_Cd) {
        this.FdGrp_Cd = fdGrp_Cd;
    }

    @Column(name = "FdGrp_Desc", columnDefinition = "varchar(60)", nullable = false)
    public String getFdGrp_Desc() {
        return FdGrp_Desc;
    }

    public void setFdGrp_Desc(String fdGrp_Desc) {
        FdGrp_Desc = fdGrp_Desc;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "foodGroup")
    public Set<FoodDescription> getFoodDescriptionSet() {
        return foodDescriptionSet;
    }

    public void setFoodDescriptionSet(Set<FoodDescription> foodDescriptionSet) {
        this.foodDescriptionSet = foodDescriptionSet;
    }
}
