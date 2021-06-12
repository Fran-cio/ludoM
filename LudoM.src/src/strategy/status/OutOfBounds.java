package strategy.status;

public class OutOfBounds implements Status{
    private String state;

    public OutOfBounds() {
        this.state = "OutOfBounds";
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
