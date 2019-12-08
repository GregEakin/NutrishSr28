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

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class NutrientDataKey implements Serializable {

    private FoodDescription foodDescription;        // The food item
    private NutrientDefinition nutrientDefinition;  // The nutrient to which footnote applies.

    public NutrientDataKey() {
    }

    public NutrientDataKey(FoodDescription foodDescription, NutrientDefinition nutrientDefinition) {
        this.foodDescription = foodDescription;
        this.nutrientDefinition = nutrientDefinition;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NDB_No", nullable = false)
    public FoodDescription getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(FoodDescription foodDescription) {
        this.foodDescription = foodDescription;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Nutr_No", nullable = false)
    public NutrientDefinition getNutrientDefinition() {
        return nutrientDefinition;
    }

    public void setNutrientDefinition(NutrientDefinition nutrientDefinition) {
        this.nutrientDefinition = nutrientDefinition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NutrientDataKey that = (NutrientDataKey) o;

        return (foodDescription != null ? foodDescription.equals(that.foodDescription) : that.foodDescription == null)
                && (nutrientDefinition != null ? nutrientDefinition.equals(that.nutrientDefinition) : that.nutrientDefinition == null);
    }

    @Override
    public int hashCode() {
        int result;
        result = (foodDescription != null ? foodDescription.hashCode() : 0);
        result = 31 * result + (nutrientDefinition != null ? nutrientDefinition.hashCode() : 0);
        return result;
    }
}
