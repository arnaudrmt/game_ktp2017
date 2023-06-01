package fr.first92.ktp2017.round;

public enum RoundState {

    PLAYING(false), WAITING(true);

    private boolean state;

    RoundState(boolean state) {
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
