<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<head>
		<title>
			<h:outputText value="Project Track" />
		</title>
		
		<link type="text/css" rel="stylesheet" href="<c:out value="${pageContext.request.contextPath}" />/css/style.css" />
	</head>

	<div><c:out value="${pageContext.request.contextPath}" /></div>
	<div><%=request.getContextPath() %></div>
	<div><h:outputText value="#{facesContext.externalContext.requestContextPath}" /></div>
asd
	<h:form>
		<f:loadBundle var="message" basename="messages"/>
		
		<h:messages errorClass="errors"/>
		<h:panelGrid columns="2">
			<h:graphicImage url="/images/logo.jpg"></h:graphicImage>
			
			<h:panelGroup>
				<h:outputText styleClass="login-title" value="Project Track" />
				
				<h:panelGrid columns="3">
					<h:outputLabel for="user">
						<h:outputText value="#{message.username}"></h:outputText>
					</h:outputLabel>
					<h:inputText id="user" required="true" value="#{authenticationBean.loginName}">
						<f:validateLength minimum="1"/>
					</h:inputText>
					<h:message for="user" errorClass="errors"></h:message>
					
					<h:outputLabel for="password">
						<h:outputText value="#{message.password}" />
					</h:outputLabel>
					<h:inputSecret id="password" required="true" value="#{authenticationBean.password}">
						<f:validateLength minimum="1"/>
					</h:inputSecret>
					<h:message for="password" errorClass="errors"></h:message>
					
					<h:panelGroup></h:panelGroup>
					<h:commandButton value="Submit" image="/images/tia.png" action="#{authenticationBean.login}"></h:commandButton>
					<h:panelGroup></h:panelGroup>
				</h:panelGrid>
			</h:panelGroup>
		</h:panelGrid>
		
		
				
		
	</h:form>	

</f:view>