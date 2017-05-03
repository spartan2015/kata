<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		
		<h:outputLabel for="check">
			<f:verbatim>Check this: </f:verbatim>
		</h:outputLabel>
		<h:selectBooleanCheckbox id="check" value="#{userForm.check}"></h:selectBooleanCheckbox>
		
		<h:commandButton  value="Submit" action="retry"></h:commandButton>
	</h:form>
	
</f:view>