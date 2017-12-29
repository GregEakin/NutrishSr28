/*
 * Copyright (c) 2017. Greg Eakin
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

package info.gdbtech.dao.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LANGDESC")
public class Language {

    private String Factor_Code;
    private String Description;
    private Set<FoodDescription> foodDescriptionSet = new HashSet<>(0);

    //  Links to the LanguaL Factor file by the Factor_Code field

    @Id
    @Column(name = "Factor_Code", length = 5, nullable = false)
    public String getFactor_Code() {
        return Factor_Code;
    }

    public void setFactor_Code(String factor_Code) {
        Factor_Code = factor_Code;
    }

    @Column(name = "Description", length = 140, nullable = false)
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @ManyToMany(mappedBy = "languageSet")
    public Set<FoodDescription> getFoodDescriptionSet() {
        return foodDescriptionSet;
    }

    public void setFoodDescriptionSet(Set<FoodDescription> foodDescriptionSet) {
        this.foodDescriptionSet = foodDescriptionSet;
    }
}
