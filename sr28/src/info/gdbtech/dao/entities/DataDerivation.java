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
@Table(name = "DERIV_CD")
public class DataDerivation {
    private String Deriv_Cd;
    private String Deriv_Desc;
    private Set<NutrientData> nutrientDataSet = new HashSet<>(0);

    //  Links to the Nutrient Data file by Deriv_Cd

    @Id
    @Column(name = "Deriv_Cd", length = 4, nullable = false)
    public String getDeriv_Cd() {
        return Deriv_Cd;
    }

    public void setDeriv_Cd(String deriv_Cd) {
        Deriv_Cd = deriv_Cd;
    }

    @Column(name = "Deriv_Desc", length = 120, nullable = false)
    public String getDeriv_Desc() {
        return Deriv_Desc;
    }

    public void setDeriv_Desc(String deriv_Desc) {
        Deriv_Desc = deriv_Desc;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dataDerivation")
    public Set<NutrientData> getNutrientDataSet() {
        return nutrientDataSet;
    }

    public void setNutrientDataSet(Set<NutrientData> nutrientDataSet) {
        this.nutrientDataSet = nutrientDataSet;
    }
}
