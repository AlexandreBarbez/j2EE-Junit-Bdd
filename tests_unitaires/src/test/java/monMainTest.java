import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alex on 22/04/2014.
 */
public class monMainTest {

    @Test
    public void renvoieUnNombre(){
            assertEquals(2,monMain.trouverValeurAbsolue(-2));
    }



}
