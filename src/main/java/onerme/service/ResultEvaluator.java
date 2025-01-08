package onerme.service;

import onerme.model.player.Player;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResultEvaluator {
    Locale locale = Language.messages.getLocale();
    public void evaluate(Player player1, Player player2, GameEngine gameEngine) {
        ResourceBundle messages = ResourceBundle.getBundle("messages", locale);
        System.out.println(messages.getString("finalScore"));
        System.out.println(player1.getName() + ": " + gameEngine.getPlayer1Score());
        System.out.println(player2.getName() + ": " + gameEngine.getPlayer2Score());

        System.out.println(messages.getString("drawCount").replace("{0}", String.valueOf(gameEngine.getDrawCount())));
        if (gameEngine.getPlayer1Score() > gameEngine.getPlayer2Score()) {
            System.out.println(messages.getString("winnerGame").replace("{0}", player1.getName()));
        } else if (gameEngine.getPlayer1Score() < gameEngine.getPlayer2Score()) {
            System.out.println(messages.getString("winnerGame").replace("{0}", player2.getName()));
        } else {
            System.out.println(messages.getString("tieRound"));
        }
    }
}
