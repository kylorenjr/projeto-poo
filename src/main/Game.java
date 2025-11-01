package main;
import javax.imageio.ImageIO;
import javax.swing.JFrame; //*=Jframe
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Game extends JFrame implements Runnable {

    private GameScreen gameScreen; //criamos um novo objeto GameScreen para podermos usar
    private BufferedImage img; //criação do objeto imagem
    private Thread gameThread;

    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    private int updates;
    private long lastTimeUPS; //atributo para armazenar os updates por segundo do jogo


    public Game() throws IOException {

        importImg(); //metodo que permite a exibição da imagem na tela

        setSize(600, 600); //tamanho da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); //oq acontece por padrão quando fechamos a janela, nesse caso encerra o game
        setLocationRelativeTo(null); //diz onde a janela vai aparecer quando iniciar o game

        gameScreen = new GameScreen(img); // aqui inicializamos o objeto GameScreen
        add(gameScreen);
        setVisible(true);//colocando o setVisible em baixo para evitar bugs
    }

    private void importImg() throws IOException {

        InputStream is = getClass().getResourceAsStream("/AtlasSprites.png");

        img = ImageIO.read(is);

        //IOExeception é necessário para evitar bugs ao carregar imagem e não causar problemas maiores se não conseguir achar a imagem
    }

    private void start(){
        gameThread = new Thread(this){};//criação da função de inicio e atribuição de uma thread para ela

        gameThread.start();//lembrete: sempre iniciar as threads (obs, comentar essa linha faz o jogo não atualizar!)
    }

    private void callUPS(){
        if(System.currentTimeMillis() - lastTimeUPS >= 1000){
            System.out.println("UPS: " + updates);
            updates = 0;
            lastTimeUPS = System.currentTimeMillis();
        }
    }

    private void updateGame(){
        //System.out.println("Jogo atualizado!");//apenas para teste de atualização, remoção póstuma
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.start();
    }

    @Override
    public void run() { //função que permite rodar em diferentes threads

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();

        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;


        while(true){
        if (System.nanoTime() - lastFrame >= timePerFrame) {
            repaint();
            lastFrame = System.nanoTime();
            frames++;
        }

        if(System.nanoTime() - lastUpdate >= timePerUpdate){
            updateGame();
            lastUpdate = System.nanoTime();
            updates++;
            }

        if(System.currentTimeMillis() - lastTimeCheck >= 1000){
            System.out.println("FPS: " + frames + " | UPS: " + updates);
            frames = 0;
            updates = 0;
            lastTimeCheck = System.currentTimeMillis();
            }

        }


    }
}
