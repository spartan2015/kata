<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		
		<h:messages />
		inputTextarea are o problem cu convertoarele - da o eroare text name must not be null
		<h:outputLabel for="text">
			<h:outputText value="HtmlInputTextare" />
		</h:outputLabel>		
				
		<h:inputTextarea converter="converterId" immediate="false" id="text" value="#{input.text}" validator="#{input.validate}"
		 	 valueChangeListener="#{events.valueChangeEvent}"
		 	required="true" 
		 	rows="10"
		>
			
			<f:validator validatorId="validatorId"/>
			<f:validateLength minimum="1"/>
			<f:validateLongRange minimum="1"/> 
		</h:inputTextarea>
				
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>