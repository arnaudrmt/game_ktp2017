package fr.first92.ktp2017.schedulers;

import fr.first92.ktp2017.Ktp;
import fr.first92.ktp2017.event.event.Wins;
import fr.first92.ktp2017.locations.MapManager;
import fr.first92.ktp2017.round.RoundState;
import fr.first92.octaapi.utils.Title;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.scheduler.BukkitRunnable;

public class WaitingStartScheduler {

    int maxtimer;
    int timer;

    public WaitingStartScheduler(int timer) {
        this.maxtimer = timer;
        this.timer = timer;

       task.runTaskTimer(Ktp.getInstance(), 20, 20);
    }

    public BukkitRunnable task = new BukkitRunnable() {

        @Override
        public void run() {

            if(Bukkit.getOnlinePlayers().size() <= 1) {
                new Wins().gameWin();
                task.cancel();
            }

            if(timer == maxtimer) {

                Ktp.getInstance().getRoundManager().setRoundState(RoundState.WAITING);

                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.setGameMode(GameMode.ADVENTURE);
                    new Title().sendFullTitle(player, 10, 20, 10, "§6" + Ktp.getInstance().getRoundManager().getRound() + "st Round", "§7Be the last one standing!");
                    player.teleport(new MapManager().getMapByRound(Ktp.getInstance().getRoundManager().getRound()).getLocation());
                });
            }

            if(timer > 0) {

                Bukkit.getOnlinePlayers().stream().filter(rs -> rs.getGameMode().equals(GameMode.ADVENTURE))
                        .forEach(player -> {

                            player.setLevel(timer);
                        });

            } else {

                Bukkit.getOnlinePlayers().stream().forEach(player -> {
                    player.setLevel(0);
                    Ktp.getInstance().getRoundManager().setRoundState(RoundState.PLAYING);
                });

                task.cancel();
            }

            timer --;
        }
    };
}
