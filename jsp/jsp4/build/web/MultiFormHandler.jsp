<html>
<body>
The names you entered are:
< pre>
<%
// Fetch the name values.
    String names[] = request.getParameterValues("names");

    for (int i=0; i < names.length; i++)
    {
        out.println(names[i]);
    }
%>
</ pre>

</body>
</html>
