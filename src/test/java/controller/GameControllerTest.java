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
        language = "1";
        gameChose = "1";
        name = generateRandomString(minNameLength, maxNameLenght);
        roundCount = "1";
        moveChose1 = generateRandomInt(1, 3) + "";
        endGame = "2";

        FakeInputProvider inputProvider = new FakeInputProvider(
                language, gameChose, name, roundCount, moveChose1, endGame
        );

        Language.messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
        GameController gameController = new GameController(inputProvider);

        gameController.start();

        assertEquals(Locale.ENGLISH, Language.messages.getLocale());
    }

    @Test
    void testStart_PlayComputerVsComputer() {
        FakeInputProvider inputProvider = new FakeInputProvider(
                "1",
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
