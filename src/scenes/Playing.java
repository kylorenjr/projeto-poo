package scenes;

import helpers.LevelBuild;
import main.Game;
import managers.TileManager;

import java.awt.*;
import java.io.IOException;

public class Playing extends GameScene implements SceneMethods {

    private int [][] lvl;
    private TileManager tileManager;

    public Playing(Game game) throws IOException {
        super(game);

        lvl = LevelBuild.getLevelData();
        tileManager = new TileManager();
    }

    @Override
    public void render(Graphics g) {

        for(int y = 0; y < lvl.length; y++){
            for(int x = 0; x < lvl[y].length; x++){
                int id = lvl[y][x];
                g.drawImage(tileManager.getSprite(id), x * 32, y * 32, null);
            }
        }
    }
}
