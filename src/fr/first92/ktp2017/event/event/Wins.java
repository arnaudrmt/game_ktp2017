package fr.first92.ktp2017.event.event;

import fr.first92.ktp2017.Ktp;
import fr.first92.ktp2017.points.PointsManager;
import fr.first92.ktp2017.schedulers.WaitingStartScheduler;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.Map;

public class Wins {

    public void elimination(Player p, Player target) {

        new PointsManager(p).addPoint(1);

        target.setGameMode(GameMode.SPECTATOR);

        if(Bukkit.getOnlinePlayers().stream().filter(rs -> rs.getGameMode().equals(GameMode.ADVENTURE)).count() <= 1) roundWin(p);
    }

    public void roundWin(Player p) {

        new PointsManager(p).addPoint(2);
        Ktp.getInstance().getRoundManager().addRound();

        if(!Ktp.getInstance().getRoundManager().isRound(6)) {

            Bukkit.broadcastMessage(p.getDisplayName() + " won the round with " + new PointsManager(p).getPlayerPoints() + " points");

            new WaitingStartScheduler(5);

        } else gameWin();
    }

    public void gameWin() {

        Map.Entry<Player, Integer> playerIntegerEntry = new PointsManager().getPoints().entrySet().stream()
                .min(Map.Entry.comparingByValue()).get();

        Bukkit.broadcastMessage(playerIntegerEntry.getKey() + " won with " + playerIntegerEntry.getValue() + " points");
    }
}
