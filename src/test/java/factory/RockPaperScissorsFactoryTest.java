package factory;

import onerme.factory.concreteFactory.RockPaperScissorsFactory;
import onerme.model.move.Move;
import onerme.model.move.Paper;
import onerme.model.move.Rock;
import onerme.model.move.Scissors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RockPaperScissorsFactoryTest {

    private final RockPaperScissorsFactory factory = new RockPaperScissorsFactory();

    @Test
    void createMove_ShouldReturnRockInstance_WhenInputIsRock() {
        assertMoveInstance("rock", Rock.class);
    }

    @Test
    void createMove_ShouldReturnPaperInstance_WhenInputIsPaper() {
        assertMoveInstance("paper", Paper.class);
    }

    @Test
    void createMove_ShouldReturnScissorsInstance_WhenInputIsScissors() {
        assertMoveInstance("scissors", Scissors.class);
    }

    @Test
    void createMove_ShouldThrowException_WhenInputIsInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> factory.createMove("invalid"));
        assertEquals("Invalid move type: invalid", exception.getMessage(),
                "Expected exception message for invalid move type.");
    }

    @Test
    void createMove_ShouldBeCaseInsensitive() {
        assertMoveInstance("ROCK", Rock.class);
        assertMoveInstance("PaPeR", Paper.class);
        assertMoveInstance("sCiSsOrS", Scissors.class);
    }

    @Test
    void createMove_ShouldThrowException_WhenInputIsNullOrEmpty() {

        assertThrows(IllegalArgumentException.class,
                () -> factory.createMove(""), "Empty string input should throw exception.");
        assertThrows(IllegalArgumentException.class,
                () -> factory.createMove("   "), "Input with spaces should throw exception.");
    }

    private void assertMoveInstance(String input, Class<?> expectedClass) {
        Move move = factory.createMove(input);
        assertNotNull(move, "Move should not be null for input: " + input);
        assertTrue(expectedClass.isInstance(move),
                "Expected a " + expectedClass.getSimpleName() + " instance for input: " + input);
    }
}
