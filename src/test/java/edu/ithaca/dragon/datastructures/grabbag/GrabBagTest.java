package edu.ithaca.dragon.datastructures.grabbag;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.maze.Location;


public class GrabBagTest {
    
    public GrabBag createInstance(){
        //TODO: return an instance of your class that implements GrabBag
        return null;
    }
    
    @Test
    public void simplePutTakeTest(){
        GrabBag myGrabBag = createInstance();
        myGrabBag.putSomethingIn(new Location(0, 0));
        assertEquals(new Location(0, 0), myGrabBag.takeSomethingOut());
    }

    @Test
    public void isEmptyTest(){
        GrabBag myGrabBag = createInstance();
        assertTrue(myGrabBag.isEmpty());
        myGrabBag.putSomethingIn(new Location(0, 0));
        assertFalse(myGrabBag.isEmpty());
        myGrabBag.putSomethingIn(new Location(1, 1));
        assertFalse(myGrabBag.isEmpty());
        assertFalse(myGrabBag.isEmpty());
        myGrabBag.takeSomethingOut();
        assertFalse(myGrabBag.isEmpty());
        myGrabBag.takeSomethingOut();
        assertTrue(myGrabBag.isEmpty());
        assertTrue(myGrabBag.isEmpty());
    }

    @Test
    public void complexPutTakeTest(){
        GrabBag myGrabBag = createInstance();
        myGrabBag.putSomethingIn(new Location(5, 5));
        assertEquals(new Location(5, 5), myGrabBag.takeSomethingOut());
        
        myGrabBag.putSomethingIn(new Location(3, 2));
        myGrabBag.putSomethingIn(new Location(11, 22));
        Location location = myGrabBag.takeSomethingOut();
        assertTrue(location.equals(new Location(3, 2)) || location.equals(new Location(11, 22)));
        location = myGrabBag.takeSomethingOut();
        assertTrue(location.equals(new Location(3, 2)) || location.equals(new Location(11, 22)));

        myGrabBag.putSomethingIn(new Location(7, 3));
        assertEquals(new Location(7, 3), myGrabBag.takeSomethingOut());
    }

    @Test
    public void sameItemsTest(){
        GrabBag myGrabBag = createInstance();
        for (int i=0; i<9; i++){
            if (i%2==0){
                myGrabBag.putSomethingIn(new Location(2, 2));
            }
            else{
                myGrabBag.putSomethingIn(new Location(1, 1));
            }
        }
        assertFalse(myGrabBag.isEmpty());

        int count1s = 4;
        int count2s = 5;
        for (int i=0; i<9; i++){
            Location itemRetrieved = myGrabBag.takeSomethingOut();
            if (itemRetrieved.equals(new Location(1, 1))){
               count1s--;
            }
            else if (itemRetrieved.equals(new Location(2, 2))){
                count2s--;
            }
            else {
                fail("unrecognized item");
            }
        }
        assertTrue(myGrabBag.isEmpty());
        assertEquals(0, count1s);
        assertEquals(0, count2s);
    }

    @Test
    public void lotsOfItemsTest(){
        GrabBag myGrabBag = createInstance();
        assertTrue(myGrabBag.isEmpty());
        for (int i=0; i<10000; i++){  
            myGrabBag.putSomethingIn(new Location(i+2, i+1));
        }
        assertFalse(myGrabBag.isEmpty());


        for (int i=0; i<5000; i++){  
            Location itemRetrieved = myGrabBag.takeSomethingOut();
            assertTrue(itemRetrieved.getX()>=2 && itemRetrieved.getX() < 10002);
            assertTrue(itemRetrieved.getY()>=1 && itemRetrieved.getY() < 10001);
            assertEquals(1, itemRetrieved.getX()-itemRetrieved.getY());
        }
        assertFalse(myGrabBag.isEmpty());

        for (int i=0; i<5000; i++){  
            myGrabBag.putSomethingIn(new Location(i+2, i+1));
        }
        assertFalse(myGrabBag.isEmpty());

        for (int i=0; i<10000; i++){
            Location itemRetrieved = myGrabBag.takeSomethingOut();
            assertTrue(itemRetrieved.getX()>=2 && itemRetrieved.getX() < 10002);
            assertTrue(itemRetrieved.getY()>=1 && itemRetrieved.getY() < 10001);
            assertEquals(1, itemRetrieved.getX()-itemRetrieved.getY());
        }
        assertTrue(myGrabBag.isEmpty());
    }
}
