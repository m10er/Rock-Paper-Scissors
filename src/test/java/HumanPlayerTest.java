import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import onerme.model.player.HumanPlayer;
import onerme.factory.abstractFactory.MoveFactory;
import onerme.factory.concreteFactory.RockPaperScissorsFactory;
import onerme.model.move.Move;
import onerme.utilities.FakeInputProvider;
import utilities.ReusableMethods;

public class HumanPlayerTest extends ReusableMethods {

    String randomName=generateRandomString(minNameLength,maxNameLenght);

    @Test
    void testMakeMove_ValidInput() {
        FakeInputProvider inputProvider = new FakeInputProvider("1");

        MoveFactory moveFactory = new RockPaperScissorsFactory();
        HumanPlayer player = new HumanPlayer(randomName, moveFactory, inputProvider);

        Move move = player.makeMove();

        assertNotNull(move);
        assertEquals(move1, move.getName());
    }

    @Test
    void testMakeMove_InvalidInput() {
        FakeInputProvider inputProvider = new FakeInputProvider("5", "2");

        MoveFactory moveFactory = new RockPaperScissorsFactory();
        HumanPlayer player = new HumanPlayer(randomName, moveFactory, inputProvider);
        Move move = player.makeMove();

        assertNotNull(move);
        assertEquals(move2, move.getName());
    }

    @Test
    void testGetName() {
        FakeInputProvider inputProvider = new FakeInputProvider("1");

        MoveFactory moveFactory = new RockPaperScissorsFactory();
        HumanPlayer player = new HumanPlayer(randomName, moveFactory, inputProvider);

        assertEquals(randomName, player.getName());
    }
}
