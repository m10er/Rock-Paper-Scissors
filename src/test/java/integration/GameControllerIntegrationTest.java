package integration;

import onerme.controller.GameController;
import onerme.utilities.FakeInputProvider;
import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameControllerIntegrationTest extends ReusableMethods {
    private ResourceBundle messages;
    private ByteArrayOutputStream outputStream;
    String[] arr = genarateRandomMoveArray();
    String name = generateRandomString(minNameLength,maxNameLenght);

    @Test
    void testGameControllerIntegration_HumanVsComputer() {
        FakeInputProvider inputProvider = new FakeInputProvider(
                languageEnglish,
                modePlayerAgainComputers,
                name,
                arr.length+"",
                gameEnd
        );

        messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        GameController gameController = new GameController(inputProvider);
        gameController.start();

        String consoleOutput = outputStream.toString();

        assertTrue(consoleOutput.contains(messages.getString("welcome")), "Welcome message should be displayed.");
        assertTrue(consoleOutput.contains(messages.getString("finalScore")), "Final score should be displayed.");
        assertTrue(consoleOutput.contains(messages.getString("playAgain")), "playAgain should be displayed.");

        System.setOut(System.out);
    }

    @Test
    void testGameControllerIntegration_HumanVsComputeronGerman() {
        FakeInputProvider inputProvider = new FakeInputProvider(
                languageDeutsch,
                modePlayerAgainComputers,
                name,
                arr.length+"",
                gameEnd
        );

        messages = ResourceBundle.getBundle("messages", Locale.GERMAN);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        GameController gameController = new GameController(inputProvider);
        gameController.start();

        String consoleOutput = outputStream.toString();

        assertTrue(consoleOutput.contains(messages.getString("welcome")), "Welcome message should be displayed.");
        assertTrue(consoleOutput.contains(messages.getString("finalScore")), "Final score should be displayed.");
        assertTrue(consoleOutput.contains(messages.getString("playAgain")), "playAgain should be displayed.");

        System.setOut(System.out);
    }

    @Test
    void testGameControllerIntegration_ComputerVsComputer() {
        String languageChoice = generateRandomInt(1,2) + "";
        FakeInputProvider inputProvider = new FakeInputProvider(
                languageChoice,
                modeComputerAgainComputers,
                gameEnd
        );

        if (languageChoice.equals("1")) {
            messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
        } else {
            messages = ResourceBundle.getBundle("messages", Locale.GERMAN);
        }

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        GameController gameController = new GameController(inputProvider);
        gameController.start();

        String consoleOutput = outputStream.toString();

        assertTrue(consoleOutput.contains(messages.getString("finalScore")), "Final score should be displayed.");
        assertTrue(consoleOutput.contains(messages.getString("playAgain")), "playAgain should be displayed.");

        System.setOut(System.out);
    }

    @Test
    void testGameControllerIntegration_newGame() {
        FakeInputProvider inputProvider = new FakeInputProvider(
                languageEnglish,
                modeComputerAgainComputers,
                gameNew,
                modeComputerAgainComputers,
                gameEnd
        );

        messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        GameController gameController = new GameController(inputProvider);
        gameController.start();

        String consoleOutput = outputStream.toString();

        assertTrue(consoleOutput.contains(messages.getString("finalScore")), "Final score should be displayed.");
        assertTrue(consoleOutput.contains(messages.getString("playAgain")), "playAgain should be displayed.");
        assertTrue(consoleOutput.contains(messages.getString("chooseMode")), "chooseMode should be displayed.");

        System.setOut(System.out);
    }
}
