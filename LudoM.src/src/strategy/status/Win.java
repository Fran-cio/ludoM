package strategy.status;

public class Win implements Status {
    private String state;

    public Win() {
        this.state = "Win";
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
