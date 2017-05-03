<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>


<f:view>
	<html>
	<head>
	<title>JSF - Hello World</title>
	</head>
	<body>
	<h:form id="welcomeForm">
		<h:outputText id="welcomeOutput"
			value="Welcome to Java Server Faces !"
			style="fon-family: Arial, sans-serif; font-size:24px; color: green;" />
			
		<h:message for="helloInput" id="errors" style="color:red" />
		
		<h:outputLabel for="helloInput">
			<h:outputText id="helloInputLabel" value="Enter a number of controls to display !" />			 
		</h:outputLabel>
		
		<h:inputText id="helloInput" value="#{helloBean.numControls}" required="true" size="10">		
			<f:validateLongRange minimum="1" maximum="500" />
		</h:inputText>
		
		<div>
		<h:inputText id="inputText">
			<f:validateLength minimum="1" maximum="2"/>
		</h:inputText>
		</div>
		
		
		<h:panelGrid id="controlPanel" binding="#{helloBean.controlPanel}" columns="20" border="1" cellspacing="0" />
		
		<h:commandButton  id="redisplayCommand" type="submit" value="Redisplay" actionListener="#{helloBean.addControls}"  /> 
		
		<h:commandButton  id="goodbyeCommand" type="submit" value="GoodBye" action="#{helloBean.goodbye}"  immediate="true"/>
		
	</h:form>
	</body>
	</html>

</f:view>