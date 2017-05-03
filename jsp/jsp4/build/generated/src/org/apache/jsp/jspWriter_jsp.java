package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jspWriter_jsp extends org.apache.jasper.runtime.HttpJspBase
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


/*
Built-in objects:
    request
    response
    out
    application - ServletContext
    config - ServletConfig
    page - this page - for other scripting languages than java that need to implement the same objects
    
     
   pageContext - acts as a central repository for information that a JSP might need to obtain.
       .
        public ServletRequest getRequest()
        public ServletResponse getResponse()
        public JspWriter getOut()
        public HttpSession getSession()
        public ServletContext getServletContext()
        public ServletConfig getServletConfig()
        public Object getPage()
        public Throwable getException()
        
        public Object getAttribute(String name)
        public void setAttribute(String name, Object ob)
        public void removeAttribute(String name)
        
        Public Object getAttribute(String name, int scope)
        Public void setAttribute(String name, Object object,int scope)
        public void removeAttribute(String name, int scope)
        //PAGE_SCOPE, REQUEST_SCOPE, SESSION_SCOPE, and APPLICATION_SCOPE. 
        Object ob = pageContext.getAttribute("object",pageContext.PAGE_SCOPE);
        public Enumeration getAttributeNamesInScope(int scope)
        public Object findAttribute(String name)
        public int getAttributesScope(String name)





    
    
        
out.println();
out.newLine();
out.clear(); - throws IOException - clear entire page, throw exception when some content already sent to browser
out.clearBuffer(); clears the current buffer;
out.isAutoFlush(); 

out.getBufferSize();
out.getRemaining();
*/        

out.println(out.getBufferSize()); // return 0 if auto-managed
out.println(out.getRemaining());

//pageContext.forward();
pageContext.include("UploadForm.jsp");

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
