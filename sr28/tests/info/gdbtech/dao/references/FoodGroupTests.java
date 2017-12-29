package info.gdbtech.dao.references;

import info.gdbtech.dao.entities.FoodDescription;
import info.gdbtech.dao.entities.FoodGroup;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class FoodGroupTests {
    private final Session session;

    FoodGroupTests(Session session) {
        this.session = session;
    }

    //  Links to the Food Description file by FdGrp_Cd
    @Test
    public void foodDescriptionTest() {
        FoodGroup foodGroup = session.load(FoodGroup.class, "0400");

        Set<FoodDescription> foodDescriptionSet = foodGroup.getFoodDescriptionSet();
        Assertions.assertEquals(220, foodDescriptionSet.size());
    }
}

