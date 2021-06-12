package strategy.status;

public class Moving implements Status {
    private String state;

    public Moving() {
        this.state = "Moving";
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
