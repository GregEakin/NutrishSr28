/*
 * Copyright (c) 2019. Greg Eakin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.eakin.dao.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FOOD_DES")
public class FoodDescription {
    private String NDB_No;
    private FoodGroup foodGroup;
    private String Long_Desc;
    private String Shrt_Desc;
    private String ComName;
    private String ManufacName;
    private String Survey;
    private String Ref_desc;
    private Integer Refuse;
    private String SciName;
    private Double N_Factor;
    private Double Pro_Factor;
    private Double Fat_Factor;
    private Double CHO_Factor;
    private Set<NutrientData> nutrientDataSet = new HashSet<>(0);
    private Set<Weight> weightSet = new HashSet<>(0);
    private Set<Footnote> footnoteSet = new HashSet<>(0);
    private Set<Language> languageSet = new HashSet<>(0);

    //  Links to the Food Group Description file by the FdGrp_Cd field
    //  Links to the Nutrient Data file by the NDB_No field
    //  Links to the Weight file by the NDB_No field
    //  Links to the Footnote file by the NDB_No field
    //  Links to the LanguaL Factor file by the NDB_No field

    @Id
    @Column(name = "NDB_No", length = 5, nullable = false)
    public String getNDB_No() {
        return NDB_No;
    }

    public void setNDB_No(String nDB_No) {
        this.NDB_No = nDB_No;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FdGrp_Cd", nullable = false)
    public FoodGroup getFoodGroup() {
        return foodGroup;
    }

    public void setFoodGroup(FoodGroup foodGroup) {
        this.foodGroup = foodGroup;
    }

    public void addFoodGroup(FoodGroup foodGroup) {
        if (foodGroup == null)
            throw new IllegalArgumentException("Null FoodGroup");
//        if (this.foodGroup != null)
//            this.foodGroup.getFoodDescriptionSet().remove(this);
        this.foodGroup = foodGroup;
        this.foodGroup.getFoodDescriptionSet().add(this);
    }

    @Column(name = "Long_Desc", length = 200, nullable = false)
    public String getLong_Desc() {
        return Long_Desc;
    }

    public void setLong_Desc(String long_Desc) {
        Long_Desc = long_Desc;
    }

    @Column(name = "Shrt_Desc", length = 60, nullable = false)
    public String getShrt_Desc() {
        return Shrt_Desc;
    }

    public void setShrt_Desc(String shrt_Desc) {
        Shrt_Desc = shrt_Desc;
    }

    @Column(name = "ComName", length = 100)
    public String getComName() {
        return ComName;
    }

    public void setComName(String comName) {
        ComName = comName;
    }

    @Column(name = "ManufacName", length = 65)
    public String getManufacName() {
        return ManufacName;
    }

    public void setManufacName(String manufacName) {
        ManufacName = manufacName;
    }

    @Column(name = "Survey", length = 1)
    public String getSurvey() {
        return Survey;
    }

    public void setSurvey(String survey) {
        Survey = survey;
    }

    @Column(name = "Ref_desc", length = 135)
    public String getRef_desc() {
        return Ref_desc;
    }

    public void setRef_desc(String ref_desc) {
        Ref_desc = ref_desc;
    }

    @Column(name = "Refuse")
    public Integer getRefuse() {
        return Refuse;
    }

    public void setRefuse(Integer refuse) {
        Refuse = refuse;
    }

    @Column(name = "SciName", length = 65)
    public String getSciName() {
        return SciName;
    }

    public void setSciName(String sciName) {
        SciName = sciName;
    }

    @Column(name = "N_Factor")
    public Double getN_Factor() {
        return N_Factor;
    }

    public void setN_Factor(Double n_Factor) {
        N_Factor = n_Factor;
    }

    @Column(name = "Pro_Factor")
    public Double getPro_Factor() {
        return Pro_Factor;
    }

    public void setPro_Factor(Double pro_Factor) {
        Pro_Factor = pro_Factor;
    }

    @Column(name = "Fat_Factor")
    public Double getFat_Factor() {
        return Fat_Factor;
    }

    public void setFat_Factor(Double fat_Factor) {
        Fat_Factor = fat_Factor;
    }

    @Column(name = "CHO_Factor")
    public Double getCHO_Factor() {
        return CHO_Factor;
    }

    public void setCHO_Factor(Double CHO_Factor) {
        this.CHO_Factor = CHO_Factor;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nutrientDataKey.foodDescription")
    public Set<NutrientData> getNutrientDataSet() {
        return nutrientDataSet;
    }

    public void setNutrientDataSet(Set<NutrientData> nutrientData) {
        this.nutrientDataSet = nutrientData;
    }

    public void addNutrientData(NutrientData nutrientData) {
        if (nutrientData == null)
            throw new IllegalArgumentException("Null NutrientData");

        NutrientDataKey nutrientDataKey = nutrientData.getNutrientDataKey();
        nutrientDataKey.setFoodDescription(this);
        nutrientDataSet.add(nutrientData);
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "weightKey.foodDescription")
    public Set<Weight> getWeightSet() {
        return weightSet;
    }

    public void setWeightSet(Set<Weight> weightSet) {
        this.weightSet = weightSet;
    }

    public void addWeight(Weight weight) {
        if (weight == null)
            throw new IllegalArgumentException("null Weight");
        if (!weight.getWeightKey().getFoodDescription().getNDB_No().equals(NDB_No))
            throw new IllegalArgumentException("Weight not related to FoodDescription");
        weightSet.add(weight);
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "foodDescription")
    public Set<Footnote> getFootnoteSet() {
        return footnoteSet;
    }

    public void setFootnoteSet(Set<Footnote> footnoteSet) {
        this.footnoteSet = footnoteSet;
    }

    public void addFootnote(Footnote footnote) {
        if (footnote == null)
            throw new IllegalArgumentException("null Footnote");
        footnote.setFoodDescription(this);
        footnoteSet.add(footnote);
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "LANGUAL",
            joinColumns = {@JoinColumn(name = "NDB_No", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "Factor_Code", nullable = false)}
    )

    public Set<Language> getLanguageSet() {
        return languageSet;
    }

    public void setLanguageSet(Set<Language> languageSet) {
        this.languageSet = languageSet;
    }

    public void addLanguage(Language language) {
        if (language == null)
            throw new IllegalArgumentException("null Language");
        language.getFoodDescriptionSet().add(this);
        languageSet.add(language);
    }
}
