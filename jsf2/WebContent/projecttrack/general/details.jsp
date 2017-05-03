<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<head>
		<title>Project Track - Details</title>
		<link type="text/css" rel="stylesheet" href="<c:out value="${pageContext.request.contextPath }"/>/css/style.css" />
	</head>
	
	<jsp:include page="/projecttrack/includes/header.jsp"></jsp:include>
	
	<h:form>
		<h:panelGrid columns="1">
			<h:outputText value="Details" />
			<h:messages />
			<h:panelGrid columns="2">
				
				
				<%@ include file="/projecttrack/includes/project_info.jsp" %>
				
				<h:outputText value="Completed artefacts:" />
				<h:dataTable value="#{visitBean.currentProject.artefacts}"var="artefact">
					<h:column>
						<f:facet name="header">
							<h:outputText value="Artefact"></h:outputText>
						</f:facet>
						<h:outputText value="#{artefact}" />
					</h:column>
				</h:dataTable>	
									
				<f:facet name="footer">
					<h:panelGroup>
						<h:dataTable binding="#{showHistoryBean.historyDataTable}" 
							value="#{showHistoryBean.currentProjectHistory}" 
							var="operation"
							rows="#{showHistoryBean.rowsToDisplay}">
							<f:facet name="header">
								<h:outputText value="History" />
							</f:facet>
							
							<h:column>
								<h:panelGrid columns="1">
									<h:panelGrid columns="3">
										<h:outputText value="#{operation.timestamp}">
											<f:convertDateTime type="both" dateStyle="full" timeStyle="both"/>
										</h:outputText>
										
										<h:outputText value="#{operation.toStatus}" />
										
										<h:outputText value="#{operation.user.roleType}" />
									</h:panelGrid>
									
									<h:panelGrid columns="1">
										<h:outputText value="Comments: " />
										
										<h:outputText value="#{operation.comments}" />
									</h:panelGrid>
								</h:panelGrid>	
							</h:column>
							
							<f:facet name="footer">
								<h:panelGroup>								
									<h:commandLink rendered="#{showHistoryBean.showNext}" action="#{showHistoryBean.next}" value="Next" />
									<h:commandLink rendered="#{showHistoryBean.showPrevious}" action="#{showHistoryBean.previous}" value="Previous" />
								</h:panelGroup>
							</f:facet>
						
						</h:dataTable>						
						
					</h:panelGroup>
				</f:facet>				
			</h:panelGrid>		
						
			
			
			<h:panelGrid columns="2">
					<h:panelGroup>						
						<h:commandButton value="OK" action="#{showHistoryBean.cancel}" immediate="true" />
					</h:panelGroup>
					<h:panelGroup></h:panelGroup>
			</h:panelGrid>
			
		</h:panelGrid>
				
		
	</h:form>	

</f:view>