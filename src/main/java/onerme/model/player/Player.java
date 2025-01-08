package onerme.model.player;

import onerme.model.move.Move;

public interface Player {
    String getName();
    Move makeMove();
}
