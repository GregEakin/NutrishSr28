package info.gdbtech.dao.dataValadition;

import info.gdbtech.dao.entities.*;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ExtendWith(NutrishRepositoryExtension.class)
public class FoodSearchTests {
    private final Session session;

    FoodSearchTests(Session session) {
        this.session = session;
    }

    @Test
    public void Test1() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "01001");
        System.out.println("Basic Report: " + foodDescription.getNDB_No()
                + ", " + foodDescription.getLong_Desc());

        System.out.println("   Weight: Value per 100 g");
        Set<Weight> weightSet = foodDescription.getWeightSet();
        for (Weight weight : weightSet) {
            System.out.println("   Weight: " + weight.getMsre_Desc() + ", " + weight.getAmount() + " x " + weight.getGm_Wgt() + " g");
        }

        Set<NutrientData> nutrientDataSet = foodDescription.getNutrientDataSet();
        Comparator<NutrientData> nutrientDataComparator = Comparator.comparingInt(o -> o.getNutrientDataKey().getNutrientDefinition().getSR_Order());
        List<NutrientData> data = nutrientDataSet.stream().sorted(nutrientDataComparator).collect(Collectors.toList());
        for (NutrientData nutrientData : data) {
            NutrientDataKey nutrientDataKey = nutrientData.getNutrientDataKey();
            NutrientDefinition nutrientDefinition = nutrientDataKey.getNutrientDefinition();

            System.out.println("   NutData: " + nutrientDefinition.getSR_Order()
                    + ", " + nutrientDefinition.getNutrDesc()
                    + " = " + nutrientData.getNutr_Val()
                    + " " + nutrientDefinition.getUnits());
        }
    }
}

