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

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/*
    Weight File  (file name = WEIGHT). This file (Table 12) contains the weight in grams of a number of common measures for each food item.
 */

@Entity
@Table(name = "WEIGHT")
public class Weight implements Serializable {

    private WeightKey weightKey;
    private Double Amount;
    private String Msre_Desc;
    private Double Gm_Wgt;
    private Integer Num_Data_Pts;
    private Double Std_Dev;

    //  Links to Food Description file by NDB_No
    //  Links to Nutrient Data file by NDB_No

    @EmbeddedId
    public WeightKey getWeightKey() {
        return weightKey;
    }

    public void setWeightKey(WeightKey weightKey) {
        this.weightKey = weightKey;
    }


    // Amount N 5.3 N Unit modifier (for example, 1 in “1 cup”).
    @Column(name = "Amount", nullable = false)
    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    // Msre_Desc A 84 N Description (for example, cup, diced, and 1-inch pieces).
    @Column(name = "Msre_Desc", length = 84, nullable = false)
    public String getMsre_Desc() {
        return Msre_Desc;
    }

    public void setMsre_Desc(String msre_Desc) {
        Msre_Desc = msre_Desc;
    }

    // Gm_Wgt N 7.1 N Gram weight.
    @Column(name = "Gm_Wgt", nullable = false)
    public Double getGm_Wgt() {
        return Gm_Wgt;
    }

    public void setGm_Wgt(Double gm_Wgt) {
        Gm_Wgt = gm_Wgt;
    }

    // Num_Data_Pts N 3 Y Number of data points.
    @Column(name = "Num_Data_Pts")
    public Integer getNum_Data_Pts() {
        return Num_Data_Pts;
    }

    public void setNum_Data_Pts(Integer num_Data_Pts) {
        Num_Data_Pts = num_Data_Pts;
    }

    // Std_Dev N 7.3 Y Standard deviation.
    @Column(name = "Std_Dev")
    public Double getStd_Dev() {
        return Std_Dev;
    }

    public void setStd_Dev(Double std_Dev) {
        Std_Dev = std_Dev;
    }
}
