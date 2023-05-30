import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTests {
    ArrayList allShipCoordinates;
    String[] ships;
    String[] guesses;
    Game game;
    @Before
    public void before() {
        game = new Game(0, 0);
        ships = new String[] { "3:3,3:5", "1:1,1:2" };
        guesses = new  String[] { "3:3", "1:1", "1:2" };
        allShipCoordinates = new ArrayList<String>();
        allShipCoordinates.add("3:3");
        allShipCoordinates.add("3:5");
        allShipCoordinates.add("3:4");
    }
    @Test
    public void canCreateShip(){
        assertEquals(allShipCoordinates,game.createShip(ships[0]));}

    @Test
    public void canHitShip(){
        assertEquals(true ,game.checkHit(allShipCoordinates,"3:3"));
        assertEquals(true ,game.checkHit(allShipCoordinates,"3:4"));
        assertEquals(true ,game.checkHit(allShipCoordinates,"3:5"));
        assertEquals(false ,game.checkHit(allShipCoordinates,"3:6"));
        assertEquals(false ,game.checkHit(allShipCoordinates,"3:6"));
    }
    @Test
    public void canPlay(){
        assertEquals("Ships Sunk = 1, Ships Left = 1" ,game.play(ships,guesses));
    }

}
