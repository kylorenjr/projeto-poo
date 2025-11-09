package scenes;

import helpers.LoadSave;
import main.Game;
import managers.EnemyManager;
import managers.TowerManager;
import objects.PathPoint;
import objects.Tower;
import ui.ActionBar;
import managers.EnemyManager;
import static helpers.Constants.Tiles.GRASS_TILE;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class Playing extends GameScene implements SceneMethods {

    private int [][] lvl;
    private ActionBar actionBar;
    private int mouseX, mouseY;
    private EnemyManager enemyManager;
    private TowerManager towerManager;
    private PathPoint start, end;
    private Tower selectedTower;

    public Playing(Game game) throws IOException {
        super(game);
        loadDefaultLevel();

        actionBar = new ActionBar(0, 640, 640, 160, this);

        enemyManager = new EnemyManager(this, start, end);
        towerManager = new TowerManager(this);

    }

    private void loadDefaultLevel() {
        lvl = LoadSave.GetLevelData("novo_nível");
        ArrayList<PathPoint> points = LoadSave.GetLevelPathPoints("novo_nível");
        start = points.get(0);
        end = points.get(1);
    }

    public void setLevel(int [][] lvl) {
        this.lvl = lvl;
    }

    public void update(){
        enemyManager.update();
        updateTick();
        towerManager.update();
    }

    public void setSelectedTower(Tower selectedTower) {
        this.selectedTower = selectedTower;
    }

    @Override
    public void render(Graphics g) {

        drawLevel(g);
        actionBar.draw(g);
        enemyManager.draw(g);
        towerManager.draw(g);
        drawSelectedTower(g);

    }

    private void drawSelectedTower(Graphics g) {
        if (selectedTower != null)
            g.drawImage(towerManager.getTowerImgs()[selectedTower.getTowerType()], mouseX, mouseY, null);
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
    public void mouseClicked(int x, int y) {
        if (y >= 640)
            actionBar.mouseClicked(x, y);
        else {
            if (selectedTower != null)
                if (isTileGrass(mouseX, mouseY)) {
                    towerManager.addTower(selectedTower, mouseX, mouseY);
                    selectedTower = null;
                }
        }
    }

    private boolean isTileGrass(int x, int y) {
        int id = lvl[y / 32][x / 32];
        int tileType = game.getTileManager().getTile(id).getTileType();
        return tileType == GRASS_TILE;
    }

    @Override
    public void mouseMoved(int x, int y) {
        if(y >= 640) {
            actionBar.mouseMoved(x, y);
        }else{
            mouseX = (x / 32) * 32;
            mouseY = (y / 32) * 32;
        }

    }

    @Override
    public void mousePressed(int x, int y) {
        if(y >= 640) {
            actionBar.mousePressed(x, y);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        actionBar.mouseReleased(x, y);
    }

    @Override
    public void mouseDragged(int x, int y) throws IOException {

    }

    public TowerManager getTowerManager() {
        return towerManager;
    }

}
