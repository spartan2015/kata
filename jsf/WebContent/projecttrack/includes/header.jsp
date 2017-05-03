<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/stylesheet.css"  />

<f:subview id="header">
	<f:loadBundle basename="messages"  var="bundle"/>

	<h:form>
		<h:panelGrid columns="3" width="100%" cellspacing="0" cellpadding="0" styleClass="header">
			<h:panelGrid id="header" columns="9" cellpadding="4" cellspacing="0" border="0" >
				
				<h:outputText value="#{messages.applicationName}" styleClass="header-header"/>
				
				<h:commandLink action="inbox" rendered="#{authentication.inboxAuthorized}">
					<h:graphicImage url="/images/tia.png" styleClass="header-icon" alt="Inbox"></h:graphicImage>
					<h:outputText value="Inbox" styleClass="header-command" />
				</h:commandLink>
				
				<h:commandLink action="show_all">
					<h:graphicImage url="/images/tia.png" styleClass="" alt="Show all projects"/>
					<h:outputText value="Show All" styleClass=""></h:outputText>
				</h:commandLink>
				
				<h:commandLink action="create" rendered="#{authentication.createNewAuthorized}">
					<h:graphicImage url="/images/tia.png" styleClass="" alt="Create new project"></h:graphicImage>
					<h:outputText value="createNew" styleClass="" ></h:outputText>
				</h:commandLink>
				
				<h:commandLink action="#{authentication.logout}">
					<h:graphicImage url="/images/tia.png" styleClass="" alt="" />
					<h:outputText value="Logout" styleClass=""></h:outputText>
				</h:commandLink>				
				
			</h:panelGrid>
			
			<h:panelGroup>
				<h:outputLabel for="select">
					<h:outputText value="Select language"/>					
				</h:outputLabel>
				<h:selectOneMenu id="select" value="#{visit.locale}">
					<f:selectItems value="#{visit.supportedLocales}"/>
				</h:selectOneMenu>
				<h:commandButton value="Go!" />				
			</h:panelGroup>
			
			<h:outputText value="User: #{visit.user.user}" />
		</h:panelGrid>
	</h:form>
</f:subview>