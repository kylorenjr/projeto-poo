package helpers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {

    public static BufferedImage getSpriteAtlas() throws IOException {

        BufferedImage img = null;
        InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("AtlasSprites.png");

        img = ImageIO.read(is);
        return img;
    }
}
