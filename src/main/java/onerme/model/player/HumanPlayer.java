package onerme.model.player;

import onerme.factory.abstractFactory.MoveFactory;
import onerme.model.move.Move;
import onerme.utilities.InputProvider;

public class HumanPlayer implements Player {
    private final String name;
    private final MoveFactory moveFactory;
    private InputProvider inputProvider;

    public HumanPlayer(String name, MoveFactory moveFactory, InputProvider inputProvider) {
        this.name = name;
        this.moveFactory = moveFactory;
        this.inputProvider=inputProvider;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Move makeMove() {
        System.out.println("\nChoose your move: 1) Rock  2) Paper  3) Scissors");
        String userInput = "";
        Move move = null;

        while (move == null) {
            System.out.print("Enter your choice (1, 2, or 3): ");
            userInput = inputProvider.getInput();
            switch (userInput) {
                case "1":
                    move = moveFactory.createMove("rock");
                    break;
                case "2":
                    move = moveFactory.createMove("paper");
                    break;
                case "3":
                    move = moveFactory.createMove("scissors");
                    break;
                default:
                    System.out.println("Invalid input. Please enter 1, 2, or 3.");
            }
        }

        System.out.println(name + " chose: " + move.toString());

        return move;
    }
}