package greg.info.relational.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DATSRCLN")
public class DataSourceLink implements Serializable {
    private String NDB_No;
    private String Nutr_No;
    private String DataSrc_ID;

    private FoodDescription foodDescription;
    private NutrientData nutrientData;
    private NutrientDefinition nutrientDefinition;
    private DataSource dataSource;
    //  Links to the Nutrient Data file by NDB No. and Nutr_No
    //  Links to the Nutrient Definition file by Nutr_No
    //  Links to the Sources of Data file by DataSrc_ID

    @Id
    @Column(name = "NDB_No", columnDefinition = "character(5)", nullable = false, insertable = false, updatable = false)
    public String getNDB_No() {
        return NDB_No;
    }

    public void setNDB_No(String nDB_No) {
        this.NDB_No = nDB_No;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NDB_No")
    public FoodDescription getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(FoodDescription foodDescription) {
        this.foodDescription = foodDescription;
    }

    @Id
    @Column(name = "Nutr_No", columnDefinition = "character(3)", insertable = false, updatable = false)
    public String getNutr_No() {
        return Nutr_No;
    }

    public void setNutr_No(String nutr_No) {
        Nutr_No = nutr_No;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Nutr_No")
    public NutrientDefinition getNutrientDefinition() {
        return nutrientDefinition;
    }

    public void setNutrientDefinition(NutrientDefinition nutrientDefinition) {
        this.nutrientDefinition = nutrientDefinition;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "NDB_No", insertable = false, updatable = false),
            @JoinColumn(name = "Nutr_No", insertable = false, updatable = false)})
    public NutrientData getNutrientData() {
        return nutrientData;
    }

    public void setNutrientData(NutrientData nutrientData) {
        this.nutrientData = nutrientData;
    }

    @Id
    @Column(name = "DataSrc_ID", columnDefinition = "character(6)", nullable = false, insertable = false, updatable = false)
    public String getDataSrc_ID() {
        return DataSrc_ID;
    }

    public void setDataSrc_ID(String dataSrc_ID) {
        DataSrc_ID = dataSrc_ID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DataSrc_ID")
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
