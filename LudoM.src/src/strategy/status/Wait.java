package strategy.status;

public class Wait implements Status {
    private String state;

    public Wait() {
        this.state="Wait";
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
