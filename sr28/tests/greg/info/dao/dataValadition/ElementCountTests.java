package greg.info.dao.dataValadition;

import greg.info.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(NutrishRepositoryExtension.class)
public class ElementCountTests {
    private final Session session;

    ElementCountTests(Session session) {
        this.session = session;
    }

    @Test
    public void Test1() {

    }
}
