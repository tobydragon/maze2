package edu.ithaca.dragon.maze.mazerunner;

import java.util.Collections;
import java.util.List;

import edu.ithaca.dragon.maze.GridMove;
import edu.ithaca.dragon.maze.Location;
import edu.ithaca.dragon.maze.Occupant;

public class MazeRunnerVisionImpl implements MazeRunnerVisionAPI{
    private List<List<Location>> grid;
    private Occupant player;
    private Location goal;
    private int numColumns;
    private int numRows;

    
    public MazeRunnerVisionImpl(List<List<Location>> grid, Occupant  player, Location goal, int gridColumns, int gridRows){
        this.grid = grid;
        this.player = player;
        this.goal = goal;
        this.numColumns = gridColumns;
        this.numRows = gridRows;
    }

    @Override
    public Location getCurrentLocation(){
        return player.getLocation();
    }

    @Override
    public List<Location> allReachableNeighbors() {
        List<Location> neighbors = GridMove.calcOpenMainNeighbors(grid, player.getLocation(), numColumns, numRows);
        Collections.shuffle(neighbors);
        return neighbors;
    }

    @Override
    public boolean atGoalNow() {
        return player.getLocation().equals(goal);
    }

    @Override
    public boolean haveVisitedLocation(Location location){
        return player.haveVisited(location);
    }
}