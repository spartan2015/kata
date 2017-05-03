<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<f:view>
	<h:form>
		<div>
			selectOne family save in one property of any type, as long there is a converter. By default is a String.
			This is opposed with selectMany wich needs a List of SelectItem to save the value of the component.
			
		</div>
		<h:selectOneRadio value="#{checkbox.selectOneResult}">
			<f:selectItem itemLabel="manual label" itemValue="manual Value" />
			<f:selectItem value="#{checkbox.selectItem}" /> 
			<f:selectItems value="#{checkbox.selectItems}" />
		</h:selectOneRadio>
		
		<h:selectOneListbox  value="#{checkbox.selectOneResult}">
			<f:selectItem itemLabel="manual label" itemValue="manual Value" />
			<f:selectItem value="#{checkbox.selectItem}" />
			<f:selectItems value="#{checkbox.selectItems}" />
		</h:selectOneListbox>
		
		<h:selectOneMenu  value="#{checkbox.selectOneResult}">
			<f:selectItem itemLabel="manual label" itemValue="manual Value" />
			<f:selectItem value="#{checkbox.selectItem}" />
			<f:selectItems value="#{checkbox.selectItems}" />
		</h:selectOneMenu>
				
		<h:commandButton ></h:commandButton>
	</h:form>	

</f:view>