package fr.first92.ktp2017;

import fr.first92.ktp2017.event.EventsManager;
import fr.first92.ktp2017.game.Game;
import fr.first92.ktp2017.round.RoundManager;
import fr.first92.octaapi.game.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Ktp extends JavaPlugin {

    private GameManager game;
    private static Ktp instance;
    private RoundManager roundManager = new RoundManager();

    @Override
    public void onEnable() {

        instance = this;

        new Game();

        new EventsManager().registerEvents();
    }

    public RoundManager getRoundManager() {
        return roundManager;
    }

    public void setGame(GameManager game) {
        this.game = game;
    }

    public GameManager getGame() {
        return game;
    }

    public static Ktp getInstance() {
        return instance;
    }
}
