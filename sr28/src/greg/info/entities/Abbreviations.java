package greg.info.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ABBREV")
public class Abbreviations {

    private String NDB_No;  // 5-digit Nutrient Databank number that uniquely identifies a food item.
    private String Shrt_Desc; // A 60 60-character abbreviated description of food item.†
    private Double Water; // N 10.2 Water (g/100 g)
    private Integer Energ_Kcal; //    Energ_Kcal N 10 Food energy (kcal/100 g)
    private Double Protein; //    Protein N 10.2 Protein (g/100 g)
    private Double Lipid_Tot; //    Lipid_Tot N 10.2 Total lipid (fat) (g/100 g)
    private Double Ash;//    Ash N 10.2 Ash (g/100 g)
    private Double Carbohydrt; //    Carbohydrt N 10.2 Carbohydrate, by difference (g/100 g)
    private Double Fiber_TD; //    Fiber_TD N 10.1 Total dietary fiber (g/100 g)
    private Double Sugar_Tot; //    Sugar_Tot N 10.2 Total sugars (g/100 g)
    private Integer Calcium; //    Calcium N 10 Calcium (mg/100 g)
    private Double Iron; //    Iron N 10.2 Iron (mg/100 g)
    private Integer Magnesium;//    Magnesium N 10 Magnesium (mg/100 g)
    private Integer Phosphorus; //    Phosphorus N 10 Phosphorus (mg/100 g)
    private Integer Potassium; //    Potassium N 10 Potassium (mg/100 g)
    private Integer Sodium; //    Sodium N 10 Sodium (mg/100 g)
    private Double Zinc;//    Zinc N 10.2 Zinc (mg/100 g)
    private Double Copper;//    Copper N 10.3 Copper (mg/100 g)
    private Double Manganese;//    Manganese N 10.3 Manganese (mg/100 g)
    private Double Selenium;//    Selenium N 10.1 Selenium (μg/100 g)
    private Double Vit_C;//    Vit_C N 10.1 Vitamin C (mg/100 g)
    private Double Thiamin;//    Thiamin N 10.3 Thiamin (mg/100 g)
    private Double Riboflavin;//    Riboflavin N 10.3 Riboflavin (mg/100 g)
    private Double Niacin;//    Niacin N 10.3 Niacin (mg/100 g)
    private Double Panto_acid;//    Panto_acid N 10.3 Pantothenic acid  (mg/100 g)
    private Double Vit_B6;//    Vit_B6 N 10.3 Vitamin B6 (mg/100 g)
    private Integer Folate_Tot;//    Folate_Tot N 10 Folate, total (μg/100 g)
    private Integer Folic_acid;//    Folic_acid N 10 Folic acid (μg/100 g)
    private Integer Food_Folate;//    Food_Folate N 10 Food folate (μg/100 g)
    private Integer Folate_DFE;//    Folate_DFE N 10 Folate (μg dietary folate equivalents/100 g)
    private Double Choline_Tot;//    Choline_Tot N 10.1 Choline, total (mg/100 g)
    private Double Vit_B12;//    Vit_B12 N 10.2 Vitamin B12 (μg/100 g)
    private Integer Vit_A_IU;//    Vit_A_IU N 10 Vitamin A (IU/100 g)
    private Integer Vit_A_RAE;//    Vit_A_RAE N 10 Vitamin A (μg retinol activity equivalents/100g)
    private Integer Retinol;//    Retinol N 10 Retinol (μg/100 g)
    private Integer Alpha_Carot;//    Alpha_Carot N 10 Alpha-carotene (μg/100 g)
    private Integer Beta_Carot;//    Beta_Carot N 10 Beta-carotene (μg/100 g)
    private Integer Beta_Crypt;//    Beta_Crypt N 10 Beta-cryptoxanthin (μg/100 g)
    private Integer Lycopene;//    Lycopene N 10 Lycopene (μg/100 g)
    private Integer Lut_Zea; //    Lut+Zea N 10 Lutein+zeazanthin (μg/100 g)
    private Double Vit_E;//    Vit_E N 10.2 Vitamin E (alpha-tocopherol) (mg/100 g)
    private Double Vit_D_mcg;//    Vit_D_mcg N 10.1 Vitamin D (μg/100 g)
    private Integer Vit_D_IU;//    Vit_D_IU N 10 Vitamin D (IU/100 g)
    private Double Vit_K;//    Vit_K N 10.1 Vitamin K (phylloquinone) (μg/100 g)
    private Double FA_Sat;//    FA_Sat N 10.3 Saturated fatty acid (g/100 g)
    private Double FA_Mono;//    FA_Mono N 10.3 Monounsaturated fatty acids (g/100 g)
    private Double FA_Poly;//    FA_Poly N 10.3 Polyunsaturated fatty acids (g/100 g)
    private Double Cholestrl;//    Cholestrl N 10.3 Cholesterol (mg/100 g)
    private Double GmWt_1;//    GmWt_1 N 9.2 First household weight for this item from the Weight file.‡
    private String GmWt_Desc1;//    GmWt_Desc1 A 120 Description of household weight number 1.
    private Double GmWt_2;//    GmWt_2 N 9.2 Second household weight for this item from the Weight file.‡
    private String GmWt_Desc2;//    GmWt_Desc2 A 120 Description of household weight number 2.
    private Integer Refuse_Pct;//    Refuse_Pct N 2 Percent refuse.
    // private FoodDescription foodDescription;

