<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	
	<h:form>
	
	<h:messages globalOnly="true"></h:messages>
	
	<div>Context path: 
		<h:outputText value="#{facesContext.externalContext.requestContextPath}" />
		<c:out value="${pageContext.request.contextPath}"/>
	</div>
	
	<h:panelGrid id="ido" columns="3">
				
		<h:outputLabel for="user1">
			<f:verbatim>User</f:verbatim>
		</h:outputLabel>
			
		<h:inputText id="user1" required="true" value="#{authentication.user}">
			<f:validateLength minimum="2"/>
		</h:inputText>
		<h:message for="user1" errorClass="error" />
	
	
				
		<h:outputLabel for="pass">
			<f:verbatim>Password</f:verbatim>
		</h:outputLabel>
			
		<h:inputSecret id="pass" required="true"  value="#{authentication.password}">
			<f:validateLength minimum="2"/>
		</h:inputSecret>
		<h:message for="pass" errorClass="error" />
		
		
		<h:panelGroup />	
		<h:commandButton action="#{authentication.login}"  image="/images/tia.png"></h:commandButton>				
		<h:panelGroup />
	
	</h:panelGrid>	
	

		
		
	</h:form>	

</f:view>