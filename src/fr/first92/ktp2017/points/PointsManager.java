package fr.first92.ktp2017.points;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PointsManager {

    private Player p;

    public Map<Player, Integer> points = new HashMap<>();

    public PointsManager(Player p) {
        this.p = p;
    }

    public PointsManager() {}

    public void addPoint(int amount) {

        if(points.containsKey(p)) points.replace(p, points.get(p) + amount);
        else points.put(p, amount);
    }

    public Map<Player, Integer> getPoints() {
        return points;
    }

    public Integer getPlayerPoints() {
        return points.get(p);
    }

    public void removePlayer() {

        points.remove(p);
    }
}
