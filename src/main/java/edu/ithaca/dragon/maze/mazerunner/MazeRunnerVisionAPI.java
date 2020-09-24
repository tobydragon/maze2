package edu.ithaca.dragon.maze.mazerunner;

import java.util.List;

import edu.ithaca.dragon.maze.Location;

public interface MazeRunnerVisionAPI {
    Location getCurrentLocation();
    boolean atGoalNow();
    List<Location> allReachableNeighbors();
    boolean haveVisitedLocation(Location location);   
}