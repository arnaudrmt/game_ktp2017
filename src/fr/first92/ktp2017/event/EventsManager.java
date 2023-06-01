package fr.first92.ktp2017.event;

import fr.first92.ktp2017.Ktp;
import fr.first92.ktp2017.event.event.EntityDamageEvent;
import fr.first92.ktp2017.event.event.QuitEvent;
import org.bukkit.plugin.PluginManager;

public class EventsManager {

    public void registerEvents() {

        Ktp ktp = Ktp.getInstance();
        PluginManager pm = ktp.getServer().getPluginManager();

        pm.registerEvents(new EntityDamageEvent(), ktp);
        pm.registerEvents(new QuitEvent(), ktp);
    }
}
