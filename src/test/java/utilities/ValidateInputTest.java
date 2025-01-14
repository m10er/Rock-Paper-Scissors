package utilities;

import onerme.service.Language;
import onerme.utilities.FakeInputProvider;
import onerme.utilities.ValidateInput;
import org.junit.jupiter.api.Test;


import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

class ValidateInputTest extends ReusableMethods {

    @Test
    void testGetValidatedIntInput_ValidInput() {
        int random= generateRandomInt(minChooseCount, maxChooseCount);
        FakeInputProvider inputProvider = new FakeInputProvider(String.valueOf(random));
        ValidateInput validateInput = new ValidateInput(inputProvider);

        int result = validateInput.getValidatedIntInput(minChooseCount, maxChooseCount, "Invalid input");
        assertEquals(random, result);
    }

    @Test
    void testGetValidatedIntInput_InvalidThenValidInput() {

        FakeInputProvider inputProvider = new FakeInputProvider(
                generateRandomString(minNameLength,maxNameLenght),
                generateRandomString(minNameLength, maxNameLenght),
                minNameLength+""
        );
        ValidateInput validateInput = new ValidateInput(inputProvider);


        int result = validateInput.getValidatedIntInput(minNameLength, maxNameLenght, "Invalid input");


        assertEquals(minNameLength, result);
    }

    @Test
    void testGetValidatedStringInput_ValidInput() {
        String random= generateRandomString(minNameLength,maxNameLenght);
        FakeInputProvider inputProvider = new FakeInputProvider(random);
        ValidateInput validateInput = new ValidateInput(inputProvider);

        String result = validateInput.getValidatedStringInput();
        assertEquals(random, result);
    }

    @Test
    void testGetValidatedStringInput_InvalidThenValidInput() {

        String validName= generateRandomString(minNameLength,maxNameLenght);
        FakeInputProvider inputProvider = new FakeInputProvider("",
                generateRandomInt(minNameLength,maxNameLenght)+"", validName);
        ValidateInput validateInput = new ValidateInput(inputProvider);

        Language.messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
        String result = validateInput.getValidatedStringInput();
        assertEquals(validName, result);
    }

    @Test
    void testGetValidatedYesNoInput_YesInput() {
        FakeInputProvider inputProvider = new FakeInputProvider("1");
        ValidateInput validateInput = new ValidateInput(inputProvider);

        boolean result = validateInput.getValidatedYesNoInput("Do you want to continue?");
        assertTrue(result);
    }

    @Test
    void testGetValidatedYesNoInput_NoInput() {
        FakeInputProvider inputProvider = new FakeInputProvider("2");
        ValidateInput validateInput = new ValidateInput(inputProvider);

        boolean result = validateInput.getValidatedYesNoInput("Do you want to continue?");
        assertFalse(result);
    }

    @Test
    void testGetValidatedYesNoInput_InvalidThenValidInput() {
        FakeInputProvider inputProvider = new FakeInputProvider(generateRandomString(minChooseCount, maxChooseCount),
                generateRandomInt(maxChooseCount+1,maxChooseCount+100)+"", "1");
        ValidateInput validateInput = new ValidateInput(inputProvider);

        Language.messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);

        boolean result = validateInput.getValidatedYesNoInput("Do you want to continue?");
        assertTrue(result);
    }
}
