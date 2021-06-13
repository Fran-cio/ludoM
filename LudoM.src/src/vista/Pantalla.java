package vista;

public final class Pantalla {

    private final int ancho;
    private final int alto;
    public final int[] pixeles;

    public Pantalla(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;

        this.pixeles = new int[ancho * alto];
    }

    public void limpiar(){
        for (int i=0 ; i< pixeles.length ; i++){
            pixeles[i]=0;
        }
    }

}
