<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>

	<f:verbatim escape="true">
		Just plain text, no formatting or changes done, <b>no html added</b>
		
		<jsp:include page="/WEB-INF/web.xml"></jsp:include>
	</f:verbatim>
	
	
	<h:panelGrid columns="2" border="1">
		
		<f:verbatim>
			prima coloana
		</f:verbatim>
		
		<f:verbatim>
			a doua coloana
		</f:verbatim>
	
	</h:panelGrid>
</f:view>