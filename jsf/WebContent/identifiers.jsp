<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
	<h:form id="myForm">
		<h:inputText id="textBox"
			onmouseover="document.forms.myForm['myForm:textBox'].value=99"
			onmouseout="document.forms.myForm['myForm:textBox'].value=64"
		></h:inputText>
		
		<h:commandButton actionListener="#{identifiers.processActionEvent}"></h:commandButton>
		<h:outputText id="text"></h:outputText>
	</h:form>
	
	
</f:view>    
    