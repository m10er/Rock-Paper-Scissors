
import onerme.model.move.Move;
import onerme.model.move.Paper;
import onerme.model.move.Rock;
import onerme.model.move.Scissors;
import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;

import static org.junit.jupiter.api.Assertions.*;

public class MoveTest extends ReusableMethods {

    @Test
    public void testRockBeatsScissors() {
        Move rock = new Rock();
        Move scissors = new Scissors();

        assertTrue(rock.beats(scissors), "Rock should beat Scissors.");
        assertFalse(scissors.beats(rock), "Scissors should not beat Rock.");
    }

    @Test
    public void testPaperBeatsRock() {
        Move paper = new Paper();
        Move rock = new Rock();

        assertTrue(paper.beats(rock), "Paper should beat Rock.");
        assertFalse(rock.beats(paper), "Rock should not beat Paper.");
    }

    @Test
    public void testScissorsBeatsPaper() {
        Move scissors = new Scissors();
        Move paper = new Paper();

        assertTrue(scissors.beats(paper), "Scissors should beat Paper.");
        assertFalse(paper.beats(scissors), "Paper should not beat Scissors.");
    }

    @Test
    public void testMoveNames() {
        Move rock = new Rock();
        Move paper = new Paper();
        Move scissors = new Scissors();

        assertEquals(move1, rock.getName(), "Rock's name should be 'Rock'.");
        assertEquals(move2, paper.getName(), "Paper's name should be 'Paper'.");
        assertEquals(move3, scissors.getName(), "Scissors' name should be 'Scissors'.");
    }
}
