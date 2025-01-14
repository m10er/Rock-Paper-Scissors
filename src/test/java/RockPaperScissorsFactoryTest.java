
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
    void testCreateMove_Rock() {
        Move move = factory.createMove("rock");
        assertNotNull(move);
        assertTrue(move instanceof Rock, "Expected a Rock instance.");
    }

    @Test
    void testCreateMove_Paper() {
        Move move = factory.createMove("paper");
        assertNotNull(move);
        assertTrue(move instanceof Paper, "Expected a Paper instance.");
    }

    @Test
    void testCreateMove_Scissors() {
        Move move = factory.createMove("scissors");
        assertNotNull(move);
        assertTrue(move instanceof Scissors, "Expected a Scissors instance.");
    }

    @Test
    void testCreateMove_InvalidMoveType() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> factory.createMove("invalid"));
        assertEquals("Invalid move type: invalid", exception.getMessage());
    }

    @Test
    void testCreateMove_CaseInsensitive() {
        Move rockMove = factory.createMove("ROCK");
        assertNotNull(rockMove);
        assertTrue(rockMove instanceof Rock);

        Move paperMove = factory.createMove("PaPeR");
        assertNotNull(paperMove);
        assertTrue(paperMove instanceof Paper);

        Move scissorsMove = factory.createMove("sCiSsOrS");
        assertNotNull(scissorsMove);
        assertTrue(scissorsMove instanceof Scissors);
    }
}
