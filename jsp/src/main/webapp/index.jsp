<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.util.Enumeration"
    %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<body>
<h2>Hello World!</h2>


<%
	Enumeration en = request.getAttributeNames();
	Object o = null;
	while(en.hasMoreElements()){
		out.println("" + en.nextElement() + "<br/>");
	}
	%>
	
</body>
</html>
