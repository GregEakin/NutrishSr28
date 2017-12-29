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
import java.io.Serializable;

@Embeddable
public class WeightKey implements Serializable {

    private FoodDescription foodDescription;
    private String Seq;

    public WeightKey() {
    }

    public WeightKey(FoodDescription foodDescription, String Seq) {
        this.foodDescription = foodDescription;
        this.Seq = Seq;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NDB_No", nullable = false)
    public FoodDescription getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(FoodDescription foodDescription) {
        this.foodDescription = foodDescription;
    }

    @Column(name = "Seq", length = 2, nullable = false)
    public String getSeq() {
        return Seq;
    }

    public void setSeq(String seq) {
        Seq = seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeightKey that = (WeightKey) o;

        return (foodDescription != null ? foodDescription.equals(that.foodDescription) : that.foodDescription == null)
                && (Seq != null ? Seq.equals(that.Seq) : that.Seq == null);
    }

    @Override
    public int hashCode() {
        int result;
        result = (foodDescription != null ? foodDescription.hashCode() : 0);
        result = 31 * result + (Seq != null ? Seq.hashCode() : 0);
        return result;
    }
}
