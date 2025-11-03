package inputs;

import main.GameStates;

import java.awt.event.KeyEvent;

import static main.GameStates.*;

public class KeyListener implements  java.awt.event.KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //código temporario, apenas para testes
        if (e.getKeyCode() == KeyEvent.VK_A) {
            GameStates.gameState = MENU;
        }else if (e.getKeyCode() == KeyEvent.VK_S) {
            GameStates.gameState = PLAYING;
        }else if (e.getKeyCode() == KeyEvent.VK_D) {
            GameStates.gameState = SETTINGS;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
