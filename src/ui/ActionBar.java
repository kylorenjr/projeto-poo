package ui;

import scenes.Playing;

import java.awt.*;
import java.io.IOException;


import static main.GameStates.MENU;
import static main.GameStates.SetGameState;

public class ActionBar extends Bar{

    private MyButton bMenu;
    private Playing playing;

    public ActionBar(int x, int y, int width, int height, Playing playing) {
        super(x, y, width, height);
        this.playing = playing;
        initButtons();
    }

    public void draw(Graphics g) {
        //Background
        g.setColor(new Color(220,123,15));
        g.fillRect(x, y, width, height);

        //Buttons
        drawButtons(g);
    }

    private void initButtons() {
        bMenu = new MyButton("Menu", 2, 642, 100, 30);
    }

    private void drawButtons(Graphics g) {
        bMenu.draw(g);
    }

    public void mouseClicked(int x, int y) throws IOException {
        if (bMenu.getBounds().contains(x, y))
            SetGameState(MENU);
    }

    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMouseOver(true);
    }

    public void mousePressed(int x, int y) {
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMousePressed(true);
    }

    public void mouseReleased(int x, int y) {
        bMenu.resetBooleans();
    }
}
