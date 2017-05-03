package servlets;

import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.apache.oro.io.RegexFilenameFilter;
import org.apache.oro.text.regex.*;


public class ReceiveUploadServlet extends GenericServlet
{
    public void service(ServletRequest request,
        ServletResponse response)
        throws IOException
    {
// Get the content type.
        String contentType = request.getContentType();
        
        
        
        
// Set a default for the boundary string length.
// Find out where the boundary string starts.
        int boundaryIndex = contentType.indexOf("boundary=");

// Get the boundary string.
        String boundary = contentType.substring(boundaryIndex+9);
        int boundaryStrLength = boundary.length();

// Get the input stream to read the uploaded file.
        ServletInputStream servIn = request.getInputStream();

        DataInputStream in = new DataInputStream(servIn);

// Lop off the headers from the content (read until you get a blank line).
        String line;
        /* you loop throgh this headers: - one of them can provide you the filename
         -----------------------------7d72c030140370
Content-Disposition: form-data; name="foo"; filename="D:\myrds.txt"
Content-Type: text/plain
         */
        java.util.ArrayList list = new ArrayList();
        
        StringBuffer utg = new StringBuffer();
        String destFile = new String("uploaded_file_unamed.txt");
        // good only if you send one multipar file
        // if you send more you need to detect that and receive other files or parameters
        /*
-----------------------------7d734d18140370
Content-Disposition: form-data; name="textInput1"

valueInput
-----------------------------7d734d18140370
Content-Disposition: form-data; name="textInput2"

valueInput
-----------------------------7d734d18140370
Content-Disposition: form-data; name="textInput3"

valueInput
         */
        
        while ((line = in.readLine()) != null)
        {
            //"/Content-Disposition: form-data; name=\"[a-z0-9A-Z]*\"; filename=\"[a-zA-Z0-9]\"/"
            //Content-Disposition: form-data; name=\"[a-z0-9A-Z]*\"; filename=\"[a-zA-Z0-9]\"
            //String sr = "Content-Disposition: form-data; name=\"formName\"; filename=\"FileName.txt\"Content-Disposition: form-data; name=\"formName\"; filename=\"FileName.txt\"";
            
            try{
            
            Perl5Matcher m = new Perl5Matcher();
            Pattern p = new Perl5Compiler().compile("filename=\"([:\\\\/a-zA-Z0-9\\.]*)\"");
            m.contains(line,p);
            MatchResult r = m.getMatch();
            if (r.groups() >= 2)
            {    
                destFile = r.group(1);
                int i1 = destFile.lastIndexOf("\\");
                int i2 = destFile.lastIndexOf("/");
                int f  = i1 > i2 ? i1 : i2;
                destFile = destFile.substring(f+1);                
            }
            //for(int u = 0; u < r.groups(); u++)
            //    utg.append(r.group(u)+"\r\n");
            
            }catch(Throwable t){System.err.println(t);}
            
            
            //utg.append("Line: " + line + "'r'n");
            //getServletContext().log("Got line: "+line);
            if (line.trim().length() == 0) break;
        }
        
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream(request.getContentLength());

        byte[] buffer = new byte[4096];
        int len;

// Copy the uploaded file to a byte array.
        while ((len = in.read(buffer)) > 0)
        {
            byteOut.write(buffer, 0, len);
        }

        byte[] outBytes = byteOut.toByteArray();

        String path = this.getServletContext().getRealPath("/") + "\\"+destFile;
        FileOutputStream fileOut = new FileOutputStream(path);

// Write the byte array out to the file, trim off the boundary plus some
// padding surrounding the boundary.
        fileOut.write(outBytes, 0, outBytes.length - boundaryStrLength - 8);
        fileOut.close();

// Tell the Web server that the response is HTML.
response.setContentType("text/html");

// Get the PrintWriter for writing out the response
        PrintWriter out = response.getWriter();

// Write the HTML back to the browser.
        out.println("<html>");
        out.println("<body>");

        String clientHost = request.getRemoteHost();

        out.println("File: "+path+" Accepted, thank you.");
        out.println(utg);

        out.println("</body>");
        out.println("</html>");
    }
}
