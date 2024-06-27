import main.App;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void testHelloWorldOutput() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));

        App.main(new String[]{});

        System.setOut(originalOut);

        assertEquals("Hello, World!", outputStreamCaptor.toString().trim());
    }
}