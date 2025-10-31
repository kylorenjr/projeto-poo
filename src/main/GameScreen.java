package main;

import javax.swing.JPanel; //jpanel é um container?
import java.awt.Graphics;
import java.awt.Color;

public class GameScreen extends JPanel{

    public GameScreen(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);//delega para o JPanel as configurações de vídeo

        //g.drawRect(50, 50, 120, 100);
        g.setColor(Color.BLUE);
        g.fillRect(50, 50, 120, 100);
    }
}
