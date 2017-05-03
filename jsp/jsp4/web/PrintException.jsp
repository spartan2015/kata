<%@ page language="java" import="java.io.*" %>

<html>
<body bgcolor="#ffffff">
<pre>
<%
    try
    {
        throw new RuntimeException("Print me, please");
    }
    catch (RuntimeException exc)
    {
        PrintWriter pw = new PrintWriter(out);

        exc.printStackTrace(pw);
    }
%>
</pre>
</body>
</html>
