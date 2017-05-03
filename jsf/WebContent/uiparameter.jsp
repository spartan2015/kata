<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<div>UIParameters (f:param) it's used to set some properties for
	components like: h:outputFormat, h:outputLink, h:commandLink</div>
	<h:form>
		
		<h:outputFormat  value="Hello {0}">
			<f:param value="Neo" />
		</h:outputFormat>
		
	</h:form>
</f:view>