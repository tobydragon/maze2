package edu.ithaca.dragon.maze;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class GridMoveTest {

    @Test
    public void calcNewLocationOrStayTest(){
        List<Location> allowedLocations = new ArrayList<>();
        allowedLocations.add(new Location(5, 4));
        allowedLocations.add(new Location(5, 6));
        Location startingLocation = new Location(5, 5);
        
        //check that a move up works because it is an allowed location
        Location above = GridMove.calcNewLocationOrStay(startingLocation, GridMove.UP, allowedLocations);
        assertEquals(new Location(5, 4), above);
        //check that a move left doesn't work (stays same) because it is not an allowed location
        Location same = GridMove.calcNewLocationOrStay(startingLocation, GridMove.LEFT, allowedLocations);
        assertEquals(startingLocation, same);
    }
    
}
