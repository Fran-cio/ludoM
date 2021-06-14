package vista.Graficos;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HojaSprites {
    private final int ancho;
    private final int alto;
    public final int[] pixeles;

    //colleccion de hojas de sprites
    public static HojaSprites texturas = new HojaSprites("/texturas/Planteilla1.png",320,320);
    //fin de la colleccion

    public HojaSprites(final String ruta, final int ancho, final int alto){
        this.ancho=ancho;
        this.alto=alto;

        pixeles = new int[ancho * alto];

        BufferedImage imagen = null;
        try {
            imagen = ImageIO.read(HojaSprites.class.getResource(ruta));

            imagen.getRGB(0,0,ancho,alto,pixeles,0,ancho);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getAncho() {
        return ancho;
    }
}
