package greg.info.relational.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DATSRCLN")
public class DataSourceLink implements Serializable {
    private NutrientDataKey nutrientDataKey;
    private DataSource dataSource;

    //  Links to the Nutrient Data file by NDB No. and Nutr_No
    //  Links to the Nutrient Definition file by Nutr_No
    //  Links to the Sources of Data file by DataSrc_ID

    @EmbeddedId
    public NutrientDataKey getNutrientDataKey() {
        return nutrientDataKey;
    }

    public void setNutrientDataKey(NutrientDataKey nutrientDataKey) {
        this.nutrientDataKey = nutrientDataKey;
    }

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DataSrc_ID", columnDefinition = "character(6)", nullable = false)
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataSourceLink that = (DataSourceLink) o;

        if (nutrientDataKey != null ? !nutrientDataKey.equals(that.nutrientDataKey) : that.nutrientDataKey != null)
            return false;
        if (dataSource != null ? !dataSource.equals(that.dataSource) : that.dataSource != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (nutrientDataKey != null ? nutrientDataKey.hashCode() : 0);
        result = 31 * result + (dataSource != null ? dataSource.hashCode() : 0);
        return result;
    }
}
