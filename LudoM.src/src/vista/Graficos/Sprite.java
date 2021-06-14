package vista.Graficos;

public final class Sprite {
    private final int lado;

    private int x;
    private int y;

    public int[] pixeles;
    private final HojaSprites hoja;

    //Colleccion de sprites
    public static Sprite piezaAmarilla  = new Sprite(32,0,0,HojaSprites.texturas);
    public static Sprite piezaVerde     = new Sprite(32,1,0,HojaSprites.texturas);
    public static Sprite piezaRoja      = new Sprite(32,2,0,HojaSprites.texturas);
    public static Sprite piezaAzul      = new Sprite(32,3,0,HojaSprites.texturas);
    public static Sprite escudo         = new Sprite(32,4,0,HojaSprites.texturas);
    public static Sprite piezaAmarillaP = new Sprite(32,5,0,HojaSprites.texturas);
    public static Sprite piezaVerdeP    = new Sprite(32,6,0,HojaSprites.texturas);
    public static Sprite piezaRojaP     = new Sprite(32,7,0,HojaSprites.texturas);
    public static Sprite piezaAzulP     = new Sprite(32,8,0,HojaSprites.texturas);
    public static Sprite Dado1          = new Sprite(32,9,0,HojaSprites.texturas);
    public static Sprite Dado2          = new Sprite(32,0,1,HojaSprites.texturas);
    public static Sprite Dado3          = new Sprite(32,1,1,HojaSprites.texturas);
    public static Sprite Dado4          = new Sprite(32,2,1,HojaSprites.texturas);
    public static Sprite Dado5          = new Sprite(32,3,1,HojaSprites.texturas);
    public static Sprite Dado6          = new Sprite(32,4,1,HojaSprites.texturas);

    //Colleccion de sprites

    public Sprite(final int lado,final int columna,final int fila,
                  final HojaSprites hoja) {
        this.lado = lado;
        this.pixeles = new int[this.lado*this.lado];

        this.x=columna * lado;
        this.y=fila * lado;
        this.hoja=hoja;

        for(int y=0 ; y< lado;y++){
            for(int x=0; x<lado ; x++){
                pixeles[x + y * lado] = hoja.pixeles[( x + this.x )
                        + ( y + this.y ) * hoja.getAncho()];
            }
        }
    }
}
