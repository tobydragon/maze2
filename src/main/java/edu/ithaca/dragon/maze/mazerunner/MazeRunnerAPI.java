package edu.ithaca.dragon.maze.mazerunner;

import edu.ithaca.dragon.maze.Location;
import edu.ithaca.dragon.maze.KeyPress;

public interface MazeRunnerAPI {
    /**
     * Provides the MazeRunner with an object that lets them observe the maze in order to make informed decisions
     */
    void initialize(MazeRunnerVisionAPI mazeRunnerVision);

    /**
     * @param keyPress an enum representing the current key pressed
     * @return the cell to move to (does not need to be colocated with current position)
     */
    public Location chooseNewLocation(KeyPress keyPress);

    
}
