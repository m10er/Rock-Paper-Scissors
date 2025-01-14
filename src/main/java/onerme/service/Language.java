package onerme.service;

import onerme.utilities.InputProvider;
import onerme.utilities.ValidateInput;

import java.util.Locale;
import java.util.ResourceBundle;


public class Language {
    public static ResourceBundle messages;
     InputProvider inputProvider;
     ValidateInput validateInput;

    public Language(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
        this.validateInput = new ValidateInput(inputProvider);
    }

    public Locale getLanguage(){

        System.out.println("Select Language / Sprache wählen: 1) English  2) Deutsch");
        int languageChoice = validateInput.getValidatedIntInput(1, 2, "Invalid choice. Please enter 1 or 2.");
        Locale locale = (languageChoice == 2) ? Locale.GERMAN : Locale.ENGLISH;
        messages = ResourceBundle.getBundle("messages", locale);
        System.out.println(messages.getString("welcome"));
        return locale;
    }
}