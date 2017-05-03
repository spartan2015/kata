<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>


<f:view>
	<html>
	<head>
	<title>JSF - Hello World</title>
	</head>
	<body>
	<h:form id="welcomeForm">
		
		<div><h:outputText value="#{helloBean.date}">
			<f:convertDateTime timeStyle="full" type="date" dateStyle="full"
				timeZone="GMT+3" />
		</h:outputText></div>

		<div><h:outputText value="#{helloBean.date}">
			<f:convertDateTime timeStyle="full" type="time" dateStyle="full"
				timeZone="GMT+3" />
		</h:outputText></div>


		<div><h:outputText value="#{helloBean.date}">
			<f:convertDateTime timeStyle="full" type="both" dateStyle="full"
				timeZone="GMT+3" />
		</h:outputText></div>

		<div><h:outputText value="#{helloBean.date}">
			<f:convertDateTime timeStyle="full" type="both" dateStyle="full"
				timeZone="GMT" />
		</h:outputText></div>


		<div><h:outputText value="#{helloBean.date}">
			<f:convertDateTime pattern="yyyy" />
		</h:outputText></div>


		<div><h:outputText value="#{helloBean.date}">
			<f:convertDateTime pattern="yyyy" />
		</h:outputText></div>

		<div><h:outputText value="#{helloBean.date}">
			<f:convertDateTime pattern="dd/MMM/yyyy hh:mm:ss" locale="en_US" />
		</h:outputText></div>

		<div><h:outputText value="#{helloBean.date}">
			<f:convertDateTime dateStyle="full" locale="it_IT" />
		</h:outputText></div>


		<div><h:outputText value="#{helloBean.date}">
			<f:convertDateTime dateStyle="full" locale="ro_RO" />
		</h:outputText></div>
	</h:form>
	</body>
	</html>
</f:view>