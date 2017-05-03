<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<head>
		<title>Project Track - Reject</title>
		<link type="text/css" rel="stylesheet" href="<c:out value="${pageContext.request.contextPath }"/>/css/style.css" />
	</head>
	
	<jsp:include page="/projecttrack/includes/header.jsp"></jsp:include>
	
	<h:form>
		<h:panelGrid columns="1">
			<h:outputText value="Reject" />
			<h:messages />
			<h:panelGrid columns="2">
				
				
				<%@ include file="/projecttrack/includes/project_info.jsp" %>
				
				
				<%@ include file="/projecttrack/includes/project_artefacts.jsp" %>					
				
			</h:panelGrid>		
			
			<%@ include file="/projecttrack/includes/project_comments.jsp" %>
			
			<h:panelGrid columns="2">
					<h:panelGroup>
						<h:commandButton value="Reject" action="#{updateProjectBean.reject}" />
						<h:commandButton value="Cancel" action="#{updateProjectBean.cancel}" immediate="true" />
					</h:panelGroup>
					<h:panelGroup></h:panelGroup>
			</h:panelGrid>
			
		</h:panelGrid>
				
		
	</h:form>	

</f:view>