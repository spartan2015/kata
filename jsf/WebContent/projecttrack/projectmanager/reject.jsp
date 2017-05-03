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
						<h:outputText value="Reject project" />
					</f:facet>
					<h:messages globalOnly="true"></h:messages>
				</h:panelGrid>
			</f:facet>
			
			<%@ include file="/projecttrack/includes/project_info.jsp" %>
			<%@ include file="/projecttrack/includes/project_artefacts.jsp" %>
			
			
			<f:facet name="footer">
				<h:panelGroup>
					<jsp:include page="/projecttrack/includes/project_comments.jsp"></jsp:include>
					
					<h:panelGrid columns="2">
						<h:commandButton action="reject" value="Reject" />
						<h:commandButton action="cancel" immediate="true" value="Cancel" />
					</h:panelGrid>
				</h:panelGroup>
			</f:facet>
		</h:panelGrid>
	</h:form>	

</f:view>