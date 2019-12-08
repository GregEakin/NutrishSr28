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
@Table(name = "FD_GROUP")
public class FoodGroup {
    private String FdGrp_Cd;
    private String FdGrp_Desc;
    private Set<FoodDescription> foodDescriptionSet = new HashSet<>(0);

    //  Links to the Food Description file by FdGrp_Cd

    @Id
    @Column(name = "FdGrp_Cd", length = 4, nullable = false)
    public String getFdGrp_Cd() {
        return FdGrp_Cd;
    }

    public void setFdGrp_Cd(String fdGrp_Cd) {
        this.FdGrp_Cd = fdGrp_Cd;
    }

    @Column(name = "FdGrp_Desc", length = 60, nullable = false)
    public String getFdGrp_Desc() {
        return FdGrp_Desc;
    }

    public void setFdGrp_Desc(String fdGrp_Desc) {
        FdGrp_Desc = fdGrp_Desc;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "foodGroup")
    public Set<FoodDescription> getFoodDescriptionSet() {
        return foodDescriptionSet;
    }

    public void setFoodDescriptionSet(Set<FoodDescription> foodDescriptionSet) {
        this.foodDescriptionSet = foodDescriptionSet;
    }

    public void addFoodDescriptionSet(FoodDescription foodDescription) {
        if (foodDescription == null)
            throw new IllegalArgumentException("Null FoodDescription");
        foodDescription.setFoodGroup(this);
        foodDescriptionSet.add(foodDescription);
    }
}
