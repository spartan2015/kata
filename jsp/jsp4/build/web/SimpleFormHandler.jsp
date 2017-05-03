<html>
<body>

<%

// Grab the variables from the form.
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String sex = request.getParameter("sex");
    String javaType = request.getParameter("javaType");
%>
<%-- Print out the variables. --%>
<h1>Hello, <%=firstName%> <%=lastName%>!</h1>
I see that you are <%=sex%>. You know, you remind me of a
<%=javaType%> variable I once knew.

</body>
</html>
