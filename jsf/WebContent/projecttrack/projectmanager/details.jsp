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
		
		<h:panelGrid columns="2">
			<f:facet name="header">
				<h:panelGrid columns="1">
					<f:facet name="header">
						<h:outputText value="Approve project" />
					</f:facet>
					
					<h:messages globalOnly="true"></h:messages>
				</h:panelGrid>
			</f:facet>
			
			<%@ include file="/projecttrack/includes/project_info.jsp" %>
			
			<h:outputText value="Completed artifact" />
			<h:dataTable var="artifact" value="#{visit.currentProject.artifacts}">
				<h:column>
					<h:outputText value="#{artifact}" />				
				</h:column>				
			</h:dataTable>
			
			
			<f:facet name="footer">
				<h:panelGroup>
					<h:dataTable 
						binding="#{showHistory.historyDataTable}" 
						var="operation" 
						value="#{showHistory.currentProjectHistory}" 
						rows="#{showHistory.rowsToDisplay}">
						
						<f:facet name="header">
						 <h:outputText value="History" />
						</f:facet>
						
						<h:column>						
							<h:panelGrid columns="3">
								<h:outputText value="#{operation.timestamp}">
									<f:convertDateTime dateStyle="full" timeStyle="short"/>
								</h:outputText>
								<h:outputText value="#{operation.fromStatus} -> #{operation.toStatus} "></h:outputText>
								<h:outputText value="#{operation.user.role}"></h:outputText>
							</h:panelGrid>
							<h:panelGrid columns="1">
								<h:outputText value="#{operation.comments}" />
							</h:panelGrid>						
						</h:column>
						
						
						<f:facet name="footer">
							<h:panelGroup>
								<h:commandLink action="#{showHistory.previous}" rendered="#{showHistory.showPrevious}">
									<h:outputText value="Previous"></h:outputText>
								</h:commandLink>
								<h:commandLink action="#{showHistory.next}" rendered="#{showHistory.showNext}">
									<h:outputText value="Next"></h:outputText>
								</h:commandLink>
							</h:panelGroup>
						</f:facet>
						
					</h:dataTable>
					
					<h:panelGrid columns="2">						
						<h:commandButton action="#{showHistory.cancel}" immediate="true" value="OK" />
					</h:panelGrid>
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>			
		
	</h:form>	

</f:view>