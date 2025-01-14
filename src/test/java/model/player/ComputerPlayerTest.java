package model.player;

import onerme.factory.abstractFactory.MoveFactory;
import onerme.model.move.Move;
import onerme.model.move.Paper;
import onerme.model.move.Rock;
import onerme.model.move.Scissors;
import onerme.model.player.ComputerPlayer;
import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.SimpleMoveFactory;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerPlayerTest extends ReusableMethods {

    String randomName = generateRandomString(minNameLength, maxNameLenght);

    private ComputerPlayer createComputerPlayer() {
        MoveFactory factory = new SimpleMoveFactory();
        return new ComputerPlayer(randomName, factory);
    }

    @Test
    void getName_ShouldReturnPlayerName() {
        ComputerPlayer player = createComputerPlayer();
        assertEquals(randomName, player.getName(), "Player name should match the expected random name.");
    }

    @Test
    void makeMove_ShouldReturnValidMove() {
        ComputerPlayer player = createComputerPlayer();

        Move move = player.makeMove();

        assertNotNull(move, "The move should not be null.");
        assertTrue(
                move instanceof Rock || move instanceof Paper || move instanceof Scissors,
                "The move should be one of Rock, Paper, or Scissors."
        );
    }

    @Test
    void makeMove_ShouldProduceAllPossibleMovesOverTime() {
        ComputerPlayer player = createComputerPlayer();

        boolean rockFound = false;
        boolean paperFound = false;
        boolean scissorsFound = false;

        for (int i = 0; i < 100; i++) { // Test 100 iterations for randomness.
            Move move = player.makeMove();
            if (move instanceof Rock) rockFound = true;
            if (move instanceof Paper) paperFound = true;
            if (move instanceof Scissors) scissorsFound = true;

            if (rockFound && paperFound && scissorsFound) break; // All types found, exit early.
        }

        assertTrue(rockFound, "Rock move should be produced over multiple iterations.");
        assertTrue(paperFound, "Paper move should be produced over multiple iterations.");
        assertTrue(scissorsFound, "Scissors move should be produced over multiple iterations.");
    }
}
