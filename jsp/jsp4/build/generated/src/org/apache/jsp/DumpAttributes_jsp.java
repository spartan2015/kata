package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class DumpAttributes_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("<body>\n");
      out.write("This page has access to the following attributes:\n");
      out.write("<pre>\n");


// Create an array of the possible scopes.
    int scopes[] = new int[] {
        PageContext.PAGE_SCOPE,
        PageContext.REQUEST_SCOPE,
        PageContext.SESSION_SCOPE,
        PageContext.APPLICATION_SCOPE };

// Create names for each possible scope.
    String scopeNames[] = new String[] {
        "Page", "Request", "Session", "Application"
    };

    
    
// Loop through the possible scopes.
    for (int i=0; i < scopes.length; i++)
    {
        out.println("In the "+scopeNames[i]+" scope:");

// Get all the attribute names for the current scope.
        Enumeration e = pageContext.getAttributeNamesInScope(scopes[i]);

        while (e.hasMoreElements())
        {
// Get the attribute name.
            Object nameOb = e.nextElement();

// The name should always be a string, but just in case someone put
// some bad data somewhere, you won't get a class cast exception this way.
            if (nameOb instanceof String)
            {
// Print out the attribute name and its value.
                String name = (String) nameOb;

                out.print(name+": ");
                out.println(pageContext.getAttribute(name, scopes[i]));
            }
            else
            {
                out.println("Oops, the attribute name isn't a string! It's "+
                    nameOb.getClass().getName());
            }
        }
        out.println();
    }

      out.write("\n");
      out.write("</pre>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
