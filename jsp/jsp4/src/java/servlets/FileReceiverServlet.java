package examples;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

/** Receives a file uploaded via a straight HTTP POST request */


public class FileReceiverServlet extends HttpServlet
{
    public void service(HttpServletRequest request,
        HttpServletResponse response)
        throws java.io.IOException, ServletException
    {
// Get the input stream for reading the file.
        InputStream in = request.getInputStream();

// save file to root of web directory
        String path = getServletContext().getRealPath("/");

        OutputStream fileOut = new BufferedOutputStream(
            new FileOutputStream("/tmp/uploaded_file"));
// Create a buffer for reading bytes from the input stream.
        byte[] buff = new byte[4096];
        int len;

// Read bytes from the input stream, and write them to the file.
        while ((len = in.read(buff)) > 0)
        {
            fileOut.write(buff, 0, len);
        }
        fileOut.close();

// Send a response back to the client saying the upload was successful.
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        out.println("Upload successful!");
    }
}
