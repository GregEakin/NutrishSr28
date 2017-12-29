package greg.info.dao.dataValadition;

import greg.info.dao.utilities.NutrishRepositoryExtension;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(NutrishRepositoryExtension.class)
public class NutGroupTests {
    private final Session session;

    NutGroupTests(Session session) {
        this.session = session;
    }

    @Test
    public void Test1() {

    }
}
