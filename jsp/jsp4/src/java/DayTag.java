package servlets;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;

public class DayTag extends TagSupport
{
    public int doStartTag()
        throws JspException
    {
// Get the time of day.
        GregorianCalendar currTime = new GregorianCalendar();

// Get the hour of day.
        int hour = currTime.get(Calendar.HOUR_OF_DAY);

// If the time is between 6 a.m. and 6 p.m., tell the JSP engine to
// include the text between the start and end tag.
        if ((hour >= 6) && (hour <= 18))
        {
            return EVAL_BODY_INCLUDE;
        }
        else
        {
// Otherwise, ignore the body text.
            return SKIP_BODY;
        }
    }

    public int doEndTag()
    {
        return EVAL_PAGE;
    }
}
