import javax.swing.*;
import java.awt.*;


public class Tabla extends JFrame{
  private JPanel tablero2;
    //private Panel fondo;
    private JLabel jLabel1;

    public Tabla(){

        this.setLayout(null);
        setTitle("Ludo Matic");
        setLocationRelativeTo(null);
        this.setResizable(false);
        setMinimumSize(new Dimension(200,200));
        this.setBounds(0, 0, 800, 800);
        //setSize(800,800);
        this.getContentPane().setBackground(Color.darkGray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.tablero2.setBounds(0, 0, 500, 500);
        this.tablero2.setBackground(new Color(190, 190, 190));
        this.tablero2.setVisible(false);
        this.add(tablero2);


        JPanel[][] tablero1 = new JPanel[15][15];
    for(int i=0;i<15;i++) {
        for (int j = 0; j < 15; j++) {
            tablero1[i][j] = new JPanel();
            tablero1[i][j].setBounds((i + 1) * 40, (j + 1) * 40, 40, 40);
            this.add(tablero1[i][j]);
            if ((i <= 5 && j <= 5) || (i == 1 && j == 6) || ((i > 0 && i < 7) && j == 7)) {
                tablero1[i][j].setBackground(new Color(3, 94, 23));
            } else if ((i >= 9 && j <= 5) || (i == 8 && j == 1) || ((j > 0 && j < 7) && i == 7)) {
                tablero1[i][j].setBackground(new Color(217, 4, 4));
            } else if ((i <= 5 && j >= 9) || (i == 6 && j == 13) || ((j > 7 && j < 14) && i == 7)) {
                tablero1[i][j].setBackground(new Color(232, 210, 3));
            } else if ((i >= 9 && j >= 9) || (i == 13 && j == 8) || ((i > 7 && i < 14) && j == 7)) {
                tablero1[i][j].setBackground(new Color(3, 41, 232));
            } else {
                tablero1[i][j].setBackground(new Color(253, 253, 253));
            }

            tablero1[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }

   /* fondo = new Panel();
    tablero1[1][8].add(fondo);
    tablero1[1][8].setOpaque(true);*/

        /*jLabel1 = new JLabel();
        jLabel1.setIcon(new ImageIcon("C:\\Users\\Maximiliano\\Google Drive\\Facu\\Ing de software\\TestigosDeTuring\\Imagenes\\shield.png"));
        tablero1[1][8].setOpaque(false);
        tablero1[1][8].add(jLabel1);
        tablero1[1][8].repaint();
        tablero1[1][8].revalidate();
        this.repaint();
        this.revalidate();*/
        jLabel1 = new JLabel();
        Image img= new ImageIcon("C:\\Users\\Maximiliano\\Google Drive\\Facu\\Ing de software\\TestigosDeTuring\\Imagenes\\shield.png").getImage();
        ImageIcon img2=new ImageIcon(img.getScaledInstance(tablero1[1][8].getWidth(), tablero1[1][8].getHeight(), Image.SCALE_SMOOTH));
        jLabel1.setIcon(img2);
        tablero1[1][8].add(jLabel1);




    }






}