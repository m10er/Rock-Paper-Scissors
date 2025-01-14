package model.player;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import onerme.model.player.HumanPlayer;
import onerme.factory.abstractFactory.MoveFactory;
import onerme.factory.concreteFactory.RockPaperScissorsFactory;
import onerme.model.move.Move;
import onerme.utilities.FakeInputProvider;
import utilities.ReusableMethods;

public class HumanPlayerTest extends ReusableMethods {

    String randomName = generateRandomString(minNameLength, maxNameLenght);

    private HumanPlayer createHumanPlayer(String... inputs) {
        FakeInputProvider inputProvider = new FakeInputProvider(inputs);
        MoveFactory moveFactory = new RockPaperScissorsFactory();
        return new HumanPlayer(randomName, moveFactory, inputProvider);
    }

    @Test
    void makeMove_WhenInputIsValid_ShouldReturnCorrespondingMove() {
        HumanPlayer player = createHumanPlayer(minChooseCount+"");

        Move move = player.makeMove();

        assertNotNull(move, "Move should not be null for valid input.");
        assertEquals(move1, move.getName(), "Move name should match the expected value for input '1'.");
    }

    @Test
    void makeMove_WhenInputIsInvalid_ShouldFallbackToValidMove() {
        HumanPlayer player = createHumanPlayer("5", "2");

        Move move = player.makeMove();

        assertNotNull(move, "Move should not be null for invalid input.");
        assertEquals(move2, move.getName(), "Move name should default to the fallback value for invalid input.");
    }

    @Test
    void makeMove_WhenInputIsEmpty_ShouldFallbackToDefaultMove() {
        HumanPlayer player = createHumanPlayer("", minChooseCount+"");

        Move move = player.makeMove();

        assertNotNull(move, "Move should not be null for empty input.");
        assertEquals(move1, move.getName(), "Move name should match the default value for empty input.");
    }

    @Test
    void makeMove_WhenInputIsAlphabetic_ShouldFallbackToDefaultMove() {
        HumanPlayer player = createHumanPlayer(generateRandomString(1,3), minChooseCount+"");

        Move move = player.makeMove();

        assertNotNull(move, "Move should not be null for alphabetic input.");
        assertEquals(move1, move.getName(), "Move name should match the default value for alphabetic input.");
    }

    @Test
    void getName_ShouldReturnPlayerName() {
        HumanPlayer player = createHumanPlayer(minChooseCount+"");

        String name = player.getName();

        assertEquals(randomName, name, "Player name should match the expected random name.");
    }
}
