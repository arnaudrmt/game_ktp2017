package fr.first92.ktp2017.event.event;

import fr.first92.ktp2017.Ktp;
import fr.first92.ktp2017.round.RoundState;
import fr.first92.octaapi.game.gamestate.GameState;
import fr.first92.octaapi.game.gamestate.GameStateManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageEvent implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {

        if(!(e.getDamager() instanceof Player) && !(e.getEntity() instanceof Player)) {
            e.setCancelled(true);
            return;
        }

        if(new GameStateManager().isState(GameState.GAME) &&
                Ktp.getInstance().getRoundManager().isRoundState(RoundState.PLAYING))
            new Wins().elimination((Player) e.getDamager(), (Player) e.getEntity());
    }

    @EventHandler
    public void onDamage(org.bukkit.event.entity.EntityDamageEvent e) {

        if(!(e.getEntity() instanceof Player)) {
            e.setCancelled(true);
            return;
        }

        if(!e.getCause().equals(org.bukkit.event.entity.EntityDamageEvent.DamageCause.ENTITY_ATTACK)) e.setCancelled(true);
        if(!new GameStateManager().isState(GameState.GAME) ||
                Ktp.getInstance().getRoundManager().isRoundState(RoundState.WAITING)) e.setCancelled(true);
    }
}
