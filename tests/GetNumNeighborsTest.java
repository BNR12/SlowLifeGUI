import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.SQLException;



/**
 * Created by brittanyregrut on 3/29/16.
 */
public class GetNumNeighborsTest {

    MainPanel mp;
    Cell[][] cells;

    @Before
    public void setUp(){
        mp = new MainPanel(15);
        cells = mp.getCells();
    }

    //Test that a corner cell, with all neighbors set alive, will return 3 for getNumNeighbors()
    @Test
    public void testCorner(){

        //reset the cells
        for (int x = 0; x < 15; x++){
            for (int y = 0; y < 15; y++){
                cells[x][y].reset();
            }
        }

        //set the neighboring cells alive
        cells[14][13].setAlive(true);
        cells[13][14].setAlive(true);
        cells[13][13].setAlive(true);

        //update cells
        mp.setCells(cells);

        //call getNumNeighbors()
        int neighbors = mp.getNumNeighbors(14, 14);

        //because this is a corner cell, and all neighbors have been set to true, should return 3
        assertEquals(neighbors, 3);
    }

    //Test that when all cells are not alive, and getNumNeighbors() is called on any cell, it will return 0
    @Test
    public void testAllDead(){

        //reset the cells
        for (int x = 0; x < 15; x++){
            for (int y = 0; y < 15; y++){
                cells[x][y].reset();
            }
        }

        //update cells
        mp.setCells(cells);

        //call getNumNeighbors() for some arbitrary cell
        int neighbors = mp.getNumNeighbors(5,5);

        //should return 0
        assertEquals(neighbors, 0);
    }

    //Test that for a cell with 8 neighbors, when 4 are set alive, getNumNeighbors() will return 4
    @Test
    public void testSomeNeighbors(){

        //reset the cells
        for (int x = 0; x < 15; x++){
            for (int y = 0; y < 15; y++){
                cells[x][y].reset();
            }
        }

        //set the neighboring cells alive, chosen cell is cells[3][3]
        cells[2][3].setAlive(true);
        cells[4][3].setAlive(true);
        cells[3][2].setAlive(true);
        cells[4][2].setAlive(true);

        //update cells
        mp.setCells(cells);

        //call getNumNeighbors()
        int neighbors = mp.getNumNeighbors(3, 3);

        //should return 4
        assertEquals(neighbors, 4);
    }


}
