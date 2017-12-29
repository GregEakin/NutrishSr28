package greg.info.dao.dataValadition;

import greg.info.dao.entities.FoodDescription;
import greg.info.dao.entities.Language;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

@ExtendWith(NutrishRepositoryExtension.class)
public class LanguageTests {
    private final Session session;

    LanguageTests(Session session) {
        this.session = session;
    }

    //  Links to the Food Description file by the NDB_No field
    @Test
    public void foodDescriptionTest() {
        Language language = session.load(Language.class, "A0143");
        Set<FoodDescription> foodDescriptionSet = language.getFoodDescriptionSet();
        Assertions.assertEquals(232, foodDescriptionSet.size());
    }

    //  Links to LanguaL Factors Description file by the Factor_Code field
    @Test
    public void LanguageSetTest() {
        FoodDescription foodDescription = session.load(FoodDescription.class, "02014");
        Set<Language> languageSet = foodDescription.getLanguageSet();
        Assertions.assertEquals(13, languageSet.size());
    }

}

