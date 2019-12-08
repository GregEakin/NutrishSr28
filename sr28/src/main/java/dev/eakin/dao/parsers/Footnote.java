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
import dev.eakin.dao.entities.NutrientDefinition;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

// after FoodDescription
// after NutrientDefinition

public class Footnote {
    public static final String Filename = ".\\data\\FOOTNOTE.txt";

    public static void parseFile(final Session session) throws IOException {

        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> parseLine(session, line));
        }
    }

    private static void parseLine(final Session session, final String line) {
        String[] fields = line.split("\\^", -1);
        dev.eakin.dao.entities.Footnote item = parseFootnote(session, fields);

        if (item != null)
            session.save(item);
    }

    private static dev.eakin.dao.entities.Footnote parseFootnote(final Session session, final String[] fields) {
        dev.eakin.dao.entities.Footnote item = new dev.eakin.dao.entities.Footnote();

        String foodDescriptionId = fields[0].substring(1, fields[0].length() - 1);
        FoodDescription foodDescription = session.load(FoodDescription.class, foodDescriptionId);
        item.setFoodDescription(foodDescription);

        item.setFootnt_No(fields[1].substring(1, fields[1].length() - 1));

        item.setFootnt_Typ(fields[2].substring(1, fields[2].length() - 1));

        if (fields[3].length() > 2) {
            String Nutr_No = fields[3].substring(1, fields[3].length() - 1);
            NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, Nutr_No);
            item.addNutrientDefinition(nutrientDefinition);
        }

        item.setFootnt_Txt(fields[4].substring(1, fields[4].length() - 1));

        foodDescription.addFootnote(item);
        return item;
    }
}
