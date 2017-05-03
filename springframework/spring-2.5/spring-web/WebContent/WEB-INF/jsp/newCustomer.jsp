<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form commandName="customer">
	
	Phone number: <c:out value="${requestParameters.number}" /><br />
	State: <form:input path="state"/> <br />
	City: <form:input path="city"/> <br />
	ZipCode: <form:input path="zipCode"/> <br />
	StreetAddress: <form:input path="streetAddress"/> <br />
	
	
	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
	<input type="submit" name="_eventId_submit" value="Submit" />
	<input type="submit" name="_eventId_cancel" value="cancel" />
</form:form>


</body>
</html>