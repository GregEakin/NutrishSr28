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
import java.util.Set;

@Entity
@Table(name = "SRC_CD")
public class SourceCode {
    private String Src_Cd;
    private String SrcCd_Desc;
    private Set<NutrientData> nutrientDataSet;

    //  Links to the Nutrient Data file by Src_Cd

    @Id
    @Column(name = "Src_Cd", length = 2, nullable = false)
    public String getSrc_Cd() {
        return Src_Cd;
    }

    public void setSrc_Cd(String src_Cd) {
        Src_Cd = src_Cd;
    }

    @Column(name = "SrcCd_Desc", length = 60, nullable = false)
    public String getSrcCd_Desc() {
        return SrcCd_Desc;
    }

    public void setSrcCd_Desc(String srcCd_Desc) {
        SrcCd_Desc = srcCd_Desc;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sourceCode")
    public Set<NutrientData> getNutrientDataSet() {
        return nutrientDataSet;
    }

    public void setNutrientDataSet(Set<NutrientData> nutrientDataSet) {
        this.nutrientDataSet = nutrientDataSet;
    }
}
