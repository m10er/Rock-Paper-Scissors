package onerme.model.move;

public class Rock implements Move {
    @Override
    public String getName() {
        return "Rock";
    }

    @Override
    public boolean beats(Move opponent) {
        return opponent instanceof Scissors;
    }
}
