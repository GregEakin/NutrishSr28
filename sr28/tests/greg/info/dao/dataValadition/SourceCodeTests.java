package greg.info.dao.dataValadition;

import greg.info.dao.entities.NutrientData;
import greg.info.dao.entities.SourceCode;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class SourceCodeTests {
    private final Session session;

    SourceCodeTests(Session session) {
        this.session = session;
    }

    //  Links to the Nutrient Data file by Src_Cd
    @Test
    public void nutrientDataTest() {
        SourceCode sourceCode = session.load(SourceCode.class, "11");
        Set<NutrientData> nutrientDataSet = sourceCode.getNutrientDataSet();
        Assertions.assertEquals(822, nutrientDataSet.size());
    }
}


