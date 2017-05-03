<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:subview id="header">
	<h:form id="header_form">
		<h:panelGrid columns="3">	
			<h:panelGrid columns="5">
				<h:outputText value="Project Track"/>
				
				<h:commandLink action="inbox" rendered="#{!authenticationBean.inboxAuthorized}">
					<h:graphicImage url="/images/tia.png" />
					<h:outputText value="Inbox" />
				</h:commandLink>
				
				<h:commandLink action="show_all">
					<h:graphicImage url="/images/tia.png" />
					<h:outputText value="Show All" />
				</h:commandLink>
				
				<h:commandLink id="create" action="#{createProjectBean.create}" rendered="#{!authenticationBean.createNewAuthorized}">
					<h:graphicImage url="/images/tia.png" />
					<h:outputText value="Create New" />
				</h:commandLink>
				
				<h:commandLink action="#{authenticationBean.logout}">
					<h:graphicImage url="/images/tia.png" />
					<h:outputText value="logout" />
				</h:commandLink>			
			</h:panelGrid>	
			
			<h:panelGroup>
				<h:outputLabel for="select">
					<h:outputText value="Select Language" />
				</h:outputLabel>
				<h:selectOneListbox id="select" size="1" value="#{visitBean.locale}" onchange="this.form.submit()">
					<f:converter converterId="SelectItemToLocaleConverter"/>
					<f:selectItems value="#{visitBean.supportedLocales}"/>
				</h:selectOneListbox>
				<h:message for="select"></h:message>
			</h:panelGroup>
			
			<h:outputText value="#{visitBean.user.loginName}" />
		</h:panelGrid>
	</h:form>
</f:subview>