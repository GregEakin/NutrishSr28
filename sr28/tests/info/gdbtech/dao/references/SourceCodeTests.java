package info.gdbtech.dao.references;

import info.gdbtech.dao.entities.NutrientData;
import info.gdbtech.dao.entities.SourceCode;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
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


