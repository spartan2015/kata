<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
			<div><h:selectManyListbox enabledClass="enabledClass" size="20"
			 disabledClass="disabledClass">
			<f:selectItems value="#{userForm.selectItems}" />
		</h:selectManyListbox></div>	
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>