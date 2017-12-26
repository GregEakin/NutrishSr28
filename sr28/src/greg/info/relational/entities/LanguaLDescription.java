package greg.info.relational.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LANGDESC")
public class LanguaLDescription {
    //  Links to the LanguaL Factor file by the Factor_Code field

    private String Factor_Code;
    private String Description;

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
}
