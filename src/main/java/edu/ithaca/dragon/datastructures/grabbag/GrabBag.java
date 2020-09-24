package edu.ithaca.dragon.datastructures.grabbag;

import edu.ithaca.dragon.maze.Location;

public interface GrabBag {
    void putSomethingIn(Location item);
    boolean isEmpty();
    Location takeSomethingOut();
}
