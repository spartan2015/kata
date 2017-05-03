<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>


<f:view>
	a dynamic inclusion - at runtime
	
	<jsp:include page="includeme.jsp"></jsp:include>
	
</f:view>