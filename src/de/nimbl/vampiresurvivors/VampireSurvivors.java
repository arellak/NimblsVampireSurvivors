package de.nimbl.vampiresurvivors;

import de.nimbl.vampiresurvivors.game.Game;

public class VampireSurvivors {

    public static void main(String[] args) {
        Game game = new Game();

        game.start();
        game.gameLoop();
    }

}