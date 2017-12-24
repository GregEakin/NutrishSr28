package greg.info.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DERIV_CD")
public class DataDerivation {
    private String Deriv_Cd;
    private String Deriv_Desc;

    @Id
    @Column(name = "Deriv_Cd", columnDefinition = "character(4)", nullable = false, unique = true)
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
}