<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
	
		Implicit variables:
		<div>
			applicationScope:
			<h:outputText value="#{applicationScope}"/>
		</div>
	
		<div>
			sessionScope:
			<h:outputText value="#{sessionScope}"/>
		</div>
		
		
		<div>
			requestScope:
			<h:outputText value="#{requestScope}"/>
		</div>
		
		
		<div>
			facesContext:
			<h:outputText value="#{facesContext}"/>
		</div>
		
		
		<div>
			cookie:
			<h:outputText value="#{cookie}"/>
		</div>
		
		
		<div>
			header['User-Agent']:
			<h:outputText value="#{header['User-Agent']}"/>
		</div>
		
		
		<div>
			headerValues['Accept-encoding'][0]:
			<h:outputText value="#{headerValues['Accept-encoding'][0]}"/>
		</div>
		
		
		<div>
			initParam:
			<h:outputText value="#{initParam}"/>
		</div>
		
		
		<div>
			param:
			<h:outputText value="#{param}"/>
		</div>
		
		
		<div>
			paramValues:
			<h:outputText value="#{paramValues}"/>
		</div>
		
		
		<div>
			view:
			<h:outputText value="#{view}"/>
		</div>
		
		
		<div>
			view.viewId:
			<h:outputText value="#{view.viewId}"/>
		</div>
		
		<div>
			view.locale:
			<h:outputText value="#{view.locale}"/>
		</div>
		
		<div>
			view.renderKitId:
			<h:outputText value="#{view.renderKitId}"/>
		</div>
		
						
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>