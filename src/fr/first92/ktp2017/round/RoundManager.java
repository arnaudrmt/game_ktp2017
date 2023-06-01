package fr.first92.ktp2017.round;

import java.util.Arrays;

public class RoundManager {

    private Integer round = 1;

    public boolean isRoundState(RoundState roundState) {
        return roundState.isState();
    }

    public RoundState getRoundState() {
        return Arrays.stream(RoundState.values()).filter(rs -> rs.isState()).findFirst().get();
    }

    public void setRoundState(RoundState roundState) {
        Arrays.stream(RoundState.values()).forEach(rs -> rs.setState(false));
        roundState.setState(true);
    }

    public boolean isRound(Integer round) {
        return this.round.equals(round);
    }

    public Integer getRound() {
        return round;
    }

    public void addRound() {
        this.round++;
    }
}
