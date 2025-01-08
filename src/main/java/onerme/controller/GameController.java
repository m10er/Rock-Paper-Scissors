package onerme.controller;

import onerme.factory.concreteFactory.RockPaperScissorsFactory;
import onerme.model.player.ComputerPlayer;
import onerme.model.player.HumanPlayer;
import onerme.model.player.Player;
import onerme.service.GameEngine;
import onerme.service.Language;
import onerme.service.ResultEvaluator;
import static onerme.service.Language.messages;
import static onerme.utilities.ValidateInput.*;

public class GameController {

    ResultEvaluator resultEvaluator;
    Language language;

    public void start() {

        language = new Language();
        language.getLanguage();

        boolean playAgain = true;

        while (playAgain) {
            System.out.println(messages.getString("chooseMode"));
            int mode = getValidatedIntInput( 1, 2, messages.getString("invalidMode"));

            Player player1, player2;

            if (mode == 1) {
                System.out.println(messages.getString("enterName"));
                String playerName = getValidatedStringInput(messages.getString("invalidName"));
                player1 = new HumanPlayer(playerName, new RockPaperScissorsFactory());
                player2 = new ComputerPlayer("Computer", new RockPaperScissorsFactory());
            } else {
                player1 = new ComputerPlayer("Computer 1", new RockPaperScissorsFactory());
                player2 = new ComputerPlayer("Computer 2", new RockPaperScissorsFactory());
            }

            System.out.println(messages.getString("enterRounds"));
            int totalRounds = getValidatedIntInput(1, 20, messages.getString("invalidRounds"));

            GameEngine gameEngine = new GameEngine(player1, player2, totalRounds, messages);

            System.out.println("\n--- " + messages.getString("roundNumber") + " ---");
            gameEngine.play();

            resultEvaluator= new ResultEvaluator();
            resultEvaluator.evaluate(player1,player2,gameEngine);

            playAgain = getValidatedYesNoInput(messages.getString("playAgain"), messages);
        }
    }


}