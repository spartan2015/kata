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
		<h:panelGrid columns="1" cellpadding="5">
			<f:facet name="header">
				<h:outputText value="Inbox - Approve or reject projects"></h:outputText>				
			</f:facet>
			
			<h:messages globalOnly="true"></h:messages>
			
			<h:dataTable binding="#{inbox.inboxProjects}" rowClasses="row1,row2" var="project">
				
				<h:column>
					<f:facet name="header">
						<h:commandLink actionListener="#{inbox.sort}">
							<h:outputText value="Project name" />
							<f:param name="column" value="name"/>
						</h:commandLink>
					</f:facet>
					<h:outputText value="#{project.name}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:commandLink actionListener="#{inbox.sort}">
							<h:outputText value="Type" />
							<f:param name="column" value="type"/>
						</h:commandLink>
					</f:facet>
					<h:outputText value="#{project.type}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:commandLink actionListener="#{inbox.sort}">
							<h:outputText value="Status"></h:outputText>
							<f:param name="column" value="status"/>
						</h:commandLink>
					</f:facet>
					<h:outputText value="${project.status}" />
				</h:column>
				
				<h:column>				
					<h:commandLink action="#{inbox.approve}">
						<h:outputText value="Approve"></h:outputText>
					</h:commandLink>
				</h:column>
				
				<h:column>
					<h:commandLink action="#{inbox.reject}">
					<h:outputText value="Reject"></h:outputText>
				</h:commandLink>
				</h:column>
				
				
				<h:column>
					<h:commandLink action="#{inbox.details}">
					<h:outputText value="Details"></h:outputText>
				</h:commandLink>
				</h:column>
				
			</h:dataTable>			
		</h:panelGrid>		
		
	</h:form>	

</f:view>