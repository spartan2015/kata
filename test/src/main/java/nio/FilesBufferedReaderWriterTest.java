package nio;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Battlestar on 2/3/2015.
 */
public class FilesBufferedReaderWriterTest {

    @Test
    public void test(){

        try(BufferedReader br = Files.newBufferedReader(Paths.get("./source"),Charset.forName("UTF-8"));
        BufferedWriter bw = Files.newBufferedWriter(Paths.get("./source"), Charset.forName("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE)){

/*
            * Opens or creates a file for writing, returning a {@code BufferedWriter}
            * that may be used to write text to the file in an efficient manner.
            * The {@code options} parameter specifies how the the file is created or
                    * opened. If no options are present then this method works as if the {@link
                *StandardOpenOption#CREATE CREATE}, {@link
                * StandardOpenOption#TRUNCATE_EXISTING TRUNCATE_EXISTING}, and {@link
                * StandardOpenOption#WRITE WRITE} options are present. In other words, it
                    * opens the file for writing, creating the file if it doesn't exist, or
                    * initially truncating an existing {@link #isRegularFile regular-file} to
                    * a size of {@code 0} if it exists.

*/

        }catch(IOException e){

        }

    }

}
