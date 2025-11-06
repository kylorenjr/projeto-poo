package helpers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
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

        public static void CreatLevel(String name, int[] idArr){
            File newLevel = new File("resources/" + name + ".txt"); //o nome do arquivo será correspondente ao level
            if(newLevel.exists()){
                System.out.println("O arquivo " + name + " ja existe.");
                return;
            } else {
                try {
                    newLevel.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            WriteToFile(newLevel, idArr);
        }

        public static void WriteToFile(File f, int[] idArr){

            try {
                PrintWriter pw = new PrintWriter(f);
                for(Integer i : idArr)
                    pw.println(i);

                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private static ArrayList<Integer> ReadFromFile(File file){
            ArrayList<Integer> list = new ArrayList<>();

            try {
                Scanner sc = new Scanner(file);

                while (sc.hasNextLine()){//NextLine?
                    list.add(Integer.parseInt(sc.nextLine()));
                }

                sc.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return list;
        }

        public static int[][] GetLevelData(String name){
            File lvlFile = new File("resources/" + name + ".txt");

            if (lvlFile.exists()){
                ArrayList<Integer> list = ReadFromFile(lvlFile);
                return Utilz.ArrayListTo2Dint(list, 20, 20);
            } else {
                System.out.println("o arquivo " + name + " não existe");
                return null;
            }

        }

}
