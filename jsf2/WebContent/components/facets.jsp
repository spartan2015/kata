<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		
		<h:dataTable var="row" value="#{managedBean.name}">
			<f:facet name="header">
				<f:verbatim>Table Header</f:verbatim>
			</f:facet>
			
			<h:column>
				<f:facet name="header">
					<f:verbatim>Column Header</f:verbatim>
				</f:facet>
				<h:outputText value="#{row}" />
			</h:column>
			
			<f:facet name="footer">
				<f:verbatim>Table Footer</f:verbatim>
			</f:facet>
		</h:dataTable>				
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>