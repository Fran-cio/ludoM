package strategy.status;

public class RectaFinal implements Status{
    private int Resto;
    private String state;

    public RectaFinal(int resto) {
        state="RectaFinal";
        Resto = resto;
    }

    public int getResto() {
        return Resto;
    }

    public void setResto(int resto) {
        Resto = resto;
    }

    @Override
    public String getState() {
        return state;
    }
}
