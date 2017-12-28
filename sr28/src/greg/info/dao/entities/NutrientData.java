package greg.info.dao.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "NUT_DATA")
public class NutrientData {

    private NutrientDataKey nutrientDataKey;
    private Double Nutr_Val;                // Amount in 100 grams, edible portion †.
    private Integer Num_Data_Pts;            // Number of data points is the number of analyses used to calculate the nutrient value. If the number of data points is 0, the value was calculated or imputed.
    private Double Std_Error;               // Standard error of the mean. Null if cannot be calculated. The standard error is also not given if the number of data points is less than three.
    private SourceCode sourceCode;          // Src_Cd - Code indicating type of data.
    private DataDerivation dataDerivation;  // Deriv_Cd - Data Derivation Code giving specific information on how the value is determined.  This field is populated only for items added or updated starting with SR14.  This field may not be populated if older records were used in the calculation of the mean value.
    private FoodDescription foodDescription;        // The item used to calculate a missing value. Populated only for items added or updated starting with SR14.
    private String Add_Nutr_Mark;           // Indicates a vitamin or mineral added for fortification or enrichment. This field is populated for ready-toeat breakfast cereals and many brand-name hot cereals in food group 08.
    private Integer Num_Studies;            // Number of studies.
    private Double Min;                     // Min.
    private Double Max;                     // Max.
    private Integer DF;                     // Degrees of freedom.
    private Double Low_EB;                  // Lower 95% error bound.
    private Double Up_EB;                   // Upper 95% error bound.
    private String Stat_cmt;                // Statistical comments.
    private String AddMod_Date;             // Indicates when a value was either added to the database or last modified.
    private String CC;                      // Confidence Code indicating data quality, based on evaluation of sample plan, sample handling, analytical method, analytical quality control, and number of samples analyzed.
    private Set<DataSource> dataSourceSet = new HashSet<>(0);
    // private Set<Weight> weightSet = new HashSet<>(0);
    // private Set<Footnote> footnoteSet = new HashSet<>(0);

    //  Links to the Food Description file by NDB_No
    //  Links to the Footnote file by NDB_No and when applicable, Nutr_No
    //  Links to the Nutrient Definition file by Nutr_No
    //  Links to the Footnote file by NDB_No and when applicable, Nutr_No
    //  Links to the Source Code file by Src_Cd
    //  Links to the Data Derivation Code Description file by Deriv_Cd
    //  Links to the Food Description file by Ref_NDB_No
    //  Links to the Sources of Data Link file by NDB_No and Nutr_No
    //  Links to the Weight file by NDB_No

    @EmbeddedId
    public NutrientDataKey getNutrientDataKey() {
        return nutrientDataKey;
    }

    public void setNutrientDataKey(NutrientDataKey nutrientDataKey) {
        this.nutrientDataKey = nutrientDataKey;
    }

    @Column(name = "Nutr_Val", columnDefinition = "float", nullable = false)
    public Double getNutr_Val() {
        return Nutr_Val;
    }

    public void setNutr_Val(Double nutr_Val) {
        Nutr_Val = nutr_Val;
    }

    @Column(name = "Num_Data_Pts", columnDefinition = "integer", nullable = false)
    public Integer getNum_Data_Pts() {
        return Num_Data_Pts;
    }

    public void setNum_Data_Pts(Integer num_Data_Pts) {
        Num_Data_Pts = num_Data_Pts;
    }

    @Column(name = "Std_Error", columnDefinition = "float")
    public Double getStd_Error() {
        return Std_Error;
    }

    public void setStd_Error(Double std_Error) {
        Std_Error = std_Error;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Src_Cd", columnDefinition = "character(2)", nullable = false)
    public SourceCode getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(SourceCode sourceCode) {
        this.sourceCode = sourceCode;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Deriv_Cd", columnDefinition = "character(4)")
    public DataDerivation getDataDerivation() {
        return dataDerivation;
    }

    public void setDataDerivation(DataDerivation dataDerivation) {
        this.dataDerivation = dataDerivation;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Ref_NDB_No", columnDefinition = "character(5)")
    public FoodDescription getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(FoodDescription foodDescription) {
        this.foodDescription = foodDescription;
    }

    @Column(name = "Add_Nutr_Mark", columnDefinition = "character(1)")
    public String getAdd_Nutr_Mark() {
        return Add_Nutr_Mark;
    }

    public void setAdd_Nutr_Mark(String add_Nutr_Mark) {
        Add_Nutr_Mark = add_Nutr_Mark;
    }

    @Column(name = "Num_Studies", columnDefinition = "integer")
    public Integer getNum_Studies() {
        return Num_Studies;
    }

    public void setNum_Studies(Integer num_Studies) {
        Num_Studies = num_Studies;
    }

    public Double getMin() {
        return Min;
    }

    @Column(name = "Min", columnDefinition = "float")
    public void setMin(Double min) {
        Min = min;
    }

    @Column(name = "Max", columnDefinition = "float")
    public Double getMax() {
        return Max;
    }

    public void setMax(Double max) {
        Max = max;
    }

    @Column(name = "DF", columnDefinition = "integer")
    public Integer getDF() {
        return DF;
    }

    public void setDF(Integer DF) {
        this.DF = DF;
    }

    @Column(name = "Low_EB", columnDefinition = "float")
    public Double getLow_EB() {
        return Low_EB;
    }

    public void setLow_EB(Double low_EB) {
        Low_EB = low_EB;
    }

    @Column(name = "Up_EB", columnDefinition = "float")
    public Double getUp_EB() {
        return Up_EB;
    }

    public void setUp_EB(Double up_EB) {
        Up_EB = up_EB;
    }

    @Column(name = "Stat_cmt", columnDefinition = "character(10)")
    public String getStat_cmt() {
        return Stat_cmt;
    }

    public void setStat_cmt(String stat_cmt) {
        Stat_cmt = stat_cmt;
    }

    @Column(name = "AddMod_Date", columnDefinition = "character(10)")
    public String getAddMod_Date() {
        return AddMod_Date;
    }

    public void setAddMod_Date(String addMod_Date) {
        AddMod_Date = addMod_Date;
    }

    @Column(name = "CC", columnDefinition = "character(1)")
    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "DATSRCLN",
            joinColumns = {@JoinColumn(name = "NDB_No", columnDefinition = "character(5)", nullable = false), @JoinColumn(name = "Nutr_No", columnDefinition = "character(3)", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "DataSrc_ID", columnDefinition = "character(6)", nullable = false)}
    )
    public Set<DataSource> getDataSourceSet() {
        return dataSourceSet;
    }

    public void setDataSourceSet(Set<DataSource> dataSources) {
        this.dataSourceSet = dataSources;
    }

//    @ManyToMany
//    @JoinColumn(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
//    public Set<Weight> getWeightSet() {
//        return weightSet;
//    }
//
//    public void setWeightSet(Set<Weight> weightSet) {
//        this.weightSet = weightSet;
//    }

//    @ManyToMany
//    @JoinColumn(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
//    public Set<Footnote> getFootnoteSet() {
//        return footnoteSet;
//    }
//
//    public void setFootnoteSet(Set<Footnote> footnoteSet) {
//        this.footnoteSet = footnoteSet;
//    }
}