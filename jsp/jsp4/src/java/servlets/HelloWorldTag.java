package servlets;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class HelloWorldTag extends TagSupport
{
    public int doStartTag() throws JspException
    {
        try{
        
        JspWriter out = pageContext.getOut();
        out.println("<h1>This tag says: Hello World!</h1>");
        
        }catch(Throwable t){pageContext.getServletContext().log(t.getMessage());}
        
        return SKIP_BODY;
        
    }

    public int doEndTag()
    {
        return EVAL_PAGE;
    }
}


