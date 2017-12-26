package greg.info.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SRC_CD")
public class SourceCode {
    private String Src_Cd;
    private String SrcCd_Desc;

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
}
