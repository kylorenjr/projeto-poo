package main;

import inputs.KeyListener;
import inputs.MyMouseListener;

import javax.swing.JPanel;
import java.awt.*;
import java.io.IOException;

public class GameScreen extends JPanel{

    private Game game;
    private Dimension size;

    private MyMouseListener mouseListener;
    private KeyListener keyListener;

    public GameScreen(Game game) throws IOException {
        this.game = game;

        setPanelSize();
    }


    public void initInputs() {

        mouseListener = new MyMouseListener(game);
        keyListener = new KeyListener();

        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
        addKeyListener(keyListener);

        requestFocus();
    }

    private void setPanelSize(){
        size = new Dimension(640,640);

        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        game.getRender().render(g);
    }
}
