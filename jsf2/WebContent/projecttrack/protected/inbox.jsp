<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<head>
		<title>Project Track - Inbox			
		</title>
		<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/style.css" />
	</head>
	<jsp:include page="/projecttrack/includes/header.jsp"></jsp:include>
		
	<h:form>
		<h:panelGrid columns="1">
			<h:outputText value="Inbox" />
			
			<h:messages globalOnly="true" />	
				
			<h:dataTable binding="#{inboxBean.projectTable}" var="project" value="#{inboxBean.inboxProjects}">
				<h:column>
					<f:facet name="header">
						<h:commandLink actionListener="#{inboxBean.sort}">		
							<h:outputText value="Project Name"></h:outputText>
							<f:param name="column" value="name" />
						</h:commandLink>
					</f:facet>
					<h:outputText value="#{project.name}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:commandLink actionListener="#{inboxBean.sort}">
							<h:outputText value="Type"></h:outputText>
							<f:param name="column" value="type" />
						</h:commandLink>
					</f:facet>
					<h:outputText value="#{project.type}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:commandLink actionListener="#{inboxBean.sort}">
							<h:outputText value="Status"></h:outputText>
							<f:param name="column" value="status" />
						</h:commandLink>
					</f:facet>
					<h:outputText value="#{project.status}" />
				</h:column>				
				<h:column>
					<h:commandLink action="#{inboxBean.approve}">
					<h:outputText value="Approve" />
				</h:commandLink>
				</h:column>
				<h:column>
					<h:commandLink action="#{inboxBean.reject}">
						<h:outputText value="Reject" />
					</h:commandLink>
				</h:column>
				<h:column>
					<h:commandLink action="#{inboxBean.details}">
						<h:outputText value="Details" />
					</h:commandLink>
				</h:column>									
			</h:dataTable>		
		</h:panelGrid>
	</h:form>	

</f:view>