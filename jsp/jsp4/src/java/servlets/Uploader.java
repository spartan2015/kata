package examples;

import java.net.*;
import java.io.*;

/** Performs an HTTP POST to upload a file to a servlet */
public class Uploader
{
    public static void main(String[] args)
    {
        if (args.length < 1)
        {
            System.out.println("Please supply the name of the file to upload.");
            System.exit(1);
        }

        try
        {
            File inFile = new File(args[0]);


// Open the file to be uploaded.
            InputStream in = new BufferedInputStream(
                new FileInputStream(inFile));

// Create a URL object for the destination servlet.
            URL destination = new URL("http://localhost:8080/servlet/"+
                "examples.FileReceiverServlet");

// Open a connection to the servlet.
            URLConnection conn = destination.openConnection();

// Tell the connection that there is output to be sent.
            conn.setDoOutput(true);

// Tell the receiver that this is a stream of bytes.
            conn.setRequestProperty("Content-type",
                "application/octet-stream");

// Tell the receiver how many bytes there are.
            conn.setRequestProperty("Content-length",
                ""+inFile.length());

            OutputStream out = conn.getOutputStream();

            byte[] buff = new byte[4096];

            int len;

// Copy bytes from the file to the output stream.
            while ((len = in.read(buff)) > 0)
            {
                out.write(buff, 0, len);
            }

            InputStream response = conn.getInputStream();

// Read the response back from the receiver servlet.
            while ((len = response.read(buff)) > 0)
            {
                System.out.write(buff, 0, len);
            }
        }
        catch (Exception exc)
        {
        }
    }
}

