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
    String language;
    String gameChose;
    String name;
    String roundCount;
    String moveChose1;
    String endGame;

    @Test
    void testStart_PlayHumanVsComputer() {
        String random=generateRandomInt(1,2)+"";
        language = random;
        gameChose = modePlayerAgainComputers;
        name = generateRandomString(minNameLength, maxNameLenght);
        roundCount = "1";
        moveChose1 = generateRandomInt(1, 3) + "";
        endGame = gameEnd;

        FakeInputProvider inputProvider = new FakeInputProvider(
                language, gameChose, name, roundCount, moveChose1, endGame
        );

        if (random.equals("1")){
            Language.messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
            assertEquals(Locale.ENGLISH, Language.messages.getLocale());
        }
        else {
            Language.messages = ResourceBundle.getBundle("messages", Locale.GERMAN);
            assertEquals(Locale.GERMAN, Language.messages.getLocale());
        }

        GameController gameController = new GameController(inputProvider);

        gameController.start();

        if (random.equals("1")){
            assertEquals(Locale.ENGLISH, Language.messages.getLocale());
        }else {
            assertEquals(Locale.GERMAN, Language.messages.getLocale());
        }

    }

    @Test
    void testStart_PlayComputerVsComputer() {
        FakeInputProvider inputProvider = new FakeInputProvider(
                languageEnglish,
                "3",
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
