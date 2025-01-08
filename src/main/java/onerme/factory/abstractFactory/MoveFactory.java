package onerme.factory.abstractFactory;

import onerme.model.move.Move;

public interface MoveFactory {
    Move createMove(String moveType);
}
