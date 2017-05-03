<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>

	<h:messages style="color:red"></h:messages>

	<h:message for="forAnInputComponent" style="color:red"></h:message>
	<h:form>
		<h:inputText id="forAnInputComponent"></h:inputText>
	</h:form>
</f:view>