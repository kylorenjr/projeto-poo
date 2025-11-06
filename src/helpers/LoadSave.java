package helpers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class LoadSave {

        public static BufferedImage getSpriteAtlas() throws IOException {

            BufferedImage img = null;
            InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("AtlasSprites.png");

            try {
                img = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return img;
        }

        public static void CreateFile(){

            File txtFile = new File("resources/testSaveFile.txt");

            try {
                txtFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void WriteToFile(){
            File txtFile = new File("resources/testSaveFile.txt");

            try {
                PrintWriter pw = new PrintWriter(txtFile);
                pw.println("An? tomar no cu va");
                pw.println("suspicous bush");
                pw.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public static void ReadFromFile(){
            File txtFile = new File("resources/test.txt");
            try {
                Scanner sc = new Scanner(txtFile);

                while (sc.hasNextLine()){
                    System.out.println(sc.nextLine());
                }

                sc.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

}
