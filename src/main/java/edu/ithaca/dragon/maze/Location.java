package edu.ithaca.dragon.maze;

// Represents one tile in the grid
public class Location {

    private boolean isWall = false;
    private int x;
    private int y;
  
    public Location(int x, int y) {
      this.x = x;
      this.y = y;
    }
  
    public boolean isWall() {
      return isWall;
    }
  
    public void setWall(boolean wall) {
      isWall = wall;
    }
  
    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Location)) {
        return false;
      }
      Location otherLoc = (Location) obj;
      return otherLoc.x == x && otherLoc.y == y;
    }
  
    @Override
    public String toString() {
      return  "(" + x + ", " + y + ")";
    }

    public int getX(){
      return x;
    }

    public int getY(){
      return y;
    }

  }