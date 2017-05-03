<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	h:panelGroup only groups elemets and applies a style - and of course you get a group id for what ever java or javascript manipulation
	<h:panelGroup id="group" style="background-color:#5F5F5F">
		<h:graphicImage value="/images/danica.jsp" />
		<h:outputText value="asd" />
		<h:outputText value="asd1" />
		
	</h:panelGroup>

</f:view>