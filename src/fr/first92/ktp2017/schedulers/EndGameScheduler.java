package fr.first92.ktp2017.schedulers;

import fr.first92.ktp2017.Ktp;
import fr.first92.octaapi.game.gamestate.GameState;
import fr.first92.octaapi.game.gamestate.GameStateManager;
import org.bukkit.scheduler.BukkitRunnable;

public class EndGameScheduler {

    int timer;
    int maxTimer;

    public EndGameScheduler(int timer) {

        this.maxTimer = timer;
        this.timer = timer;

        task.runTaskTimer(Ktp.getInstance(), 20, 20);
    }

    public BukkitRunnable task = new BukkitRunnable() {

        @Override
        public void run() {

            if(timer == maxTimer) new GameStateManager().setState(GameState.END);

            if(timer == 0) {

                Ktp.getInstance().getServer().shutdown();
            }

            timer --;
        }
    };
}
