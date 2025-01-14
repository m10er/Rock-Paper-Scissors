package service;

import static org.junit.jupiter.api.Assertions.*;

import onerme.service.Language;
import onerme.utilities.FakeInputProvider;
import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;

import java.util.Locale;

public class LanguageTest extends ReusableMethods {

    @Test
    void testGetLanguage_ValidChoice_English() {
        FakeInputProvider inputProvider = new FakeInputProvider(languageEnglish);
        Language language = new Language(inputProvider);

        Locale locale = language.getLanguage();

        assertEquals(Locale.ENGLISH, locale);
    }

    @Test
    void testGetLanguage_ValidChoice_German() {
        FakeInputProvider inputProvider = new FakeInputProvider(languageDeutsch);
        Language language = new Language(inputProvider);

        Locale locale = language.getLanguage();

        assertEquals(Locale.GERMAN, locale);
    }

    @Test
    void testGetLanguage_InvalidChoice() {
        FakeInputProvider inputProvider = new FakeInputProvider((maxChooseCount+1)+"", "1");
        Language language = new Language(inputProvider);

        Locale locale = language.getLanguage();

        assertEquals(Locale.ENGLISH, locale);
    }
}
