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
<title>Forms</title>
</head>
<body>
	<form:form>
		<spring:message code="name"/>
		<form:input path="name" cssErrorClass="error"/> <form:errors path="name"/>		
		<form:input path="quantity"  cssErrorClass="error"/> <form:errors path="quantity"/>
		<form:input path="price"  cssErrorClass="error"/> <form:errors path="price"/>
		<form:input path="date"  cssErrorClass="error"/> <form:errors path="date"/>
		<form:input path="quantity"  cssErrorClass="error"/> <form:errors path="quantity"/>
		<form:checkbox path="check"  cssErrorClass="error"/> <form:errors path="check"/>
		<form:select path="select"  cssErrorClass="error"> <form:errors path="select"/>
			<form:options items="selects" />		
		</form:select>		
		<form:radiobuttons items="selects" path="select"  cssErrorClass="error"/> <form:errors path="select"/>		
		<form:password path="password"  cssErrorClass="error"/> <form:errors path="password"/>		
		<form:input path="commandCustom"  cssErrorClass="error" /> <form:errors path="commandCustom"/>		
	</form:form>
</body>
</html>