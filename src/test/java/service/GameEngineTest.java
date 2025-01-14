package service;

import onerme.model.move.Move;
import onerme.model.move.Paper;
import onerme.model.move.Rock;
import onerme.model.move.Scissors;
import onerme.model.player.Player;
import onerme.service.GameEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest extends ReusableMethods {

    private Player mockPlayer1;
    private Player mockPlayer2;
    private ResourceBundle messages;
    String randomName1=generateRandomString(minNameLength,maxNameLenght);
    String randomName2=generateRandomString(minNameLength,maxNameLenght);

    @BeforeEach
    void setUp() {
        messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);

        mockPlayer1 = new Player() {
            @Override
            public String getName() {
                return randomName1;
            }

            @Override
            public Move makeMove() {
                return new Rock();
            }
        };

        mockPlayer2 = new Player() {
            @Override
            public String getName() {
                return randomName2;
            }

            @Override
            public Move makeMove() {
                return new Scissors();
            }
        };
    }

    @Test
    void testGameEngine_Player1Wins() {
        GameEngine gameEngine = new GameEngine(mockPlayer1, mockPlayer2, 3, messages);
        gameEngine.play();

        assertEquals(3, gameEngine.getPlayer1Score(), "Player 1 should have won all rounds.");
        assertEquals(0, gameEngine.getPlayer2Score(), "Player 2 should not win any round.");
        assertEquals(0, gameEngine.getDrawCount(), "There should be no draws.");
    }

    @Test
    void testGameEngine_Draws() {
        // Both players play Rock to ensure all rounds are draws
        mockPlayer2 = new Player() {
            @Override
            public String getName() {
                return randomName2;
            }

            @Override
            public Move makeMove() {
                return new Rock();
            }
        };

        GameEngine gameEngine = new GameEngine(mockPlayer1, mockPlayer2, 3, messages);
        gameEngine.play();

        assertEquals(0, gameEngine.getPlayer1Score(), "Player 1 should not win any round.");
        assertEquals(0, gameEngine.getPlayer2Score(), "Player 2 should not win any round.");
        assertEquals(3, gameEngine.getDrawCount(), "All rounds should be draws.");
    }

    @Test
    void testGameEngine_Player2Wins() {
        // Player 2 plays Paper to beat Player 1's Rock
        mockPlayer2 = new Player() {
            @Override
            public String getName() {
                return randomName2;
            }

            @Override
            public Move makeMove() {
                return new Paper();
            }
        };

        GameEngine gameEngine = new GameEngine(mockPlayer1, mockPlayer2, 3, messages);
        gameEngine.play();

        assertEquals(0, gameEngine.getPlayer1Score(), "Player 1 should not win any round.");
        assertEquals(3, gameEngine.getPlayer2Score(), "Player 2 should win all rounds.");
        assertEquals(0, gameEngine.getDrawCount(), "There should be no draws.");
    }

}
