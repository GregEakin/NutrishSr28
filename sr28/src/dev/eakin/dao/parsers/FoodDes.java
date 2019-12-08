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

package dev.eakin.dao.parsers;

import dev.eakin.dao.entities.FoodDescription;
import dev.eakin.dao.entities.FoodGroup;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FoodDes {
    public static final String Filename = ".\\data\\FOOD_DES.txt";

    public static void parseFile(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> parseLine(session, line));
        }
    }

    private static void parseLine(final Session session, final String line) {

        String[] fields = line.split("\\^", -1);

        FoodDescription item = parseFoodDescription(session, fields);

        session.save(item);
    }

    private static FoodDescription parseFoodDescription(final Session session, final String[] fields) {

        FoodDescription item = new FoodDescription();

        item.setNDB_No(fields[0].substring(1, fields[0].length() - 1));

        String foodGroupId = fields[1].substring(1, fields[1].length() - 1);
        FoodGroup foodGroup = session.load(FoodGroup.class, foodGroupId);
        item.addFoodGroup(foodGroup);

        item.setLong_Desc(fields[2].substring(1, fields[2].length() - 1));
        item.setShrt_Desc(fields[3].substring(1, fields[3].length() - 1));
        if (fields[4].length() > 2) item.setComName(fields[4].substring(1, fields[4].length() - 1));
        if (fields[5].length() > 2) item.setManufacName(fields[5].substring(1, fields[5].length() - 1));
        if (fields[6].length() > 2) item.setSurvey(fields[6].substring(1, fields[6].length() - 1));
        if (fields[7].length() > 2) item.setRef_desc(fields[7].substring(1, fields[7].length() - 1));
        if (fields[8].length() > 0) item.setRefuse(Integer.parseInt(fields[8]));
        if (fields[9].length() > 2) item.setSciName(fields[9].substring(1, fields[9].length() - 1));
        if (fields[10].length() > 0) item.setN_Factor(Double.parseDouble(fields[10]));
        if (fields[11].length() > 0) item.setPro_Factor(Double.parseDouble(fields[11]));
        if (fields[12].length() > 0) item.setFat_Factor(Double.parseDouble(fields[12]));
        if (fields[13].length() > 0) item.setCHO_Factor(Double.parseDouble(fields[13]));
        return item;
    }
}
