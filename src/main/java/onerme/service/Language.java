package onerme.service;

import java.util.Locale;
import java.util.ResourceBundle;

import static onerme.utilities.ValidateInput.getValidatedIntInput;

public class Language {
    public static ResourceBundle messages;

    public Locale getLanguage(){

        System.out.println("Select Language / Sprache wählen: 1) English  2) Deutsch");
        int languageChoice = getValidatedIntInput(1, 2, "Invalid choice. Please enter 1 or 2.");
        Locale locale = (languageChoice == 2) ? Locale.GERMAN : Locale.ENGLISH;
        messages = ResourceBundle.getBundle("messages", locale);
        System.out.println(messages.getString("welcome"));
        return locale;
    }
}
