import onerme.factory.concreteFactory.RockPaperScissorsFactory;
import onerme.model.player.ComputerPlayer;
import onerme.model.player.HumanPlayer;
import onerme.model.player.Player;
import onerme.service.GameEngine;
import onerme.service.Language;
import onerme.service.ResultEvaluator;
import onerme.utilities.FakeInputProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResultEvaluatorTest extends ReusableMethods {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private ResultEvaluator resultEvaluator;
    private Player player1;
    private Player player2;
    private GameEngine gameEngine;
    ConfigReader configReader = new ConfigReader(getFilePathEnglish);
    String randomName=generateRandomString(minNameLength,maxNameLenght);
    int randomRoundCount= generateRandomInt(minRound+3,maxRound);

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        Language.messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
        resultEvaluator = new ResultEvaluator();

        FakeInputProvider fakeInputProvider = new FakeInputProvider(randomName);

        player1 = new HumanPlayer(randomName, new RockPaperScissorsFactory(),fakeInputProvider);
        player2 = new ComputerPlayer("Computer", new RockPaperScissorsFactory());

        gameEngine = new GameEngine(player1, player2, randomRoundCount, Language.messages);
    }

    @Test
    void testEvaluate_Player1Wins() {
        gameEngine.setPlayer1Score(randomRoundCount-2);
        gameEngine.setPlayer2Score(1);
        gameEngine.setDrawCount(1);

        resultEvaluator.evaluate(player1, player2, gameEngine);

        String consoleOutput = outputStream.toString();

        String formattedMessage = MessageFormat.format(Language.messages.getString("winnerGame"), player1.getName());

        assertTrue(consoleOutput.contains(formattedMessage), "Player 1 win message should be displayed.");
    }


    @Test
    void testEvaluate_Draw() {
        gameEngine.setPlayer1Score(minRound);
        gameEngine.setPlayer2Score(minRound);
        gameEngine.setDrawCount(minRound+1);

        resultEvaluator.evaluate(player1, player2, gameEngine);

        String formattedMessage = MessageFormat.format(Language.messages.getString("tieRound"), player1.getName());

        String consoleOutput = outputStream.toString();

        assertTrue(consoleOutput.contains(formattedMessage), "Draw message should be displayed.");
    }

    @Test
    void testEvaluate_ComputerVsComputer() {
        player1 = new ComputerPlayer("Computer1", new RockPaperScissorsFactory());
        player2 = new ComputerPlayer("Computer2", new RockPaperScissorsFactory());


        gameEngine = new GameEngine(player1, player2, 3, Language.messages);


        gameEngine.setPlayer1Score(minRound+1);
        gameEngine.setPlayer2Score(minRound+1);
        gameEngine.setDrawCount(minRound);


        resultEvaluator.evaluate(player1, player2, gameEngine);

        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains(configReader.getProperty("computerBattle")), "Computer vs Computer message should be displayed.");
    }

    @Test
    void testEvaluate_ComputerBeatsPlayer() {
        gameEngine.setPlayer1Score(minRound);
        gameEngine.setPlayer2Score(minRound+1);
        gameEngine.setDrawCount(minRound);

        resultEvaluator.evaluate(player1, player2, gameEngine);

        String formattedMessage = MessageFormat.format(Language.messages.getString("winnerGame"), player2.getName());


        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains(formattedMessage), "Computer win message should be displayed.");
    }
}
