<%@ page errorPage="ErrorPage.jsp" %>
<html>
<body>
You shouldn't see this because I plan
to throw an exception in just a second.
<%
    if (true) throw new RuntimeException("Sorry about that, Chief!");
%>
</body>
</html>
