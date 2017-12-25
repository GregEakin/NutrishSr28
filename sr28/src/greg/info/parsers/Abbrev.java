package greg.info.parsers;

import greg.info.entities.Abbreviations;
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

    // null Columns: [6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52]
    private static Abbreviations parseAbbreviation(final String[] fields) {

        Abbreviations item = new Abbreviations();
        item.setNDB_No(fields[0].substring(1, fields[0].length() - 1));
        item.setShrt_Desc(fields[1].substring(1, fields[1].length() - 1));
        if (fields[2].length() > 0) item.setWater(Double.parseDouble(fields[2]));
//        private Integer Energ_Kcal; //    Energ_Kcal N 10 Food energy (kcal/100 g)
        if (fields[3].length() > 0) item.setEnerg_Kcal(Integer.parseInt(fields[3]));
//        private Double Protein; //    Protein N 10.2 Protein (g/100 g)
        if (fields[4].length() > 0) item.setProtein(Double.parseDouble(fields[4]));
//        private Double Lipid_Tot; //    Lipid_Tot N 10.2 Total lipid (fat) (g/100 g)
        if (fields[5].length() > 0) item.setLipid_Tot(Double.parseDouble(fields[5]));
//        private Double Ash;//    Ash N 10.2 Ash (g/100 g)
        if (fields[6].length() > 0) item.setAsh(Double.parseDouble(fields[6]));
//        private Double Carbohydrt; //    Carbohydrt N 10.2 Carbohydrate, by difference (g/100 g)
        if (fields[7].length() > 0) item.setCarbohydrt(Double.parseDouble(fields[7]));
//        private Double Fiber_TD; //    Fiber_TD N 10.1 Total dietary fiber (g/100 g)
        if (fields[8].length() > 0) item.setFiber_TD(Double.parseDouble(fields[8]));
//        private Double Sugar_Tot; //    Sugar_Tot N 10.2 Total sugars (g/100 g)
        if (fields[9].length() > 0) item.setSugar_Tot(Double.parseDouble(fields[9]));
//        private Integer Calcium; //    Calcium N 10 Calcium (mg/100 g)
        if (fields[10].length() > 0) item.setCalcium(Integer.parseInt(fields[10]));
//        private Double Iron; //    Iron N 10.2 Iron (mg/100 g)
        if (fields[11].length() > 0) item.setIron(Double.parseDouble(fields[11]));
//        private Integer Magnesium;//    Magnesium N 10 Magnesium (mg/100 g)
        if (fields[12].length() > 0) item.setMagnesium(Integer.parseInt(fields[12]));
//        private Integer Phosphorus; //    Phosphorus N 10 Phosphorus (mg/100 g)
        if (fields[13].length() > 0) item.setPhosphorus(Integer.parseInt(fields[13]));
//        private Integer Potassium; //    Potassium N 10 Potassium (mg/100 g)
        if (fields[14].length() > 0) item.setPotassium(Integer.parseInt(fields[14]));
//        private Integer Sodium; //    Sodium N 10 Sodium (mg/100 g)
        if (fields[15].length() > 0) item.setSodium(Integer.parseInt(fields[15]));
//        private Double Zinc;//    Zinc N 10.2 Zinc (mg/100 g)
        if (fields[16].length() > 0) item.setZinc(Double.parseDouble(fields[16]));
//        private Double Copper;//    Copper N 10.3 Copper (mg/100 g)
        if (fields[17].length() > 0) item.setCopper(Double.parseDouble(fields[17]));
//        private Double Manganese;//    Manganese N 10.3 Manganese (mg/100 g)
        if (fields[18].length() > 0) item.setManganese(Double.parseDouble(fields[18]));
//        private Double Selenium;//    Selenium N 10.1 Selenium (μg/100 g)
        if (fields[19].length() > 0) item.setSelenium(Double.parseDouble(fields[19]));
//        private Double Vit_C;//    Vit_C N 10.1 Vitamin C (mg/100 g)
        if (fields[20].length() > 0) item.setVit_C(Double.parseDouble(fields[20]));
//        private Double Thiamin;//    Thiamin N 10.3 Thiamin (mg/100 g)
        if (fields[21].length() > 0) item.setThiamin(Double.parseDouble(fields[21]));
//        private Double Riboflavin;//    Riboflavin N 10.3 Riboflavin (mg/100 g)
        if (fields[22].length() > 0) item.setRiboflavin(Double.parseDouble(fields[22]));
//        private Double Niacin;//    Niacin N 10.3 Niacin (mg/100 g)
        if (fields[23].length() > 0) item.setNiacin(Double.parseDouble(fields[23]));
//        private Double Panto_acid;//    Panto_acid N 10.3 Pantothenic acid  (mg/100 g)
        if (fields[24].length() > 0) item.setPanto_acid(Double.parseDouble(fields[24]));
//        private Double Vit_B6;//    Vit_B6 N 10.3 Vitamin B6 (mg/100 g)
        if (fields[25].length() > 0) item.setVit_B6(Double.parseDouble(fields[25]));
//        private Integer Folate_Tot;//    Folate_Tot N 10 Folate, total (μg/100 g)
        if (fields[26].length() > 0) item.setFolate_Tot(Integer.parseInt(fields[26]));
//        private Integer Folic_acid;//    Folic_acid N 10 Folic acid (μg/100 g)
        if (fields[27].length() > 0) item.setFolic_acid(Integer.parseInt(fields[27]));
//        private Integer Food_Folate;//    Food_Folate N 10 Food folate (μg/100 g)
        if (fields[28].length() > 0) item.setFood_Folate(Integer.parseInt(fields[28]));
//        private Integer Folate_DFE;//    Folate_DFE N 10 Folate (μg dietary folate equivalents/100 g)
        if (fields[29].length() > 0) item.setFolate_DFE(Integer.parseInt(fields[29]));
//        private Integer Choline_Tot;//    Choline_Tot N 10 Choline, total (mg/100 g)
        if (fields[30].length() > 0) item.setCholine_Tot(Double.parseDouble(fields[30]));
//        private Double Vit_B12;//    Vit_B12 N 10.2 Vitamin B12 (μg/100 g)
        if (fields[31].length() > 0) item.setVit_B12(Double.parseDouble(fields[31]));
//        private Integer Vit_A_IU;//    Vit_A_IU N 10 Vitamin A (IU/100 g)
        if (fields[32].length() > 0) item.setVit_A_IU(Integer.parseInt(fields[32]));
//        private Integer Vit_A_RAE;//    Vit_A_RAE N 10 Vitamin A (μg retinol activity equivalents/100g)
        if (fields[33].length() > 0) item.setVit_A_RAE(Integer.parseInt(fields[33]));
//        private Integer Retinol;//    Retinol N 10 Retinol (μg/100 g)
        if (fields[34].length() > 0) item.setRetinol(Integer.parseInt(fields[34]));
//        private Integer Alpha_Carot;//    Alpha_Carot N 10 Alpha-carotene (μg/100 g)
        if (fields[35].length() > 0) item.setAlpha_Carot(Integer.parseInt(fields[35]));
//        private Integer Beta_Carot;//    Beta_Carot N 10 Beta-carotene (μg/100 g)
        if (fields[36].length() > 0) item.setBeta_Carot(Integer.parseInt(fields[36]));
//        private Integer Beta_Crypt;//    Beta_Crypt N 10 Beta-cryptoxanthin (μg/100 g)
        if (fields[37].length() > 0) item.setBeta_Crypt(Integer.parseInt(fields[37]));
//        private Integer Lycopene;//    Lycopene N 10 Lycopene (μg/100 g)
        if (fields[38].length() > 0) item.setLycopene(Integer.parseInt(fields[38]));
//        private Integer Lut_Zea; //    Lut+Zea N 10 Lutein+zeazanthin (μg/100 g)
        if (fields[39].length() > 0) item.setLut_Zea(Integer.parseInt(fields[39]));
//        private Double Vit_E;//    Vit_E N 10.2 Vitamin E (alpha-tocopherol) (mg/100 g)
        if (fields[40].length() > 0) item.setVit_E(Double.parseDouble(fields[40]));
//        private Double Vit_D_mcg;//    Vit_D_mcg N 10.1 Vitamin D (μg/100 g)
        if (fields[41].length() > 0) item.setVit_D_mcg(Double.parseDouble(fields[41]));
//        private Integer Vit_D_IU;//    Vit_D_IU N 10 Vitamin D (IU/100 g)
        if (fields[42].length() > 0) item.setVit_D_IU(Integer.parseInt(fields[42]));
//        private Double Vit_K;//    Vit_K N 10.1 Vitamin K (phylloquinone) (μg/100 g)
        if (fields[43].length() > 0) item.setVit_K(Double.parseDouble(fields[43]));
//        private Double FA_Sat;//    FA_Sat N 10.3 Saturated fatty acid (g/100 g)
        if (fields[44].length() > 0) item.setFA_Sat(Double.parseDouble(fields[44]));
//        private Double FA_Mono;//    FA_Mono N 10.3 Monounsaturated fatty acids (g/100 g)
        if (fields[45].length() > 0) item.setFA_Mono(Double.parseDouble(fields[45]));
//        private Double FA_Poly;//    FA_Poly N 10.3 Polyunsaturated fatty acids (g/100 g)
        if (fields[46].length() > 0) item.setFA_Poly(Double.parseDouble(fields[46]));
//        private Double Cholestrl;//    Cholestrl N 10.3 Cholesterol (mg/100 g)
        if (fields[47].length() > 0) item.setCholestrl(Double.parseDouble(fields[47]));
//        private Double GmWt_1;//    GmWt_1 N 9.2 First household weight for this item from the Weight file.‡
        if (fields[48].length() > 0) item.setGmWt_1(Double.parseDouble(fields[48]));
//        private String GmWt_Desc1;//    GmWt_Desc1 A 120 Description of household weight number 1.
        if (fields[49].length() > 2) item.setGmWt_Desc1(fields[49].substring(1, fields[49].length() - 1));
//        private Double GmWt_2;//    GmWt_2 N 9.2 Second household weight for this item from the Weight file.‡
        if (fields[50].length() > 0) item.setGmWt_2(Double.parseDouble(fields[50]));
//        private String GmWt_Desc2;//    GmWt_Desc2 A 120 Description of household weight number 2.
        if (fields[51].length() > 2) item.setGmWt_Desc2(fields[51].substring(1, fields[51].length() - 1));
//        private Integer Refuse_Pct;//    Refuse_Pct N 2 Percent refuse.
        if (fields[52].length() > 0) item.setRefuse_Pct(Integer.parseInt(fields[52]));

        return item;
    }
}
