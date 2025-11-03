package main;

import javax.swing.JPanel; //jpanel é um container?
import java.awt.*;
import java.awt.image.BufferedImage; //importando classe para conseguir usar a imagem
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random; //importando a classe random

public class GameScreen extends JPanel{

    private Dimension size;
    private Game game;

    public GameScreen(Game game) throws IOException {
        this.game = game;

        setPanelSize(); //ajuste para nada ficar escondido na tela do jogo
    }

    private void setPanelSize(){
        size = new Dimension(640,640);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);//delega para o JPanel as configurações de vídeo

        game.getRender().render(g);
    }
}
