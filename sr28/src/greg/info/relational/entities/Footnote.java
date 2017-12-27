package greg.info.relational.entities;

import javax.persistence.*;

@Entity
@Table(name = "FOOTNOTE")
public class Footnote {

    private Integer Id;

    private String NDB_No;
    private FoodDescription foodDescription;    // 5-digit Nutrient Databank number that uniquely identifies a food item.
    private String Footnt_No;                   // Sequence number.
    private String Footnt_Typ;                  // Type of footnote:
    private String Nutr_No;
    //private NutrientDefinition nutrientDefinition; // The nutrient to which footnote applies.
    private String Footnt_Txt;                  // Footnote text.
    //private Set<NutrientData> nutrientDataSet = new HashSet<>(0);

    //  Links to the Food Description file by NDB_No
    //  Links to the Nutrient Data file by NDB_No and when applicable, Nutr_No
    //  Links to the Nutrient Definition file by Nutr_No, when applicable

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

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

    @Column(name = "Footnt_No", columnDefinition = "character(4)", nullable = false)
    public String getFootnt_No() {
        return Footnt_No;
    }

    public void setFootnt_No(String footnt_No) {
        Footnt_No = footnt_No;
    }

    @Column(name = "Footnt_Typ", columnDefinition = "character(1)", nullable = false)
    public String getFootnt_Typ() {
        return Footnt_Typ;
    }

    public void setFootnt_Typ(String footnt_Typ) {
        Footnt_Typ = footnt_Typ;
    }

    // NutrientDefinition
    @Column(name = "Nutr_No", columnDefinition = "character(3)")
    public String getNutr_No() {
        return Nutr_No;
    }

    public void setNutr_No(String nutr_No) {
        Nutr_No = nutr_No;
    }

//    @OneToOne
//    @JoinColumn(name = "Nutr_No", columnDefinition = "character(3)")
//    public NutrientDefinition getNutrientDefinition() {
//        return nutrientDefinition;
//    }
//
//    public void setNutrientDefinition(NutrientDefinition nutrientDefinition) {
//        this.nutrientDefinition = nutrientDefinition;
//    }

    @Column(name = "Footnt_Txt", columnDefinition = "varchar(200)", nullable = false)
    public String getFootnt_Txt() {
        return Footnt_Txt;
    }

    public void setFootnt_Txt(String footnt_Txt) {
        Footnt_Txt = footnt_Txt;
    }

//    @OneToMany
//    @JoinColumns({
//            @JoinColumn(name = "NDB_No", columnDefinition = "character(5)", nullable = false),
//            @JoinColumn(name = "Nutr_No", columnDefinition = "character(3)", nullable = false)
//    })
//    public Set<NutrientData> getNutrientDataSet() {
//        return nutrientDataSet;
//    }
//
//    public void setNutrientDataSet(Set<NutrientData> nutrients) {
//        this.nutrientDataSet = nutrients;
//    }
}