    @Id
    @Column(name = "NDB_No", columnDefinition = "character(5)", nullable = false)
    public String getNDB_No() {
        return NDB_No;
    }

    public void setNDB_No(String NDB_No) {
        this.NDB_No = NDB_No;
    }

    @Column(name = "Shrt_Desc", columnDefinition = "varchar(60)", nullable = false)
    public String getShrt_Desc() {
        return Shrt_Desc;
    }

    public void setShrt_Desc(String shrt_Desc) {
        Shrt_Desc = shrt_Desc;
    }

    @Column(name = "Water", columnDefinition = "float")
    public Double getWater() {
        return Water;
    }

    public void setWater(Double water) {
        Water = water;
    }

    @Column(name = "Energ_Kcal", columnDefinition = "integer")
    public Integer getEnerg_Kcal() {
        return Energ_Kcal;
    }

    public void setEnerg_Kcal(Integer energ_Kcal) {
        Energ_Kcal = energ_Kcal;
    }

    @Column(name = "Protein", columnDefinition = "float")
    public Double getProtein() {
        return Protein;
    }

    public void setProtein(Double protein) {
        Protein = protein;
    }

    @Column(name = "Lipid_Tot", columnDefinition = "float")
    public Double getLipid_Tot() {
        return Lipid_Tot;
    }

    public void setLipid_Tot(Double lipid_Tot) {
        Lipid_Tot = lipid_Tot;
    }

    @Column(name = "Ash", columnDefinition = "float")
    public Double getAsh() {
        return Ash;
    }

    public void setAsh(Double ash) {
        Ash = ash;
    }

    @Column(name = "Carbohydrt", columnDefinition = "float", nullable = false)
    public Double getCarbohydrt() {
        return Carbohydrt;
    }

    public void setCarbohydrt(Double carbohydrt) {
        Carbohydrt = carbohydrt;
    }

    @Column(name = "Fiber_TD", columnDefinition = "float")
    public Double getFiber_TD() {
        return Fiber_TD;
    }

    public void setFiber_TD(Double fiber_TD) {
        Fiber_TD = fiber_TD;
    }

    @Column(name = "Sugar_Tot", columnDefinition = "float")
    public Double getSugar_Tot() {
        return Sugar_Tot;
    }

    public void setSugar_Tot(Double sugar_Tot) {
        Sugar_Tot = sugar_Tot;
    }

    @Column(name = "Calcium", columnDefinition = "integer")
    public Integer getCalcium() {
        return Calcium;
    }

    public void setCalcium(Integer calcium) {
        Calcium = calcium;
    }

    @Column(name = "Iron", columnDefinition = "float")
    public Double getIron() {
        return Iron;
    }

    public void setIron(Double iron) {
        Iron = iron;
    }

    @Column(name = "Magnesium", columnDefinition = "integer")
    public Integer getMagnesium() {
        return Magnesium;
    }

    public void setMagnesium(Integer magnesium) {
        Magnesium = magnesium;
    }

    @Column(name = "Phosphorus", columnDefinition = "integer")
    public Integer getPhosphorus() {
        return Phosphorus;
    }

    public void setPhosphorus(Integer phosphorus) {
        Phosphorus = phosphorus;
    }

    @Column(name = "Potassium", columnDefinition = "integer")
    public Integer getPotassium() {
        return Potassium;
    }

    public void setPotassium(Integer potassium) {
        Potassium = potassium;
    }

    @Column(name = "Sodium", columnDefinition = "integer")
    public Integer getSodium() {
        return Sodium;
    }

    public void setSodium(Integer sodium) {
        Sodium = sodium;
    }

