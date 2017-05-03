<%


response.setContentType("text/html; charset=UTF-8");

// in caz ca trimiti un fisier caruia ii stii dimensiunea, exemplu: o imagine
//public void setContentLength(int contentLength)

// get output streams
/*
public ServletOutputStream getOutputStream() throws IOException
public PrintWriter getWriter() throws IOException
*/

/*
public void setLocale(Locale aLocale)
public Locale getLocale()
public String getCharacterEncoding()


*/

/*
 *Response is usually buffered
public int getBufferSize()
public void setBufferSize(int bufferSize)
public void flushBuffer() throws IOException
 *clear content of the buffer
public void reset()
 *
public void resetBuffer()

 *

  public boolean isCommitted() // when headers are already sent to the browser
  *

public void setHeader(String header, String value)
public void setIntHeader(String header, int value)
public void setDateHeader(String header, Date value)

 *
 *Multiple values stored in the same header 
public void addHeader(String header, String value)
public void addIntHeader(String header, int value)
public void addDateHeader(String header, Date value)

 *
public boolean containsHeader(String header) //method returns true if a header value has already been set
 *
 *
 public void sendRedirect(String redirectURL)
 //A forward is much more efficient than a redirect because it happesn local on server files
 *
 *
 *other status then 200 and an error message
 *public void setStatus(int statusCode)
public void setError(int statusCode)
public void setError(int statusCode, String errorMessage)
    throws IOException

// adds session url id here in case browser does not support cookies
public String encodeURL(String url)
public String encodeRedirectURL(String url)

 *
//public void addCookie(Cookie cookie)

 *


*/

%>