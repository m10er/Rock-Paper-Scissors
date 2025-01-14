package service;

import static org.junit.jupiter.api.Assertions.*;

import onerme.service.Language;
import onerme.utilities.FakeInputProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;

import java.util.Locale;

public class LanguageTest extends ReusableMethods {


    private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;

    private Language createLanguageWithInput(String... inputs) {
        return new Language(new FakeInputProvider(inputs));
    }

    @BeforeEach
    void resetLocale() {
        Language.messages = null;
    }

    @Test
    void getLanguage_WhenEnglishChosen_ShouldReturnEnglishLocale() {
        Language language = createLanguageWithInput(languageEnglish);
        Locale locale = language.getLanguage();
        assertEquals(Locale.ENGLISH, locale);
    }

    @Test
    void getLanguage_WhenGermanChosen_ShouldReturnGermanLocale() {
        Language language = createLanguageWithInput(languageDeutsch);
        Locale locale = language.getLanguage();
        assertEquals(Locale.GERMAN, locale);
    }

    @Test
    void getLanguage_WhenInvalidChoiceGiven_ShouldDefaultToEnglishLocale() {
        Language language = createLanguageWithInput(String.valueOf(maxChooseCount + 1), "1");
        Locale locale = language.getLanguage();
        assertEquals(DEFAULT_LOCALE, locale);
    }

    @Test
    void getLanguage_WhenAlphabeticInputGiven_ShouldDefaultToEnglishLocale() {
        Language language = createLanguageWithInput(generateRandomString(1,3), minChooseCount+"");
        Locale locale = language.getLanguage();
        assertEquals(DEFAULT_LOCALE, locale);
    }

    @Test
    void getLanguage_WhenEmptyInputGiven_ShouldDefaultToEnglishLocale() {
        Language language = createLanguageWithInput("",minChooseCount+"");
        Locale locale = language.getLanguage();
        assertEquals(DEFAULT_LOCALE, locale);
    }
}
