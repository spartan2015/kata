package test.io;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.Test;

public class FileReadUsingByteBufferToString {

	@Test
	public void main() throws Exception {
		
		assertEquals("abcdefg", inputStreamToString(FileReadUsingByteBufferToString.class.getResourceAsStream("data.txt")));
		
	}
	
	@Test
	public void t(){
		String s = "/a/b/c/d/e/aasd.b";
        System.out.println(s.substring(s.lastIndexOf("/")+1));
	}
	

	public static String inputStreamToString(InputStream inputStream) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        byte[] data = new byte[2];

        int read = -1;
        while ((read = inputStream.read(data)) > 0)
        {
            sb.append(new String(Arrays.copyOf(data, read)));
        }

        return sb.toString();
    }
	
}
