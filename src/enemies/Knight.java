package enemies;

import managers.EnemyManager;

import static helpers.Constants.Enemies.KNIGHT;

public class Knight extends Enemy{



    public Knight(float x, float y, int ID, EnemyManager em) {
        super(x, y, ID, KNIGHT, em);
    }
}
