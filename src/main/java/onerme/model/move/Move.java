package onerme.model.move;

public interface Move {
    String getName();
    boolean beats(Move opponent);
}
