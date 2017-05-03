package servlets;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class TestBodyTag extends BodyTagSupport
{
    public int doStartTag()
        throws JspException
    {
        return EVAL_BODY_BUFFERED;
    }

    public int doEndTag()
    {
        return EVAL_PAGE;
    }

    public void doInitTag()
    {
    }

    public int doAfterBody()
        throws JspException
    {
// Get the current body content
        BodyContent body = getBodyContent();

        try
        {
// Ask the body content to write itself out to the response.
           
            body.println("Print more of this<hr>");
            body.writeOut(body.getEnclosingWriter());
            
        }
        catch (IOException exc)
        {
            throw new JspException(exc.toString());
        }
// Tell the JSP engine that the body content has been evaluated.
        return SKIP_BODY;
    }
}
