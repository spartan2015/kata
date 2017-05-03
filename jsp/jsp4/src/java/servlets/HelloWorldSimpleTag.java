package servlets;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class HelloWorldSimpleTag extends SimpleTagSupport
{
    public void doTag()  throws JspException, IOException{
        
        getJspContext().getOut().write("<h1>SimpleTag Hello World</h2>");
        
    }
}
