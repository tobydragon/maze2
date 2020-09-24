package edu.ithaca.dragon.maze;

import java.util.HashSet;
import java.util.Set;

public class Occupant {
    private Location currentLocation;
    private Set<Location> visitedLocations;

    public Occupant(Location startingLocation){
        currentLocation = startingLocation;
        visitedLocations = new HashSet<>();
    }

    public Location getLocation(){
        return currentLocation;
    }

    public void setLocation(Location newLocation){
        currentLocation = newLocation;
        visitedLocations.add(newLocation);
    }

    public boolean haveVisited(Location cellToCheck){
        return visitedLocations.contains(cellToCheck);
    }
}