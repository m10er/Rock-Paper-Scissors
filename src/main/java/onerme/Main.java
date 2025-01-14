package onerme;

import onerme.controller.GameController;
import onerme.utilities.DefaultInputProvider;
import onerme.utilities.InputProvider;

public class Main {
    public static void main(String[] args) {
        InputProvider provider =new DefaultInputProvider();
        GameController game = new GameController(provider);
        game.start();

        }

}