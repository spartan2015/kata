<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		<div>f:param is used by: outputFormat, outputLink, commandLink</div>		
				
		<h:outputFormat value="bunica e pe camp {1}">
			<f:param value="(Inlocuit)"/>
		</h:outputFormat>
				
		<h:outputLink value="http://google.ro">
			<f:param name="myParam" value="myValue" />
		</h:outputLink>
		
		
		<h:commandLink value="Click ME">
			<f:param name="myParam" value="myValue" />
		</h:commandLink>
				
		
	</h:form>	

</f:view>