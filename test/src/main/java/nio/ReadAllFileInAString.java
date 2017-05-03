package nio;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Battlestar on 2/16/2015.
 */
public class ReadAllFileInAString {

    @Test
    public void str() throws Exception{

        String contents = new String(Files.readAllBytes(
                Paths.get("alice.txt")), StandardCharsets.UTF_8);


    }
}
