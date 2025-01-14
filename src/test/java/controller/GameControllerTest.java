package controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import onerme.controller.GameController;
import onerme.utilities.FakeInputProvider;
import onerme.service.Language;
import onerme.service.ResultEvaluator;
import onerme.service.GameEngine;
import onerme.model.player.Player;
import onerme.model.player.ComputerPlayer;
import onerme.factory.concreteFactory.RockPaperScissorsFactory;
import utilities.ReusableMethods;

import java.util.ResourceBundle;
import java.util.Locale;

public class GameControllerTest extends ReusableMethods {

    private void setLocale(String languageChoice) {
        if ("1".equals(languageChoice)) {
            Language.messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
            assertEquals(Locale.ENGLISH, Language.messages.getLocale());
        } else {
            Language.messages = ResourceBundle.getBundle("messages", Locale.GERMAN);
            assertEquals(Locale.GERMAN, Language.messages.getLocale());
        }
    }

    @Test
    void start_ShouldInitializeWithCorrectLanguage_WhenPlayingHumanVsComputer() {
        String languageChoice = generateRandomInt(1, 2) + "";
        String gameChoice = modePlayerAgainComputers;
        String playerName = generateRandomString(minNameLength, maxNameLenght);
        String roundCount = "1";
        String moveChoice = generateRandomInt(1, 3) + "";
        String endGame = gameEnd;

        FakeInputProvider inputProvider = new FakeInputProvider(
                languageChoice, gameChoice, playerName, roundCount, moveChoice, endGame
        );

        setLocale(languageChoice);

        GameController gameController = new GameController(inputProvider);
        gameController.start();

        setLocale(languageChoice);
    }

    @Test
    void start_ShouldInitializeWithCorrectLanguage_WhenPlayingComputerVsComputer() {
        String languageChoice = languageEnglish;
        FakeInputProvider inputProvider = new FakeInputProvider(
                languageChoice,
                modeComputerAgainComputers,
                "10",
                "2"
        );

        Language.messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
        GameController gameController = new GameController(inputProvider);
        gameController.start();

        assertEquals(Locale.ENGLISH, Language.messages.getLocale());

        Player player1 = new ComputerPlayer("Computer 1", new RockPaperScissorsFactory());
        Player player2 = new ComputerPlayer("Computer 2", new RockPaperScissorsFactory());

        GameEngine gameEngine = new GameEngine(player1, player2, 10, Language.messages);
        gameEngine.play();

        ResultEvaluator resultEvaluator = new ResultEvaluator();
        resultEvaluator.evaluate(player1, player2, gameEngine);
    }

}
