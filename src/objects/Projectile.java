package objects;

import java.awt.geom.Point2D;

public class Projectile {

    private Point2D.Float pos;
    private int id, projectileType;
    private boolean active = true;
    private float xSpeed, ySpeed;

    public Projectile(float x, float y, float xSpeed, float ySpeed, int id, int projectileType) {
        pos = new Point2D.Float(x,y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.id = id;
        this.projectileType = projectileType;
    }

    public void move() {
        pos.x += xSpeed;
        pos.y += ySpeed;
    }

    public Point2D.Float getPos() {
        return pos;
    }

    public int getId() {
        return id;
    }

    public int getProjectileType() {
        return projectileType;
    }

    public boolean isActive() {
        return active;
    }

}
