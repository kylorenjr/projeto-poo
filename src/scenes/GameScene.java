package scenes;

import main.Game;

import java.awt.image.BufferedImage;

public class GameScene {

    protected Game game;
    protected int animationIndex;
    protected int tick;
    protected int ANIMATION_SPEED = 25;

    public GameScene(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    protected boolean isAnimation(int spriteId) {
        return game.getTileManager().isSpriteAnimation(spriteId);
    }

    protected void updateTick() {
        tick++;
        if(tick >= ANIMATION_SPEED){
            tick = 0;
            animationIndex++;
            if(animationIndex >= 4)
                animationIndex = 0;
        }

    }

    protected BufferedImage getSprite(int spriteId){
        return game.getTileManager().getSprite(spriteId);
    }

    protected BufferedImage getSprite(int spriteID, int animationIndex){
        return game.getTileManager().getAniSprite(spriteID, animationIndex);
    }

}