    @Column(name = "Zinc", columnDefinition = "float")
    public Double getZinc() {
        return Zinc;
    }

    public void setZinc(Double zinc) {
        Zinc = zinc;
    }

    @Column(name = "Copper", columnDefinition = "float")
    public Double getCopper() {
        return Copper;
    }

    public void setCopper(Double copper) {
        Copper = copper;
    }

    @Column(name = "Manganese", columnDefinition = "float")
    public Double getManganese() {
        return Manganese;
    }

    public void setManganese(Double manganese) {
        Manganese = manganese;
    }

    @Column(name = "Selenium", columnDefinition = "float")
    public Double getSelenium() {
        return Selenium;
    }

    public void setSelenium(Double selenium) {
        Selenium = selenium;
    }

    @Column(name = "Vit_C", columnDefinition = "float")
    public Double getVit_C() {
        return Vit_C;
    }

    public void setVit_C(Double vit_C) {
        Vit_C = vit_C;
    }

    @Column(name = "Thiamin", columnDefinition = "float")
    public Double getThiamin() {
        return Thiamin;
    }

    public void setThiamin(Double thiamin) {
        Thiamin = thiamin;
    }

    @Column(name = "Riboflavin", columnDefinition = "float")
    public Double getRiboflavin() {
        return Riboflavin;
    }

    public void setRiboflavin(Double riboflavin) {
        Riboflavin = riboflavin;
    }

    @Column(name = "Niacin", columnDefinition = "float")
    public Double getNiacin() {
        return Niacin;
    }

    public void setNiacin(Double niacin) {
        Niacin = niacin;
    }

    @Column(name = "Panto_acid", columnDefinition = "float")
    public Double getPanto_acid() {
        return Panto_acid;
    }

    public void setPanto_acid(Double panto_acid) {
        Panto_acid = panto_acid;
    }

    @Column(name = "Vit_B6", columnDefinition = "float")
    public Double getVit_B6() {
        return Vit_B6;
    }

    public void setVit_B6(Double vit_B6) {
        Vit_B6 = vit_B6;
    }

    @Column(name = "Folate_Tot", columnDefinition = "integer")
    public Integer getFolate_Tot() {
        return Folate_Tot;
    }

    public void setFolate_Tot(Integer folate_Tot) {
        Folate_Tot = folate_Tot;
    }

    @Column(name = "Folic_acid", columnDefinition = "integer")
    public Integer getFolic_acid() {
        return Folic_acid;
    }

    public void setFolic_acid(Integer folic_acid) {
        Folic_acid = folic_acid;
    }

    @Column(name = "Food_Folate", columnDefinition = "integer")
    public Integer getFood_Folate() {
        return Food_Folate;
    }

    public void setFood_Folate(Integer food_Folate) {
        Food_Folate = food_Folate;
    }

    @Column(name = "Folate_DFE", columnDefinition = "integer")
    public Integer getFolate_DFE() {
        return Folate_DFE;
    }

    public void setFolate_DFE(Integer folate_DFE) {
        Folate_DFE = folate_DFE;
    }

    @Column(name = "Choline_Tot", columnDefinition = "float")
    public Double getCholine_Tot() {
        return Choline_Tot;
    }

    public void setCholine_Tot(Double choline_Tot) {
        Choline_Tot = choline_Tot;
    }

    @Column(name = "Vit_B12", columnDefinition = "float")
    public Double getVit_B12() {
        return Vit_B12;
    }

    public void setVit_B12(Double vit_B12) {
        Vit_B12 = vit_B12;
    }

    @Column(name = "Vit_A_IU", columnDefinition = "integer")
    public Integer getVit_A_IU() {
        return Vit_A_IU;
    }

    public void setVit_A_IU(Integer vit_A_IU) {
        Vit_A_IU = vit_A_IU;
    }

    @Column(name = "Vit_A_RAE", columnDefinition = "integer")
    public Integer getVit_A_RAE() {
        return Vit_A_RAE;
    }

    public void setVit_A_RAE(Integer vit_A_RAE) {
        Vit_A_RAE = vit_A_RAE;
    }

    @Column(name = "Retinol", columnDefinition = "integer")
    public Integer getRetinol() {
        return Retinol;
    }

    public void setRetinol(Integer retinol) {
        Retinol = retinol;
    }

    @Column(name = "Alpha_Carot", columnDefinition = "integer")
    public Integer getAlpha_Carot() {
        return Alpha_Carot;
    }

    public void setAlpha_Carot(Integer alpha_Carot) {
        Alpha_Carot = alpha_Carot;
    }

