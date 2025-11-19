package helpers;

import objects.PathPoint;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadSave {

    // --- CARREGAMENTO DE IMAGENS ---
    public static BufferedImage getSpriteAtlas() {
        BufferedImage img = null;
        // A barra "/" indica que busca na raiz do JAR (onde a pasta resources é descompactada)
        InputStream is = LoadSave.class.getResourceAsStream("/spriteatlas_torres_inimigos.png");

        try {
            if (is != null) {
                img = ImageIO.read(is);
            } else {
                System.out.println("Imagem spriteatlas não encontrada!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    // --- LEITURA DE ARQUIVOS (CORRIGIDO PARA JAR) ---

    // Mudamos de 'File' para 'InputStream'
    private static ArrayList<Integer> ReadFromFile(InputStream is) {
        ArrayList<Integer> list = new ArrayList<>();

        try {
            Scanner sc = new Scanner(is);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                // Pequena proteção contra linhas vazias
                if (!line.trim().isEmpty()) {
                    list.add(Integer.parseInt(line.trim()));
                }
            }
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static ArrayList<PathPoint> GetLevelPathPoints(String name) {
        // Tenta carregar o arquivo de dentro do JAR
        InputStream is = LoadSave.class.getResourceAsStream("/" + name + ".txt");

        if (is != null) {
            ArrayList<Integer> list = ReadFromFile(is);
            ArrayList<PathPoint> points = new ArrayList<>();
            // Verifica se a lista tem tamanho suficiente para evitar IndexOutOfBounds
            if (list.size() > 403) {
                points.add(new PathPoint(list.get(400), list.get(401)));
                points.add(new PathPoint(list.get(402), list.get(403)));
            }
            return points;
        } else {
            System.out.println("O arquivo " + name + ".txt não existe dentro do JAR!");
            return null;
        }
    }

    public static int[][] GetLevelData(String name) {
        // Tenta carregar o arquivo de dentro do JAR
        InputStream is = LoadSave.class.getResourceAsStream("/" + name + ".txt");

        if (is != null) {
            ArrayList<Integer> list = ReadFromFile(is);
            return Utilz.ArrayListTo2Dint(list, 20, 20);
        } else {
            System.out.println("O arquivo " + name + ".txt não existe dentro do JAR!");
            return null;
        }
    }

    // --- MÉTODOS DE SALVAR (AVISO IMPORTANTE) ---
    /*
     * IMPORTANTE:
     * Você NÃO consegue salvar/criar arquivos DENTRO do JAR enquanto ele roda.
     * Os métodos abaixo (CreateLevel, SaveLevel) só vão funcionar enquanto você
     * estiver rodando pelo IntelliJ.
     * Se você tentar usar o editor de níveis no JAR exportado, ele vai falhar ou
     * não salvar nada, pois o JAR é "somente leitura".
     */

    public static void CreateLevel(String name, int[] idArr) {
        // Mantivemos File aqui pois salvar exige acesso ao DISCO, não ao JAR.
        File newLevel = new File("resources/" + name + ".txt");
        if (newLevel.exists()) {
            System.out.println("O arquivo " + name + " ja existe.");
            return;
        } else {
            try {
                newLevel.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        WriteToFile(newLevel, idArr, new PathPoint(0, 0), new PathPoint(0, 0));
    }

    public static void WriteToFile(File f, int[] idArr, PathPoint start, PathPoint end) {
        try {
            PrintWriter pw = new PrintWriter(f);
            for (Integer i : idArr)
                pw.println(i);

            pw.println(start.getxCord());
            pw.println(start.getyCord());
            pw.println(end.getxCord());
            pw.println(end.getyCord());

            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void SaveLevel(String name, int[][] idArr, PathPoint start, PathPoint end) {
        File levelFile = new File("resources/" + name + ".txt");

        if (levelFile.exists()) {
            WriteToFile(levelFile, Utilz.twoDto1DArr(idArr), start, end);
        } else {
            System.out.println("o arquivo " + name + " não existe");
            return;
        }
    }
}