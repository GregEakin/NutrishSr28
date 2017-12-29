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

package info.gdbtech.dao.parsers;

import info.gdbtech.dao.entities.FoodDescription;
import info.gdbtech.dao.entities.WeightKey;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Weight {
    public static final String Filename = ".\\data\\WEIGHT.txt";

    public static void parseFile(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> praseLine(session, line));
        }
    }


    private static void praseLine(final Session session, final String line) {

        String[] fields = line.split("\\^", -1);

        info.gdbtech.dao.entities.Weight item = new info.gdbtech.dao.entities.Weight();

        // NDB_No A 5* N 5-digit Nutrient Databank number that uniquely identifies a food item.
        // Seq A 2* N Sequence number.
        String foodDescriptionId = fields[0].substring(1, fields[0].length() - 1);
        FoodDescription foodDescription = session.load(FoodDescription.class, foodDescriptionId);
        item.setWeightKey(new WeightKey(foodDescription, fields[1]));

        // Amount N 5.3 N Unit modifier (for example, 1 in “1 cup”).
        item.setAmount(Double.parseDouble(fields[2]));

        // Msre_Desc A 84 N Description (for example, cup, diced, and 1-inch pieces).
        String description = fields[3].substring(1, fields[3].length() - 1);
        item.setMsre_Desc(description);

        // Gm_Wgt N 7.1 N Gram weight.
        item.setGm_Wgt(Double.parseDouble(fields[4]));

        // Num_Data_Pts N 3 Y Number of data points.
        if (fields[5].length() > 0) item.setNum_Data_Pts(Integer.parseInt(fields[5]));

        // Std_Dev N 7.3 Y Standard deviation.
        if (fields[6].length() > 0) item.setStd_Dev(Double.parseDouble(fields[6]));

        session.save(item);
    }
}