    @Column(name = "Beta_Carot", columnDefinition = "integer")
    public Integer getBeta_Carot() {
        return Beta_Carot;
    }

    public void setBeta_Carot(Integer beta_Carot) {
        Beta_Carot = beta_Carot;
    }

    @Column(name = "Beta_Crypt", columnDefinition = "integer")
    public Integer getBeta_Crypt() {
        return Beta_Crypt;
    }

    public void setBeta_Crypt(Integer beta_Crypt) {
        Beta_Crypt = beta_Crypt;
    }

    @Column(name = "Lycopene", columnDefinition = "integer")
    public Integer getLycopene() {
        return Lycopene;
    }

    public void setLycopene(Integer lycopene) {
        Lycopene = lycopene;
    }

    @Column(name = "Lut_Zea", columnDefinition = "integer")
    public Integer getLut_Zea() {
        return Lut_Zea;
    }

    public void setLut_Zea(Integer lut_Zea) {
        Lut_Zea = lut_Zea;
    }

    @Column(name = "Vit_E", columnDefinition = "float")
    public Double getVit_E() {
        return Vit_E;
    }

    public void setVit_E(Double vit_E) {
        Vit_E = vit_E;
    }

    @Column(name = "Vit_D_mcg", columnDefinition = "float")
    public Double getVit_D_mcg() {
        return Vit_D_mcg;
    }

    public void setVit_D_mcg(Double vit_D_mcg) {
        Vit_D_mcg = vit_D_mcg;
    }

    @Column(name = "Vit_D_IU", columnDefinition = "integer")
    public Integer getVit_D_IU() {
        return Vit_D_IU;
    }

    public void setVit_D_IU(Integer vit_D_IU) {
        Vit_D_IU = vit_D_IU;
    }

    @Column(name = "Vit_K", columnDefinition = "float")
    public Double getVit_K() {
        return Vit_K;
    }

    public void setVit_K(Double vit_K) {
        Vit_K = vit_K;
    }

    @Column(name = "FA_Sat", columnDefinition = "float")
    public Double getFA_Sat() {
        return FA_Sat;
    }

    public void setFA_Sat(Double FA_Sat) {
        this.FA_Sat = FA_Sat;
    }

    @Column(name = "FA_Mono", columnDefinition = "float")
    public Double getFA_Mono() {
        return FA_Mono;
    }

    public void setFA_Mono(Double FA_Mono) {
        this.FA_Mono = FA_Mono;
    }

    @Column(name = "FA_Poly", columnDefinition = "float")
    public Double getFA_Poly() {
        return FA_Poly;
    }

    public void setFA_Poly(Double FA_Poly) {
        this.FA_Poly = FA_Poly;
    }

    @Column(name = "Cholestrl", columnDefinition = "float")
    public Double getCholestrl() {
        return Cholestrl;
    }

    public void setCholestrl(Double cholestrl) {
        Cholestrl = cholestrl;
    }

    @Column(name = "GmWt_1", columnDefinition = "float")
    public Double getGmWt_1() {
        return GmWt_1;
    }

    public void setGmWt_1(Double gmWt_1) {
        GmWt_1 = gmWt_1;
    }

    @Column(name = "GmWt_Desc1", columnDefinition = "varchar(120)")
    public String getGmWt_Desc1() {
        return GmWt_Desc1;
    }

    public void setGmWt_Desc1(String gmWt_Desc1) {
        GmWt_Desc1 = gmWt_Desc1;
    }

    @Column(name = "GmWt_2", columnDefinition = "float")
    public Double getGmWt_2() {
        return GmWt_2;
    }

    public void setGmWt_2(Double gmWt_2) {
        GmWt_2 = gmWt_2;
    }

    @Column(name = "GWt_Desc2", columnDefinition = "varchar(120)")
    public String getGmWt_Desc2() {
        return GmWt_Desc2;
    }

    public void setGmWt_Desc2(String gmWt_Desc2) {
        GmWt_Desc2 = gmWt_Desc2;
    }

    @Column(name = "Refuse_Pct", columnDefinition = "integer")
    public Integer getRefuse_Pct() {
        return Refuse_Pct;
    }

    public void setRefuse_Pct(Integer refuse_Pct) {
        Refuse_Pct = refuse_Pct;
    }

//    @OneToOne
//    @JoinColumn(name = "NDB_No", columnDefinition = "character(5)")
//    public FoodDescription getFoodDescription() {
//        return foodDescription;
//    }
//
//    public void setFoodDescription(FoodDescription foodDescription) {
//        this.foodDescription = foodDescription;
//    }
}
