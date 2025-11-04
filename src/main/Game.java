package main;
import inputs.KeyListener;
import inputs.MouseListener;
import scenes.Playing;
import scenes.Settings;
import scenes.Menu;

import javax.imageio.ImageIO;
import javax.swing.JFrame; //*=Jframe
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Game extends JFrame implements Runnable {

    private GameScreen gameScreen; //criamos um novo objeto GameScreen para podermos usar
    private Thread gameThread;

    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    private int updates;
    private long lastTimeUPS; //atributo para armazenar os updates por segundo do jogo

    private MouseListener mouseListener;
    private KeyListener keyListener;

    private Render render;
    private Menu menu;
    private Playing playing;
    private Settings settings;

    public Game() throws IOException {

        initClasses();

        setDefaultCloseOperation(EXIT_ON_CLOSE); //oq acontece por padrão quando fechamos a janela, nesse caso encerra o game
        setLocationRelativeTo(null); //diz onde a janela vai aparecer quando iniciar o game
        setResizable(false);
        add(gameScreen);
        pack();
        setVisible(true);//colocando o setVisible em baixo para evitar bugs
    }

    private void initClasses() throws IOException {
        render = new Render(this);
        gameScreen = new GameScreen(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);
    }

    private void initInputs() {

        //metodo que inicializa os inputs do teclado e do mouse do usuario
        mouseListener = new MouseListener();
        keyListener = new KeyListener();

        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
        addKeyListener(keyListener);

        requestFocus(); //apenas para prevenir bugs
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
        game.initInputs();
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

        long now;


        while(true){

            now = System.nanoTime();
        if (now - lastFrame >= timePerFrame) {
            repaint();
            lastFrame = now;
            frames++;
        }

        if(now - lastUpdate >= timePerUpdate){
            updateGame();
            lastUpdate = now;
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

    public Render getRender() {
        return render;
    }

    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }

    public Settings getSettings() {
        return settings;
    }
}
