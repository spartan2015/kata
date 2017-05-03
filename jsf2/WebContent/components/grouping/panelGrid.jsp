<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.row1{
background-color:red;
}
.row2{
background-color:yellow;
}

.col1{
font-weight: bold;
}

.col2{
text-decoration: line-through;
}

.header{
font-size:23px;
}

.footer{
background-color:grey;
}
</style>

<f:view>
	<h:form>
		<div>PanelGrid renders a table</div>
		
		<h:panelGrid border="1" cellpadding="1" cellspacing="1"  
		
			columns="2" 
			headerClass="header" footerClass="footer"
			rowClasses="row1,row2" columnClasses="col1,col2">
			<f:facet name="header">
				<f:verbatim>
					Table Header
				</f:verbatim>
			</f:facet>
			
			<h:outputText value="Col 1 Row 1" />
			<h:outputText value="Col 2 Row 1" />
			
			<h:outputText value="Col 1 Row 2" />
			<h:outputText value="Col 2 Row 2" />
			
			<f:facet name="footer">
				<f:verbatim>
					Table Footer
				</f:verbatim>
			</f:facet>
		</h:panelGrid>
			
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>