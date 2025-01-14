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
    String randomName = generateRandomString(minNameLength,maxNameLenght);

    @Test
    public void testGetName() {


        MoveFactory factory = new SimpleMoveFactory();
        ComputerPlayer player = new ComputerPlayer(randomName, factory);

        assertEquals(randomName, player.getName(), "Player name should be '" + randomName + "'.");
    }


    @Test
    public void testMakeMove() {
        MoveFactory factory = new SimpleMoveFactory();
        ComputerPlayer player = new ComputerPlayer(randomName, factory);

        Move move = player.makeMove();

        assertNotNull(move, "The move should not be null.");
        assertTrue(
                move instanceof Rock || move instanceof Paper || move instanceof Scissors,
                "The move should be one of Rock, Paper, or Scissors."
        );
    }
}
