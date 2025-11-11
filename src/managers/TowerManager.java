package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import enemies.Enemy;
import helpers.LoadSave;
import objects.Tower;
import scenes.Playing;

public class TowerManager {

    private Playing playing;
    private BufferedImage[] towerImgs;
    private ArrayList<Tower> towers = new ArrayList<>();
    private int towerAmount = 0;

    public TowerManager(Playing playing) throws IOException {
        this.playing = playing;
        loadTowerImgs();
    }

    private void loadTowerImgs() throws IOException {
        BufferedImage atlas = LoadSave.getSpriteAtlas();
        towerImgs = new BufferedImage[3];
        for (int i = 0; i < 3; i++)
            towerImgs[i] = atlas.getSubimage((4 + i) * 32, 32, 32, 32);
    }

    public void addTower(Tower selectedTower, int xPos, int yPos) {
        towers.add(new Tower(xPos, yPos, towerAmount++, selectedTower.getTowerType()));
    }

    public void update() {
        atackEnemyIfClose();
    }

    private void atackEnemyIfClose() {
        for(Tower t: towers) {
            for(Enemy e : playing.getEnemyManager().getEnemies()) {
                if(e.isAlive())
                    if(isEnemyInRange(t,e)){
                        e.hurt(1);
                    }else{
                        //do nothing
                }
            }
        }
    }

    private boolean isEnemyInRange(Tower t, Enemy e) {

        int range = helpers.Utilz.GetHypoDistance(t.getX(), t.getY(), e.getX(), e.getY());

        return range < t.getRange();
    }

    public void draw(Graphics g) {
        for (Tower t : towers)
            g.drawImage(towerImgs[t.getTowerType()], t.getX(), t.getY(), null);
    }

    public Tower getTowerAt(int x, int y) {
        for (Tower t : towers)
            if (t.getX() == x)
                if (t.getY() == y)
                    return t;
        return null;
    }

    public BufferedImage[] getTowerImgs() {
        return towerImgs;
    }

}
