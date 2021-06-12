package strategy.status;

public interface Status {
    String getState();
    int    getResto();
    default Status getStatus(){
        return this;
    };
}
