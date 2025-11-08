package inputs;

import main.Game;
import main.GameStates;

import java.awt.event.KeyEvent;

import static main.GameStates.*;

public class KeyListener implements  java.awt.event.KeyListener {

    private Game game;

    public KeyListener(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(GameStates.gameState == EDIT)
            game.getEditor().keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
