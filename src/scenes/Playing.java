package scenes;

import helpers.LoadSave;
import main.Game;
import managers.EnemyManager;
import ui.ActionBar;
import managers.EnemyManager;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Playing extends GameScene implements SceneMethods {

    private int [][] lvl;
    private ActionBar bottomBar;
    private int mouseX, mouseY;
    private EnemyManager enemyManager;

    public Playing(Game game) throws IOException {
        super(game);
        loadDefaultLevel();

        bottomBar = new ActionBar(0, 640, 640, 100, this);

        enemyManager = new EnemyManager(this);

    }

    private void loadDefaultLevel() {
        lvl = LoadSave.GetLevelData("novo_nível");
    }

    public void setLevel(int [][] lvl) {
        this.lvl = lvl;
    }

    public void update(){
        enemyManager.update();
        updateTick();
    }

    @Override
    public void render(Graphics g) {

        drawLevel(g);
        bottomBar.draw(g);
        enemyManager.draw(g);

    }

    private void drawLevel(Graphics g){
        for(int y = 0; y < lvl.length; y++){
            for(int x = 0; x < lvl[y].length; x++){
                int id = lvl[y][x];
                if(isAnimation(id)){
                    g.drawImage(getSprite(id, animationIndex), x * 32, y * 32, null);
                }else
                    g.drawImage(getSprite(id), x * 32, y * 32, null);
            }
        }
    }

    //private BufferedImage getSprite(int spriteID){
    //    return game.getTileManager().getSprite(spriteID);
    //}

    public int getTileType(int x, int y) {
        int xCord = x / 32;
        int yCord = y / 32;

        if(xCord < 0 || xCord > 19)
            return 0;
        if(yCord < 0 || yCord > 19)
            return 0;


        int id = lvl[y / 32][x / 32];
        return game.getTileManager().getTile(id).getTileType();
    }

    @Override
    public void mouseClicked(int x, int y) throws IOException {
        if(y >= 640)
            bottomBar.mouseClicked(x, y);
//        else
//            enemyManager.addEnemy(x, y);
    }

    @Override
    public void mouseMoved(int x, int y) {
        if(y >= 640) {
            bottomBar.mouseMoved(x, y);
        }else{
            mouseX = (x / 32) * 32;
            mouseY = (y / 32) * 32;
        }

    }

    @Override
    public void mousePressed(int x, int y) {
        if(y >= 640) {
            bottomBar.mousePressed(x, y);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        bottomBar.mouseReleased(x, y);
    }

    @Override
    public void mouseDragged(int x, int y) throws IOException {

    }
}
