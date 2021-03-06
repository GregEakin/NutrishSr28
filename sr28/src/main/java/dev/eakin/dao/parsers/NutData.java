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

import dev.eakin.dao.entities.*;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class NutData {
    public static final String Filename = ".\\data\\NUT_DATA.txt";

    public static void parseFile(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> parseLine(session, line));
        }
    }

    private static void parseLine(final Session session, final String line) {
        String[] fields = line.split("\\^", -1);

        NutrientData item = new NutrientData();

        String NDB_No = fields[0].substring(1, fields[0].length() - 1);
        FoodDescription foodDescription = session.load(FoodDescription.class, NDB_No);

        String Nutr_No = fields[1].substring(1, fields[1].length() - 1);
        NutrientDefinition nutrientDefinition = session.load(NutrientDefinition.class, Nutr_No);

        NutrientDataKey nutrientDataKey = new NutrientDataKey(foodDescription, nutrientDefinition);
        item.setNutrientDataKey(nutrientDataKey);

        item.setNutr_Val(Double.parseDouble(fields[2]));

        item.setNum_Data_Pts(Integer.parseInt(fields[3]));

        if (fields[4].length() > 0) item.setStd_Error(Double.parseDouble(fields[4]));

        String Src_Cd = fields[5].substring(1, fields[5].length() - 1);
        SourceCode sourceCode = session.load(SourceCode.class, Src_Cd);
        item.addSourceCode(sourceCode);

        if (fields[6].length() > 2) {
            String Deriv_Cd = fields[6].substring(1, fields[6].length() - 1);
            DataDerivation dataDerivation = session.load(DataDerivation.class, Deriv_Cd);
            item.addDataDerivation(dataDerivation);
        }

        if (fields[7].length() > 2) {
            String Ref_NDB_No = fields[7].substring(1, fields[7].length() - 1);
            FoodDescription refFoodDescription = session.load(FoodDescription.class, Ref_NDB_No);
            item.setRefFoodDescription(refFoodDescription);
        }

        if (fields[8].length() > 2) item.setAdd_Nutr_Mark(fields[8].substring(1, fields[8].length() - 1));
        if (fields[9].length() > 0) item.setNum_Studies(Integer.parseInt(fields[9]));
        if (fields[10].length() > 0) item.setMin(Double.parseDouble(fields[10]));
        if (fields[11].length() > 0) item.setMax(Double.parseDouble(fields[11]));
        if (fields[12].length() > 0) item.setDF(Integer.parseInt(fields[12]));
        if (fields[13].length() > 0) item.setLow_EB(Double.parseDouble(fields[13]));
        if (fields[14].length() > 0) item.setUp_EB(Double.parseDouble(fields[14]));
        if (fields[15].length() > 2) item.setStat_cmt(fields[15].substring(1, fields[15].length() - 1));
        if (fields[16].length() > 0) item.setAddMod_Date(fields[16]);
        if (fields[17].length() > 0) item.setCC(fields[17]);

        foodDescription.addNutrientData(item);
        nutrientDefinition.addNutrientData(item);
        session.save(item);
    }
}
