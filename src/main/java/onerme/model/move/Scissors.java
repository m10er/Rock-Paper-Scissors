package onerme.model.move;

public class Scissors implements Move {
    @Override
    public String getName() {
        return "Scissors";
    }

    @Override
    public boolean beats(Move opponent) {
        return opponent instanceof Paper;
    }
}
