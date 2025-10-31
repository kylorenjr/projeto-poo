package main;
import javax.swing.JFrame; //*=Jframe

public class Game extends JFrame {

    private GameScreen gameScreen; //criamos um novo objeto GameScreen para podermos usar

    public Game(){

        setSize(600, 600); //tamanho da janela
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //oq acontece por padrão quando fechamos a janela, nesse caso encerra o game
        setLocationRelativeTo(null); //diz onde a janela vai aparecer quando iniciar o game
        gameScreen = new GameScreen(); // aqui inicializamos o objeto GameScreen
        //Jframe.add(Jpanel);
        add(gameScreen);
    }

    public static void main(String[] args){
        Game game = new Game();
    }
}
