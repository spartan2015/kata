<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@ page language="java" import="servlets.*" %>


<%!
public java.util.Enumeration t;

public void jspInit(){
    
   t = this.getServletConfig().getServletContext().getInitParameterNames();
    
}

public void jspDestroy()
    {
        t = null;
    }


public void printParameters(JspWriter out, HttpServletRequest request)throws java.io.IOException, ServletException  {
try{
    
java.util.Enumeration a = request.getParameterNames();
while(a.hasMoreElements())
{
    String p = (String)a.nextElement();
    if (request.getParameterValues(p).length > 1)
        for(int y = 0; y<request.getParameterValues(p).length; y++)
            out.println("Parameter name: " + p + ", Value: " + request.getParameterValues(p)[y]);
    else    
        out.println("Parameter name: " + p + ", Value: " + request.getParameter(p));
} 

}catch(Throwable t){System.out.println(t);}
}
 
public void printCookies(JspWriter out, HttpServletRequest request)throws java.io.IOException, ServletException  {
    //throws  java.lang.Exception
 try{  
    Cookie[] c = request.getCookies();
    for(int i = 0; i<c.length; i++){
        out.println("\nCookie "+i+":");        
        out.println("Name: " + ((Cookie)c[i]).getName());
        out.println("Value: " + ((Cookie)c[i]).getValue());
        out.println("Domain " + ((Cookie)c[i]).getDomain());
        out.println("Path " + ((Cookie)c[i]).getPath());
        out.println("Version: " + ((Cookie)c[i]).getVersion());
        out.println("Secure: " + ((Cookie)c[i]).getSecure());
        out.println("MaxAge: " + ((Cookie)c[i]).getMaxAge());
    }
        
 }catch(Throwable t){System.out.println(t);}   
}


%>


<%
out.println("<pre>");
        
//request.
//public Object getAttribute(String name)
//public void setAttribute(String name, Object attr)
//public void removeAttribute(String name)

//request.setAttribute("attr1","an object of string type");
//request.getAttribute("attr1");
//request.removeAttribute("attr1");

//public java.util.Enumeration getAttributeNames()

/*
public String getServerName()
public int getServerPort()

public String getLocalName()
public String getLocalAddr()
public int getLocalPort()

public String getRemoteHost()
public String getRemoteAddr()
public Int getRemotePort()

Example schemes would be http, https, and ftp.
public String getProtocol()
public String getScheme()


 *public boolean isSecure()

When your servlet processes requests made via the secure protocol HTTPS (HTTP over SSL), you can access the client's security certificate, if it is available,
with the attribute javax.servlet.request.X509Certificate


//size and type of data sent to the servlet: text/html, text/xml, image/jpeg, excel, etc
public int getContentLength()
public String getContentType()

public String getCharacterEncoding()
 *
 *
 *
 *public void setCharacterEncoding(String env)
throws UnsupportedEncodingException

To read the request content, use either getReader or getInputStream:

public java.io.BufferedReader getReader()
    throws IOException
public ServletInputStream getInputStream()
    throws IOException

To read binary data, use getInputStream

 *public java.util.Locale getLocale()
public java.util.Enumeration getLocales()




public String getMethod()












Date d = new Date(getDateHeader("If-Modified-Since"));

public String getHeader(String name)
public java.util.Enumeration getHeaders(String name)

public java.lang.String getServletPath()

 
public java.lang.String getRequestURI()
public java.lang.StringBuffer getRequestURL()

 *public String getQueryString()


*/


out.println("getContextPath()" + request.getContextPath());
out.println("getPathInfo()" + request.getPathInfo());
out.println("getPathTranslated()" + request.getPathTranslated());
out.println("getMethod()" + request.getMethod());
out.println("getRequestURI()" + request.getRequestURI());
out.println("getRequestURL()" + request.getRequestURL());
out.println("getServletPath()" + request.getServletPath());
out.println("getQueryString()" + request.getQueryString());


String path = getServletContext().getRealPath("/");
out.println("Path: "+path);
//print parameters
printParameters(out,request);



//print cookies
printCookies(out,request);


//print session details and vars
out.println("Hello World");


out.println("");


HttpSession session1 = request.getSession(true);
out.println("session.isNew " + new Boolean(session1.isNew()).toString());
out.println("session.getCreationTime: " + new java.util.Date(session1.getCreationTime()).toString());
out.println("session.getId " + session1.getId());
out.println("session.getLastAccessedTime " + new java.util.Date(session1.getLastAccessedTime()).toString());

out.println("session.getMaxInactiveInterval " + session1.getMaxInactiveInterval());
java.util.Enumeration sess = session1.getAttributeNames();
while(sess.hasMoreElements())
{ 
    String name = (String)sess.nextElement();
    out.println("Session variable: " + name + ", Value: " + session1.getAttribute(name));    
}


out.println("isRequestedSessionIdFromCookie " + request.isRequestedSessionIdFromCookie());
out.println("isRequestedSessionIdFromURL " + request.isRequestedSessionIdFromURL());
out.println("isRequestedSessionIdValid " + request.isRequestedSessionIdValid());






/*
 *ServletContext
public int getMajorVersion()
public int getMinorVersion()
public String getServerInfo()
*/

out.println("");

out.println("application.getMajorVersion() " + application.getMajorVersion());
out.println("application.getMinorVersion() " + application.getMinorVersion());
out.println("application.getServerInfo() " + application.getServerInfo());

out.println("application.getServletContextName() " + application.getServletContextName());

/*
in ServletContext you can save application wide attributes
public Object getAttribute(String name)
public void setAttribute(String name, Object attr)
public void removeAttribute(String name)

 *
public void log(String message)
public void log(String message, Throwable throwable)

 *
Calling Other Servlets and JSPs
 *
public RequestDispatcher getRequestDispatcher(String url)
public RequestDispatcher getNamedDispatcher(String name)


you can include other files either
 
*/
RequestDispatcher rd1 = request.getRequestDispatcher("/UploadForm.jsp"); // path parameter is relative to the current servlet
rd1.include(request,response);
//application.getNamedDispatcher() // get servlet by name as defined in web.xml
//sau
RequestDispatcher rd = application.getRequestDispatcher("/DumpHeaders.jsp"); // path relative to application root
rd.include(request,response);

// access other servlets context
//public ServletContext getContext(String uripath)


out.println("");

/*
public java.net.URL getResource(java.lang.String path)
    throws java.net.MalformedURLException

public java.io.InputStream getResourceAsStream(
    java.lang.String path)

Using getResourcePaths, you can get a directory-like listing of resources available within a context:
public java.util.Set getResourcePaths(java.lang.String path)
public String getRealPath(String path)
*/

out.println("");
out.println("Resources of the ServletContext");
java.util.Set set = application.getResourcePaths("/");

java.util.Iterator it = set.iterator();
while(it.hasNext())
{
    String path1 = application.getRealPath("/");
    String res = (String)it.next();
    //out.println(res);
    //java.io.FileInputStream in = new FileInputStream(path1 + res);
    java.io.File f = new java.io.File(path1 + res);
    out.println(res + " = " + new Boolean(f.isDirectory()).toString());
    
}
//out.println(set.toString());

//out.println("");




// get init parameters - t is initialized in jspInit()
if (t != null){
    while(t.hasMoreElements()){
        String s = (String)t.nextElement();
        out.println("InitParameter name: " + s + ", InitValue: " + this.getServletContext().getInitParameter(s));        
    }        
          
}



%>
<%=reloader.message()%>
<hr>
<% 
String a = "123456";
out.println(a.substring(2));



out.println("</pre>");
%>