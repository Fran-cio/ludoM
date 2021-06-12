package elements;
import javax.swing.*;
import java.awt.*;



public class Panel extends JPanel{
    private Image imagen;



@Override
    public void paint(Graphics g){

        imagen= new ImageIcon(getClass().getResource("C:\\Users\\Maximiliano\\Google Drive\\Facu\\Ing de software\\TestigosDeTuring\\Imagenes\\shield.png")).getImage();
        g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }

}
