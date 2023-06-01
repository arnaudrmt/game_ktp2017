package fr.first92.ktp2017.locations;

import java.util.Arrays;

public class MapManager {

    public MapLocations getMapByRound(Integer round) {
        return Arrays.stream(MapLocations.values()).filter(rs -> rs.getRound().equals(round)).findFirst().get();
    }
}
