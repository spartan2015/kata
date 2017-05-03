<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<<style>
<!--
div{
padding: 5 5 5 5;
}
-->
</style>

<f:view>

<div>
	applicationScope	
	<h:outputText value="#{applicationScope}" />
</div>

<div>
	sessionScope	
	<h:outputText value="#{sessionScope}" />
</div>

<div>
	requestScope	
	<h:outputText value="#{requestScope}" />
</div>

<div>
	cookie	
	<h:outputText value="#{cookie}" />
</div>

<div>
	header	
	<h:outputText value="#{header}" />
</div>

<div>
	initParam	
	<h:outputText value="#{initParam}" />
</div>


<div>
	param	
	<h:outputText value="#{param}" />
</div>	


<div>
	paramValues	
	<h:outputText value="#{paramValues}" />
</div>	

<div>
	facesContext	
	<h:outputText value="#{facesContext}" />	
</div>	

<div>
	view	
	<h:outputText value="#{view}" />
	
	<ul>
		<li>locale <h:outputText value="#{view.locale}" /></li>
		<li>viewId <h:outputText value="#{view.viewId}" /></li>
		<li>renderKitId <h:outputText value="#{view.renderKitId}" /></li>
	</ul>
</div>	
		
</f:view>