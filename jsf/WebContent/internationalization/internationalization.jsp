<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<div>you must use f:loadBundle to load the bundle</div>
	<f:loadBundle basename="messages" var="bundle"/>
	<h:form>
	
		<h:commandButton action="#{applicationUsage.getBundle}" value="Echo Message in Code" ></h:commandButton>
		
		<div>
		This is: bundle.keyWithoutdot
		<h:outputText value="#{bundle.keyWithoutdot}"></h:outputText>
		</div>
	
		<div>parametrized</div>
		<h:outputFormat value="#{bundle.parametrized}">
			<f:param value="Name"/>
			<f:param value="Romania"/>
		</h:outputFormat>
			
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>