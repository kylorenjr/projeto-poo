package main;
import javax.imageio.ImageIO;
import javax.swing.JFrame; //*=Jframe
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Game extends JFrame {

    private GameScreen gameScreen; //criamos um novo objeto GameScreen para podermos usar

    private BufferedImage img; //criação do objeto imagem

    public Game() throws IOException {

        importImg(); //metodo que permite a exibição da imagem na tela

        setSize(600, 600); //tamanho da janela
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //oq acontece por padrão quando fechamos a janela, nesse caso encerra o game
        setLocationRelativeTo(null); //diz onde a janela vai aparecer quando iniciar o game
        gameScreen = new GameScreen(img); // aqui inicializamos o objeto GameScreen
        //Jframe.add(Jpanel);
        add(gameScreen);
    }

    private void importImg() throws IOException {

        InputStream is = getClass().getResourceAsStream("/AtlasSprites.png");

        img = ImageIO.read(is);

        //IOExeception é necessário para evitar bugs ao carregar imagem e não causar problemas maiores se não conseguir achar a imagem
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
    }
}
