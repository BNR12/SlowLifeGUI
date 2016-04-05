import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by brittanyregrut on 4/5/16.
 */
public class ToStringTest {

    //Test that toString() returns "." when called on a dead cell
    @Test
    public void testDeadCell(){

        //create a new cell
        Cell test = new Cell();

        //set the cell to dead
        test.setAlive(false);

        //call toString()
        String cellState = test.toString();

        //string should equal "."
        assertEquals(cellState, ".");
    }

    //Test that toString() returns "X" when called on an alive cell
    @Test
    public void testAliveCell(){

        //create a new cell
        Cell test = new Cell();

        //set the cell to alive
        test.setAlive(true);

        //call toString()
        String cellState = test.toString();

        //string should equal "X"
        assertEquals(cellState, "X");
    }


    //Test that toString() does not throw an exception of any kind
    @Test
    public void testNoError(){
        try{
            //create a new cell
            Cell test = new Cell();

            //set the cell to alive
            test.setAlive(true);

            //call toString()
            String cellState = test.toString();
        }catch (Exception e){

            //if any exception is caught, test fails
            fail();
        }
    }
}
