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

package dev.eakin.flatfile.parsers;

import dev.eakin.flatfile.entities.Abbreviations;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Abbrev {
    public static final String Filename = ".\\data\\ABBREV.txt";

    public static void parseFile(final Session session) throws IOException {
        Path path = Paths.get(Filename);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.ISO_8859_1)) {
            lines.forEach((line) -> parseLine(session, line));
        }
    }

    private static void parseLine(final Session session, final String line) {
        String[] fields = line.split("\\^", -1);
        Abbreviations item = parseAbbreviation(fields);
        session.save(item);
    }

    private static Abbreviations parseAbbreviation(final String[] fields) {

        Abbreviations item = new Abbreviations();
        item.setNDB_No(fields[0].substring(1, fields[0].length() - 1));
        item.setShrt_Desc(fields[1].substring(1, fields[1].length() - 1));
        if (fields[2].length() > 0) item.setWater(Double.parseDouble(fields[2]));
        if (fields[3].length() > 0) item.setEnerg_Kcal(Integer.parseInt(fields[3]));
        if (fields[4].length() > 0) item.setProtein(Double.parseDouble(fields[4]));
        if (fields[5].length() > 0) item.setLipid_Tot(Double.parseDouble(fields[5]));
        if (fields[6].length() > 0) item.setAsh(Double.parseDouble(fields[6]));
        if (fields[7].length() > 0) item.setCarbohydrt(Double.parseDouble(fields[7]));
        if (fields[8].length() > 0) item.setFiber_TD(Double.parseDouble(fields[8]));
        if (fields[9].length() > 0) item.setSugar_Tot(Double.parseDouble(fields[9]));
        if (fields[10].length() > 0) item.setCalcium(Integer.parseInt(fields[10]));
        if (fields[11].length() > 0) item.setIron(Double.parseDouble(fields[11]));
        if (fields[12].length() > 0) item.setMagnesium(Integer.parseInt(fields[12]));
        if (fields[13].length() > 0) item.setPhosphorus(Integer.parseInt(fields[13]));
        if (fields[14].length() > 0) item.setPotassium(Integer.parseInt(fields[14]));
        if (fields[15].length() > 0) item.setSodium(Integer.parseInt(fields[15]));
        if (fields[16].length() > 0) item.setZinc(Double.parseDouble(fields[16]));
        if (fields[17].length() > 0) item.setCopper(Double.parseDouble(fields[17]));
        if (fields[18].length() > 0) item.setManganese(Double.parseDouble(fields[18]));
        if (fields[19].length() > 0) item.setSelenium(Double.parseDouble(fields[19]));
        if (fields[20].length() > 0) item.setVit_C(Double.parseDouble(fields[20]));
        if (fields[21].length() > 0) item.setThiamin(Double.parseDouble(fields[21]));
        if (fields[22].length() > 0) item.setRiboflavin(Double.parseDouble(fields[22]));
        if (fields[23].length() > 0) item.setNiacin(Double.parseDouble(fields[23]));
        if (fields[24].length() > 0) item.setPanto_acid(Double.parseDouble(fields[24]));
        if (fields[25].length() > 0) item.setVit_B6(Double.parseDouble(fields[25]));
        if (fields[26].length() > 0) item.setFolate_Tot(Integer.parseInt(fields[26]));
        if (fields[27].length() > 0) item.setFolic_acid(Integer.parseInt(fields[27]));
        if (fields[28].length() > 0) item.setFood_Folate(Integer.parseInt(fields[28]));
        if (fields[29].length() > 0) item.setFolate_DFE(Integer.parseInt(fields[29]));
        if (fields[30].length() > 0) item.setCholine_Tot(Double.parseDouble(fields[30]));
        if (fields[31].length() > 0) item.setVit_B12(Double.parseDouble(fields[31]));
        if (fields[32].length() > 0) item.setVit_A_IU(Integer.parseInt(fields[32]));
        if (fields[33].length() > 0) item.setVit_A_RAE(Integer.parseInt(fields[33]));
        if (fields[34].length() > 0) item.setRetinol(Integer.parseInt(fields[34]));
        if (fields[35].length() > 0) item.setAlpha_Carot(Integer.parseInt(fields[35]));
        if (fields[36].length() > 0) item.setBeta_Carot(Integer.parseInt(fields[36]));
        if (fields[37].length() > 0) item.setBeta_Crypt(Integer.parseInt(fields[37]));
        if (fields[38].length() > 0) item.setLycopene(Integer.parseInt(fields[38]));
        if (fields[39].length() > 0) item.setLut_Zea(Integer.parseInt(fields[39]));
        if (fields[40].length() > 0) item.setVit_E(Double.parseDouble(fields[40]));
        if (fields[41].length() > 0) item.setVit_D_mcg(Double.parseDouble(fields[41]));
        if (fields[42].length() > 0) item.setVit_D_IU(Integer.parseInt(fields[42]));
        if (fields[43].length() > 0) item.setVit_K(Double.parseDouble(fields[43]));
        if (fields[44].length() > 0) item.setFA_Sat(Double.parseDouble(fields[44]));
        if (fields[45].length() > 0) item.setFA_Mono(Double.parseDouble(fields[45]));
        if (fields[46].length() > 0) item.setFA_Poly(Double.parseDouble(fields[46]));
        if (fields[47].length() > 0) item.setCholestrl(Double.parseDouble(fields[47]));
        if (fields[48].length() > 0) item.setGmWt_1(Double.parseDouble(fields[48]));
        if (fields[49].length() > 2) item.setGmWt_Desc1(fields[49].substring(1, fields[49].length() - 1));
        if (fields[50].length() > 0) item.setGmWt_2(Double.parseDouble(fields[50]));
        if (fields[51].length() > 2) item.setGmWt_Desc2(fields[51].substring(1, fields[51].length() - 1));
        if (fields[52].length() > 0) item.setRefuse_Pct(Integer.parseInt(fields[52]));

        return item;
    }
}
