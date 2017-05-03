/*
 * SessionRecorder.java
 *
 * Created on 20 septembrie 2007, 16:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package servlets;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Enumeration;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class SessionRecorder implements Filter
{
    public static final String RECORDING_FILE = "RECORDING_FILE";

    public static HashMap times = new HashMap();
    public static int recordingId;
    public static String recordingPrefix;
    public FilterConfig config;

    public SessionRecorder()
    {
    }

    public void init(FilterConfig filterConfig)
    {
        // Grab the destination of the recording files from
        // the filter configuration. The prefix should contain
        // a directory name and the beginning of a filename.
        // The rest of the filename will be a sequence number
        // and ".xml".
        recordingPrefix = filterConfig.getInitParameter("prefix");
        config = filterConfig;
    }

    public void destroy()
    {
    }

    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain chain)
        throws java.io.IOException, ServletException
    {
        // Ignore non-http requests.
        if (!(request instanceof HttpServletRequest))
        {
            chain.doFilter(request,response);
            return;
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        httpRequest.getSession();

        // Execute the JSP/servlet or chained filter.
        chain.doFilter(request, response);

        // Write the request out to the recording file.
        recordRequest((HttpServletRequest) request,
                (HttpServletResponse) response);
    }

    public synchronized static int getNextRecordingId()
    {
        return recordingId++;
    }

    public String generateRecordingFilename()
    {
        return recordingPrefix+getNextRecordingId()+".xml";
    }

    public PrintWriter openRecordingFile(String filename)
    {
        try
        {
            PrintWriter out = new PrintWriter(new BufferedWriter(
                        new FileWriter(filename, true)));
            return out;
        }
        catch (Exception exc)
        {
            config.getServletContext()
                        .log("Error opening recording file: ", exc);
            return null;
        }
    }

    public void recordRequest(HttpServletRequest request,
            HttpServletResponse response)
    {
        HttpSession session = request.getSession();

        // Get the recording file name.
        RecordingFile recordingFile =
            (RecordingFile) session.getAttribute(RECORDING_FILE);

        // If there is no recording file, create a new one.
        if (recordingFile == null)
        {
            recordingFile = new RecordingFile(generateRecordingFilename());
            session.setAttribute(RECORDING_FILE, recordingFile);
            initializeRecordingFile(recordingFile.filename);
        }

        // Write the request parameters and URI to the file.
        try
        {
            PrintWriter out = openRecordingFile(recordingFile.filename);
            if (out == null) return;

            out.println("<request>");
            out.print("<uri>");
            out.print(request.getRequestURI());
            out.println("</uri>");
            Enumeration e = request.getParameterNames();
            while (e.hasMoreElements())
            {
                String paramName = (String) e.nextElement();
                String[] values = request.getParameterValues(paramName);
                for (int i=0; i < values.length; i++)
                {
                    out.print("<param><name>");
                    out.print(paramName);
                    out.print("</name><value>");
                    out.print(values[i]);
                    out.println("</value></param>");
                }
            }
            out.println("</request>");
            out.close();
        }
        catch (Exception exc)
        {
            config.getServletContext()
                        .log("Error appending to recording file: ", exc);
        }
    }

    public void initializeRecordingFile(String filename)
    {
        try
        {
            PrintWriter out = openRecordingFile(filename);
            if (out == null) return;
            out.println("<?xml version=\"1.0\"?>");
            out.println("<session>");
            out.close();
        }
        catch (Exception exc)
        {
            config.getServletContext()
                        .log("Error initializing recording file: ", exc);
        }
    }

    public void finishRecordingFile(String filename)
    {
        try
        {
            PrintWriter out = openRecordingFile(filename);
            if (out == null) return;
            out.println("</session>");
            out.close();
        }
        catch (Exception exc)
        {
            config.getServletContext()
                        .log("Error finishing recording file: ", exc);
        }
    }

    class RecordingFile implements HttpSessionBindingListener
    {
        public String filename;

        public RecordingFile(String aFilename)
        {
            filename = aFilename;
        }

        public void valueBound(HttpSessionBindingEvent event)
        {
        }

        public void valueUnbound(HttpSessionBindingEvent event)
        {
            // When the session terminates, this method is invoked.
            // Close out the recording file by writing the closing tag.
            finishRecordingFile(filename);
        }
    }
}
