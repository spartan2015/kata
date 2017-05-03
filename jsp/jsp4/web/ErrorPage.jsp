<%@ page isErrorPage="true" %>
<html>
<body>
<h1>Error</h1>
An error occurred while processing your request.
<p>
The error message is: <%= exception.getMessage() %>.
</body>
</html>

