<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		<h:messages></h:messages>
		<div>Common input components properties</div>
		<ol>
			<li></li>
		</ol>	
		
		<h:inputText id="id1" value="#{input.text}" converter="converterId" validator="#{input.validate}" 
			immediate="false" required="true" 
			valueChangeListener="#{events.valueChangeEvent}" binding="#{input.inputText}"
		>
			<f:valueChangeListener type="org.mseco.learning.jsf.ValueChangeListenerImpl"/>
			<f:validator validatorId="validatorId"/>
		</h:inputText>
			
		<h:commandButton action="retry"></h:commandButton>
	</h:form>	

</f:view>