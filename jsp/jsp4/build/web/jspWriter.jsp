<%
/*
Built-in objects:

    request HttpServletRequest 
    response HttpServletResponse 
    out JspWriter 
    session HttpSession 
    application ServletContext 
    pageContext PageContext 
    config ServletConfig 
    page Object - this page - for other scripting languages than java that need to implement the same objects
    exception Throwable
 
 
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

        public void forward(String url)    throws IOException, ServletException
        public void include(String url)    throws IOException, ServletException

        You can prevent the content of the buffer from being flushed prior to processing the include by using
        public void include(String url, boolean flush)   throws IOException, ServletException





    
    
        
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
%>