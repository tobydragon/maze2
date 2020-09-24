package edu.ithaca.dragon.maze.mazerunner;

import java.util.List;

import edu.ithaca.dragon.maze.Location;
import edu.ithaca.dragon.maze.GridMove;
import edu.ithaca.dragon.maze.KeyPress;

public class HumanChoiceMazeRunner implements MazeRunnerAPI {
    private MazeRunnerVisionAPI myVision;

    public HumanChoiceMazeRunner() {
        myVision = null;
    }

    @Override
    public void initialize(MazeRunnerVisionAPI mazeRunnerVision) {
        myVision = mazeRunnerVision;
    }

    @Override
    public Location chooseNewLocation(KeyPress keyPress) {
        List<Location> allPossibleMoves = myVision.allReachableNeighbors();
        Location newLocation = myVision.getCurrentLocation();

        //TODO:
        //if there is only one location to go to, return that location 
        //else if there are only two locations, you came from one, go to the other one
        //hint, you'll need to "remember" the last location as a property
        //otherwise, there are too many choices, just let the user's keypress choose like ManualMazeRunner
        
        return newLocation;
    }
}
