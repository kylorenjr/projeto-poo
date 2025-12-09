package scenes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import main.Game;
import ui.MyButton;
import static main.GameStates.*;

public class Menu extends GameScene implements SceneMethods {

    private MyButton bPlaying, bEdit, bQuit;


    public Menu(Game game) throws IOException {
        super(game);
        initButtons();
    }

    private void initButtons() {

        int w = 200;
        int h = w / 3;
        int x = 640 / 2 - w / 2;
        int y = 250;
        int yOffset = 100;

        bPlaying = new MyButton("Jogar", x, y, w, h);
        bEdit = new MyButton("Editar", x, y + yOffset, w, h);
        bQuit = new MyButton("Sair", x, y + yOffset * 2, w, h);

    }

    @Override
    public void render(Graphics g) {

        g.setColor(new Color(255, 255, 102));
        g.fillRect(0, 0, 640, 800);

        drawButtons(g);
    }

    private void drawButtons(Graphics g) {
        bPlaying.draw(g);
        bEdit.draw(g);
        bQuit.draw(g);

    }

    @Override
    public void mouseClicked(int x, int y) {

        if (bPlaying.getBounds().contains(x, y)) {
            SetGameState(PLAYING);
        }else if (bEdit.getBounds().contains(x, y)) {
            SetGameState(EDIT);
        } else if (bQuit.getBounds().contains(x, y))
            System.exit(0);
    }

    @Override
    public void mouseMoved(int x, int y) {
        bPlaying.setMouseOver(false);
        bEdit.setMouseOver(false);
        bQuit.setMouseOver(false);

        if (bPlaying.getBounds().contains(x, y)) {
            bPlaying.setMouseOver(true);
        }else if (bEdit.getBounds().contains(x, y)) {
            bEdit.setMouseOver(true);
        } else if (bQuit.getBounds().contains(x, y)) {
            bQuit.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {

        if (bPlaying.getBounds().contains(x, y)) {
            bPlaying.setMousePressed(true);
        }else if (bEdit.getBounds().contains(x, y)) {
            bEdit.setMousePressed(true);
        } else if (bQuit.getBounds().contains(x, y)) {
            bQuit.setMousePressed(true);
        }
    }


    @Override
    public void mouseReleased(int x, int y) {resetButtons();}

    @Override
    public void mouseDragged(int x, int y) {

    }

    private void resetButtons() {
    bPlaying.resetBooleans();
    bEdit.resetBooleans();
    bQuit.resetBooleans();
    }
}

