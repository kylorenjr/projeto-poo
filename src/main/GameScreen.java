package main;

import javax.swing.JPanel; //jpanel é um container?
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage; //importando classe para conseguir usar a imagem
import java.util.ArrayList;
import java.util.Random; //importando a classe random

public class GameScreen extends JPanel{

    private Random random; //criação do objeto random
    private BufferedImage img; //criação do objeto img

    private ArrayList<BufferedImage> sprites = new ArrayList<>(); //inicializando um array list para carregar todas as sprites que vão ser usadas no jogo

    public GameScreen(BufferedImage img){
        this.img = img; //inicializando a imagem
        
        loadSprites();
        
        random = new Random(); //inicializando variavel random

    }

    private void loadSprites() {

        //este metodo carrega todas as sprites (32x32) da imagem (320x320) para facilitar a impressão delas na tela
        //y e x < 10 é porque como a imagem é 320x320 e as sprites são 32x32 teriamos um eixo X e Y de 10 (ja que 320/32 = 10)

        for(int y = 0; y < 10; y++) {
            for(int x = 0; x < 10; x++) {
                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
            }
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);//delega para o JPanel as configurações de vídeo

        //g.drawRect(50, 50, 120, 100);
        //g.setColor(Color.BLUE);
        //g.fillRect(50, 50, 120, 100);

        //g.drawImage(img, 0, 0, null);

        //este nested loop é apenas para confirmar que a imagem foi carregada e que os sprites foram armazenados no array list criado acima, não será mantido no jogo, é apenas um teste
        for(int y = 0; y < 20; y++) {
            for(int x = 0; x < 20; x++) {
                g.drawImage(sprites.get(getRndInt()), x * 32, y * 32, null);
            }
        }

    }

    private int getRndInt() {
        return random.nextInt(100);
    }
}
