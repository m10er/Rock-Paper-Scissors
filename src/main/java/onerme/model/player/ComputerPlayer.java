package onerme.model.player;

import onerme.factory.abstractFactory.MoveFactory;
import onerme.model.move.Move;

public class ComputerPlayer implements Player {
    private final String name;
    private final MoveFactory moveFactory;

    public ComputerPlayer(String name, MoveFactory moveFactory) {
        this.name = name;
        this.moveFactory = moveFactory;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Move makeMove() {
        String[] moves = {"rock", "paper", "scissors"};
        int randomIndex = (int) (Math.random() * moves.length);
        return moveFactory.createMove(moves[randomIndex]);
    }
}
