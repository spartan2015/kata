<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<jsp:include page="/projecttrack/includes/header.jsp"></jsp:include>
	
	<h:form>
				
		<h:panelGrid columns="3">
			<f:facet name="header">
				<h:panelGrid columns="1">
					<f:facet name="header">
						<h:outputText value="Create project" />
					</f:facet>
					<h:messages globalOnly="true"></h:messages>
				</h:panelGrid>
			</f:facet>
			
			
			<h:outputText value="Name" />
			<h:inputText id="name" value="#{visit.currentProject.name}" />
			<h:message for="name" />
			
			<h:outputText value="Type" />
			<h:selectOneMenu id="type" binding="#{createProject.projectSelectOne}" >
				<f:selectItems value="#{selectItems.projectTypes}" />
			</h:selectOneMenu>
			<h:message  for="type" />
			
			<h:outputText value="Initiated by" />
			<h:inputText id="initiator" value="#{visit.currentProject.initiatedBy}" />
			<h:message for="initiator"/>
			
			<h:outputText value="Requirements contact" />
			<h:inputText id="requirementsContact" value="#{visit.currentProject.requirementsContact}"
				validator="#{createProject.validateReqContact}" />
			<h:message for="requirementsContact" />
			
			<h:outputText value="Requirements email" />
			<h:inputText id="requirementsEmail" value="#{visit.currentProject.requirementsContactEmail}" 
				binding="#{createProject.reqContactEmail}" />
			<h:message for="requirementsEmail"></h:message>
			
			<h:outputText value="Initial comments" />
			<h:inputText id="initialComments" value="#{visit.currentProject.initialComments}" />
			<h:message for="initialComments"></h:message>
			
			
			<%@ include file="/projecttrack/includes/project_artefacts.jsp" %>
			<h:panelGroup></h:panelGroup>
			
			<f:facet name="footer">
				<h:panelGroup>
					
					<h:panelGrid columns="1">
						<h:outputLabel for="comments">
							<h:outputText value="Your comments: "></h:outputText>
						</h:outputLabel>
						
						<h:inputTextarea id="comments" rows="10" cols="80" />
					</h:panelGrid>
					
					<h:panelGrid columns="2">
						<h:commandButton action="#{createProject.add}" value="Create" />
						<h:commandButton action="#{createProject.cancel}" immediate="true" value="Cancel" />
					</h:panelGrid>
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>	

</f:view>