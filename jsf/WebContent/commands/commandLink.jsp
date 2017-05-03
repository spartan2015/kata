<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
				
				<div>CommandLink is different from outputLink because it POSTBACK with submit and triggera an ACTION</div>
		
		<h:outputLink>
			<f:verbatim>outputLink</f:verbatim>
		 </h:outputLink>
		 
		 
		<h:commandLink action="retry">
			<h:outputText>Next >></h:outputText>
			<f:actionListener type="org.mseco.learning.jsf.listeners.ActionListenerImpl"/>
		</h:commandLink>
	</h:form>	

</f:view>