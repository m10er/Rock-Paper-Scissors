package onerme.factory.concreteFactory;

import onerme.factory.abstractFactory.MoveFactory;
import onerme.model.move.Move;
import onerme.model.move.Paper;
import onerme.model.move.Rock;
import onerme.model.move.Scissors;

public class RockPaperScissorsFactory implements MoveFactory {
    @Override
    public Move createMove(String moveType) {
        switch (moveType.toLowerCase()) {
            case "rock":
                return new Rock();
            case "paper":
                return new Paper();
            case "scissors":
                return new Scissors();
            default:
                throw new IllegalArgumentException("Invalid move type: " + moveType);
        }
    }
}
