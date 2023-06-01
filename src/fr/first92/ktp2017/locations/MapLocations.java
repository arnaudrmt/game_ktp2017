package fr.first92.ktp2017.locations;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public enum MapLocations {

    LOC1(1, new Location(Bukkit.getWorld("world"), 0, 100, 10, 1, 1)),
    LOC2(2, new Location(Bukkit.getWorld("world"), 0, 100, 20, 1, 1)),
    LOC3(3, new Location(Bukkit.getWorld("world"), 0, 100, 30, 1, 1)),
    LOC4(4, new Location(Bukkit.getWorld("world"), 0, 100, 40, 1, 1)),
    LOC5(5, new Location(Bukkit.getWorld("world"), 0, 100, 50, 1, 1));

    private Integer round;
    private Location location;

    MapLocations(Integer round, Location location) {
        this.round = round;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public Integer getRound() {
        return round;
    }
}
