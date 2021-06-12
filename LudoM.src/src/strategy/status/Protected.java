package strategy.status;

public class Protected implements Status {
    private String state;

    public Protected() {
        this.state="Protected";
    }
    @Override
    public String getState() {
        return state;
    }

    @Override
    public int getResto() {
        return 0;
    }
}
