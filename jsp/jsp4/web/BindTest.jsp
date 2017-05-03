<%@ page language="java" import="servlets.BindListener" %>

<html>
<body bgcolor="#ffffff">

<%-- Set up a static BindListener shared by all instances of this JSP.
     There is probably only one instance, but just in case the server creates
     multiple instances, this page can handle it. --%>
<%!
    protected static BindListener listener = new BindListener();
%>

<%

    BindListener l = null;

// Allow the browser to pass a "removeListener" parameter to remove
// a listener from the session.

    if (request.getParameter("removeListener") != null)
    {
        session.removeAttribute("listener");
    }

// Allow the browser to pass a resetSession parameter to clear out
// the session.
    else if (request.getParameter("resetSession") != null)
    {
// See whether there is already a session.
        HttpSession oldSession = request.getSession(false);

// If there is already a session, invalidate it.
        if (oldSession != null)
        {
            l = (BindListener)
                oldSession.getAttribute("listener");
            oldSession.invalidate();

// Tell the user that the session was reset and show that the
// bind counts have been updated. Make sure that there was a
// listener on the old session, too.

            if (l != null)
            {
%>
Your current session was reset. The listener now has <%=l.getNumSessions()%>
active sessions.<p>
<%
            } else {
%>
Your old session didn't have a listener.<p>
<%
            }

            l = null;
        }
    }
    else
    {
// See if the listener is already in the session.
         l = (BindListener)
            session.getAttribute("listener");

// If not, add the global copy of the listener to the session.
        if (l == null)
        {
// Put the global listener variable into the session.
            session.setAttribute("listener", listener);
            l = listener;
        }
    }
%>
<%
    if (l != null)
    {
%>
You have a listener bound to your session.
<%
    } else {
%>
You do not have a listener bound to your session.
<%
    }
%>
There are currently <%=listener.getNumSessions()%> sessions holding onto the
bind listener.
<p>
<table>
<tr>
<td>
<A href="BindTest.jsp">Refresh Form</A>
<td>
<A href="BindTest.jsp?removeListener">Remove Listener</A>
<td>
<A href="BindTest.jsp?resetSession">Reset Session</A>
</table>
</body>
</html>

