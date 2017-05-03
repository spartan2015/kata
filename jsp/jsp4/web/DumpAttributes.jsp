<%@ page import="java.util.*" %>
<html>
<body>
This page has access to the following attributes:
<pre>
<%

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
    
    application.getRequestDispatcher();
    application.getNamedDispatcher();
    
%>
<jsp:include>UploadForm.jsp</jsp:include>
<jsp:forward>
    
</pre>
</body>
</html>

