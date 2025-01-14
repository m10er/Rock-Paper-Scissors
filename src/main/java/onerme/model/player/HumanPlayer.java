package onerme.model.player;

import onerme.factory.abstractFactory.MoveFactory;
import onerme.model.move.Move;
import onerme.utilities.InputProvider;

import static onerme.service.Language.messages;

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
        System.out.println(messages.getString("rockPapierScissors"));

        String userInput = "";
        Move move = null;

        while (move == null) {
            System.out.print(messages.getString("playerMove"));
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
                    System.out.println(messages.getString("invalidMode3"));
            }
        }

        return move;
    }
}