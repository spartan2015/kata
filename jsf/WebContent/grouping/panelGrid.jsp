<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.headerClass{
color:blue;
}
.footerClass{
color:red
}

.row1{
bakground-color:grey;
}
.row2{
bakcground-color:#5F5F5F;
}

</style>
<f:view>

	creates tables
	<h:panelGrid columns="3" border="1" headerClass="headerClass" footerClass="footerClass" rowClasses="row1 row2" columnClasses="row1 row2">
		<f:facet name="header">
			<f:verbatim>Table Header</f:verbatim>
		</f:facet>
		
		<f:verbatim>Col 1 Row 1</f:verbatim>
		<f:verbatim>Col 2 Row 1</f:verbatim>
		<f:verbatim>Col 3 Row 1</f:verbatim>
		
		
		<f:verbatim>Col 1 Row 2</f:verbatim>
		<f:verbatim>Col 2 Row 2</f:verbatim>
		<f:verbatim>Col 3 Row 2</f:verbatim>
		
		<f:verbatim>Col 1 Row 3</f:verbatim>
		<f:verbatim>Col 2 Row 3</f:verbatim>
		<f:verbatim>Col 3 Row 3</f:verbatim>
		
		<f:verbatim>Col 1 Row 4</f:verbatim>
		<f:verbatim>Col 2 Row 4</f:verbatim>
		<f:verbatim>Col 3 Row 4</f:verbatim>
		
		<f:facet name="footer">
			<f:verbatim>Table footer</f:verbatim>
		</f:facet>
	</h:panelGrid>
</f:view>