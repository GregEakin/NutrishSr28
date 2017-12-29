package info.gdbtech.dao.entities;

import javax.persistence.*;

@Entity
@Table(name = "FOOTNOTE")
public class Footnote {

    private int id;
    private FoodDescription foodDescription;        // The food item
    private String Footnt_No;                       // Sequence number.
    private String Footnt_Typ;                  // Type of footnote:
    private NutrientDefinition nutrientDefinition;  // The nutrient to which footnote applies.
    private String Footnt_Txt;                  // Footnote text.

    //  Links to the Food Description file by NDB_No
    //  Links to the Nutrient Data file by NDB_No and when applicable, Nutr_No
    //  Links to the Nutrient Definition file by Nutr_No, when applicable

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Nutr_No", columnDefinition = "character(3)")
    public NutrientDefinition getNutrientDefinition() {
        return nutrientDefinition;
    }

    public void setNutrientDefinition(NutrientDefinition nutrientDefinition) {
        this.nutrientDefinition = nutrientDefinition;
    }

    @Column(name = "Footnt_Txt", columnDefinition = "varchar(200)", nullable = false)
    public String getFootnt_Txt() {
        return Footnt_Txt;
    }

    public void setFootnt_Txt(String footnt_Txt) {
        Footnt_Txt = footnt_Txt;
    }
}
