
package onerme.service;

import onerme.model.player.ComputerPlayer;
import onerme.model.player.HumanPlayer;
import onerme.model.player.Player;
import java.util.Locale;

import static onerme.service.Language.messages;


public class ResultEvaluator {
    Locale locale = messages.getLocale();
    public void evaluate(Player player1, Player player2, GameEngine gameEngine) {

        System.out.println(messages.getString("finalScore"));
        System.out.println(player1.getName() + ": " + gameEngine.getPlayer1Score());
        System.out.println(player2.getName() + ": " + gameEngine.getPlayer2Score());
        System.out.println(messages.getString("drawCount").replace("{0}", String.valueOf(gameEngine.getDrawCount())));

        int player1Score = gameEngine.getPlayer1Score();
        int player2Score = gameEngine.getPlayer2Score();

        if (player1Score > player2Score) {
            System.out.println(messages.getString("winnerGame").replace("{0}", player1.getName()));

            if (player1Score - player2Score >= 5) {
                System.out.println(messages.getString("bigWin").replace("{0}", player1.getName()));
            }
        } else if (player1Score < player2Score) {
            System.out.println(messages.getString("winnerGame").replace("{0}", player2.getName()));

            if (player2Score - player1Score >= 5) {
                System.out.println(messages.getString("bigWin").replace("{0}", player2.getName()));
            }
        } else {
            System.out.println(messages.getString("tieRound"));
        }


        if (player1 instanceof HumanPlayer && player2 instanceof ComputerPlayer) {
            if (player1Score > player2Score) {
                System.out.println(messages.getString("playerBeatsComputer").replace("{0}", player1.getName()));
            } else if (player1Score < player2Score) {
                System.out.println(messages.getString("computerBeatsPlayer").replace("{0}", player2.getName()));
            }
        } else if (player1 instanceof ComputerPlayer && player2 instanceof ComputerPlayer) {
            System.out.println(messages.getString("computerBattle"));
        }
    }
}
