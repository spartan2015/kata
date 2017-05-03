<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<head>
		<title>Project Track - Create</title>
		<link type="text/css" rel="stylesheet" href="<c:out value="${pageContext.request.contextPath }"/>/css/style.css" />
	</head>
	
	<jsp:include page="/projecttrack/includes/header.jsp"></jsp:include>
	
	<h:form>
		<h:panelGrid columns="1">
			<h:outputText value="Create" />
			<h:messages />
			<h:panelGrid columns="3">
			
				<h:outputLabel for="name">
					<h:outputText value="Name:" ></h:outputText>
				</h:outputLabel>
				<h:inputText id="name" required="true" value="#{visitBean.currentProject.name}">
					<f:validateLength minimum="1" />
				</h:inputText>
				<h:message for="name" />
				
				<h:outputLabel for="type">
					<h:outputText value="Type" />
				</h:outputLabel>
				<h:selectOneMenu id="type" required="true" binding="#{createProjectBean.projectSelectOne}"
						value="#{visitBean.currentProject.type}">
					<f:converter converterId="projectTypeConverter" />
					<f:selectItems value="#{selectItems.projectTypes}" />
				</h:selectOneMenu>
				<h:message for="type" />
				
				<h:outputLabel for="initiatedBy">
					<h:outputText value="Initiated by" />
				</h:outputLabel>
				<h:inputText id="initiatedBy" required="true" value="#{visitBean.currentProject.initiatedBy}">
					<f:validateLength minimum="1" />
				</h:inputText>
				<h:message for="initiatedBy" />
				
				<h:outputLabel for="requirementsContact">
					<h:outputText value="Requirement contact" />
				</h:outputLabel>
				<h:inputText id="requirementsContact" required="true"					 
					 validator="#{createProjectBean.validateReqContact}"
					 value="#{visitBean.currentProject.requirementsContact}">
					<f:validateLength minimum="1"/>
				</h:inputText>
				<h:message for="requirementsContact"></h:message>
				
				<h:outputLabel for="requirementsEmail">
					<h:outputText value="Requirements email" />
				</h:outputLabel>
				<h:inputText id="requirementsEmail" required="true"	
					binding="#{createProjectBean.reqContactEmail}"				
					value="#{visitBean.currentProject.requirementsContactEmail}"
					>
					<f:validateLength minimum="1"/>
				</h:inputText>
				<h:message for="requirementsEmail"></h:message>
				
				<h:outputLabel for="completedArtefact" >
					<h:outputText value="Completed Artefacts" />
				</h:outputLabel>
				<h:selectManyCheckbox id="completedArtefact" layout="pageDirection" value="#{visitBean.currentProject.artefacts}"
					converter="artefactTypeConverter"
					>					
					<f:selectItems value="#{selectItems.artefacts}" />
				</h:selectManyCheckbox>					
				<h:message for="completedArtefacts"></h:message>
				
			</h:panelGrid>		
			
			<h:panelGrid columns="1">
					<h:outputLabel for="comments">
						<h:outputText value="Your comments: " />
					</h:outputLabel>
					<h:inputTextarea  id="comments" cols="50" />
			</h:panelGrid>
			
			<h:panelGrid columns="2">
					<h:panelGroup>
						<h:commandButton value="Create" action="#{createProjectBean.add}" />
						<h:commandButton value="Cancel" action="#{createProjectBean.cancel}" immediate="true" />
					</h:panelGroup>
					<h:panelGroup></h:panelGroup>
			</h:panelGrid>
			
		</h:panelGrid>
				
		
	</h:form>	

</f:view>