package fr.first92.ktp2017.game;

import fr.first92.ktp2017.Ktp;
import fr.first92.ktp2017.schedulers.WaitingStartScheduler;
import fr.first92.octaapi.game.GameManager;

import java.util.Arrays;
import java.util.List;

public class Game extends GameManager {

    public Game() {
        super(Ktp.getInstance(), "KTP2017",5,1);
        Ktp.getInstance().setGame(this);
    }

    @Override
    public List<String> description() {
        return Arrays.asList("This game is played in 5 rounds!",
                "The goal is too kill the most enemies possible.",
                "You can one-tap your enemies.",
                "Good Luck and have fun");
    }

    @Override
    public void launchGame() {

        new WaitingStartScheduler(5);
    }
}
