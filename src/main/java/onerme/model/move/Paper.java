package onerme.model.move;

public class Paper implements Move {
    @Override
    public String getName() {
        return "Paper";
    }

    @Override
    public boolean beats(Move opponent) {
        return opponent instanceof Rock;
    }
}
