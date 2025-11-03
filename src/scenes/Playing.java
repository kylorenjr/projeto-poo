package scenes;

import main.Game;

import java.awt.*;

public class Playing extends GameScene implements SceneMethods {

    public Playing(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics g) {
        //codigo atual serve apenas para testes
        g.setColor(Color.red);
        g.fillRect(0, 0, 640, 640);
    }
}
