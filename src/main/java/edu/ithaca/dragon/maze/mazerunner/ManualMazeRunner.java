package edu.ithaca.dragon.maze.mazerunner;

import edu.ithaca.dragon.maze.Location;
import edu.ithaca.dragon.maze.GridMove;
import edu.ithaca.dragon.maze.KeyPress;

public class ManualMazeRunner implements MazeRunnerAPI {

    private MazeRunnerVisionAPI myVision;

    @Override
    public void initialize(MazeRunnerVisionAPI mazeRunnerVision) {
        myVision = mazeRunnerVision;
    }

    @Override
    public Location chooseNewLocation(KeyPress keyPress) {
        GridMove move = keyPress.convertToMove();
        return GridMove.calcNewLocationOrStay(myVision.getCurrentLocation(), move, myVision.allReachableNeighbors());
    }
    
}
