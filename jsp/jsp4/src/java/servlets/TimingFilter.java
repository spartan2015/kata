package servlets;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;


public class TimingFilter implements Filter
{
    // The table of time values for each JSP/Servlet
    public static HashMap times = new HashMap();

    public TimingFilter()
    {
    }

    public void init(FilterConfig filterConfig)
    {
    }

    public void destroy()
    {
    }

    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain chain)
        throws java.io.IOException, ServletException
    {
        // If this isn't an HTTP request, don't bother timing it.
        if (!(request instanceof HttpServletRequest))
        {
            chain.doFilter(request,response);
            return;
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Get the pathname of the requested JSP/servlet.
        String uri = httpRequest.getRequestURI();

        // See whether there is an existing time value for this object.
        Times time = (Times) times.get(uri);

        // If not, create a new one.
        if (time == null)
        {
            time = new Times(uri);
            times.put(uri, time);
        }

        time.begin(); // Tells the time object this is a pending request

        // Note the start time.
        long startTime = System.currentTimeMillis();

        // Invoke the JSP/servlet or other chained filter objects.
        chain.doFilter(request, response);

        // Note the finish time.
        long endTime = System.currentTimeMillis();

        // Tell the time object that the pending request has completed.
        time.end();

        // Add the execution time to the time object.
        time.addTime(endTime-startTime);
    }

    /** Returns an array of all the time values known by this filter */
    public static Times[] getTimes()
    {
        ArrayList timeArray = new ArrayList();

        for (Iterator iter=times.keySet().iterator(); iter.hasNext();)
        {
            timeArray.add(times.get(iter.next()));
        }

        return (Times[]) timeArray.toArray(
                new Times[timeArray.size()]);
    }
}

