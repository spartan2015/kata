package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;
import servlets.*;

public final class ShowTimes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<h1>Current JSP/Servlet Times</h1>\n");
      out.write("<table border=\"4\">\n");
      out.write("<tr>\n");
      out.write("<th>URL</th><th>Total Requests</th><th># Pending</th>\n");
      out.write("<th>Weighted Average Time (mSec.)</th><th>Average Time</th>\n");
      out.write("</tr>\n");

    Times[] times = TimingFilter.getTimes();
    DecimalFormat formatter = new DecimalFormat("00.00");

    for ( int i = 0; i < times.length ; ++i ) {
       out.println("<tr>");
       out.println("<td>" + times[i].timerName + "</td>");
       out.println("<td>" + times[i].numAccesses + "</td>");
       out.println("<td>" + times[i].numPending + "</td>");
       out.println("<td>" + formatter.format(times[i].weightedAverage) + "</td>");
       out.println("<td>" + formatter.format(times[i].totalTime) + "</td>");
       out.println("</tr>");
        }


      out.write("\n");
      out.write("</table>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
