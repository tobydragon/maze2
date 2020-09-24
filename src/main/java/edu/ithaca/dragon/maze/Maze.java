package edu.ithaca.dragon.maze;

import bridges.games.NonBlockingGame;
import edu.ithaca.dragon.maze.mazerunner.MazeRunnerAPI;
import edu.ithaca.dragon.maze.mazerunner.MazeRunnerVisionImpl;
import bridges.base.NamedColor;
import bridges.base.NamedSymbol;

import java.util.Arrays;
import java.util.List;

class Maze extends NonBlockingGame {
  private int numColumns;
  private int numRows;
  private List<List<Location>> grid;
  private int pauseMillis;

  private Location goalLocation;
  private Occupant player;
  private MazeRunnerAPI mazeRunner;

  public Maze(MazeRunnerAPI mazeRunner, int bridgesWebpageId, String bridgesUserId, String bridgesApiKey, int numColumns, int numRows) {
    super(bridgesWebpageId, bridgesUserId, bridgesApiKey, numColumns, numRows);
    this.mazeRunner = mazeRunner;
    this.numColumns = numColumns;
    this.numRows = numRows;
    this.pauseMillis = 0;
    randomizeAndSetupCells();
    
    setTitle("A-Maze-ing");
    setDescription("A maze to be solved by a player, or maybe someday a computer...");
    start();
  }

  private void randomizeAndSetupCells(){
    grid = MazeCreator.createMazeLocations(numRows, numColumns);
    player = new Occupant(grid.get(1).get(1));
    goalLocation = grid.get(numColumns-2).get(numRows-2);
    mazeRunner.initialize(new MazeRunnerVisionImpl(grid, player, goalLocation, numColumns, numRows));
  }

  @Override
  public void initialize() {
    drawMaze();
  }

  // Game loop will run many times per second.
  @Override
  public void gameLoop() {
    try {
      Thread.sleep(pauseMillis);
    }
    catch (InterruptedException e){
      System.err.println("WARNING: Wait interrupted, message:" + e);
    }

    KeyPress keyPress = getSingleKeyPress();
    if (keyPress == KeyPress.SPACE){
      randomizeAndSetupCells();
    }
    else if (mazeIsSolved()){
      displaySolvedMessage(goalLocation);
    }
    else {
      Location newLocation = mazeRunner.chooseNewLocation(keyPress);
      if (!newLocation.isWall()){
        player.setLocation(newLocation);
        drawMaze();
      }
    }
  }

  private KeyPress getSingleKeyPress() {
      if (keyLeft()){
        return KeyPress.LEFT;
      } 
      else if(keyRight()){
        return KeyPress.RIGHT;
      } 
      else if(keyUp()){
        return KeyPress.UP;
      }
      else if(keyDown()){
        return KeyPress.DOWN;
      }
      else if (keyA()){
        return KeyPress.A;
      } 
      else if(keyD()){
        return KeyPress.D;
      } 
      else if(keyW()){
        return KeyPress.W;
      }
      else if(keyS()){
        return KeyPress.S;
      }
      else if (keySpace()) {
        return KeyPress.SPACE;
      }
      else {
        return KeyPress.NONE;
      }
  }
  
  private void drawMaze() {
    //draw grid
    for (List<Location> column: grid){
      for (Location c : column) {
        if (c.isWall()) {
          setBGColor(c.getY(), c.getX(), NamedColor.black);
        }
        else {
          setBGColor(c.getY(), c.getX(), NamedColor.white);
        }
        drawSymbol(c.getY(), c.getX(), NamedSymbol.none, NamedColor.white);
      }
    }
    
    //draw player and goal
    setBGColor(player.getLocation().getY(), player.getLocation().getX(), NamedColor.blue);
    setBGColor(goalLocation.getY(), goalLocation.getX(), NamedColor.gold);
  }

  private boolean mazeIsSolved() {
    return player.getLocation().equals(goalLocation);
  }

  private void displaySolvedMessage(Location goalLocation) {
    int x = goalLocation.getX() - 6;
    int y = goalLocation.getY();
    List<NamedSymbol> solvedText = Arrays.asList(
      NamedSymbol.campfire,
      NamedSymbol.G,
      NamedSymbol.O,
      NamedSymbol.A,
      NamedSymbol.L,
      NamedSymbol.campfire
      );
    for (NamedSymbol symbol : solvedText){
      drawSymbol(y, x, symbol, NamedColor.darkviolet );
      x++;
    }
    setBGColor(goalLocation.getY(),goalLocation.getX(), NamedColor.goldenrod);
  }
}


