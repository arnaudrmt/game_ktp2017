package fr.first92.ktp2017.event.event;

import fr.first92.ktp2017.points.PointsManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        Player p = e.getPlayer();

        new PointsManager(p).removePlayer();

        if(Bukkit.getOnlinePlayers().size() <= 1) new Wins().gameWin();
    }
}
