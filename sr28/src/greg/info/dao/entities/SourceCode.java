package greg.info.dao.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SRC_CD")
public class SourceCode {
    private String Src_Cd;
    private String SrcCd_Desc;
    private Set<NutrientData> nutrientDataSet;

    //  Links to the Nutrient Data file by Src_Cd

    @Id
    @Column(name = "Src_Cd", columnDefinition = "character(2)", nullable = false)
    public String getSrc_Cd() {
        return Src_Cd;
    }

    public void setSrc_Cd(String src_Cd) {
        Src_Cd = src_Cd;
    }

    @Column(name = "SrcCd_Desc", columnDefinition = "varchar(60)", nullable = false)
    public String getSrcCd_Desc() {
        return SrcCd_Desc;
    }

    public void setSrcCd_Desc(String srcCd_Desc) {
        SrcCd_Desc = srcCd_Desc;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sourceCode")
    public Set<NutrientData> getNutrientDataSet() {
        return nutrientDataSet;
    }

    public void setNutrientDataSet(Set<NutrientData> nutrientDataSet) {
        this.nutrientDataSet = nutrientDataSet;
    }
}
