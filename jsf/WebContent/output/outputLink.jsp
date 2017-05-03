<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<div><h:outputLink value="http://google.ro">
		<f:verbatim>Link content always in a jsf tag Google.ro</f:verbatim>
		<f:param name="myName" value="myValue"/>
	</h:outputLink></div>
	<div><h:outputLink value="/jsf/faces/hello.jsp">
		<f:verbatim>hello.jsp Page</f:verbatim>
	</h:outputLink></div>
</f:view>