package lt.vu.mif.jate.tasks.task03.mt;

import lt.vu.mif.jate.tasks.task03.mt.tool.ClientTest;
import java.io.IOException;
import static junit.framework.TestCase.fail;
import lt.vu.mif.jate.tasks.task03.mt.client.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Test that server is dropping the subsequent
 * connections from the same IP. Only one is allowed!
 * No worries - this test suite must pass (in the beginning...)!
 * @author valdo
 */
@RunWith(JUnit4.class)
public class TestSuite02Test implements ClientTest {
    
    @Test
    public void ClientTest() {
        try (Client c1 = new Client(SERVER_ADDR)) {
            
            test("first connection works", c1);
            
            try (Client c2 = new Client(SERVER_ADDR)) {
                
                test("second connection fails", c2);
                fail("Must not reach this line");
                
            } catch (IOException ex) {
                // OK - it failed!
                System.out.println("OK!");
            }

        } catch (Exception ex) {
            fail(ex.getMessage());
        }
     }
    
}
