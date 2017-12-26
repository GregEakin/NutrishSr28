package greg.info.relational.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "DATSRCLN")
public class DataSourceLink implements Serializable {
    private String NDB_No;
    private String Nutr_No;
    private String DataSrc_ID;

    //  Links to the Nutrient Data file by NDB No. and Nutr_No
    //  Links to the Nutrient Definition file by Nutr_No
    //  Links to the Sources of Data file by DataSrc_ID

    @Id
    @Column(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
    public String getNDB_No() {
        return NDB_No;
    }

    public void setNDB_No(String nDB_No) {
        this.NDB_No = nDB_No;
    }

    @Id
    @Column(name = "Nutr_No", columnDefinition = "character(3)")
    public String getNutr_No() {
        return Nutr_No;
    }

    public void setNutr_No(String nutr_No) {
        Nutr_No = nutr_No;
    }

    @Id
    @Column(name = "DataSrc_ID", columnDefinition = "character(6)", nullable = false)
    public String getDataSrc_ID() {
        return DataSrc_ID;
    }

    public void setDataSrc_ID(String dataSrc_ID) {
        DataSrc_ID = dataSrc_ID;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataSourceLink that = (DataSourceLink) o;

        if (NDB_No != null ? !NDB_No.equals(that.NDB_No) : that.NDB_No != null)
            return false;
        if (Nutr_No != null ? !Nutr_No.equals(that.Nutr_No) : that.Nutr_No != null)
            return false;
        if (DataSrc_ID != null ? !DataSrc_ID.equals(that.DataSrc_ID) : that.DataSrc_ID != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (NDB_No != null ? NDB_No.hashCode() : 0);
        result = 31 * result + (Nutr_No != null ? Nutr_No.hashCode() : 0);
        result = 13 * result + (DataSrc_ID != null ? DataSrc_ID.hashCode() : 0);
        return result;
    }
}
