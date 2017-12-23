package greg.info.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DERIV_CD")
public class DataDerivationCode {
    private String Deriv_Cd;
    private String Deriv_Desc;

    @Id
    public String getDeriv_Cd() {
        return Deriv_Cd;
    }

    public void setDeriv_Cd(String deriv_Cd) {
        Deriv_Cd = deriv_Cd;
    }

    public String getDeriv_Desc() {
        return Deriv_Desc;
    }

    public void setDeriv_Desc(String deriv_Desc) {
        Deriv_Desc = deriv_Desc;
    }
}
