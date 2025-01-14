package model.move;

import onerme.model.move.Move;
import onerme.model.move.Paper;
import onerme.model.move.Rock;
import onerme.model.move.Scissors;
import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;

import static org.junit.jupiter.api.Assertions.*;

public class MoveTest extends ReusableMethods {

    @Test
    public void rock_ShouldBeatScissors() {
        Move rock = new Rock();
        Move scissors = new Scissors();

        assertTrue(rock.beats(scissors), "Rock should beat Scissors.");
        assertFalse(scissors.beats(rock), "Scissors should not beat Rock.");
    }

    @Test
    public void paper_ShouldBeatRock() {
        Move paper = new Paper();
        Move rock = new Rock();

        assertTrue(paper.beats(rock), "Paper should beat Rock.");
        assertFalse(rock.beats(paper), "Rock should not beat Paper.");
    }

    @Test
    public void scissors_ShouldBeatPaper() {
        Move scissors = new Scissors();
        Move paper = new Paper();

        assertTrue(scissors.beats(paper), "Scissors should beat Paper.");
        assertFalse(paper.beats(scissors), "Paper should not beat Scissors.");
    }

    @Test
    public void move_ShouldNotBeatItself() {
        Move rock = new Rock();
        Move paper = new Paper();
        Move scissors = new Scissors();

        assertFalse(rock.beats(rock), "Rock should not beat itself.");
        assertFalse(paper.beats(paper), "Paper should not beat itself.");
        assertFalse(scissors.beats(scissors), "Scissors should not beat itself.");
    }

    @Test
    public void moveNames_ShouldBeCorrect() {
        Move rock = new Rock();
        Move paper = new Paper();
        Move scissors = new Scissors();

        assertEquals("Rock", rock.getName(), "Rock's name should be 'Rock'.");
        assertEquals("Paper", paper.getName(), "Paper's name should be 'Paper'.");
        assertEquals("Scissors", scissors.getName(), "Scissors' name should be 'Scissors'.");
    }


}
