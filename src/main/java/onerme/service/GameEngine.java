package onerme.service;

import onerme.model.move.Move;
import onerme.model.player.Player;
import java.util.ResourceBundle;

public class GameEngine {
    private int drawCount;
    private final Player player1;
    private final Player player2;
    public final int totalRounds;
    private final ResourceBundle messages;
    private int player1Score = 0;
    private int player2Score = 0;

    public GameEngine(Player player1, Player player2, int totalRounds, ResourceBundle messages) {
        this.player1 = player1;
        this.player2 = player2;
        this.totalRounds = totalRounds;
        this.messages = messages;
        this.drawCount = 0;
    }

    public void play() {
        for (int round = 1; round <= totalRounds; round++) {
            System.out.println(messages.getString("roundNumber").replace("{0}", String.valueOf(round)));

            Move move1 = player1.makeMove();
            Move move2 = player2.makeMove();

            System.out.println(messages.getString("playerChoice").replace("{0}", player1.getName()).replace("{1}", move1.getName()));
            System.out.println(messages.getString("playerChoice").replace("{0}", player2.getName()).replace("{1}", move2.getName()));

            if (move1.beats(move2)) {
                player1Score++;
                System.out.println(messages.getString("winnerRound").replace("{0}", player1.getName()));
            } else if (move2.beats(move1)) {
                player2Score++;
                System.out.println(messages.getString("winnerRound").replace("{0}", player2.getName()));
            } else {
                drawCount++;
                System.out.println(messages.getString("tieRound"));
            }

            System.out.println(messages.getString("currentScore"));
            System.out.println(player1.getName() + ": " + player1Score);
            System.out.println(player2.getName() + ": " + player2Score);
        }
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public int getDrawCount() {
        return drawCount;
    }
}