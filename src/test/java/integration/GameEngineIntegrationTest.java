package integration;

import onerme.factory.concreteFactory.RockPaperScissorsFactory;
import onerme.model.player.ComputerPlayer;
import onerme.model.player.HumanPlayer;
import onerme.model.player.Player;
import onerme.service.GameEngine;
import onerme.utilities.FakeInputProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameEngineIntegrationTest extends ReusableMethods {

    private ResourceBundle messages;
    String demoName=generateRandomString(minNameLength,maxNameLenght);

    @BeforeEach
    void setUp() {
        messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
    }

    @Test
    void testGameEngineWithHumanAndComputer() {
        String[] arr= genarateRandomMoveArray();
        FakeInputProvider fakeInputProvider = new FakeInputProvider(arr);

        Player humanPlayer = new HumanPlayer(demoName, new RockPaperScissorsFactory(),fakeInputProvider);
        Player computerPlayer = new ComputerPlayer("Computer", new RockPaperScissorsFactory());

        int totalRounds = arr.length;
        GameEngine gameEngine = new GameEngine(humanPlayer, computerPlayer, totalRounds, messages);

        gameEngine.play();

        int player1Score = gameEngine.getPlayer1Score();
        int player2Score = gameEngine.getPlayer2Score();
        int drawCount = gameEngine.getDrawCount();

        assertEquals(totalRounds, player1Score + player2Score + drawCount, "Total rounds should equal the sum of player scores and draws.");
    }

    @Test
    void testGameEngineWithComputerVsComputer() {
        Player computer1 = new ComputerPlayer("Computer 1", new RockPaperScissorsFactory());
        Player computer2 = new ComputerPlayer("Computer 2", new RockPaperScissorsFactory());

        int totalRounds = generateRandomInt(minRound,maxRound);
        GameEngine gameEngine = new GameEngine(computer1, computer2, totalRounds, messages);

        gameEngine.play();

        int player1Score = gameEngine.getPlayer1Score();
        int player2Score = gameEngine.getPlayer2Score();
        int drawCount = gameEngine.getDrawCount();

        assertEquals(totalRounds, player1Score + player2Score + drawCount, "Total rounds should equal the sum of player scores and draws.");
    }
}
