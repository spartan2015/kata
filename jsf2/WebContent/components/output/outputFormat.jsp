<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		
		<h:outputFormat escape="true" id="id" value="{0} is {1}">
			<f:param value="11" />
			<f:param value="22" />
		</h:outputFormat>
						
		
		<h:outputFormat value="User are using {0}" >
			<f:param value="#{header['User-Agent']}" />
		</h:outputFormat>						
				
		<div>
			message format pattern: using the MessageFormat class			
		</div>
		
		<div>
			<h:outputFormat value="{0, date, medium}" >
			<f:param value="#{messageFormat.date}" />
		</h:outputFormat>
		</div>		
					
		<div>Dynamically displaying substrings with choice formats</div>
		<c:set scope="request" var="nr" value="1" /> 					
		<div>
			<h:outputFormat value="{0, choice, 1#oneOrLess|2#two|3#threeOrMore}" >
			<f:param value="#{nr}" />
		</h:outputFormat>
		</div>
		<c:set scope="request" var="nr" value="2" /> 					
		<div>
			<h:outputFormat value="{0, choice, 1#oneOrLess|2#two|3#threeOrMore}" >
			<f:param value="#{nr}" />
		</h:outputFormat>
		</div>		
		<c:set scope="request" var="nr" value="3" /> 					
		<div>
			<h:outputFormat value="{0, choice, 1#oneOrLess|2#two|3#threeOrMore}" >
			<f:param value="#{nr}" />
		</h:outputFormat>
		</div>				
						
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>