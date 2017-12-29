package info.gdbtech.dao.dataValadition;

import info.gdbtech.dao.entities.FoodDescription;
import info.gdbtech.dao.entities.FoodGroup;
import info.gdbtech.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class NutGroupTests {
    private final Session session;

    NutGroupTests(Session session) {
        this.session = session;
    }

    @Test
    public void Test1() {
        FoodGroup foodGroup = session.load(FoodGroup.class, "1200");
        System.out.println(foodGroup.getFdGrp_Cd() + ", " + foodGroup.getFdGrp_Desc());
        Set<FoodDescription> foodDescriptionSet = foodGroup.getFoodDescriptionSet();
        for (FoodDescription foodDescription : foodDescriptionSet) {
            System.out.println("  " + foodDescription.getNDB_No() + " " + foodDescription.getShrt_Desc());
        }
    }
}
